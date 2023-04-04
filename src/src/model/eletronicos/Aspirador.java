package model.eletronicos;

import model.comodos.Comodo;

import java.util.ArrayList;
import java.util.List;

public class Aspirador extends Dispositivo{

    private List<Comodo> comodos;
    public Aspirador() {
        super();
        this.comodos = new ArrayList<>();
    }

    public void adicionaComodoRota(Comodo comodo){
        this.comodos.add(comodo);
    }

    @Override
    public String getTipo() {
        return "Aspirador";
    }
}
