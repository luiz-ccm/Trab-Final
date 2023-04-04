package model.eletronicos;

import java.io.Serializable;

public abstract class Dispositivo implements Serializable {
    private String nome;
    private boolean estado;

    public Dispositivo() {
        this.estado = false;
    }

    public String getNome() {
        return nome;
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
                ", estado=" + estado +
                '}';
    }
}

