package model.eletronicos;

public class TV extends DispositivoAudioVideo {

    public TV(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "TV";
    }
}

