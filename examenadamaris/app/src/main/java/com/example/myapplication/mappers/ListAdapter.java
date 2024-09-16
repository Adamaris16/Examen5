package com.example.myapplication.mappers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interfaces;
import com.example.myapplication.R;
import com.example.myapplication.modelo.Persona;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RecyclerViewHolder> {

    private List<Persona> personas;
    private Context mcontext;
    Interfaces i;

    public ListAdapter(List<Persona> personas, Context mcontext) {
        this.personas = personas;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_persona, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Persona persona = personas.get(position);
        Picasso.get().load(persona.getPicture().getMedium()).into(holder.imgPersona);
        holder.nombre.setText(persona.getName().getFirst() + " " + persona.getName().getLast());
        holder.correo.setText(persona.getEmail());
        holder.pais.setText(persona.getLocation().getCountry());
        holder.carViewPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = (Interfaces) mcontext;
                Bundle data = new Bundle();
                data.putSerializable("persona", (Serializable) personas.get(position));
                i.abrirModal(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPersona;
        TextView nombre, correo, pais;
        CardView carViewPersonalizado;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPersona = itemView.findViewById(R.id.imgPersona);
            nombre = itemView.findViewById(R.id.txtNombre);
            correo = itemView.findViewById(R.id.txtCorreo);
            pais = itemView.findViewById(R.id.txtPais);
            carViewPersonalizado = itemView.findViewById(R.id.carViewPersonalizado);
        }
    }
}
