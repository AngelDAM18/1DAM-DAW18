package com.example.aplicacion3.loginAndRegistrar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.aplicacion3.MetodosComunes.Comunes;
import com.example.aplicacion3.MetodosComunes.ToastManager;
import com.example.aplicacion3.R;
import com.example.aplicacion3.baseDatos.ConectarBD;
import com.example.aplicacion3.listaOferta.listaoferta;

public class login extends AppCompatActivity {

    Button btnLogear,btnRegistrar;
        EditText textCorreo,textPasswd;
    Intent abrirOtra;

    Comunes comun = new Comunes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            btnLogear = findViewById(R.id.btn_registrar_registrar);
            btnRegistrar =findViewById(R.id.button_registrar);
            textCorreo = findViewById(R.id.text_email_login);
            textPasswd =findViewById(R.id.text_password_login);


    }

    @Override
    protected void onStart() {
        super.onStart();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(comun.cargarSiguienteActividad(login.this , registrar.class));

                /***
                 * abrirOtra = new Intent(getApplicationContext(), registrar.class);
                 * startActivity(abrirOtra);
                 */
            //comun.cargarSiguienteActividad(login.this , registrar.class);

            }
        });

        btnLogear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contraS= textPasswd.getText().toString().toLowerCase();
                String emailS=textCorreo.getText().toString().toLowerCase();
            if (contraS == "" || emailS ==""){
                ToastManager.passAndEmailNull(getApplicationContext());
            }else {
                //Comprobar el email y la contraseña en la bd
                if (ConectarBD.logearBD(textCorreo.getText().toString().toLowerCase(),
                                        textPasswd.getText().toString().toLowerCase(),
                                        login.this) ) {
                    //abrimos la siguiente pantalla con un retraso de 10 seg
                    //la pantalla es: un listado (solamente) de lo requistro que hay en la BD de ofertas

                        //Metodo para abrir la siguiente actvidad ya que se utiliza en mas de un sitio
                        startActivity(comun.cargarSiguienteActividad(login.this , listaoferta.class));
                }
                //no exite el usuario
             //   ToastManager.noExiteUsuario(getApplicationContext());
            }
            }

        });
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder Contruirdialogo = new AlertDialog.Builder(this);
        Contruirdialogo.setTitle(R.string.DialogoMainTitle); //Titulo del cuadro de dialogo
        Contruirdialogo.setMessage(R.string.DialogoMainMenssage); //Mensaje del texto que sale en el cuadro "¿Quiere salir de la aplicacion?
        Contruirdialogo.setNegativeButton(R.string.DialogoMainBotonCancelar,null);
        Contruirdialogo.setPositiveButton(R.string.DialogoMainAceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //  Toast.makeText(MenuActivity.this,"Saliendo...",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Dialog MostrarDialogo= Contruirdialogo.create();
        MostrarDialogo.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menus = getMenuInflater();
        menus.inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
           /* case R.id.menuConfig:
                abrirConfigracion();
                return true;*/
            case R.id.menuAyuda:
                menudeAyuda();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void menudeAyuda() {
        //Cuadro de dialogo de ayuda con un boton de aceptar
        AlertDialog.Builder Contruirdialogo = new AlertDialog.Builder(this);
        Contruirdialogo.setTitle(R.string.DialogoMenuAyudaTitle); //Titulo del cuadro de dialogo
        Contruirdialogo.setMessage(R.string.DialogoMenuAyudaMensage); //Mensaje del texto que sale en el cuadro "¿Quiere salir de la aplicacion?
        //Contruirdialogo.setNegativeButton(R.string.DialogoMenuAyudaCancelar,null);
        Contruirdialogo.setPositiveButton(R.string.DialogoMenuAyudaAceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //  Toast.makeText(MenuActivity.this,"Saliendo...",Toast.LENGTH_LONG).show();
                closeContextMenu();
            }
        });

        Dialog MostrarDialogo= Contruirdialogo.create();
        MostrarDialogo.show();
    }

}
