/**
 * Classe de dispositivos de Audio e Vídeo
 */

package model.eletronicos;

public abstract class DispositivoAudioVideo extends Dispositivo {
    private int volume;
    private int canal;

    /**
     * Construtor
     */
    public DispositivoAudioVideo() {
        super();
        this.volume = 0;
    }

    /**
     * Método get do canal do dispositivo
     * @return valor do atributo canal
     */
    public int getCanal() {
        return canal;
    }

    /**
     * Método set do canal do dispositivo
     * @param canal novo canal do dispositivo
     */
    public void setCanal(int canal) {
        this.canal = canal;
    }

    /**
     * Método get do volume do dispositivo
     * @return valor do atributo volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Método para aumentar o volume em uma unidade
     */
    public void aumentarVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    /**
     * Método para diminui o volume em uma unidade
     */
    public void diminuirVolume() {
        if (volume > 0) {
            volume--;
        }
    }
}
