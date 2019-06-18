package com.example.aplicacion3.MetodosComunes;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.example.aplicacion3.listaOferta.objeto.tablaOfertas;

public class Comunes {

    public Comunes(){

    }

    public Intent cargarSiguienteActividad(Context aplicacionContexto, Class<?> claases){

      return new Intent(aplicacionContexto, claases);

    }


    public Intent cargarSiguienteActividad(Application aplicacionContexto, Class<?> claases, tablaOfertas listaTablaOfertas) {
         Intent it = new Intent(aplicacionContexto, claases);
            it.putExtra("ID", listaTablaOfertas.getIdBD());
            it.putExtra("NombreEmpresa", listaTablaOfertas.getNombreEmpresaBD());
            it.putExtra("Descripcion", listaTablaOfertas.getDescripcion());
            it.putExtra("FechaPublicacion", listaTablaOfertas.getFechaPublicacion());
            it.putExtra("CorreoEmpresa", listaTablaOfertas.getCorreoEmpresaBD());
            it.putExtra("IdUsuario", listaTablaOfertas.getIdUsuario());
            it.putExtra("Localidad", listaTablaOfertas.getLocalidad());
            it.putExtra("Telefono", listaTablaOfertas.getTelefonoBD());
        return it ;
    }
}
