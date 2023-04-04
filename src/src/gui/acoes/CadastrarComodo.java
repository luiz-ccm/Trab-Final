package gui.acoes;

import model.comodos.Comodo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarComodo extends JPanel implements ActionListener {

    private JLabel labelNomeComodo;
    private JTextField textFieldNomeComodo;
    private  JButton btnCadastrar;

    private JButton btnListarComodos;
    public CadastrarComodo(){
        int width = 550;
        int height = 500;
        this.setLayout(null);
        this.setSize(width,height);
        this.setBackground(new Color(255, 240, 143));
        this.setBounds(250,0,width,height);
        this.setVisible(true);


        this.labelNomeComodo = new JLabel("Nome do comodo:");
        this.add(labelNomeComodo);
        this.labelNomeComodo.setBounds(20,50,130,30);

        this.textFieldNomeComodo = new JTextField();
        this.add(textFieldNomeComodo);
        textFieldNomeComodo.setBounds(130,50,100,30);

        this.btnCadastrar = new JButton("cadastrar");
        this.add(this.btnCadastrar);
        this.btnCadastrar.setBounds(260,50,100,30);
        this.btnCadastrar.addActionListener(this::salvarComodo);

        this.btnListarComodos = new JButton("listar comodos");


    }

    private void salvarComodo(ActionEvent actionEvent) {
        Comodo comodo = new Comodo(this.labelNomeComodo.getText());
    }







    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
