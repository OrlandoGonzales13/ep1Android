package com.example.servicios;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Integrantes extends AppCompatActivity {

    private RecyclerView recyclerViewIntegrantes;
    private List<String> listaIntegrantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrantes);

        // Configurar el RecyclerView y su adaptador
        recyclerViewIntegrantes = findViewById(R.id.recyclerViewIntegrantes);
        recyclerViewIntegrantes.setLayoutManager(new LinearLayoutManager(this));

        // Crear los datos de ejemplo para la lista
        listaIntegrantes = new ArrayList<>();
        listaIntegrantes.add("ALCANTARA LAMONJA RICARDO LUIS ALEJANDRO");
        listaIntegrantes.add("ALVAREZ MELENDEZ JEAN CARLO GIOVANNI");
        listaIntegrantes.add("FERNANDEZ CARTAGENA LUCILA");
        listaIntegrantes.add("GONZALES PAZ ORLANDO ALONSO");

        // Crear y configurar el adaptador para el RecyclerView
        IntegrantesAdapter adapter = new IntegrantesAdapter(listaIntegrantes);
        recyclerViewIntegrantes.setAdapter(adapter);
    }
}
