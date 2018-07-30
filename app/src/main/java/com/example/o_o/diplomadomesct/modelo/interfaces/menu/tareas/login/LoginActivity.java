package com.example.o_o.diplomadomesct.modelo.interfaces.menu.tareas.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import com.example.o_o.diplomadomesct.R;
import com.example.o_o.diplomadomesct.persistence.menu.tareas.login.person;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText etCorreo;
    EditText etClave;
    HashMap<String, person> data;
    private AppCompatButton btnLogin;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etCorreo = findViewById(R.id.etCorreo);
        etClave = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnEnter);

        createDummyListOfPeople();
        SharedPreferences mLoged = getSharedPreferences("UserInf", Context.MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = "";

                if (etCorreo != null) {
                    correo = etCorreo.getText().toString().toLowerCase();
                }

                person currentPerson = data.get(correo);

                if (currentPerson != null) {
                    Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                    i.putExtra("PROFILE_DATA", currentPerson);
                    startActivity(i);
                } else {
                    showErrorDialog();
                    etCorreo.setText("");
                    etClave.setText("");
                }
            }
        });
    }

    private void showErrorDialog() {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(R.string.dialog_body_message);
        dlgAlert.setTitle(R.string.dialog_title_message);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    private void createDummyListOfPeople() {
        person person = new person();
        person.setName("Leandro Leonardo");
        person.setEmail("prueba@leandro.com");
        person.setAbout("I'm Leandro Leonardo Software Developer specialized on Android Development.");
        person.setProjects(100);
        person.setStars(300);
        person.setRepos(150);

        data = new HashMap<>();
        data.put("prueba@leandro.com", person);
    }
}
