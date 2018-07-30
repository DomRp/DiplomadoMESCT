package com.example.o_o.diplomadomesct.modelo.interfaces.menu.proyectosFinales.servNotificacion;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.o_o.diplomadomesct.R;

public class NotificationActivity extends AppCompatActivity {

    private Button btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnNotif = findViewById(R.id.btnNotificacion);

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pulsaNotificacion(view);
            }
        });
    }

    public void pulsaNotificacion(View view) {

        NotificationCompat.Builder notificarBuilder = new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.sleep_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.sleep_icon))
                .setContentTitle("Notificación del día!!!")
                .setContentText("Gracias por utilizar esta aplicación");

        NotificationManager notificaciManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificaciManager.notify(1, notificarBuilder.build());
    }
}
