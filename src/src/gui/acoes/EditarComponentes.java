package gui.acoes;

import gui.acoes.exceptions.DadosInvalidosException;
import model.comodos.Comodo;
import model.eletronicos.Dispositivo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

import static repository.ComodoRepository.*;
import static repository.DispositivoRepository.*;

public class EditarComponentes extends JFrame {
    private JLabel estadoDisp;
    private JComboBox<String> comboBoxDispositivos;
    private JPanel container;

    public EditarComponentes(Comodo comodo) {
        super("Editar Componentes");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setSize(700,400);
        this.setVisible(true);

        addTelaInicial(comodo);


    }


    private void addTelaInicial(Comodo comodo){
        JLabel labelNomeComodo = new JLabel(comodo.getNome() + " - " + comodo.getTipoComodo(),JLabel.CENTER);
        labelNomeComodo.setFont(new Font(labelNomeComodo.getName(), labelNomeComodo.getFont().getStyle(),24));
        labelNomeComodo.setSize(400,30);
        labelNomeComodo.setBounds(0,0,400,30);

        JButton btnExcluirComodo = new JButton("excluir comodo");
        btnExcluirComodo.setBounds(300,10,130,20);
        btnExcluirComodo.addActionListener(c -> excluirComodo(comodo));
        this.add(labelNomeComodo);
        this.add(btnExcluirComodo);

        JPanel panelListaDeDispositivos = new JPanel();
        panelListaDeDispositivos.add(listaDeDispositivos(comodo));
        panelListaDeDispositivos.setBounds(5,100,650,300);

        this.comboBoxDispositivos = new JComboBox<>();
        List<Dispositivo> todosDispositivosDisponiveis;
        try {
            todosDispositivosDisponiveis = listarTodosDispositivos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        todosDispositivosDisponiveis.stream().filter(d -> d.getComodo() == null).forEach(disp -> {
            comboBoxDispositivos.addItem(disp.getTipo() + " - " + disp.getNome());
        });
        this.comboBoxDispositivos.setBounds(120,50,150,20);
        this.add(comboBoxDispositivos);
        JButton btnVincularDispositivo = new JButton("vincular");
        btnVincularDispositivo.addActionListener(e -> {
            if(comboBoxDispositivos.getItemCount() == 0){
                JOptionPane.showMessageDialog(null, "primeiramente cadestre um dispositivo!", "Erro", JOptionPane.ERROR_MESSAGE);
                throw new DadosInvalidosException("primeiramente cadestre um dispositivo!");
            }

             vincularDispositivoAoComodo(comodo);
        });
        btnVincularDispositivo.setBounds(300,50,100,20);
        this.add(btnVincularDispositivo);
        this.add(panelListaDeDispositivos);
    }

    private void vincularDispositivoAoComodo(Comodo comodo) {

        String nome = this.comboBoxDispositivos.getSelectedItem().toString().split(" - ")[1];
        Dispositivo dispositivo = null ;
        Comodo com = null;
        try {
            dispositivo = buscarDispositivoPorNome(nome);
            com = buscarComodoPorNome(comodo.getNome());
            com.adicionarDispositivo(dispositivo);
            dispositivo.setComodo(com);
            atualizarDispositivo(dispositivo);
            atualizarComodo(com);
            JOptionPane.showMessageDialog(null, "Dispositivo vinculado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.dispose();

    }

    private Component listaDeDispositivos(Comodo comodo) {
        JPanel listadisp = new JPanel();
        listadisp.setLayout(new GridLayout(10,1,10,10));


        comodo.getDispositivos().forEach(disp ->{
            JButton btnExcluir = new JButton("excluir");
            JButton btnDesvincular = new JButton("desvincular");
            JButton btnLigarDesligar = new JButton("ligar/desligar");
            btnDesvincular.addActionListener(c -> desvincularDispositivoDoComodo(comodo,disp));
            btnDesvincular.setSize(40,30);
            btnLigarDesligar.addActionListener(c -> ligarDesligar(disp,comodo));
            btnLigarDesligar.setSize(40,30);
            btnExcluir.setSize(40,30);
            btnExcluir.addActionListener(c -> excluirDispositivo(disp,comodo));
            container = new JPanel();
            container.setLayout(new GridLayout(1,6));
            JLabel nomedisp = new JLabel(disp.getNome(),JLabel.CENTER);
            JLabel tipoDisp = new JLabel(disp.getTipo(),JLabel.CENTER);
            this.estadoDisp = new JLabel(disp.getEstado()?"ligado":"desligado",JLabel.CENTER);
            container.add(nomedisp);
            container.add(tipoDisp);
            container.add(this.estadoDisp);
            container.add(btnLigarDesligar);
            container.add(btnDesvincular);
            container.add(btnExcluir);

            nomedisp.setSize(350,20);
            listadisp.add(container);
        });
        return listadisp;
    }



    private void ligarDesligar(Dispositivo disp, Comodo comodo) {
        try {
            ligarDesligarNoBanco(disp, comodo);
            estadoDisp.setText(disp.getEstado() ? "ligado" : "desligado");
            this.dispose();
            JOptionPane.showMessageDialog(null, "Dispositivo " + disp.getTipo() + (disp.getEstado()?" desligado":" ligado") + " com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void desvincularDispositivoDoComodo(Comodo comodo, Dispositivo disp) {

        try {
            desvincularDispositivo(disp,comodo);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Dispositivo " + disp.getTipo() + " desvinculado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void excluirDispositivo(Dispositivo disp, Comodo comodo) {
        try {
            excluirDispositivoDoBanco(disp,comodo);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Dispositivo excluido com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void excluirComodo(Comodo comodo) {
        try {
            excluirComodoDoBanco(comodo);
            this.dispose();
            JOptionPane.showMessageDialog(null, comodo.getTipoComodo() + " nomeado(a) de " + comodo.getNome() + " excluida com sucesso!" , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
