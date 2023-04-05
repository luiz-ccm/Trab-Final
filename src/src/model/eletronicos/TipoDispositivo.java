/**
 * Classe enum para organizar os tipos de dispositivos possíveis
 */

package model.eletronicos;

public enum TipoDispositivo {
    ARCONDICIONADO("Ar condicionado"),
    ASPIRADOR("Aspirador de po"),
    CAFETEIRA("Cafeteira"),
    LAMPADA("Lampada"),
    RADIO("Radio"),
    TV("Tv");

    private String nome;

    /**
     * Construtor
     * @param nome nome do dispositivo
     */
    private TipoDispositivo(String nome){
        this.nome = nome;
    }

    /**
     * Método get do nome dispositivo
     * @return nome do dispositivo
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para verificar o tipo de dispositivo
     * @param nome nome do dispositivo desejado
     * @return tipo do dispositivo
     */
    public static TipoDispositivo enumCorrespondente(String nome) {
        for (TipoDispositivo tipo : TipoDispositivo.values()) {
            if (tipo.getNome().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        return null;
    }

}
