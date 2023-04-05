package gui.acoes;

import gui.Screen;
import model.comodos.TipoComodo;
import model.eletronicos.Dispositivo;
import model.eletronicos.TipoDispositivo;
import repository.DispositivoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static model.eletronicos.TipoDispositivo.enumCorrespondente;
import static model.util.Instanciador.instanciar;
import static repository.DispositivoRepository.listarTodosDispositivos;
import static repository.DispositivoRepository.salvarDispositivo;

public class CadastrarDispositivo extends JPanel {

    private JPanel panelListaDispositivo;

    private JTextField nomeDispositivo;
    List<TipoDispositivo> tipoDispositivo;

    private JComboBox<TipoDispositivo> comboBoxTipoDispositivo;

    List<JCheckBox> checkboxes = new ArrayList<>();



    public CadastrarDispositivo(Screen component){
        int width = 550;
        int height = 500;
        this.setLayout(null);
        this.setSize(width,height);
        this.setBackground(new Color(255, 143, 220));
        this.setBounds(250,0,width,height);
        this.setVisible(true);

        JLabel tituloGeral = new JLabel("CADASTRAR DISPOSITIVO");
        tituloGeral.setFont(new Font(tituloGeral.getName(), tituloGeral.getFont().getStyle(),30));
        this.add(tituloGeral);
        tituloGeral.setBounds(70,10,550,30);

        adicionandoPainelCadastroDeDispositivos();
    }

    private void adicionandoPainelCadastroDeDispositivos(){
        JLabel tituloComodos = new JLabel("Dispositivo:");
        this.add(tituloComodos);
        tituloComodos.setBounds(20,60,150,30);

        this.tipoDispositivo = Arrays.asList(TipoDispositivo.values());
        this.panelListaDispositivo = new JPanel();
        this.panelListaDispositivo.setLayout(new GridLayout(2,5));
        this.panelListaDispositivo.setBounds(20,85,200,50);
        this.comboBoxTipoDispositivo = new JComboBox<>(TipoDispositivo.values());
        this.panelListaDispositivo.add(this.comboBoxTipoDispositivo);


        JLabel lableNomeDispositivo = new JLabel("Nome: ");
        lableNomeDispositivo.setBounds(250,85,100,25);
        this.add(lableNomeDispositivo);

        this.nomeDispositivo = new JTextField();
        this.nomeDispositivo.setBounds(300,85,100,25);
        this.add(nomeDispositivo);

        JButton btnCadastrar = new JButton("cadastrar");
        btnCadastrar.setBounds(200,150,130,25);
        btnCadastrar.addActionListener(this::cadastrar);
        this.add(btnCadastrar);
        this.add(this.panelListaDispositivo);
    }
        private void cadastrar(ActionEvent actionEvent) {
        Dispositivo dispositivo = instanciar((TipoDispositivo) this.comboBoxTipoDispositivo.getSelectedItem());
        dispositivo.setNome(this.nomeDispositivo.getText());
        try {
            salvarDispositivo(dispositivo);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        }



}
