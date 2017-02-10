package edu.espol.transespol.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.espol.transespol.R;
import edu.espol.transespol.Repositories.ComentarioRepository;
import edu.espol.transespol.adaptadores.ComentarioAdapter;
import edu.espol.transespol.objetos.Comentario;
import edu.espol.transespol.objetos.ObjetoPerdido;

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
    static ArrayAdapter<Comentario> comentarioAdapter;
    static ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
    FloatingActionButton btnAdd;

    String url = "http://transespol.herokuapp.com/api/comentarios";

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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragmen_comentario, container, false);
        mensajesLista = (ListView) root.findViewById(R.id.comentario_lista);
        // Inicializar el adaptador con la fuente de datos.
        comentarioAdapter = new ComentarioAdapter(getActivity(),
                this.comentarios);
        sendRequest();
        //Relacionando la lista con el adaptador
        mensajesLista.setAdapter(comentarioAdapter);

        btnAdd = (FloatingActionButton) root.findViewById(R.id.fab);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()  );
                builder.setTitle("Escribir comentario");

                // Set up the input
                final EditText input = new EditText(getContext());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setSingleLine(false);
                input.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        postComentario(input.getText().toString());
                        Toast.makeText(getContext(), input.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        return root;
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
        this.comentarios.clear();
        JSONObject jsonObject=null;
        try {
            JSONArray objetos = new JSONArray(json);
            for(int i=0;i<objetos.length();i++){
                JSONObject jo = objetos.getJSONObject(i);

                String nombre = jo.getString("nombre");
                String descripcion = jo.getString("descripcion");
                this.comentarios.add(new Comentario(descripcion, "1234", nombre));

            }

            comentarioAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void postComentario(String mensaje){
        final String username = "jjcedeno";
        final String coment = mensaje;


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ComentarioFragment.comentarios.add(new Comentario(coment, "1231", "jjcedeno"));
                        ComentarioFragment.comentarioAdapter.notifyDataSetChanged();
                        //Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("nombre",username);
                params.put("descripcion",coment);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}