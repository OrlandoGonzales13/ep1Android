package com.example.servicios;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class CadaDeCambio extends AppCompatActivity {

    EditText txtSoles, txtDolares, txtEuros;
    Button btnConvertir, btnLimpiar; // Agregamos la declaración del botón btnLimpiar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cada_de_cambio);

        // Obtener referencias a los elementos del layout
        txtSoles = findViewById(R.id.txtSoles);
        txtDolares = findViewById(R.id.txtDolares);
        txtEuros = findViewById(R.id.txtEuros);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnLimpiar = findViewById(R.id.btnLimpiar); // Inicializamos el botón btnLimpiar

        // Configurar el evento de clic para el botón de conversión
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la cantidad en soles ingresada por el usuario
                String cantidadSolesStr = txtSoles.getText().toString();
                if (!cantidadSolesStr.isEmpty()) {
                    // Convertir la cantidad de soles a dólares y euros
                    double cantidadSoles = Double.parseDouble(cantidadSolesStr);
                    double tasaDolar = 3.73;
                    double tasaEuro = 4.01;
                    double cantidadDolares = cantidadSoles / tasaDolar;
                    double cantidadEuros = cantidadSoles / tasaEuro;

                    // Redondear los resultados a dos decimales
                    cantidadDolares = Math.round(cantidadDolares * 100.0) / 100.0;
                    cantidadEuros = Math.round(cantidadEuros * 100.0) / 100.0;

                    // Mostrar los resultados en los EditText correspondientes
                    txtDolares.setText(String.format("%.2f", cantidadDolares));
                    txtEuros.setText(String.format("%.2f", cantidadEuros));
                } else {
                    // Mostrar un mensaje de advertencia si no se ingresa ninguna cantidad
                    Toast.makeText(CadaDeCambio.this, "Por favor, ingrese una cantidad en soles.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar el evento de clic para el botón "Limpiar"
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Limpiar los EditText estableciendo su texto como una cadena vacía
                txtSoles.setText("");
                txtDolares.setText("");
                txtEuros.setText("");
            }
        });
    }
}