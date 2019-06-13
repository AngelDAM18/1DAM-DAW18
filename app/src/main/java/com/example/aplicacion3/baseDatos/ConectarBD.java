package com.example.aplicacion3.baseDatos;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.example.aplicacion3.MetodosComunes.ConstantesURL;
import com.example.aplicacion3.MetodosComunes.ToastManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConectarBD {

    private static boolean EXITE = false;
    private static String REGISTER_URL = ConstantesURL.registrarURL();
    private static String LOGIN_URL = ConstantesURL.logearURL();
    private static String CARGAR_LISTA_URL = ConstantesURL.cargarListaURL();

    public static void registrarBD(String email, String password, final Context regtistrarThis) {
        final String urlSuffix = "?email=" +email + "&passwd=" +  password;

        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(regtistrarThis, "Espere por favor", null, true, true);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(regtistrarThis,"Registrado", Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = urlSuffix;
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(REGISTER_URL+s);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();
                    Thread.sleep(10000);
                    return  result;

                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }

        }
        RegisterUser ur=new RegisterUser();
        ur.execute(urlSuffix);
    }

    public static boolean logearBD(String email, String password, final Context loginThis) {
        final String urlSuffix = "?email=" +email + "&passwd=" +  password;

        class logearBD extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(loginThis, "Espere por favor", null, true, true);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (!EXITE){
                    ToastManager.noExiteUsuario(loginThis);
                }else{

                }

            }

            @Override
            protected String doInBackground(String... params) {
                String s = urlSuffix;
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(LOGIN_URL+s);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();
                    Thread.sleep(10000);
                    if (result.equals("YES")){
                        EXITE = true;
                    }

                    return  result;

                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }

        }
        logearBD ur=new logearBD();
        ur.execute(urlSuffix);
        return EXITE;
    }
}
