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

    public IntegrantesAdapter(List<String> listaIntegrantes) {
        this.listaIntegrantes = listaIntegrantes;
    }

    @NonNull
    @Override
    public IntegranteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_integrante, parent, false);
        return new IntegranteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntegranteViewHolder holder, int position) {
        String integrante = listaIntegrantes.get(position);
        holder.bind(integrante);
    }

    @Override
    public int getItemCount() {
        return listaIntegrantes.size();
    }

    public static class IntegranteViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNombre;

        public IntegranteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
        }

        public void bind(String integrante) {
            textViewNombre.setText(integrante);
        }
    }
}
