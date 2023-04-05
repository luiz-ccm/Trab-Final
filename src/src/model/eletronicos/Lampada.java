/**
 * Classe de dispositivos lâmpadas
 */

package model.eletronicos;

public class Lampada extends Dispositivo {
    
    /**
     * Construtor
     */
    public Lampada() {
        super();
    }

    /**
     * Método get do tipo de dispositivo
     * @return string com o tipo de dispositivo
     */
    @Override
    public String getTipo() {
        return "Lâmpada";
    }


}

