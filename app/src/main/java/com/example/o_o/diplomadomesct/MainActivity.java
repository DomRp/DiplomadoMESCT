package com.example.o_o.diplomadomesct;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.o_o.diplomadomesct.modelo.interfaces.menu.menuPrincipal.MenuPrincipalFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.bienvenidaBD.BienvenidaFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarListaUsuarioIMGconURL.ConsultaListaUsuarioImagenUrlFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarUsuarioURL.ConsultaUsuarioUrlFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarListaUsuario.ConsultarListaUsuariosFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarUsuario.ConsultarUsuarioFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarListaUsuarioIMG.ConsutarListausuarioImagenFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.autor.DesarrolladorFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.registrarUsuario.RegistrarUsuarioFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.IFragments;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.servNotificacion.NotificationActivity;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.tareas.login.LoginActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        Fragment miFragment = new MenuPrincipalFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //=========================================================================================
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    //=========================================================================================


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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        boolean fragmentSeleccionado = false;

        //=============================================================================================================
        //                                              INICIO
        //=============================================================================================================

        if (id == R.id.nav_menuPrincipal) {
            miFragment = new MenuPrincipalFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Menú principal", Toast.LENGTH_SHORT).show();
        }

        //=============================================================================================================
        //                                      PROYECTO FINAL - PARTE 1
        //=============================================================================================================

        else if (id == R.id.nav_apiRest) {
            /*miFragment = new BienvenidaFragment();
            fragmentSeleccionado = true;*/

            Toast.makeText(this, "VAYA A LA BASE DE DATOS REMOTA", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_sharedPref) {
            /*miFragment = new SharedPreferencesFragment();
            fragmentSeleccionado = true;*/

            Toast.makeText(this, "VAYA A LA BASE DE DATOS REMOTA", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_servNotificacion) {
            Intent i = new Intent(getApplicationContext(), NotificationActivity.class);
            startActivity(i);

            Toast.makeText(this, "Opps!! este servicio no está disponible", Toast.LENGTH_SHORT).show();
        }

        //=============================================================================================================
        //                                      PROYECTO FINAL - PARTE 2
        //=============================================================================================================

        else if (id == R.id.nav_inicio_bd) {
            miFragment = new BienvenidaFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Bienvenida BD Remota", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_registrar_usuario_bd) {
            miFragment = new RegistrarUsuarioFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Registrar usuario", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_consulta_usuario_bd) {
            miFragment = new ConsultarUsuarioFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Consultar usuario", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_consulta_lista_usuario) {
            miFragment = new ConsultarListaUsuariosFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Consultar lista de usuario", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_consulta_usuario_con_url) {
            miFragment = new ConsultaUsuarioUrlFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Consultar lista de usuario con URL", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_consulta_lista_usuario_imagen) {
            miFragment = new ConsutarListausuarioImagenFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Consultar lista de usuarios con imagenes desde la URL", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_consulta_lista_usuario_imagen_url) {
            miFragment = new ConsultaListaUsuarioImagenUrlFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Consultar lista de usuarios con imagenes desde la URL", Toast.LENGTH_SHORT).show();
        }

        //=============================================================================================================
        //                                              TAREAS
        //=============================================================================================================

        else if (id == R.id.nav_login) {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);

            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.nav_recyclerView) {
            Toast.makeText(this, "VAYA A LA BASE DE DATOS REMOTA", Toast.LENGTH_SHORT).show();
        }

        //=============================================================================================================
        //                                          DERECHOS DEL AUTOR
        //=============================================================================================================

        else if (id == R.id.nav_copyright) {
            Toast.makeText(this, "No disponible, próximamente", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_autor) {
            miFragment = new DesarrolladorFragment();
            fragmentSeleccionado = true;

            Toast.makeText(this, "Acerca del Autor", Toast.LENGTH_SHORT).show();
        }

        //=============================================================================================================
        //                                              COMPARTIR
        //=============================================================================================================

        else if (id == R.id.nav_enviar) {
            Toast.makeText(this, "No disponible, próximamente", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_compartir) {
            Toast.makeText(this, "No disponible, próximamente", Toast.LENGTH_SHORT).show();
        }
        //=============================================================================================================

        if (fragmentSeleccionado == true) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
