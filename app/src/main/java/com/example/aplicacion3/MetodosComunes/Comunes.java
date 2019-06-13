package com.example.aplicacion3.MetodosComunes;

import android.content.Context;
import android.content.Intent;

public class Comunes {

    public Comunes(){

    }

    public Intent cargarSiguienteActividad(Context aplicacionContexto, Class<?> claases){

      return new Intent(aplicacionContexto, claases);

    }


}
