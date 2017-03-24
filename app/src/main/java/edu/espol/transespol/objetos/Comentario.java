package edu.espol.transespol.objetos;

/**
 * Created by john on 31/01/17.
 */
public class Comentario {
    private String id;
    private String mensaje;
    private String nombre;
    private String fecha;

    public Comentario(String mensaje, String id, String nombre, String fecha) {
        this.mensaje = mensaje;
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
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

    public String getFecha(){return fecha;}

    public void setFecha(){this.fecha = fecha;}
}
