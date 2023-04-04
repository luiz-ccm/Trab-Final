package model.comodos;

import java.awt.*;

public enum TipoComodo {
    QUARTO("Quarto"),
    SALA("Sala"),
    COZINHA("Cozinha"),
    BANHEIRO("Banheiro");

    private String nome;

    private TipoComodo(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}