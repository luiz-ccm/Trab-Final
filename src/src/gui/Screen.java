package gui;

import gui.acoes.CadastrarComodo;
import gui.acoes.CadastrarDispositivo;
import gui.acoes.ListarDispositivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {
    private JComponent componenteAtivo;
    private JPanel panelOpcoes;
    private JButton btnCadastrarDispositivo;
    private JButton btnCadastrarComodo;
    private JButton btnListarDispositivos;
    public Screen(){
        int width = 800;
        int height = 500;
        int btnWidth = 200;
        int btnHeight = 50;
        int espacamento = 70;

        setTitle("Casa Inteligente");
        setVisible(true);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        this.panelOpcoes = new JPanel();
        this.panelOpcoes.setLayout(null);
        this.panelOpcoes.setSize(250,height);
        this.panelOpcoes.setBackground(new Color(176, 255, 176));
        this.panelOpcoes.setVisible(true);

        this.btnCadastrarDispositivo = new JButton("cadastrar dispositivo");
        this.btnCadastrarDispositivo.addActionListener(this);
        this.btnCadastrarDispositivo.setBounds(25,espacamento,btnWidth,btnHeight);

        this.btnCadastrarComodo = new JButton("cadastrar comodo");
        this.btnCadastrarComodo.addActionListener(this);
        this.btnCadastrarComodo.setBounds(
                    btnCadastrarDispositivo.getX(),
                btnCadastrarDispositivo.getY()+btnHeight+espacamento,
                btnWidth,
                btnHeight);

        this.btnListarDispositivos = new JButton("listar dispositivos");
        this.btnListarDispositivos.addActionListener(this);
        this.btnListarDispositivos.setBounds(
                btnCadastrarComodo.getX(),
                btnCadastrarComodo.getY()+btnHeight+espacamento,
                btnWidth,
                btnHeight);


        this.panelOpcoes.add(btnCadastrarDispositivo);
        this.panelOpcoes.add(btnCadastrarComodo);
        this.panelOpcoes.add(btnListarDispositivos);

        this.add(panelOpcoes);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("cadastrar dispositivo")){
            adicionarTelaDeAcao(new CadastrarDispositivo());
        }
        if(actionEvent.getActionCommand().equals("cadastrar comodo")){
            adicionarTelaDeAcao(new CadastrarComodo());
        }
        if(actionEvent.getActionCommand().equals("listar dispositivos")){
            adicionarTelaDeAcao(new ListarDispositivos());
        }
    }

    private void adicionarTelaDeAcao(JComponent component){
        if(!(componenteAtivo == null))
            this.remove(componenteAtivo);
        this.add(component);
        this.revalidate();
        this.repaint();
        componenteAtivo = component;
    }
}
