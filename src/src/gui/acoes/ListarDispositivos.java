package gui.acoes;

import gui.Screen;

import javax.swing.*;
import java.awt.*;

public class ListarDispositivos extends JPanel {
    public ListarDispositivos(Screen component){
        int width = 550;
        int height = 500;
        this.setLayout(null);
        this.setSize(width,height);
        this.setBackground(new Color(143, 221, 255));
        this.setBounds(250,0,width,height);
        this.setVisible(true);

        JLabel tituloGeral = new JLabel("LISTAR DISPOSITIVOS");
        tituloGeral.setFont(new Font(tituloGeral.getName(), tituloGeral.getFont().getStyle(),30));
        this.add(tituloGeral);
        tituloGeral.setBounds(90,10,550,30);



    }
}
