package model.eletronicos;

public enum TipoDispositivo {
    ARCONDICIONADO("Ar condicionado"),
    ASPIRADOR("Aspirador de po"),
    CAFETEIRA("Cafeteira"),
    LAMPADA("Lampada"),
    RADIO("Radio"),
    TV("Tv");

    private String nome;

    private TipoDispositivo(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static TipoDispositivo enumCorrespondente(String nome) {
        for (TipoDispositivo tipo : TipoDispositivo.values()) {
            if (tipo.getNome().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        return null;
    }

}
