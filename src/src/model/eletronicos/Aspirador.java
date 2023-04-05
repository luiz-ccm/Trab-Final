/**
 * Classe para o dispositivo aspirador de pó
 */

package model.eletronicos;

import model.comodos.Comodo;

import java.util.ArrayList;
import java.util.List;

public class Aspirador extends Dispositivo{

    private List<Comodo> comodos;

    /**
     * Construtor
     */
    public Aspirador() {
        super();
        this.comodos = new ArrayList<>();
    }
    
    /**
     * Método adicionar comodo na rota do aspirador pela casa
     * @param comodo novo comodo da rota
     */
    public void adicionaComodoRota(Comodo comodo){
        this.comodos.add(comodo);
    }

    /**
     * Método get do tipo de dispositivo
     * @return string com o tipo de dispositivo
     */
    @Override
    public String getTipo() {
        return "Aspirador";
    }
}
