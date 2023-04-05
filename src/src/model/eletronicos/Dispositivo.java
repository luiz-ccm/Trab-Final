package model.eletronicos;

import model.comodos.Comodo;

import java.io.Serial;
import java.io.Serializable;

public abstract class Dispositivo implements Serializable {

    private String nome;
    private Comodo comodo;
    private boolean estado;


    public Dispositivo() {
        this.estado = false;
    }

    public String getNome() {
        return nome;
    }

    public Comodo getComodo() {
        return comodo;
    }

    public void setComodo(Comodo comodo) {
        this.comodo = comodo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getEstado() {
        return estado;
    }

    public void ligarDesligar() {
        this.estado = !this.estado;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "Dispositivo{" +
                "nome='" + nome + '\'' +
                ", comodo=" + comodo +
                ", estado=" + estado +
                '}';
    }
}

