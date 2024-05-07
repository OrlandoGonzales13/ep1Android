package com.example.servicios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IntegrantesAdapter extends RecyclerView.Adapter<IntegrantesAdapter.IntegranteViewHolder> {

    private List<String> listaIntegrantes;

    // Constructor para el adaptador
    public IntegrantesAdapter(List<String> listaIntegrantes) {
        this.listaIntegrantes = listaIntegrantes;
    }

    // Método que se llama cuando se necesitan nuevas vistas (elementos de la lista)
    @NonNull
    @Override
    public IntegranteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño de cada elemento de la lista desde el archivo item_integrante.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_integrante, parent, false);
        return new IntegranteViewHolder(view);
    }

    // Método que se llama para mostrar datos en una posición específica
    @Override
    public void onBindViewHolder(@NonNull IntegranteViewHolder holder, int position) {
        // Obtener el integrante en la posición dada
        String integrante = listaIntegrantes.get(position);
        // Vincular los datos a la vista del ViewHolder
        holder.bind(integrante);
    }

    // Método que devuelve la cantidad de elementos en la lista
    @Override
    public int getItemCount() {
        return listaIntegrantes.size();
    }

    // Clase ViewHolder que representa cada elemento de la lista
    public static class IntegranteViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNombre;

        // Constructor del ViewHolder
        public IntegranteViewHolder(@NonNull View itemView) {
            super(itemView);
            // Inicializar las vistas dentro del elemento de la lista
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
        }

        // Método para vincular los datos a las vistas
        public void bind(String integrante) {
            textViewNombre.setText(integrante);
        }
    }
}
