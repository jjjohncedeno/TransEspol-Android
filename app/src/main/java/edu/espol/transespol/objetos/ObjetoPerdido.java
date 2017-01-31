package edu.espol.transespol.objetos;

import java.util.Date;

/**
 * Created by john on 31/01/17.
 */
public class ObjetoPerdido {
    private String id;
    private String nombre;
    private String descripcion;
    private Date fechaPerdido;
    private String lugarEncontrado;

    public ObjetoPerdido(String descripcion, Date fechaPerdido, String id, String lugarEncontrado, String nombre) {
        this.descripcion = descripcion;
        this.fechaPerdido = fechaPerdido;
        this.id = id;
        this.lugarEncontrado = lugarEncontrado;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPerdido() {
        return fechaPerdido;
    }

    public void setFechaPerdido(Date fechaPerdido) {
        this.fechaPerdido = fechaPerdido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLugarEncontrado() {
        return lugarEncontrado;
    }

    public void setLugarEncontrado(String lugarEncontrado) {
        this.lugarEncontrado = lugarEncontrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
