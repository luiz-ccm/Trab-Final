package gui.acoes;

import gui.Screen;
import model.comodos.TipoComodo;
import model.eletronicos.TipoDispositivo;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class CadastrarDispositivo extends JPanel {

    private JPanel panelListaDispositivo;

    private JTextField nomeDispositivo;
    List<TipoDispositivo> tipoDispositivo;


    private JCheckBox checkBox;


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
        tituloComodos.setBounds(40,60,150,30);

        this.tipoDispositivo = Arrays.asList(TipoDispositivo.values());
        this.panelListaDispositivo = new JPanel();
        this.panelListaDispositivo.setLayout(new GridLayout(2,5));
        this.panelListaDispositivo.setBounds(20,85,550,140);
//        this.panelListaDispositivo.add(this.checkBox);

        tipoDispositivo.forEach(disp ->{
            this.checkBox = new JCheckBox(disp.getNome());
            this.panelListaDispositivo.add(this.checkBox);
        });


        this.add(this.panelListaDispositivo);
    }
}
