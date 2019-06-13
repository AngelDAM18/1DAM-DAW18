package com.example.aplicacion3.MetodosComunes;

import android.content.Context;
import android.widget.Toast;

public class ToastManager {

    public static void passAndEmailNull(Context applicationContext) {
        //mensaje de contrasñea o Email NULL (sin introducir nada)
        Toast.makeText(applicationContext,"Error: algun campo vacio", Toast.LENGTH_SHORT).show();
    }

    public static void noExiteUsuario(Context applicationContext) {
        Toast.makeText(applicationContext,"Error: no exite el usuario", Toast.LENGTH_LONG).show();
    }
/*
    private static void ShowToast(Toast nombre) {
        nombre.show();
    }
*/
}
