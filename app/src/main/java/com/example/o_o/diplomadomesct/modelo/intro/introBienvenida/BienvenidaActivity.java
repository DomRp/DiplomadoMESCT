package com.example.o_o.diplomadomesct.modelo.intro.introBienvenida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.o_o.diplomadomesct.R;
import com.example.o_o.diplomadomesct.modelo.intro.introSwipes.IntroActivity;

public class BienvenidaActivity extends AppCompatActivity {

    private Button btnBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        btnBienvenida = findViewById(R.id.btnBienvenida);
    }

    public void pulsaParaContinuar(View view) {

        Intent Pulsa = new Intent(this, IntroActivity.class);
        startActivity(Pulsa);
    }
}
