package com.example.aplicacion3.listaOferta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.aplicacion3.R;

public class detalleOferta extends AppCompatActivity {

    private TextView nombreEmpresa,correo,fecha,telefono,localidad,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta);

        nombreEmpresa=findViewById(R.id.detalleOfertaEmpresa);
        correo=findViewById(R.id.detalleOfertaCorreo);
        fecha = findViewById(R.id.detalleOfertaLocalidad);

        telefono=findViewById(R.id.detalleOfertaTelefono);
        localidad=findViewById(R.id.detalleOfertaLocalidad);

        descripcion=findViewById(R.id.detalleOfertaDescripcion);

        inicializarInformacion();
    }

    private void inicializarInformacion() {

        // it.putExtra("ID",
        //            it.putExtra("",
        //            it.putExtra("IdUsuario",
        //            it.putExtra("",

// it.putExtra("NombreEmpresa",
        //CorreoEmpresa
        //FechaPublicacion
        //Telefono
        //Descripcion

        Bundle info = getIntent().getExtras();
        nombreEmpresa.setText(info.getString("NombreEmpresa"));
        correo.setText(info.getString("CorreoEmpresa"));
        fecha.setText(info.getString("FechaPublicacion"));
        telefono.setText(info.getString("Telefono"));
        localidad.setText(info.getString("Localidad"));
        descripcion.setText(info.getString("Descripcion"));

    }
}
