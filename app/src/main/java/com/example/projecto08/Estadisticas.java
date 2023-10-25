package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Estadisticas extends AppCompatActivity {
    ImageView salirHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        salirHome= findViewById(R.id.imgSalir2);

        Intent salidaHome = new Intent(getApplicationContext(), Home.class);

        salirHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(salidaHome);
            }
        });

    }
}