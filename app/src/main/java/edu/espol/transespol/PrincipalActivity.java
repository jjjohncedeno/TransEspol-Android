package edu.espol.transespol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MenuItem nav_comunidad_coment, nav_comunidad, nav_comunidad_perdido, nav_rutasE, nav_rutasS, nav_rutaE_alban, nav_rutaE_acacia;
    MenuItem nav_rutaE_norte1, nav_rutaE_norte2, nav_rutaE_norte3, nav_rutaE_orquideas, nav_rutaE_perimetral, nav_rutaE_portete, nav_rutaS_alban;
    MenuItem nav_rutaS_norte, nav_rutaS_Sur, nav_rutaE_duran;
    Menu menuNav;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setOptionMenu();

    }

    public void setOptionMenu(){
        menuNav = navigationView.getMenu();
        nav_comunidad = menuNav.findItem(R.id.nav_comunidad);
        nav_comunidad_coment = menuNav.findItem(R.id.nav_comunidad_coment);
        nav_comunidad_perdido = menuNav.findItem(R.id.nav_comunidad_perdidos);
        nav_rutasE = menuNav.findItem(R.id.nav_entrada);
        nav_rutasS = menuNav.findItem(R.id.nav_salida);
        nav_rutaS_alban = menuNav.findItem(R.id.nav_salida_alban);
        nav_rutaS_norte = menuNav.findItem(R.id.nav_salida_norte);
        nav_rutaS_Sur = menuNav.findItem(R.id.nav_salida_sur);
        nav_rutaE_alban = menuNav.findItem(R.id.nav_entrada_alban);
        nav_rutaE_acacia = menuNav.findItem(R.id.nav_entrada_acacia);
        nav_rutaE_duran = menuNav.findItem(R.id.nav_entrada_duran);
        nav_rutaE_norte1 = menuNav.findItem(R.id.nav_entrada_norte1);
        nav_rutaE_norte2 = menuNav.findItem(R.id.nav_entrada_norte2);
        nav_rutaE_norte3 = menuNav.findItem(R.id.nav_entrada_norte3);
        nav_rutaE_orquideas = menuNav.findItem(R.id.nav_entrada_orquideas);
        nav_rutaE_perimetral = menuNav.findItem(R.id.nav_entrada_perimetral);
        nav_rutaE_portete = menuNav.findItem(R.id.nav_entrada_portete);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean ret = true;

        switch (id){
            case R.id.nav_inicio:
                return true;
            case R.id.nav_ubicacion:
                return true;
            case R.id.nav_interno:
                return true;
            case R.id.nav_entrada:
                if (!nav_rutasE.isChecked()){
                    nav_rutaE_alban.setVisible(true);
                    nav_rutaE_acacia.setVisible(true);
                    nav_rutaE_duran.setVisible(true);
                    nav_rutaE_norte1.setVisible(true);
                    nav_rutaE_norte2.setVisible(true);
                    nav_rutaE_norte3.setVisible(true);
                    nav_rutaE_orquideas.setVisible(true);
                    nav_rutaE_perimetral.setVisible(true);
                    nav_rutaE_portete.setVisible(true);
                    nav_rutasE.setChecked(true);
                }else{
                    nav_rutaE_alban.setVisible(false);
                    nav_rutaE_acacia.setVisible(false);
                    nav_rutaE_duran.setVisible(false);
                    nav_rutaE_norte1.setVisible(false);
                    nav_rutaE_norte2.setVisible(false);
                    nav_rutaE_norte3.setVisible(false);
                    nav_rutaE_orquideas.setVisible(false);
                    nav_rutaE_perimetral.setVisible(false);
                    nav_rutaE_portete.setVisible(false);
                    nav_rutasE.setChecked(false);
                }
                return true;
            case R.id.nav_salida:
                if (!nav_rutasS.isChecked()){
                    nav_rutaS_alban.setVisible(true);
                    nav_rutaS_norte.setVisible(true);
                    nav_rutaS_Sur.setVisible(true);
                    nav_rutasS.setChecked(true);
                }else{
                    nav_rutaS_alban.setVisible(false);
                    nav_rutaS_norte.setVisible(false);
                    nav_rutaS_Sur.setVisible(false);
                    nav_rutasS.setChecked(false);
                }
                return true;
            case R.id.nav_comunidad:

                if (!nav_comunidad.isChecked()) {
                    nav_comunidad_coment.setVisible(true);
                    nav_comunidad_perdido.setVisible(true);
                    nav_comunidad.setChecked(true);
                }
                else{
                    nav_comunidad_coment.setVisible(false);
                    nav_comunidad_perdido.setVisible(false);
                    nav_comunidad.setChecked(false);
                }
                ret=false;
            case R.id.nav_acerca_de:
                return true;
            case R.id.nav_cerrar:
                return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return ret;
    }
}
