/**
 * Classe da interface gráfico de cadastro de dispositivos
 */

package gui.acoes;

import gui.Screen;
import gui.acoes.exceptions.DadosInvalidosException;
import gui.acoes.exceptions.DispositivoJaExisteException;
import model.eletronicos.Dispositivo;
import model.eletronicos.TipoDispositivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.util.Instanciador.instanciar;
import static repository.DispositivoRepository.salvarDispositivo;

public class CadastrarDispositivo extends JPanel {

    private JPanel panelListaDispositivo;

    private JTextField nomeDispositivo;
    
    List<TipoDispositivo> tipoDispositivo;

    private JComboBox<TipoDispositivo> comboBoxTipoDispositivo;

    List<JCheckBox> checkboxes = new ArrayList<>();

    /**
     * Construtor
     * @param component ação
     */
    public CadastrarDispositivo(Screen component){
        int width = 550;
        int height = 500;
        this.setLayout(null);
        this.setSize(width,height);
        this.setBackground(new Color(255, 143, 220));
        this.setBounds(250,0,width,height);
        this.setVisible(true);



        adicionandoPainelCadastroDeDispositivos();
    }

    /**
     * Método para adicionar o painel de cadastro de dispositivos
     */
    private void adicionandoPainelCadastroDeDispositivos(){
        JLabel tituloGeral = new JLabel("CADASTRAR DISPOSITIVO");
        tituloGeral.setFont(new Font(tituloGeral.getName(), tituloGeral.getFont().getStyle(),30));
        this.add(tituloGeral);
        tituloGeral.setBounds(70,10,550,30);

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
    
    /**
     * Método para cadastrar um dispositivo
     * @param actionEvent evento
     */
    private void cadastrar(ActionEvent actionEvent) {
        Dispositivo dispositivo = instanciar((TipoDispositivo) this.comboBoxTipoDispositivo.getSelectedItem());
        String nomeDispositivo =this.nomeDispositivo.getText();
        if(nomeDispositivo.length() <= 2) {
            JOptionPane.showMessageDialog(null, "Nome tem que ter mais de 2 caracteres!", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new DadosInvalidosException("Nome tem que ter mais de 2 caracteres!");
        }
        dispositivo.setNome(nomeDispositivo);

        try {
            salvarDispositivo(dispositivo);
        } catch (DispositivoJaExisteException e) {
            JOptionPane.showMessageDialog(null, "Dispositivo Já Cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new DispositivoJaExisteException("Dispositivo Já Cadastrado!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.removeAll();
        this.revalidate();
        this.repaint();

        adicionandoPainelCadastroDeDispositivos();
        JOptionPane.showMessageDialog(null, "Dispositivo criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);


    }



}
