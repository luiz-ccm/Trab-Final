/**
 * Classe para comodos da casa inteligente
 * 
 */


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

    /**
     * Construtor de comodo
     * @param nome nome do comodo
     * @param tipoComodo tipo do comodo
     */
    public Comodo(String nome, TipoComodo tipoComodo) {
        this.nome = nome;
        this.tipoComodo = tipoComodo;
        this.temperatura = 24;
        this.dispositivos = new ArrayList<>();
    }

    /**
     * Método get da temperatura do comodo
     * @return valor do atributo temperetura
     */
    public Integer getTemperatura() {
        return temperatura;
    }

    /**
     * Método set da temperatura do comodo
     * @param temperatura nova temperatura
     */
    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Método get do nome do comodo
     * @return valor do atributo nome
     */
    
    public String getNome() {
        return nome;
    }

    /**
     * Método get do tipo de comodo
     * @return valor do atributo tipo do comodo
     */
    public TipoComodo getTipoComodo() {
        return tipoComodo;
    }


    /**
     * Método para adicionar dispositivo no comodo
     * @param dispositivo novo dispositivo
     */
    public void adicionarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    /**
     * Método para remover dispositivo do comodo
     * @param dispositivo dispositivo a ser retirado
     */
    public void removerDispositivo(Dispositivo dispositivo) {
        dispositivos.remove(dispositivo);
    }

    /**
     * Método para obter todos os dispositivos do comodo
     * @return lista de dispositivos do comodo
     */
    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    /**
     * Método para desvincular dispositivo do comodo
     * @param dispositivo dispositivo a ser desvinculado
     */
    public void desvincular(Dispositivo dispositivo) {
        dispositivos.removeIf(d -> d.getNome().equals(dispositivo.getNome()));
    }
}

