package edu.espol.transespol.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.espol.transespol.R;
import edu.espol.transespol.Repositories.ObjetoPerdidoRepository;
import edu.espol.transespol.activities.DetallesActivity;
import edu.espol.transespol.activities.PrincipalActivity;
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
    ArrayList<ObjetoPerdido> objetos = new ArrayList<ObjetoPerdido>();

    public ObjetoFragment() {
        this.objetos.add(new ObjetoPerdido("Paraguas encontrado en la unidad del Sur, horario 11:30 am", "1", "Por ahi", "Paraguas"));
        this.objetos.add(new ObjetoPerdido("Celular encontrado en la unidad de albanborja.", "1", "Por ahi", "Celular"));
        this.objetos.add(new ObjetoPerdido("Libro encontrado en la parada de bus de Mecánica", "1", "Por ahi", "Libro"));
        this.objetos.add(new ObjetoPerdido("Tomatodo encontrado en el bus del sur", "1", "Por ahi", "Tomatodo"));
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
        View root = inflater.inflate(R.layout.fragment_objetos, container, false);
        objetosLista = (ListView) root.findViewById(R.id.objetos_lista);
        // Inicializar el adaptador con la fuente de datos.
        objetoAdapter = new ObjetoAdapter(getActivity(),
                this.objetos);

        //Relacionando la lista con el adaptador
        objetosLista.setAdapter(objetoAdapter);

        objetosLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                ObjetoPerdido item = objetos.get(position);
                Intent i = new Intent(getActivity(), DetallesActivity.class);
                i.putExtra("nombre", item.getNombre());
                i.putExtra("detalles", item.getDescripcion());
                startActivity(i);

            }
        });


        return root;
    }



}
