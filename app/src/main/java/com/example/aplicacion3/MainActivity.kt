package com.example.aplicacion3

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.aplicacion3.loginAndRegistrar.login
import android.view.View as View1


 class MainActivity : AppCompatActivity() {

     var miProgreso = 0
    var salir=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
     private val miespera = Runnable {
         while (miProgreso < 100) {
             mostrarbarraprogreso()
             try {
                 Thread.sleep(150)
             } catch (t: Throwable) {
             }
                Log.d("Mi Progeso", miProgreso.toString())

         }
         Log.d("Mi Progeso", salir.toString())
        if (!salir){
            val intento1 = Intent(this, login::class.java)
            startActivity(intento1)
        }
         finish()


     }

     private fun mostrarbarraprogreso() {
         miProgreso += 1
     }

     override fun onStart() {
         super.onStart()
         Thread(miespera).start()
     }

     override fun onBackPressed() {
         val Contruirdialogo=AlertDialog.Builder(this)
         Contruirdialogo.setTitle(getString(R.string.DialogoMainTitle)) //Titulo del cuadro de dialogo
         Contruirdialogo.setMessage(getString(R.string.DialogoMainMenssage)) //Mensaje del texto que sale en el cuadro "¿Quiere salir de la aplicacion?
         Contruirdialogo.setNegativeButton(getString(R.string.DialogoMainBotonCancelar), null)
         Contruirdialogo.setPositiveButton(getString(R.string.DialogoMainAceptar), DialogInterface.OnClickListener { _, _ ->
             //  Toast.makeText(MenuActivity.this,"Saliendo...",Toast.LENGTH_LONG).show();
            salir = true

         })

         val MostrarDialogo=Contruirdialogo.create()
         MostrarDialogo.show()
     }


}
