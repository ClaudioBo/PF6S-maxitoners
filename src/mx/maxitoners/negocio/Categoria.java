package mx.maxitoners.negocio;

public enum Categoria {
    CARTUCHOS_DE_TONER_NUEVOS_COMP(1),
    TONER_EN_KILOS(2),
    SUMINISTROS(3);

    private final int id;

    private Categoria(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Categoria getCategoria(int id) {
        for (Categoria value : values()) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }

}
