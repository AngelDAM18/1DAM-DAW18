package com.example.aplicacion3.loginAndRegistrar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.aplicacion3.R;
import com.example.aplicacion3.baseDatos.ConectarBD;


public class registrar extends AppCompatActivity {

    private EditText editTextEmail,editTextPassword;
    private EditText editTextEmailConfimacion,editTextPasswordConfirmacion;
    private Button BtnLogin,btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        editTextEmail=findViewById(R.id.text_email_login);
        editTextEmailConfimacion=findViewById(R.id.editText_email2);

        editTextPassword=findViewById(R.id.text_password_login);
        editTextPasswordConfirmacion=findViewById(R.id.editText_password2);

        btnAtras=findViewById(R.id.btn_atras_registrar);
        BtnLogin=findViewById(R.id.btn_registrar_registrar);

    }

    @Override
    protected void onStart() {
        super.onStart();

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento1 = new Intent(getApplicationContext(),login.class);
                startActivity(intento1);
            }
        });

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (igual(editTextEmail,editTextEmailConfimacion)){
                    if (igual(editTextPassword,editTextPasswordConfirmacion)){
                        //registramos
                        ConectarBD.registrarBD(editTextEmail.getText().toString().toLowerCase(),
                                editTextPassword.getText().toString().toLowerCase(),
                                registrar.this
                        );
                    }
                }else{
                    //Los datos no son iguales
                    Toast.makeText(getApplicationContext(),"Datos distintos", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    private boolean igual(EditText emailandPassword, EditText confirmacion) {
        String emailAndPasswordS = emailandPassword.getText().toString().toLowerCase();
        String confirmacionS = confirmacion.getText().toString().toLowerCase();

        if (emailAndPasswordS.equals(confirmacionS)){
            return true;
        }
        return false;
    }
}
