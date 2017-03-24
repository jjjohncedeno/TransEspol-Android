package edu.espol.transespol.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.espol.transespol.R;
import edu.espol.transespol.fragments.ObjetoFragment;

public class ManejadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manejador);

        ObjetoFragment leadsFragment = (ObjetoFragment)
                getSupportFragmentManager().findFragmentById(R.id.principal_contents);

        if (leadsFragment == null) {
            leadsFragment = ObjetoFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.principal_contents, leadsFragment)
                    .commit();
        }
    }
}
