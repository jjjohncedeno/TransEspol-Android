package edu.espol.transespol.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.espol.transespol.R;
import edu.espol.transespol.Repositories.ComentarioRepository;
import edu.espol.transespol.adaptadores.ComentarioAdapter;
import edu.espol.transespol.objetos.Comentario;

/**
 * Created by john on 5/02/17.
 */
public class ComentarioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ListView mensajesLista;
    ArrayAdapter<Comentario> comentarioAdapter;

    public ComentarioFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ComentarioFragment newInstance() {
        ComentarioFragment fragment = new ComentarioFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.frragmen_comentario, container, false);
        mensajesLista = (ListView) root.findViewById(R.id.objetos_lista);
        // Inicializar el adaptador con la fuente de datos.
        comentarioAdapter = new ComentarioAdapter(getActivity(),
                ComentarioRepository.getInstance().getLeads());

        //Relacionando la lista con el adaptador
        mensajesLista.setAdapter(comentarioAdapter);

        return root;
    }
}