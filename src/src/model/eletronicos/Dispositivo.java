/**
 * Classe abstrata de dispositivos da casa
 */

package model.eletronicos;

import model.comodos.Comodo;

import java.io.Serializable;

public abstract class Dispositivo implements Serializable {

    private String nome;
    private Comodo comodo;
    private boolean estado;

    /**
     * Construtor
     */
    public Dispositivo() {
        this.estado = false;
    }

    /**
     * Método get do nome do dispositivo
     * @return String do atributo nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método get do comodo que o dispositivo pertence
     * @return valor do artibuto comodo
     */
    public Comodo getComodo() {
        return this.comodo;
    }

    /**
     * Método set do comodo que o dispositivo pertence
     * @param comodo novo comodo que o dispositivo pertence
     */
    public void setComodo(Comodo comodo) {
        this.comodo = comodo;
    }

    /**
     * Método set do nome do dispositivo
     * @param nome novo nome do dispositivo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método get do estado do dispositivo
     * @return estado ligado (true) ou desligado (false) do dispositivo
     */
    public boolean getEstado() {
        return this.estado;
    }

    /**
     * Método para ligar ou desligar o dispositivo
     */
    public void ligarDesligar() {
        this.estado = !this.estado;
    }

    /**
     * Método get do tipo de dispositivo
     * @return string com o tipo de dispositivo
     */
    public abstract String getTipo();

    /**
     * Método de retorno dos atributos do dispositov
     * @return string com os atributos do dispositivo
     */
    @Override
    public String toString() {
        return "Dispositivo{" +
                "nome='" + this.nome + '\'' +
                ", comodo=" + this.comodo +
                ", estado=" + this.estado +
                '}';
    }

    public void desvincularComodo() {
        this.comodo =null;
    }
}

