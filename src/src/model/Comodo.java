package model;

import model.eletronicos.Dispositivo;

import java.util.ArrayList;
import java.util.List;

public class Comodo {
    private String nome;
    private List<Dispositivo> dispositivos;

    public Comodo(String nome) {
        this.nome = nome;
        this.dispositivos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void removerDispositivo(Dispositivo dispositivo) {
        dispositivos.remove(dispositivo);
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }
}

