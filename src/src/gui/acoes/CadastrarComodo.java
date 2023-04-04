package gui.acoes;

import gui.Screen;
import model.comodos.TipoComodo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

public class CadastrarComodo extends JPanel {
    private JPanel panelListaComodos;
    private List<TipoComodo> tipoComodo;

    private JComboBox<TipoComodo> comboBoxComodo;

    public CadastrarComodo(Screen component){
        int width = 550;
        int height = 500;
        this.setLayout(null);
        this.setSize(width,height);
        this.setBackground(new Color(255, 240, 143));
        this.setBounds(250,0,width,height);
        this.setVisible(true);

        JLabel tituloGeral = new JLabel("CADASTRAR COMODO");
        tituloGeral.setFont(new Font(tituloGeral.getName(), tituloGeral.getFont().getStyle(),30));
        this.add(tituloGeral);
        tituloGeral.setBounds(90,10,550,30);

        adicionandoPainelCadastroDeComodos();

    }

    private void adicionandoPainelCadastroDeComodos(){
        JLabel tituloComodos = new JLabel("Tipo de cômodo:");
        this.add(tituloComodos);
        tituloComodos.setBounds(40,60,100,30);


        this.tipoComodo = Arrays.asList(TipoComodo.values());
        this.panelListaComodos = new JPanel();
        this.panelListaComodos.setLayout(new GridLayout());
        this.panelListaComodos.setBounds(40,100,100,30);
        this.comboBoxComodo = new JComboBox<>(TipoComodo.values());
        this.panelListaComodos.add(comboBoxComodo);

        JLabel tituloDispositivos = new JLabel("Dispositivos:");
        this.add(tituloDispositivos);
        tituloDispositivos.setBounds(250,60,100,30);

        this.add(this.panelListaComodos);
    }
    private void salvarComodo(ActionEvent actionEvent) {

    }


}
