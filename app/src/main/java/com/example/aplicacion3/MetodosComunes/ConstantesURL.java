package com.example.aplicacion3.MetodosComunes;

public class ConstantesURL {

    private static String URL = "https://heaven-sent-pull.000webhostapp.com/android/";
  //  private static String URL = "http://192.168.1.133/android/";

//Cambio en las rutas
    private static String regis="register.php";
    private static String login="login.php";
    private static String cargarLista="cargarLista.php";

    public static String registrarURL(){return URL+regis;
    }

    public static String logearURL(){
        return URL+login;
    }

    public static String cargarListaURL(){
       return URL+cargarLista;
    }

}
