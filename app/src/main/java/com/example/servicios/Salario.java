package com.example.servicios;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Salario extends AppCompatActivity {

    EditText editTextNombre;
    Spinner spinnerCargo, spinnerAfiliacion;
    Button buttonCalcular;
    TextView textViewResultado;

    String nombreEmpleado, cargoSeleccionado, afiliacionSeleccionada;
    double sueldoBasico, sueldoNeto, descuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        editTextNombre = findViewById(R.id.editTextNombre);
        spinnerCargo = findViewById(R.id.spinnerCargo);
        spinnerAfiliacion = findViewById(R.id.spinnerAfiliacion);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        ArrayAdapter<CharSequence> adapterCargo = ArrayAdapter.createFromResource(this,
                R.array.cargos_array, android.R.layout.simple_spinner_item);
        adapterCargo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCargo.setAdapter(adapterCargo);

        ArrayAdapter<CharSequence> adapterAfiliacion = ArrayAdapter.createFromResource(this,
                R.array.afiliacion_array, android.R.layout.simple_spinner_item);
        adapterAfiliacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAfiliacion.setAdapter(adapterAfiliacion);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularSueldoNeto();
            }
        });
    }

    public void calcularSueldoNeto() {
        nombreEmpleado = editTextNombre.getText().toString();
        cargoSeleccionado = spinnerCargo.getSelectedItem().toString();
        afiliacionSeleccionada = spinnerAfiliacion.getSelectedItem().toString();

        if (nombreEmpleado.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre del empleado", Toast.LENGTH_SHORT).show();
            return;
        }

        if (cargoSeleccionado.equals("Administrador")) {
            sueldoBasico = 5000;
        } else if (cargoSeleccionado.equals("Contador")) {
            sueldoBasico = 3500;
        } else if (cargoSeleccionado.equals("Vendedor")) {
            sueldoBasico = 2000;
        } else if (cargoSeleccionado.equals("Recepcionista")) {
            sueldoBasico = 1500;
        }

        if (afiliacionSeleccionada.equals("AFP")) {
            descuento = sueldoBasico * 0.10;
        } else if (afiliacionSeleccionada.equals("ONP")) {
            descuento = sueldoBasico * 0.13;
        }

        sueldoNeto = sueldoBasico - descuento;

        textViewResultado.setText("Nombre: " + nombreEmpleado + "\nCargo: " + cargoSeleccionado + "\nSueldo Neto: S/. " + sueldoNeto + "\nDescuento: S/. " + descuento);
    }
}
