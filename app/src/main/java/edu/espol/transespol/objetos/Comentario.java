package edu.espol.transespol.objetos;

import java.util.Date;

/**
 * Created by john on 31/01/17.
 */
public class Comentario {
    private String id;
    private String mensaje;
    private String nombre;
    private String fecha;
    private String hora;


    public Comentario(String id, String nombre, String mensaje, String fecha, String hora) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }



}
