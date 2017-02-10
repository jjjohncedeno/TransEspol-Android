package edu.espol.transespol.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.espol.transespol.R;
import edu.espol.transespol.objetos.Comentario;
import edu.espol.transespol.objetos.ObjetoPerdido;

/**
 * Created by john on 5/02/17.
 */
public class ComentarioAdapter extends ArrayAdapter<Comentario> {

    public ComentarioAdapter(Context context, List<Comentario> comentarios) {
        super(context, 0, comentarios);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_item_comentarios,
                    parent,
                    false);
        }

        // Referencias UI.
        TextView name = (TextView) convertView.findViewById(R.id.txtNombreComent);
        TextView mensaje = (TextView) convertView.findViewById(R.id.txtTextoComent);

        // Lead actual.
        Comentario op = getItem(position);

        // Setup.
        //Glide.with(getContext()).load(op.getImage()).into(avatar);
        name.setText(op.getNombre());
        mensaje.setText(op.getMensaje());

        return convertView;
    }
}
