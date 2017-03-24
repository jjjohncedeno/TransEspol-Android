package edu.espol.transespol.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.espol.transespol.R;

/**
 * Created by john on 5/02/17.
 */
public class DetallesActivity extends Activity {

    public TextView txtNombre;
    public TextView txtDetalles;
    public ImageView imgProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String detalles = intent.getStringExtra("detalles");
        this.txtNombre = (TextView) findViewById(R.id.txtNombreProd);
        this.txtDetalles = (TextView) findViewById(R.id.txtDetalles);

        this.txtNombre.setText(nombre);
        this.txtDetalles.setText(detalles);
    }
}
