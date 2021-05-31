package mx.maxitoners.negocio;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Respuesta {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message = null;

    @SerializedName("inserted_id")
    private int inserted_id = -1;

    @SerializedName("products")
    private List<Producto> products = null;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getInserted_id() {
        return inserted_id;
    }

    public List<Producto> getProducts() {
        return products;
    }

}
