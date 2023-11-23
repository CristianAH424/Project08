package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Carton extends AppCompatActivity {

    ImageView salir;
    EditText Costo,Peso,Total;
    Spinner Mes;
    Button register;
    TextView material;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carton);

        salir = findViewById(R.id.imagSalirMc);
        Costo = findViewById(R.id.CostoKg_Carton);
        Peso = findViewById(R.id.Peso_Carton);
        Mes = findViewById(R.id.spinnerMonthElectricity);
        register = findViewById(R.id.btnRegistrar_carton);
        material= findViewById(R.id.material_carton);


        Intent exit= new Intent(getApplicationContext(), Materiales.class);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(exit);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }
}