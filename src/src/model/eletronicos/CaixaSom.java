package model.eletronicos;

public class CaixaSom extends DispositivoAudio {
    public CaixaSom(String nome) {
        super(nome);
    }

    public String getTipo() {
        return "Caixa de Som";
    }
}
