package com.example.o_o.diplomadomesct.modelo.interfaces.menu.menuPrincipal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.o_o.diplomadomesct.MainActivity;
import com.example.o_o.diplomadomesct.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuPrincipalFragment extends Fragment {


    public MenuPrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //=========================================================================================
        ((MainActivity) getActivity()).setActionBarTitle("Menú Principal");
        //=========================================================================================
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_principal, container, false);
    }

}
