/**
 * Classe de dispositivos ar condicionado
 */

package model.eletronicos;

import java.io.Serializable;

public class ArCondicionado extends Dispositivo implements Serializable {
    private Integer temperatuaAmbiente;
    private Integer temperaturaTarget;

    /**
     * Construtor
     */
    public ArCondicionado() {
        super();
    }

    /**
     * Método get da temperatura desejada para o comodo do dispositivo
     * @return valos do atributo temperaturaTarget
     */
    public Integer getTemperaturaTarget() {
        return temperaturaTarget;
    }

    /**
     * Método set da temperatura desejada para o comodo do dispositivo
     * @param temperaturaTarget temperatura desejada
     */
    public void setTemperaturaTarget(Integer temperaturaTarget) {
        if(this.getEstado() && temperaturaTarget > 15 && temperaturaTarget < 40){
            this.temperaturaTarget = temperaturaTarget;
            this.temperatuaAmbiente = temperaturaTarget;
            this.ligarDesligar();
        }
    }

    /**
     * Método get do tipo de dispositivo
     * @return string com o tipo de dispositivo
     */
    @Override
    public String getTipo() {
        return "Ar condicionado";
    }
}
