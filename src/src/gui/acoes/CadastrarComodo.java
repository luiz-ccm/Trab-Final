/**
 * Classe da interface gráfico de cadastro de cômodo
 */

package gui.acoes;

import gui.Screen;
import gui.acoes.exceptions.DadosInvalidosException;
import model.comodos.Comodo;
import model.comodos.TipoComodo;
import model.eletronicos.Dispositivo;
import repository.ComodoRepository;
import repository.DispositivoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static repository.ComodoRepository.salvarComodo;
import static repository.DispositivoRepository.*;

public class CadastrarComodo extends JPanel {
    private JPanel panelListaComodos;
    private List<TipoComodo> tipoComodo;
    private JComboBox<TipoComodo> comboBoxComodo;

    private List<JCheckBox> checkBoxes;

    private JTextField textFieldNomeDoComodo;

    /**
     * Construtor
     * @param component ação
     */
    public CadastrarComodo(Screen component){
        int width = 550;
        int height = 500;
        this.setLayout(null);
        this.setSize(width,height);
        this.setBackground(new Color(255, 240, 143));
        this.setBounds(250,0,width,height);
        this.setVisible(true);

        adicionandoPainelCadastroDeComodos();

    }

    /**
     * Método para adicionar o painel de cadastro de comodos
     */
    private void adicionandoPainelCadastroDeComodos() {
        JLabel tituloGeral = new JLabel("CADASTRAR COMODO");
        tituloGeral.setFont(new Font(tituloGeral.getName(), tituloGeral.getFont().getStyle(),30));
        this.add(tituloGeral);
        tituloGeral.setBounds(90,10,550,30);


        JLabel tituloComodos = new JLabel("Tipo de cômodo:");
        this.add(tituloComodos);
        tituloComodos.setBounds(40,60,100,30);


        this.tipoComodo = Arrays.asList(TipoComodo.values());
        this.panelListaComodos = new JPanel();
        this.panelListaComodos.setLayout(new GridLayout());
        this.panelListaComodos.setBounds(40,100,100,30);
        this.comboBoxComodo = new JComboBox<>(TipoComodo.values());
        this.panelListaComodos.add(comboBoxComodo);
        this.add(this.panelListaComodos);

        JLabel tituloDispositivos = new JLabel("Dispositivos:");
        this.add(tituloDispositivos);
        tituloDispositivos.setBounds(250,60,100,30);


        JLabel labelNomeComodo = new JLabel("Nome do comodo: ");
        this.textFieldNomeDoComodo = new JTextField();
        this.add(labelNomeComodo);
        labelNomeComodo.setBounds(40,180,150,30);
        this.textFieldNomeDoComodo.setBounds(40,210,100,25);
        this.add(this.textFieldNomeDoComodo);

        listaDeDispositivosCadastrado();

        vincularAoComodo();
    }

    /**
     * Método para adicionar botão de vínculo de dispositivo ao comodo
     */
    private void vincularAoComodo() {
        JButton btnVincular = new JButton("vincular");
        btnVincular.addActionListener(this::efetuarVinculo);
        btnVincular.setBounds(40,350,100,30);
        this.add(btnVincular);
    }

    /**
     * Método para efeturar o vínculo entre dispositivo e comodo
     * @param actionEvent evento
     */
    private void efetuarVinculo(ActionEvent actionEvent) {
        TipoComodo tipoComodo = (TipoComodo) this.comboBoxComodo.getSelectedItem();
        String nomeComodo = this.textFieldNomeDoComodo.getText();
        if(nomeComodo.length()<=2){
            JOptionPane.showMessageDialog(null, "Nome do cômodo tem que ter mais de 2 caracteres!", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new DadosInvalidosException("Nome do cômodo tem que ter mais de 2 caracteres!");
        }
        if(this.checkBoxes.stream().noneMatch(JCheckBox::isSelected)){
            JOptionPane.showMessageDialog(null, "Vincule ao menos um dispositivo ao Comodo!", "Erro", JOptionPane.ERROR_MESSAGE);
            throw new DadosInvalidosException("Vincule ao menos um dispositivo ao Comodo!");
        }
        Comodo comodo = new Comodo(nomeComodo,tipoComodo);

        this.checkBoxes.forEach(c ->{
            if(c.isSelected()){
                String nome = c.getText().split(" - ")[1];
                Dispositivo dispositivo = null ;
                try {
                    dispositivo = buscarDispositivoPorNome(nome);
                    comodo.adicionarDispositivo(dispositivo);
                    dispositivo.setComodo(comodo);
                    atualizarDispositivo(dispositivo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        try {
            salvarComodo(comodo);
            this.removeAll();
            this.revalidate();
            this.repaint();
            JOptionPane.showMessageDialog(null, "Comodo criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            adicionandoPainelCadastroDeComodos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Método para listar dispositivos cadastrados
     */
    private void listaDeDispositivosCadastrado(){
        this.checkBoxes = new ArrayList<>();
        JPanel panelCheckBox = new JPanel();
        panelCheckBox.setLayout(new GridLayout(4,4,10,10));
        panelCheckBox.setBounds(180,80,300,300);
        panelCheckBox.setBackground(new Color(123, 232, 224));

        List<Dispositivo> dispositivos = new ArrayList<>();
        try {
            dispositivos = listarTodosDispositivos().stream()
                    .filter(d -> d.getComodo() == null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        dispositivos.forEach(disp ->{
            JCheckBox checkBox = new JCheckBox(disp.getTipo() + " - " + disp.getNome());
            panelCheckBox.add(checkBox);
            this.checkBoxes.add(checkBox);
        });

        this.add(panelCheckBox);
    }




}
