package mx.maxitoners.negocio;

public enum Categoria {
    CARTUCHOS(1, "Cartuchos de toner nuevos comp."),
    TONER(2, "Toner en Kilos"),
    SUMINISTROS(3, "Suministros");

    private final int id;
    private final String nombre;

    private Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public static Categoria getCategoria(int id) {
        for (Categoria value : values()) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }

}
