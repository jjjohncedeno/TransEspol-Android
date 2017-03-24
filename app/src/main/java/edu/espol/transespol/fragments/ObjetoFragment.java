package edu.espol.transespol.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.espol.transespol.R;
import edu.espol.transespol.activities.DetallesActivity;
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
    String url = "http://tranespol.herokuapp.com/api/objetos";

    EditText nameFilter;
    ListView objetosLista;
    ArrayAdapter<ObjetoPerdido> objetoAdapter;
    ArrayList<ObjetoPerdido> objetos = new ArrayList<ObjetoPerdido>();

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_objetos, container, false);
        objetosLista = (ListView) root.findViewById(R.id.objetos_lista);
        nameFilter = (EditText) root.findViewById(R.id.editText);
        // Inicializar el adaptador con la fuente de datos.
        objetoAdapter = new ObjetoAdapter(getActivity(), this.objetos);
        sendRequest();
        //Relacionando la lista con el adaptador
        objetosLista.setAdapter(objetoAdapter);

        objetosLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ObjetoPerdido item = objetos.get(position);
                Intent i = new Intent(getActivity(), DetallesActivity.class);
                i.putExtra("nombre", item.getNombre());
                i.putExtra("detalles", item.getDescripcion());
                startActivity(i);

            }
        });

        nameFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().equals(" ")){
                    //reseteo la lista
                    sendRequest();
                }else{
                    //perfom search
                    searchItem(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        return root;
    }

    private void searchItem(String s) {
        int i;
        for( i=0; i< objetosLista.getAdapter().getCount();i++){
            if(!objetos.get(i).getNombre().contains(s)){
                objetos.remove(objetos.get(i));
            }
            objetoAdapter.notifyDataSetChanged();
        }
    }

    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //showJSON(response);

                        parseJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    public void parseJSON(String json){
        this.objetos.clear();
        JSONObject jsonObject=null;
        try {

            JSONArray objetos = new JSONArray(json);
            for(int i=0;i<objetos.length();i++){
                JSONObject jo = objetos.getJSONObject(i);
                String id = jo.getString("_id");
                String nombre = jo.getString("nombre");
                String descripcion = jo.getString("descripcion");
                String imagen = jo.getString("imagen");
                this.objetos.add(new ObjetoPerdido(descripcion, id, imagen, nombre));

            }
            objetoAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
