package edu.espol.transespol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MenuItem nav_comunidad_coment, nav_comunidad, nav_comunidad_perdido, nav_rutasE, nav_rutasS, nav_rutaE_alban, nav_rutaE_acacia;
    MenuItem nav_rutaE_norte1, nav_rutaE_norte2, nav_rutaE_norte3, nav_rutaE_orquideas, nav_rutaE_perimetral, nav_rutaE_portete, nav_rutaS_alban;
    MenuItem nav_rutaS_norte, nav_rutaS_Sur, nav_rutaE_duran;
    Menu menuNav;
    NavigationView navigationView;

    ArrayList<String> rutas_entradas = new ArrayList<String>();
    ArrayList<String> rutas_salidas = new ArrayList<String>();
    private WebView mWebView;

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

        this.llenarListas();
        this.setRutas();
        //topChannelMenu.add("Foo");
        //topChannelMenu.add("Bar");
        //topChannelMenu.add("Baz");

        setOptionMenu();
        // Enable Javascript
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("http://transespol.espol.edu.ec/");

    }

    public void llenarListas(){
        rutas_entradas.add("Ruta1");
        rutas_entradas.add("Ruta2");
        rutas_entradas.add("Ruta3");
        rutas_entradas.add("Ruta4");

        rutas_salidas.add("Ruta1");
        rutas_salidas.add("Ruta2");
        rutas_salidas.add("Ruta3");
        rutas_salidas.add("Ruta4");
    }

    public void setRutas(){
        Menu m = navigationView.getMenu();
        SubMenu entrada = m.addSubMenu(0, 3, 2, "Rutas de entrada");
        SubMenu salida = m.addSubMenu(0, 4, 3, "Rutas de salida");

        for (String i: rutas_entradas){
            entrada.add("    " + i);
        }

        for (String i: rutas_salidas){
            salida.add("    " + i);
        }

    }

    public void setOptionMenu(){
        menuNav = navigationView.getMenu();
        nav_comunidad = menuNav.findItem(R.id.nav_comunidad);
        nav_comunidad_coment = menuNav.findItem(R.id.nav_comunidad_coment);
        nav_comunidad_perdido = menuNav.findItem(R.id.nav_comunidad_perdidos);


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
                mWebView.loadUrl("http://transespol.espol.edu.ec/");
            case R.id.nav_ubicacion:
                return true;
            case R.id.nav_interno:
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

        for (String i: rutas_entradas){
            if (item.equals("    " + i)){

                Bundle args = new Bundle();

                Fragment fragment = MapaFragment.newInstance();
                fragment.setArguments(args);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .commit();
                return true;
            }
        }

        for (String i: rutas_salidas){
            if (item.equals("    " + i)){
                Bundle args = new Bundle();

                Fragment fragment = MapaFragment.newInstance();
                fragment.setArguments(args);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .commit();

                return true;
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return ret;
    }

    private void selectItem(String title) {
        // Enviar título como arguemento del fragmento
        Bundle args = new Bundle();

        Fragment fragment = MapaFragment.newInstance();
        fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .commit();

        //drawerLayout.closeDrawers(); // Cerrar drawer

        setTitle(title); // Setear título actual

    }
}
