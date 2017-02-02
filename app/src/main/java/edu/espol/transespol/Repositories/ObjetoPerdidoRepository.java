package edu.espol.transespol.Repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edu.espol.transespol.objetos.ObjetoPerdido;

/**
 * Created by john on 1/02/17.
 */
public class ObjetoPerdidoRepository {
    private static ObjetoPerdidoRepository repository = new ObjetoPerdidoRepository();
    private HashMap<String, ObjetoPerdido> objetos = new HashMap<>();

    public static ObjetoPerdidoRepository getInstance() {
        return repository;
    }

    private ObjetoPerdidoRepository() {
        saveObjetos(new ObjetoPerdido("Se me perdio", "1", "Por ahi", "Algo"));
        saveObjetos(new ObjetoPerdido("Se me perdio", "1", "Por ahi", "Algo"));
        saveObjetos(new ObjetoPerdido("Se me perdio", "1", "Por ahi", "Algo"));
        saveObjetos(new ObjetoPerdido("Se me perdio", "1", "Por ahi", "Algo"));
        saveObjetos(new ObjetoPerdido("Se me perdio", "1", "Por ahi", "Algo"));
        saveObjetos(new ObjetoPerdido("Se me perdio", "1", "Por ahi", "Algo"));
        saveObjetos(new ObjetoPerdido("Se me perdio", "1", "Por ahi", "Algo"));

    }

    private void saveObjetos(ObjetoPerdido op) {
        objetos.put(op.getId(), op);
    }

    public List<ObjetoPerdido> getLeads() {
        return new ArrayList<>(objetos.values());
    }

}
