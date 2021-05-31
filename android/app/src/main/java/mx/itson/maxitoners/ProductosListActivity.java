package mx.itson.maxitoners;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import mx.itson.maxitoners.adapters.ProductosAdapters;
import mx.itson.maxitoners.datos.Conexion;
import mx.itson.maxitoners.negocio.Producto;

public class ProductosListActivity extends AppCompatActivity {
	
	Context context;
	ListView listViewEstablecimientos;

	ArrayList<Producto> listProducto = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productos_list);
        context = this;




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirAgregar();
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recargarLista(true);
            }
        });

//        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
//            @Override
//            public void handleOnBackPressed() {
//                finish();
//                System.exit(0);
//            }
//        };
//        getOnBackPressedDispatcher().addCallback(this, callback);

        recargarLista(false);
    }

    public void recargarLista(boolean avisar){
        Conexion.verProductos(this, avisar);
    }

    public void cargarLista(){
        listViewEstablecimientos = findViewById(R.id.listProductos);
        ProductosAdapters adapters = new ProductosAdapters(this, listProducto);

        listViewEstablecimientos.setAdapter(adapters);
        registerForContextMenu(listViewEstablecimientos);
    }

    public void abrirAgregar(){
        Intent agregar = new Intent(this, ProductoFormActivity.class);
        startActivity(agregar);
    }

	@Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo){
        super.onCreateContextMenu(menu, view, contextMenuInfo);
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.usuario_menu, menu);
        menu.setHeaderTitle("Acciones");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Producto p = (Producto) listViewEstablecimientos.getItemAtPosition(info.position);

        if(item.getItemId() == R.id.editar){
            Intent editar = new Intent(this, ProductoFormActivity.class);
            editar.putExtra("prod_id", p.getId());
            editar.putExtra("nombre", p.getNombre());
            editar.putExtra("cantidad", p.getCantidad());
            editar.putExtra("precio", p.getPrecio());
            editar.putExtra("categoria", p.getCategoria().getId());
            startActivity(editar);
        } else if (item.getItemId() == R.id.eliminar){
            Conexion.borrarProducto(this, p);

        }
        return true;
    }

    public ArrayList<Producto> getListProducto() {
        return listProducto;
    }

}