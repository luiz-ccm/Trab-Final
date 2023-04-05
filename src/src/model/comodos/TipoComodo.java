/**
 * Classe enum para os tipos de comodos: quarto, sala, cozinha, banheiro
 */

package model.comodos;

import java.awt.*;
import java.io.Serializable;

public enum TipoComodo  {
    QUARTO("Quarto"),
    SALA("Sala"),
    COZINHA("Cozinha"),
    BANHEIRO("Banheiro");

    private String nome;

    /**
     * Construtor
     * @param nome nome do comodo
     */
    private TipoComodo(String nome){
        this.nome = nome;
    }

    /**
     * Método get do nome do comodo
     * @return string do atributo nome
     */
    public String getNome() {
        return nome;
    }
}
