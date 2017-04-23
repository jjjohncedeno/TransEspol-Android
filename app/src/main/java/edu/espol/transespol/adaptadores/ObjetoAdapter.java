package edu.espol.transespol.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.espol.transespol.R;
import edu.espol.transespol.Repositories.ObjetoPerdidoRepository;
import edu.espol.transespol.fragments.ObjetoFragment;
import edu.espol.transespol.objetos.ObjetoPerdido;

/**
 * Created by john on 1/02/17.
 */
public class ObjetoAdapter extends ArrayAdapter<ObjetoPerdido> implements Filterable {



    public ObjetoAdapter(Context context, List<ObjetoPerdido> objects) {
        super(context, 0, objects);

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_item_objetos,
                    parent,
                    false);
        }

        // Referencias UI.
        ImageView avatar = (ImageView) convertView.findViewById(R.id.imgObjeto);
        TextView name = (TextView) convertView.findViewById(R.id.txtNombre);
        TextView mensaje = (TextView) convertView.findViewById(R.id.txtTexto);

        // Lead actual.
        ObjetoPerdido op = getItem(position);

        // Setup.
        //Glide.with(getContext()).load(op.getImage()).into(avatar);
        name.setText(op.getNombre());
        mensaje.setText(op.getDescripcion());

        return convertView;
    }


}
