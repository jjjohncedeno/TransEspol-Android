package edu.espol.transespol.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.espol.transespol.R;
import edu.espol.transespol.Repositories.ObjetoPerdidoRepository;
import edu.espol.transespol.adaptadores.ObjetoAdapter;
import edu.espol.transespol.objetos.ObjetoPerdido;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ObjetoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjetoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ListView objetosLista;
    ArrayAdapter<ObjetoPerdido> objetoAdapter;

    public ObjetoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ObjetoFragment newInstance() {
        ObjetoFragment fragment = new ObjetoFragment();
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
        View root = inflater.inflate(R.layout.fragment_objeto, container, false);
        objetosLista = (ListView) root.findViewById(R.id.objetos_lista);
        // Inicializar el adaptador con la fuente de datos.
        objetoAdapter = new ObjetoAdapter(getActivity(),
                ObjetoPerdidoRepository.getInstance().getLeads());

        //Relacionando la lista con el adaptador
        objetosLista.setAdapter(objetoAdapter);

        return root;
    }



}
