package com.example.o_o.diplomadomesct.modelo.intro.introSwipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.o_o.diplomadomesct.MainActivity;
import com.example.o_o.diplomadomesct.R;
import com.example.o_o.diplomadomesct.persistence.introSwipes.SliderAdapter;

public class IntroActivity extends AppCompatActivity {

    //==================================
    private ViewPager mSlideViewPager;
    private LinearLayout mPuntoLayout;
    private Button mBtnSgte;
    private Button mBtnAnt;
    private Button mBtnTerm;
    private int mPagActual;
    //==================================
    private TextView[] cantPuntos;
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {

            addIndicadorPuntos(i);
            mPagActual = i;

            if (i == 0) {
                mBtnSgte.setEnabled(true);
                mBtnSgte.setVisibility(View.VISIBLE);
                mBtnSgte.setText("Siguiente");

                mBtnAnt.setEnabled(false);
                mBtnAnt.setVisibility(View.INVISIBLE);
                mBtnAnt.setText("");

                mBtnTerm.setEnabled(false);
                mBtnTerm.setVisibility(View.INVISIBLE);
                mBtnTerm.setText("");
            } else if (i == cantPuntos.length - 1) {

                mBtnSgte.setEnabled(false);
                mBtnSgte.setVisibility(View.INVISIBLE);
                mBtnSgte.setText("");

                mBtnAnt.setEnabled(true);
                mBtnAnt.setVisibility(View.VISIBLE);
                mBtnAnt.setText("Anterior");

                mBtnTerm.setEnabled(true);
                mBtnTerm.setVisibility(View.VISIBLE);
                mBtnTerm.setText("Terminar");
            } else {
                mBtnSgte.setEnabled(true);
                mBtnSgte.setVisibility(View.VISIBLE);
                mBtnSgte.setText("Siguiente");

                mBtnAnt.setEnabled(true);
                mBtnAnt.setVisibility(View.VISIBLE);
                mBtnAnt.setText("Anterior");

                mBtnTerm.setEnabled(false);
                mBtnTerm.setVisibility(View.INVISIBLE);
                mBtnTerm.setText("");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };
    //==================================
    //==================================
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //======================================================
        mSlideViewPager = findViewById(R.id.slideViewPager);
        mPuntoLayout = findViewById(R.id.dotsLayout);
        mBtnSgte = findViewById(R.id.btnIntroSiguiente);
        mBtnAnt = findViewById(R.id.btnIntroAnterior);
        mBtnTerm = findViewById(R.id.btnIntroTerminar);

        //======================================================
        sliderAdapter = new SliderAdapter(this);
        //======================================================
        mSlideViewPager.setAdapter(sliderAdapter);
        //======================================================
        addIndicadorPuntos(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        //======================================================
        mBtnSgte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mPagActual + 1);
            }
        });
        //======================================================
        mBtnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mPagActual - 1);
            }
        });
        //======================================================
        mBtnTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pulsaTerminar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(pulsaTerminar);
            }
        });
        //======================================================
    }

    public void addIndicadorPuntos(int posicion) {

        cantPuntos = new TextView[3];
        mPuntoLayout.removeAllViewsInLayout();

        for (int i = 0; i < cantPuntos.length; i++) {

            cantPuntos[i] = new TextView(this);
            cantPuntos[i].setText(Html.fromHtml("&#8226;"));
            cantPuntos[i].setTextSize(35);
            cantPuntos[i].setTextColor(getResources().getColor(R.color.colorTransparenteBlanco));

            mPuntoLayout.addView(cantPuntos[i]);
        }
        if (cantPuntos.length > 0) {
            cantPuntos[posicion].setTextColor(getResources().getColor(R.color.colorFondoAmarillo));
        }
    }
}
