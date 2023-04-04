package gui.acoes;

import gui.Screen;
import model.comodos.TipoComodo;
import model.eletronicos.Dispositivo;
import model.eletronicos.TipoDispositivo;
import repository.DispositivoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static model.eletronicos.TipoDispositivo.enumCorrespondente;
import static model.util.Instanciador.instanciar;
import static repository.DispositivoRepository.salvarDispositivo;

public class CadastrarDispositivo extends JPanel {

    private JPanel panelListaDispositivo;

    private JTextField nomeDispositivo;
    List<TipoDispositivo> tipoDispositivo;


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
        JLabel tituloComodos = new JLabel("Tipo de dispositivo:");
        this.add(tituloComodos);
        tituloComodos.setBounds(20,60,150,30);

        this.tipoDispositivo = Arrays.asList(TipoDispositivo.values());
        this.panelListaDispositivo = new JPanel();
        this.panelListaDispositivo.setLayout(new GridLayout(2,5));
        this.panelListaDispositivo.setBounds(20,85,550,140);
//        this.panelListaDispositivo.add(this.checkBox);

        tipoDispositivo.forEach(disp ->{
            JCheckBox checkBox = new JCheckBox(disp.getNome());
            this.checkboxes.add(checkBox);
            this.panelListaDispositivo.add(checkBox);
        });


        JLabel lableNomeDispositivo = new JLabel("Nome: ");
        lableNomeDispositivo.setBounds(20,250,100,25);
        this.add(lableNomeDispositivo);

        this.nomeDispositivo = new JTextField();
        this.nomeDispositivo.setBounds(60,250,100,25);
        this.add(nomeDispositivo);

        JButton btnCadastrar = new JButton("cadastrar");
        btnCadastrar.setBounds(200,400,100,25);
        btnCadastrar.addActionListener(this::cadastrar);
        this.add(btnCadastrar);

        this.add(this.panelListaDispositivo);
    }

    private void cadastrar(ActionEvent actionEvent) {
        List<String> dispositivosSelecionados = this.checkboxes.stream()
                        .filter(JCheckBox::isSelected)
                        .map(JCheckBox::getText)
                        .collect(Collectors.toList());

        dispositivosSelecionados.forEach(disp -> {
            Dispositivo dispositivo = instanciar(enumCorrespondente(disp));
            dispositivo.setNome(this.nomeDispositivo.getText());
            System.out.println(dispositivo);
            System.out.println(enumCorrespondente(disp));
            System.out.println(this.nomeDispositivo.getText());
            try {
                salvarDispositivo(dispositivo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            try {
//                System.out.println(dispositivo);
//                dispositivo.setNome(this.nomeDispositivo.getText());
//                salvarDispositivo(dispositivo);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        });

        }

}
