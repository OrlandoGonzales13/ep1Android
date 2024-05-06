package com.example.servicios;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCambio, btnSalarios, btnProductos, btnEquipos, btnIntegrantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Obtner los controles del xml y hacer el casting
        btnCambio = (Button)findViewById(R.id.btnCambio);
        btnSalarios = (Button) findViewById(R.id.btnSalarios);
        btnProductos = (Button) findViewById(R.id.btnProductos);
        btnEquipos = (Button) findViewById(R.id.btnEquipos);
        btnIntegrantes = (Button) findViewById(R.id.btnIntegrantes);

        //Creamos los eventos Click para cada botón
        //evento para el PRIMER botón: Casa de Cambio
        btnCambio.setOnClickListener(v -> {
            //Desde aquí llamamos a la actividad de CasaDeCambio
            Intent intent = new Intent(this, CadaDeCambio.class);
            //Iniciamos la actividad
            startActivity(intent);
        });

        //evento para el SEGUNDO botón: Salarios
        btnSalarios.setOnClickListener(v -> {
            //Desde aquí llamamos a la actividad de Salario
            Intent intent = new Intent(this, Salario.class);
            //Iniciamos la actividad
            startActivity(intent);
        });

        //evento para el TERCER botón: Productos
        btnProductos.setOnClickListener(v -> {
            //Desde aquí llamamos a la actividad de Productos
            Intent intent = new Intent(this, Productos.class);
            //Iniciamos la actividad
            startActivity(intent);
        });

        //evento para el CUARTO botón: Equipos
        btnEquipos.setOnClickListener(v -> {
            //Desde aquí llamamos a la actividad de Equipos
            Intent intent = new Intent(this, Equipos.class);
            //Iniciamos la actividad
            startActivity(intent);
        });

        //evento para el QUINTO botón: Integrantes
        btnIntegrantes.setOnClickListener(v -> {
            //Desde aquí llamamos a la actividad de Integrantes
            Intent intent = new Intent(this, Integrantes.class);
            //Iniciamos la actividad
            startActivity(intent);
        });
    }
}