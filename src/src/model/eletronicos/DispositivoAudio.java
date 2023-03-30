package model.eletronicos;

public abstract class DispositivoAudio extends Dispositivo {
    private int volume;

    public DispositivoAudio(String nome) {
        super(nome);
        this.volume = 0;
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
