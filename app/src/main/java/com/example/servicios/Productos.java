package com.example.servicios;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class Productos extends AppCompatActivity {
    ListView lstproductos;
    Button btnAgregar;
    EditText txtProducto, txtMarca, txtCodigo, txtPrecio;
    // Se declara  el ArrayList lista, que contendrá objetos del tipo hashmap
    ArrayList<HashMap<String, String>> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_productos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Se obtiene los controles del activity_productos.xml y se castea
        lstproductos = (ListView) findViewById(R.id.lstproductos);
        txtProducto = (EditText) findViewById(R.id.txtProducto);
        txtMarca = (EditText) findViewById(R.id.txtMarca);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        // Se Inicializa la lista
        lista = new ArrayList<>();

        // Se añade el evento click al botón Agregar
        btnAgregar.setOnClickListener(v -> {
            // Se obtiene los valores de los EditText
            String producto = txtProducto.getText().toString();
            String marca = txtMarca.getText().toString();
            String codigo = txtCodigo.getText().toString();
            String precio = txtPrecio.getText().toString();

            // se valida que se ingrese datos en todos los campos
            if (!producto.isEmpty() && !marca.isEmpty() && !codigo.isEmpty()
                && !precio.isEmpty()) {

                // Se declara e inicializa un  hashmap map para el nuevo producto
                HashMap<String, String> map = new HashMap<>();
                map.put("producto", producto);
                map.put("marca", marca);
                map.put("codigo", codigo);
                map.put("precio", precio);

                // Se agrega a la lista
                lista.add(map);

                // Limpiar los EditText después de agregar el producto
                txtProducto.setText("");
                txtMarca.setText("");
                txtCodigo.setText("");
                txtPrecio.setText("");
                // Regresa el cursor al primer campo
                txtProducto.requestFocus();

                // Se actualiza el ListView
                mostrarProductos();

                } else {
                   Toast.makeText(this, "Complete el ingreso de datos",
                           Toast.LENGTH_SHORT).show();
                }
        });
    }

    // Se crea el adaptador e instanciarlo,
    // Le pasamos los parámetros necesarios
    public void mostrarProductos() {
        ListAdapter adaptador = new SimpleAdapter(this,
                lista,
                R.layout.activity_producto,
                new String[]{"producto", "marca", "codigo", "precio"},
                new int[]{R.id.txtProducto, R.id.txtMarca, R.id.txtCodigo, R.id.txtPrecio});
        // Poblamos el ListView con el adaptador
        lstproductos.setAdapter(adaptador);
    }
}
