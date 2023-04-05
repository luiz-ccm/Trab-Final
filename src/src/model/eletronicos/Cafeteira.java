/**
 * Classe do dispositivo cafeteira
 */

package model.eletronicos;

public class Cafeteira extends Dispositivo{

    /**
     * Construtor
     */
    public Cafeteira() {
        super();
    }

    /**
     * Método get do tipo de dispositivo
     * @return string com o tipo de dispositivo
     */
    @Override
    public String getTipo() {
        return "Cafeteira";
    }

}
