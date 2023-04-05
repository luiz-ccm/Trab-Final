/**
 * Classe para  instanciar os dispositivos conforme o tipo
 */

package model.util;

import model.eletronicos.*;

public class Instanciador {
    public static Dispositivo instanciar(TipoDispositivo tipoDispositivo){
        switch (tipoDispositivo) {
            case ARCONDICIONADO:
                return new ArCondicionado();
            case ASPIRADOR:
                return new Aspirador();
            case CAFETEIRA:
                return new Cafeteira();
            case LAMPADA:
                return new Lampada();
            case RADIO:
                return new Radio();
            case TV:
                return new TV();
            default:
                throw new IllegalArgumentException("Tipo de dispositivo inválido: " + tipoDispositivo);        }

    }
}
