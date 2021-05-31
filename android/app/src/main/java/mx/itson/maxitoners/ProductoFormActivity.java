package mx.itson.maxitoners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mx.itson.maxitoners.datos.Conexion;
import mx.itson.maxitoners.negocio.Categoria;
import mx.itson.maxitoners.negocio.Producto;

public class ProductoFormActivity extends AppCompatActivity {

    int editing_id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productos_form);
        Intent intent = getIntent();

        Spinner spnCategorias = (Spinner)findViewById(R.id.spnCategorias);

        String[] arraySpinner = new String[Categoria.values().length];
        int i = 0;
        for (Categoria c : Categoria.values()) {
            arraySpinner[i++] = c.getNombre();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategorias.setAdapter(adapter);

        if(intent.hasExtra("prod_id")){

            TextView txtTitulo = ((TextView)findViewById(R.id.txtTitulo));
            txtTitulo.setText("Editar producto");


//            TextView txtId = ((TextView)findViewById(R.id.txtId));
            TextView txtNombre = ((TextView)findViewById(R.id.txtNombre));
            TextView txtCantidad = ((TextView)findViewById(R.id.txtCantidad));
            TextView txtPrecio = ((TextView)findViewById(R.id.txtPrecio));

            editing_id = intent.getIntExtra("prod_id",-1);
            String nombre_extra = intent.getStringExtra("nombre");
            int cantidad_extra = intent.getIntExtra("cantidad",0);
            double precio_extra = intent.getDoubleExtra("precio",0.0);
            int categoria_extra = intent.getIntExtra("categoria",0);

//            txtId.setText(editing_id);
            txtNombre.setText(nombre_extra);
            txtCantidad.setText(cantidad_extra+"");
            txtPrecio.setText(precio_extra+"");
            spnCategorias.setSelection(categoria_extra-1);
        }
    }

    public void guardar(View v){
//        String id = ((TextView)findViewById(R.id.txtId)).getText().toString();
        String nombre = ((TextView)findViewById(R.id.txtNombre)).getText().toString();
        int cantidad = Integer.valueOf(((TextView)findViewById(R.id.txtCantidad)).getText().toString());
        double precio = Double.valueOf(((TextView)findViewById(R.id.txtPrecio)).getText().toString());
        int categoria = ((Spinner)findViewById(R.id.spnCategorias)).getSelectedItemPosition()+1;

        Producto p = new Producto();
        p.setId(editing_id);
        p.setNombre(nombre);
        p.setCantidad(cantidad);
        p.setPrecio(precio);
        p.setCategoria(Categoria.getCategoria(categoria));

        if(editing_id == -1){
            Conexion.agregarProducto(this,p);
        } else {
            Conexion.editarProducto(this,p);
        }

    }

    public void regresar(View v){
        cerrar();
    }

    public void cerrar() {
        Intent i = new Intent(this, ProductosListActivity.class);
        startActivity(i);
        finish();
    }
}