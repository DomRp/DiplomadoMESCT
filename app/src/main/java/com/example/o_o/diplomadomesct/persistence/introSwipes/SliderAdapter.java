package com.example.o_o.diplomadomesct.persistence.introSwipes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.o_o.diplomadomesct.R;

public class SliderAdapter extends PagerAdapter {

    public int[] slide_imagenes = {

            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon
    };
    public String[] slide_titulos = {

            "PREPARA",
            "SUEÑA",
            "DESARROLLA"
    };
    public String[] slide_descs = {

            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard ",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's ",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum Leo"
    };
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_titulos.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = v.findViewById(R.id.slide_image);
        TextView slideTitulo = v.findViewById(R.id.slide_title);
        TextView slideDescripcion = v.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_imagenes[position]);
        slideTitulo.setText(slide_titulos[position]);
        slideDescripcion.setText(slide_descs[position]);

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
