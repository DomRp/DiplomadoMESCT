package com.example.o_o.diplomadomesct.modelo.interfaces;


import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.bienvenidaBD.BienvenidaFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarListaUsuarioIMGconURL.ConsultaListaUsuarioImagenUrlFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarUsuarioURL.ConsultaUsuarioUrlFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarListaUsuario.ConsultarListaUsuariosFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarUsuario.ConsultarUsuarioFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.consultarListaUsuarioIMG.ConsutarListausuarioImagenFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.autor.DesarrolladorFragment;
import com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.manejoBD.registrarUsuario.RegistrarUsuarioFragment;

/**
 * Created by CHENAO on 5/08/2017.
 */

public interface IFragments extends BienvenidaFragment.OnFragmentInteractionListener, DesarrolladorFragment.OnFragmentInteractionListener,
        RegistrarUsuarioFragment.OnFragmentInteractionListener, ConsultarUsuarioFragment.OnFragmentInteractionListener,
        ConsultarListaUsuariosFragment.OnFragmentInteractionListener, ConsutarListausuarioImagenFragment.OnFragmentInteractionListener,
        ConsultaUsuarioUrlFragment.OnFragmentInteractionListener, ConsultaListaUsuarioImagenUrlFragment.OnFragmentInteractionListener {
}

