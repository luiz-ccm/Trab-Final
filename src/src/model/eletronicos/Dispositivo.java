package model.eletronicos;

public abstract class Dispositivo {
    private String nome;
    private boolean estado;

    public Dispositivo(String nome) {
        this.nome = nome;
        this.estado = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean getEstado() {
        return estado;
    }

    public boolean setEstado(Boolean estado) {
        return this.estado = estado;
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

