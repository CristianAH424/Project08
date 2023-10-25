package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Materiales extends AppCompatActivity {

    ImageView salirm;
    Button carton, cobre, vidrio, plastico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiales);
        salirm = findViewById(R.id.imagSalirM);
        carton = findViewById(R.id.btnC);
        vidrio = findViewById(R.id.btnV);
        plastico = findViewById(R.id.btnP);
        cobre = findViewById(R.id.btnCo);

        Intent exit= new Intent(getApplicationContext(), Home.class);
        Intent Cart= new Intent(getApplicationContext(), Carton.class);
        Intent Vid= new Intent(getApplicationContext(), Vidrio.class);
        Intent Plas= new Intent(getApplicationContext(), Plastico.class);
        Intent Cobr= new Intent(getApplicationContext(), Cobre.class);

        salirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(exit);
            }
        });

        carton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Cart);
            }
        });
        vidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Vid);
            }
        });

        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Plas);
            }
        });

        cobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Cobr);

            }
        });
    }
}