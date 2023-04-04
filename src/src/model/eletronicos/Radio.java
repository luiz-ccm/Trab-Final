package model.eletronicos;

public class Radio extends DispositivoAudioVideo {
    public Radio(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "Radio";
    }
}
