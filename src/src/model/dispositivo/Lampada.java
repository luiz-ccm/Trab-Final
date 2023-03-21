package model.dispositivo;

public class Lampada extends Dispositivo {

    protected int intensidade;

    public Lampada(String nome) {
        super(nome,false);
        this.intensidade = 0;
    }

    public int getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(int intensidade) {
        if (estado && intensidade > 0) //Criar exceção
            this.intensidade = intensidade;
        else
            System.out.println(" Falha ao settar intensidade ");
    }


}
