package com.example.aplicacion3.listaOferta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.aplicacion3.MetodosComunes.Comunes;
import com.example.aplicacion3.MetodosComunes.ConstantesURL;
import com.example.aplicacion3.R;
import com.example.aplicacion3.detalleOferta;
import com.example.aplicacion3.listaOferta.objeto.tablaOfertas;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;

import java.util.ArrayList;

public class listaoferta extends AppCompatActivity {

    private ListView listaOfertaView;
    private ArrayList<tablaOfertas>  listaTablaOfertas=new ArrayList<>();
    Comunes comun = new Comunes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaoferta);

        listaOfertaView = findViewById(R.id.listViewOfertas);

        //obtener los datos del Json del php
        obtieneDatos();
    }

    //1º Tenemos que mandar la solicitud al servidor para obtner un JSON
    public void obtieneDatos(){
        AsyncHttpClient client=  new AsyncHttpClient();
        //url por ip
        String ipWeb= ConstantesURL.cargarListaURL();

        RequestParams parametros= new RequestParams();
        parametros.put("key","valor");

        //La url, parametros
        //Devulve una respuesta
        client.get(ipWeb,parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode ==200){
                    //llamar a la funcion para obtener los datos y retornar un arreglo de String u otra cosa
                    Log.d("String" , new String(responseBody));

                    //2º llamamos la funcion
                        CargarLista(obtieneDatosJSON(new String(responseBody)));
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


public ArrayList<String> obtieneDatosJSON(String responseBody){

    ArrayList<String> listado = new ArrayList<>();

    try {
        JSONArray obtejoJSON= new JSONArray(responseBody);

        String texto ;

        for (int i =0;i<obtejoJSON.length();i++){
            texto = obtejoJSON.getJSONObject(i).getString("id") + " " +
                    obtejoJSON.getJSONObject(i).getString("empresa") +" "+
                    obtejoJSON.getJSONObject(i).getString("correoEmpresa");
            listado.add(texto);


            tablaOfertas objeto= new tablaOfertas();
            objeto.setIdBD(obtejoJSON.getJSONObject(i).getInt("id"));
            objeto.setNombreEmpresaBD(obtejoJSON.getJSONObject(i).getString("empresa"));
            objeto.setCorreoEmpresaBD(obtejoJSON.getJSONObject(i).getString("correoEmpresa"));
            objeto.setTelefonoBD(obtejoJSON.getJSONObject(i).getString("telefono"));
            objeto.setDescripcion(obtejoJSON.getJSONObject(i).getString("descripcion"));
            objeto.setActiva(obtejoJSON.getJSONObject(i).getString("activa"));
            objeto.setFechaPublicacion(obtejoJSON.getJSONObject(i).getString("fechaPublicacion"));
            objeto.setLocalidad(obtejoJSON.getJSONObject(i).getString("localidad"));
            objeto.setIdUsuario(obtejoJSON.getJSONObject(i).getString("idUsuario"));//no hace nada
            listaTablaOfertas.add(objeto);
        }

    }catch (Exception e){

        e.printStackTrace();
    }

    return listado;

}

public void CargarLista(ArrayList<String> datos){

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datos);
    listaOfertaView.setAdapter(adapter);

}

/**
            for (int i =0;i<obtejoJSON.length();i++){
                objeto= new tablaOfertas();

                objeto.setIdBD(obtejoJSON.getJSONObject(i).getInt("id"));
                objeto.setNombreEmpresaBD(obtejoJSON.getJSONObject(i).getString("empresa"));

                objeto.setCorreoEmpresaBD(obtejoJSON.getJSONObject(i).getString("correoEmpresa"));
                objeto.setTelefonoBD(obtejoJSON.getJSONObject(i).getString("telefono"));
                objeto.setDescripcion(obtejoJSON.getJSONObject(i).getString("descripcion"));

                objeto.setActiva(obtejoJSON.getJSONObject(i).getString("activa"));
                objeto.setFechaPublicacion(obtejoJSON.getJSONObject(i).getString("fechaPublicacion"));
                objeto.setLocalidad(obtejoJSON.getJSONObject(i).getString("localidad"));
                objeto.setIdUsuario(obtejoJSON.getJSONObject(i).getInt("idUsuario"));//no hace nada

                arrayList.add(objeto);
                listaOfertas.add(objeto);

*/


    @Override
    protected void onStart() {
        super.onStart();

        listaOfertaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //abrir otra activity para mas descripcion
                Log.d("listaOferta", id+" ");

                comun.cargarSiguienteActividad(getApplication(), detalleOferta.class);

            }
        });

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
            case R.id.menuActualizar:
                obtieneDatos();
                return true;
            case R.id.menuAyuda:
                menudeAyuda();
                return true;
            case R.id.menuCerrarSesion:
                salirAplicacion();
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


    private void salirAplicacion() {
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder Contruirdialogo = new AlertDialog.Builder(this);
        Contruirdialogo.setTitle(R.string.DialogoOfertaTitle); //Titulo del cuadro de dialogo
        Contruirdialogo.setMessage(getString(R.string.DialogoOfertaMenssage)); //Mensaje del texto que sale en el cuadro "Estas seguro que quieres salir de la aplicacion?
        Contruirdialogo.setNegativeButton(R.string.DialogoOfertaBotonCancelar,null);
        Contruirdialogo.setPositiveButton(R.string.DialogoOfertaBotonAceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //  Toast.makeText(MenuActivity.this,"Saliendo...",Toast.LENGTH_LONG).show();
                //finish();
                finishAndRemoveTask();
            }
        });

        Dialog MostrarDialogo= Contruirdialogo.create();
        MostrarDialogo.show();
    }

}
