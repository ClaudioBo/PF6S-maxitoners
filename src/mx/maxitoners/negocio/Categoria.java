package mx.maxitoners.negocio;

import com.google.gson.annotations.SerializedName;

public enum Categoria {
    @SerializedName("1")
    CARTUCHOS(1, "Cartuchos de toner nuevos comp."),
    
    @SerializedName("2")
    TONER(2, "Toner en Kilos"),
    
    @SerializedName("3")
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
