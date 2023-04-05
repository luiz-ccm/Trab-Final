/**
 * Classe do dispositivo televisão
 */

package model.eletronicos;

public class TV extends DispositivoAudioVideo {

    /**
     * Construtor
     */
    public TV() {
        super();
    }

    /**
     * Método get do tipo de dispositivo
     * @return string com o tipo de dispositivo
     */
    @Override
    public String getTipo() {
        return "TV";
    }
}

