package model.eletronicos;

public abstract class DispositivoAudioVideo extends Dispositivo {
    private int volume;
    private int canal;

    public DispositivoAudioVideo(String nome) {
        super(nome);
        this.volume = 0;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public int getVolume() {
        return volume;
    }

    public void aumentarVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void diminuirVolume() {
        if (volume > 0) {
            volume--;
        }
    }
}
