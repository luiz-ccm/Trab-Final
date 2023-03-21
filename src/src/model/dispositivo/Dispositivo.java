package model.dispositivo;

public abstract class Dispositivo {
    protected String nome;
    protected boolean estado;

    public Dispositivo(String nome, boolean estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEstado() {
        return estado;
    }

    public void mudarEstado() {
        this.estado = !this.estado;
    }
}
