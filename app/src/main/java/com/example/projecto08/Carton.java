package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Carton extends AppCompatActivity {

    ImageView salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carton);

        salir = findViewById(R.id.imagSalirMc);

        Intent exit= new Intent(getApplicationContext(), Materiales.class);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(exit);
            }
        });



    }
}