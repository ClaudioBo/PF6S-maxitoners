package mx.itson.maxitoners.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mx.itson.maxitoners.R;
import mx.itson.maxitoners.negocio.Producto;

public class ProductosAdapters extends BaseAdapter {

    private Context context;
    private List<Producto> productos;

    public ProductosAdapters(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() { return productos.size(); }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto p = (Producto) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item_producto, null);

        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        txtNombre.setText(p.getNombre());

        TextView txtCantidad = convertView.findViewById(R.id.txtCantidad);
        txtCantidad.setText(p.getCantidad()+" disponibles");

        TextView txtPrecio = convertView.findViewById(R.id.txtPrecio);
        txtPrecio.setText("$"+p.getPrecio()+" MXN");

        TextView txtCategoria = convertView.findViewById(R.id.txtCategoria);
        txtCategoria.setText(p.getCategoria().getNombre());

        return convertView;
    }
}
