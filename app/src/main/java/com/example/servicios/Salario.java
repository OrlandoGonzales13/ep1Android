package com.example.servicios;

// Importaciones necesarias para la actividad de Android
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

// Declaración de la clase Salario que extiende de AppCompatActivity
public class Salario extends AppCompatActivity {

    // Declaración de variables de los elementos de la interfaz de usuario
    EditText editTextNombre;
    Spinner spinnerCargo, spinnerAfiliacion;
    Button buttonCalcular;
    TextView textViewResultado;

    // Declaración de variables para almacenar datos del empleado y el cálculo de sueldo
    String nombreEmpleado, cargoSeleccionado, afiliacionSeleccionada;
    double sueldoBasico, sueldoNeto, descuento;

    @Override
    // Método que se llama cuando se crea la actividad
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        // Asociación de las variables con los elementos de la interfaz
        editTextNombre = findViewById(R.id.editTextNombre);
        spinnerCargo = findViewById(R.id.spinnerCargo);
        spinnerAfiliacion = findViewById(R.id.spinnerAfiliacion);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Creación de adaptadores para los spinners con datos predefinidos
        ArrayAdapter<CharSequence> adapterCargo = ArrayAdapter.createFromResource(this,
                R.array.cargos_array, android.R.layout.simple_spinner_item);
        adapterCargo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCargo.setAdapter(adapterCargo);

        ArrayAdapter<CharSequence> adapterAfiliacion = ArrayAdapter.createFromResource(this,
                R.array.afiliacion_array, android.R.layout.simple_spinner_item);
        adapterAfiliacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAfiliacion.setAdapter(adapterAfiliacion);

        // Configuración del evento onClickListener para el botón de cálculo
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularSueldoNeto(); // Llama al método para calcular el sueldo neto
            }
        });
    }

    // Método para calcular el sueldo neto del empleado
    public void calcularSueldoNeto() {
        // Obtención de los valores seleccionados en la interfaz de usuario
        nombreEmpleado = editTextNombre.getText().toString();
        cargoSeleccionado = spinnerCargo.getSelectedItem().toString();
        afiliacionSeleccionada = spinnerAfiliacion.getSelectedItem().toString();

        // Validación de que se haya ingresado el nombre del empleado
        if (nombreEmpleado.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre del empleado", Toast.LENGTH_SHORT).show();
            return;
        }

        // Asignación del sueldo básico según el cargo seleccionado
        if (cargoSeleccionado.equals("Administrador")) {
            sueldoBasico = 5000;
        } else if (cargoSeleccionado.equals("Contador")) {
            sueldoBasico = 3500;
        } else if (cargoSeleccionado.equals("Vendedor")) {
            sueldoBasico = 2000;
        } else if (cargoSeleccionado.equals("Recepcionista")) {
            sueldoBasico = 1500;
        }

        // Cálculo del descuento según la afiliación seleccionada
        if (afiliacionSeleccionada.equals("AFP")) {
            descuento = sueldoBasico * 0.10;
        } else if (afiliacionSeleccionada.equals("ONP")) {
            descuento = sueldoBasico * 0.13;
        }

        // Cálculo del sueldo neto restando el descuento al sueldo básico
        sueldoNeto = sueldoBasico - descuento;

        // Mostrar el resultado en el TextView de la interfaz de usuario
        textViewResultado.setText("Nombre: " + nombreEmpleado + "\nCargo: " + cargoSeleccionado + "\nSueldo Neto: S/. " + sueldoNeto + "\nDescuento: S/. " + descuento);
    }
}
