package model.comodos;

import model.eletronicos.Dispositivo;

import java.util.ArrayList;
import java.util.List;

public class Comodo {
    private String nome;
    private List<Dispositivo> dispositivos;
    private Integer temperatura;

    public Comodo(String nome) {
        this.nome = nome;
        this.temperatura = 24;
        this.dispositivos = new ArrayList<>();
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public String getNome() {
        return nome;
    }

    public void salvarStatus(){

    };

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

