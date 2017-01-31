package edu.espol.transespol.objetos;

/**
 * Created by john on 31/01/17.
 */
public class Comentario {
    private String id;
    private String mensaje;

    public Comentario(String mensaje, String id) {
        this.mensaje = mensaje;
        this.id = id;
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
}
