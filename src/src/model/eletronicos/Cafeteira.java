package model.eletronicos;

public class Cafeteira extends Dispositivo{

    public Cafeteira(String nome) {
        super(nome);
    }
    @Override
    public String getTipo() {
        return "Cafeteira";
    }

}
