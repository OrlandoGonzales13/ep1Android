package com.example.servicios;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.servicios.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Equipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilitar el modo de borde a borde
        EdgeToEdge.enable(this);

        // Establecer el diseño de la actividad
        setContentView(R.layout.activity_equipos);

        // Ajustar el padding para evitar que el contenido se solape con las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener el ListView del diseño
        ListView lstEquipos = findViewById(R.id.lstEquipos);

        // Definir los datos de los equipos
        String[] nombresEquipos = new String[] {"Real Madrid", "FC Barcelona", "Liverpool FC", "Paris Saint-Germain", "Bayern Munich"};
        String[] paisesEquipos = new String[] {"España", "España", "Inglaterra", "Francia", "Alemania"};
        String[] estadiosEquipos = new String[] {"Santiago Bernabéu", "Camp Nou", "Anfield", "Parc des Princes", "Allianz Arena"};
        String[] capacidadesEstadios = new String[] {"81044", "99354", "54074", "48712", "75024"};
        int[] imagenesEscudos = new int[] {R.drawable.real_madrid_escudo, R.drawable.barcelona_escudo, R.drawable.liverpool_escudo, R.drawable.psg_escudo, R.drawable.bayern_munich_escudo};

        // Crear una lista de HashMap para almacenar los datos de los equipos
        List<HashMap<String, String>> lista = new ArrayList<>();
        for(int i = 0; i < nombresEquipos.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("Equipo", nombresEquipos[i]);
            map.put("Pais", paisesEquipos[i]);
            map.put("Estadio", estadiosEquipos[i]);
            map.put("Capacidad", capacidadesEstadios[i]);
            map.put("Escudo", String.valueOf(imagenesEscudos[i]));
            // Agregar más detalles aquí si es necesario
            lista.add(map);
        }

        // Crear un adaptador SimpleAdapter con nuestros datos personalizados
        ListAdapter adaptador = new SimpleAdapter(this,
                lista,
                R.layout.item_equipo,
                new String[]{"Equipo", "Pais", "Estadio", "Capacidad", "Escudo"}, // Añadimos la referencia al escudo
                new int[]{R.id.txtEquipo, R.id.txtPais, R.id.txtEstadio, R.id.txtCapacidad, R.id.imgEscudo}); // Ahora también incluimos el ImageView

        // Establecer el adaptador en el ListView
        lstEquipos.setAdapter(adaptador);
    }
}