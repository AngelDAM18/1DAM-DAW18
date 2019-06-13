package com.example.aplicacion3.listaOferta.objeto;

public class tablaOfertas {

    private int idBD;
    private String nombreEmpresaBD;
    private String correoEmpresaBD;
    private String telefonoBD;
    private String descripcion;
    private String activa;
    private String fechaPublicacion;
    private String localidad;
    private String idUsuario;//No hace nada


    public int getIdBD() {
        return idBD;
    }

    public void setIdBD(int idBD) {
        this.idBD = idBD;
    }

    public String getNombreEmpresaBD() {
        return nombreEmpresaBD;
    }

    public void setNombreEmpresaBD(String nombreEmpresaBD) {
        this.nombreEmpresaBD = nombreEmpresaBD;
    }

    public String getCorreoEmpresaBD() {
        return correoEmpresaBD;
    }

    public void setCorreoEmpresaBD(String correoEmpresaBD) {
        this.correoEmpresaBD = correoEmpresaBD;
    }

    public String getTelefonoBD() {
        return telefonoBD;
    }

    public void setTelefonoBD(String telefonoBD) {
        this.telefonoBD = telefonoBD;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String isActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
