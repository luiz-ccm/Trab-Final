package model.eletronicos;

public class TV extends DispositivoAudio {
    private int canal;

    public TV(String nome) {
        super(nome);
        this.canal = 1;
    }

    public int getCanal() {
        return canal;
    }

    public void aumentarCanal() {
        this.canal++;
    }

    public void diminuirCanal() {
        if (canal > 1) {
            canal--;
        }
    }

    public String getTipo() {
        return "TV";
    }
}

