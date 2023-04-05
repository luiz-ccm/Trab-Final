package model.eletronicos;

import java.io.Serializable;

public class ArCondicionado extends Dispositivo implements Serializable {
    private Integer temperatuaAmbiente;
    private Integer temperaturaTarget;
    public ArCondicionado() {
        super();

    }

    public Integer getTemperaturaTarget() {
        return temperaturaTarget;
    }

    public void setTemperaturaTarget(Integer temperaturaTarget) {
        if(this.getEstado() && temperaturaTarget > 15 && temperaturaTarget < 40){
            this.temperaturaTarget = temperaturaTarget;
            this.temperatuaAmbiente = temperaturaTarget;
            this.ligarDesligar();
        }
    }

    @Override
    public String getTipo() {
        return "Ar condicionado";
    }
}
