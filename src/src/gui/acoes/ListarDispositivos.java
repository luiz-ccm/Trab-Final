/**
 * Classe da interface gráfica de listagem de dispositivos
 */

package gui.acoes;

import gui.Screen;
import model.comodos.Comodo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

import static repository.ComodoRepository.buscarComodoPorNome;
import static repository.ComodoRepository.listarTodosComodos;

public class ListarDispositivos extends JPanel {
    private JPanel panelComodosEDispositivos;
    private JPanel painelAtual;
    private List<JButton> btnList;

    /**
     * Construtor
     * @param component ação
     */
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


        this.painelAtual =null;

        this.panelComodosEDispositivos = new JPanel();
        this.panelComodosEDispositivos.setLayout(new GridLayout(1,2,10,10));
        this.panelComodosEDispositivos.setBackground(new Color(143, 255, 130));
        this.panelComodosEDispositivos.setBounds(20,60,500,360);
        this.add(this.panelComodosEDispositivos);


        this.panelComodosEDispositivos.add(listaDeComodos());
    }

    /**
     * Método para o painel de listagem de comodos
     * @return ação
     */
    private Component listaDeComodos() {
        JPanel panelListaDeComodo = new JPanel();

        panelListaDeComodo.setSize(200,360);
        panelListaDeComodo.setLayout(new GridLayout(10,1,10,10));
        try {
            listarTodosComodos().forEach(comodo -> {
                JButton btnComodo = new JButton(comodo.getTipoComodo() + " - " + comodo.getNome());
                btnComodo.addActionListener(e -> mostrarComodo(btnComodo.getActionCommand()));
                panelListaDeComodo.add(btnComodo);

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return panelListaDeComodo;
    }

    /**
     * Método para mostrar comodo específico
     * @param nome nome do comodo desejado
     */
    private void mostrarComodo(String nome) {;
        Comodo comodo;
        try {
            comodo = buscarComodoPorNome(nome.split(" - ")[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        JPanel panelDispositivoDoComodo = new JPanel();
        panelDispositivoDoComodo.setLayout(new GridLayout(10,1,5,5));

        comodo.getDispositivos().forEach(disp ->{

            JPanel panelDisp = new JPanel();
            panelDisp.setLayout(new GridLayout(1,3));
            JLabel labelNomeDispositivo = new JLabel(disp.getNome(), JLabel.CENTER);
            JLabel labelTipoDispositivo = new JLabel(disp.getTipo(),JLabel.CENTER);
            JLabel labelEstado = new JLabel(disp.getEstado()? "ligado" : "desligado",JLabel.CENTER);

            panelDisp.add(labelNomeDispositivo);
            panelDisp.add(labelTipoDispositivo);
            panelDisp.add(labelEstado);

            panelDispositivoDoComodo.add(panelDisp);

        });

        if (painelAtual!= null)
            this.panelComodosEDispositivos.remove(painelAtual);
        this.panelComodosEDispositivos.add(panelDispositivoDoComodo);
        painelAtual = panelDispositivoDoComodo;
        this.revalidate();
        this.repaint();

    }
}
