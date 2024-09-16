package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.modelo.Persona;
import com.squareup.picasso.Picasso;

public class Vista extends DialogFragment {

    Button btnaceptar;
    private RecyclerView recyclerView;
    public Persona persona;
    ImageView btnSalir, imgPais, imgPersonaVista;
    TextView txtNombreVista, txtDireccion, txtedad, txttelefono, txtcelular, txtnacionalidad, txtidentificacion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_vista, null);
        txtNombreVista = vista.findViewById(R.id.txtNombreVista);
        txtDireccion = vista.findViewById(R.id.txtDireccion);
        txtedad = vista.findViewById(R.id.txtedad);
        txttelefono = vista.findViewById(R.id.txttelefono);
        txtcelular = vista.findViewById(R.id.txtcelular);
        txtnacionalidad = vista.findViewById(R.id.txtnacionalidad);
        txtidentificacion = vista.findViewById(R.id.txtidentificacion);
        btnaceptar = vista.findViewById(R.id.btnaceptar);
        btnSalir = vista.findViewById(R.id.btnSalir);
        imgPais = vista.findViewById(R.id.imgPais);
        imgPersonaVista = vista.findViewById(R.id.imgPersonaVista);

        persona = (Persona) getArguments().get("persona");

        txtNombreVista.setText(persona.getName().getFirst() + " " + persona.getName().getLast());
        txtDireccion.setText(persona.getLocation().getStreet().getName() + ", " + persona.getLocation().getStreet().getNumber() + ", " + persona.getLocation().getCity());
        txtedad.setText(persona.getDob().getAge());
        txttelefono.setText(persona.getPhone());
        txtcelular.setText(persona.getCell());
        txtnacionalidad.setText(persona.getLocation().getCountry());
        txtidentificacion.setText(persona.getId().getValue());
        txtidentificacion.setText(persona.getId().getValue());
        Picasso.get().load("https://restcountries.com/v3.1/name/" + persona.getLocation().getCountry()).into(imgPais);
        Picasso.get().load(persona.getPicture().getMedium()).into(imgPersonaVista);

        clicks();
        return vista;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
            //dialog.setCanceledOnTouchOutside(false);
        }
    }

    public void clicks() {
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}