package edu.espol.transespol.Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.espol.transespol.objetos.Comentario;
import edu.espol.transespol.objetos.ObjetoPerdido;

/**
 * Created by john on 1/02/17.
 */
public class ComentarioRepository {
    private static ComentarioRepository repository = new ComentarioRepository();
    private HashMap<String, Comentario> comentarios = new HashMap<>();

    public static ComentarioRepository getInstance() {
        return repository;
    }

    private ComentarioRepository() {

    }

    private void saveObjetos(Comentario op) {
        comentarios.put(op.getId(), op);
    }

    public List<Comentario> getLeads() {
        return new ArrayList<>(comentarios.values());
    }

}
