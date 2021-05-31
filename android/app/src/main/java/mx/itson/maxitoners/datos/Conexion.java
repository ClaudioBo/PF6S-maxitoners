package mx.itson.maxitoners.datos;

import android.widget.Toast;

import java.util.Collection;

import mx.itson.maxitoners.ProductoFormActivity;
import mx.itson.maxitoners.ProductosListActivity;
import mx.itson.maxitoners.negocio.Producto;
import mx.itson.maxitoners.negocio.Respuesta;
import mx.itson.maxitoners.utils.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Conexion {

    public static void verProductos(ProductosListActivity parent, boolean avisar) {
        Call<Respuesta> call = RetrofitUtil.obtenerApi().verProductos();
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> rspns) {
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    if (r.isStatus()) {
                        parent.getListProducto().clear();
                        parent.getListProducto().addAll((Collection<? extends Producto>) r.getProducts());
                        parent.cargarLista();
                        if(avisar){
                            Toast.makeText(parent,"Lista recargada.",Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(parent,"Hubo un error por parte del servidor:\n " + r.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                Toast.makeText(parent,"Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.",Toast.LENGTH_LONG).show();
            }
        });
    }

    public static void agregarProducto(ProductoFormActivity parent, Producto p) {
        Call<Respuesta> call = RetrofitUtil.obtenerApi().agregarProducto(
                p.getNombre(),
                p.getCantidad(),
                p.getPrecio(),
                p.getCategoria().getId()
        );
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> rspns) {
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    if (r.isStatus()) {
                        Toast.makeText(parent,"Producto '" + p.getNombre() + "' agregado con exito.", Toast.LENGTH_LONG).show();
                        parent.cerrar();
                    } else {
                        Toast.makeText(parent,"Hubo un error por parte del servidor:\n " + r.getMessage(), Toast.LENGTH_LONG).show();
                        parent.cerrar();
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                Toast.makeText(parent,"Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.", Toast.LENGTH_LONG).show();
                parent.cerrar();
            }
        });
    }

    public static void editarProducto(ProductoFormActivity parent, Producto p) {
        Call<Respuesta> call = RetrofitUtil.obtenerApi().editarProducto(
                p.getId(),
                p.getNombre(),
                p.getCantidad(),
                p.getPrecio(),
                p.getCategoria().getId()
        );
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> rspns) {
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    if (r.isStatus()) {
                        parent.cerrar();
                        Toast.makeText(parent,"Producto '" + p.getNombre() + "' editado con exito.",  Toast.LENGTH_LONG).show();
                    } else {
                        parent.cerrar();
                        Toast.makeText(parent,"Hubo un error por parte del servidor:\n " + r.getMessage(),  Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                parent.cerrar();
                Toast.makeText(parent,"Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.", Toast.LENGTH_LONG).show();
            }
        });
    }
    
    public static void borrarProducto(ProductosListActivity parent, Producto p) {

        Call<Respuesta> call = RetrofitUtil.obtenerApi().borrarProducto(p.getId());

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> rspns) {
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    if (r.isStatus()) {
                        parent.recargarLista(false);
                        Toast.makeText(parent,"Producto '" + p.getNombre() + "' borrado con exito.", Toast.LENGTH_LONG).show();;
                    } else {
                        Toast.makeText(parent,"Hubo un error por parte del servidor:\n " + r.getMessage(), Toast.LENGTH_LONG).show();;
                    }
                } else {
                Toast.makeText(parent,"Hubo un error por parte de la aplicacion.", Toast.LENGTH_LONG).show();;
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                Toast.makeText(parent,"Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.", Toast.LENGTH_LONG).show();
            }
        });
    }

}
