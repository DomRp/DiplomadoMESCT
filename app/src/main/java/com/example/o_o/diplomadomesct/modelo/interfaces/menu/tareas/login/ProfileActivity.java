package com.example.o_o.diplomadomesct.modelo.interfaces.menu.tareas.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.example.o_o.diplomadomesct.R;
import com.example.o_o.diplomadomesct.persistence.menu.tareas.login.person;

public class ProfileActivity extends AppCompatActivity {

    private final String PROFILE_DATA = "PROFILE_DATA";
    person currentPerson;

    TextView tvName;
    TextView textViewAbout;
    TextView textViewProjects;
    TextView textViewRepos;
    TextView textViewStars;
    AppCompatButton btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // Para dar (setear) este nombre en el bar --> setTitle("Profile");

        tvName = findViewById(R.id.textViewName);
        textViewAbout = findViewById(R.id.textViewAbout);
        textViewProjects = findViewById(R.id.textViewProjects);
        textViewRepos = findViewById(R.id.textViewRepos);
        textViewStars = findViewById(R.id.tvValoraciones);
        btnShare = findViewById(R.id.btnCompartir);

        if (getIntent() != null && getIntent().getExtras() != null) {
            currentPerson = getIntent().getParcelableExtra(PROFILE_DATA);

            if (currentPerson != null) {
                tvName.setText(currentPerson.getName());
                textViewAbout.setText(currentPerson.getAbout());
                textViewProjects.setText(String.valueOf(currentPerson.getProjects()));
                textViewRepos.setText(String.valueOf(currentPerson.getRepos()));
                textViewStars.setText(String.valueOf(currentPerson.getStars()));
            }
        }

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareProfileData(currentPerson);
            }

            private void shareProfileData(person person) {
                Intent sendIntent = new Intent();

                String textToSend = person.getName() + "\n" + person.getAbout();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textToSend);
                sendIntent.setType("text/plain");

                startActivity(sendIntent);
            }
        });
    }
}
