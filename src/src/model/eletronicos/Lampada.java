package model.eletronicos;

public class Lampada extends Dispositivo {
    public Lampada(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "Lâmpada";
    }


}

