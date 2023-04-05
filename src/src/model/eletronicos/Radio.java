/**
 * Classe de dispositivos rádio
 */

package model.eletronicos;

public class Radio extends DispositivoAudioVideo {
    
    /**
     * Construtor
     */
    public Radio() {
        super();
    }

    /**
     * Método get do tipo de dispositivo
     * @return string com o tipo de dispositivo
     */
    @Override
    public String getTipo() {
        return "Radio";
    }
}
