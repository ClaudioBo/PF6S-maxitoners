package mx.maxitoners.datos;

import java.awt.Color;
import javax.swing.JOptionPane;
import mx.maxitoners.negocio.Producto;
import mx.maxitoners.negocio.Respuesta;
import mx.maxitoners.utils.RetrofitUtil;
import mx.maxitoners.vistas.AgregarProducto;
import mx.maxitoners.vistas.EditarProducto;
import mx.maxitoners.vistas.MostrarInventario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Conexion {

    public static void verProductos(MostrarInventario parent) {
        Call<Respuesta> call = RetrofitUtil.obtenerApi().verProductos();
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> rspns) {
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    if (r.isStatus()) {
//                        parent.getListaProductos().clear();
                        parent.getListaProductos().addAll(r.getProducts());
                        parent.rellenarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n " + r.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void agregarProducto(AgregarProducto parent, Producto p) {
        Call<Respuesta> call = RetrofitUtil.obtenerApi().agregarProducto(
                p.getNombre(),
                p.getCantidad(),
                p.getPrecio(),
                p.getCategoria().getId()
        );
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> rspns) {
                parent.txtEstado.setForeground(Color.WHITE);
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    
                    if (r.isStatus()) {
                        JOptionPane.showMessageDialog(null, "Producto '" + p.getNombre() + "' agregado con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        parent.cerrar(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n " + r.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        parent.btnAgregar.setEnabled(true);
                        parent.btnCancelar.setEnabled(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                parent.txtEstado.setForeground(Color.WHITE);
                JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
                parent.btnAgregar.setEnabled(true);
                parent.btnCancelar.setEnabled(true);
            }
        });
    }

    public static void editarProducto(EditarProducto parent, Producto p) {
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
                parent.txtEstado.setForeground(Color.WHITE);
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    if (r.isStatus()) {
                        JOptionPane.showMessageDialog(null, "Producto '" + p.getNombre() + "' editado con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        parent.cerrar(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n " + r.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        parent.btnAgregar.setEnabled(true);
                        parent.btnCancelar.setEnabled(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                parent.txtEstado.setForeground(Color.WHITE);
                JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
                parent.btnAgregar.setEnabled(true);
                parent.btnCancelar.setEnabled(true);
            }
        });
    }

    public static void borrarProducto(MostrarInventario parent, Producto p) {
        Call<Respuesta> call = RetrofitUtil.obtenerApi().borrarProducto(
                p.getId()
        );
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> rspns) {
                if (rspns.isSuccessful()) {
                    Respuesta r = rspns.body();
                    if (r.isStatus()) {
                        JOptionPane.showMessageDialog(null, "Producto '" + p.getNombre() + "' borrado con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        parent.obtenerProductos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n " + r.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable thrwbl) {
                JOptionPane.showMessageDialog(null, "Hubo un error por parte del servidor:\n No hubo conexion hacia el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
