package com.example.aplicacion3.MetodosComunes;

public class ConstantesURL {

    private static String URL = "https://heaven-sent-pull.000webhostapp.com/android/";
  //  private static String URL = "http://192.168.1.133/android/";
    // return "http://192.168.1.133/android/register.php"
    // return "https://heaven-sent-pull.000webhostapp.com/android/register.php";

    public static String registrarURL(){
        return URL+"register.php";
    }

    public static String logearURL(){
        return URL+"login.php";
    }

    public static String cargarListaURL(){
       return URL+"cargarLista.php";
    }

}
