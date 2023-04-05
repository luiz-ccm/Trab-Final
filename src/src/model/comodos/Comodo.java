package model.comodos;

import model.eletronicos.Dispositivo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comodo implements Serializable {
    private String nome;
    private TipoComodo tipoComodo;
    private List<Dispositivo> dispositivos;
    private Integer temperatura;

    public Comodo(String nome, TipoComodo tipoComodo) {
        this.nome = nome;
        this.tipoComodo = tipoComodo;
        this.temperatura = 24;
        this.dispositivos = new ArrayList<>();
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public String getComodo() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public TipoComodo getTipoComodo() {
        return tipoComodo;
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

