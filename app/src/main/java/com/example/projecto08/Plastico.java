package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projecto08.models.cardboard;
import com.example.projecto08.models.plastic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Plastico extends AppCompatActivity {
    ImageView salir;
    EditText quantity,price;
    Spinner months;
    Button register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastico);

        salir = findViewById(R.id.imagSalirMPlastico);
        price= findViewById(R.id.editTextKl3);
        quantity= findViewById(R.id.editTexPe3);
        months = findViewById(R.id.spinnerMonthElectricity);
        register = findViewById(R.id.btnRe3);

        Intent receive = getIntent();
        String idUser = receive.getStringExtra("idUser");


        Intent exit = new Intent(getApplicationContext(), Materiales.class);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(exit);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity.getText().toString().isEmpty() ||
                        price.getText().toString().isEmpty() ||
                        months.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Todos los Campos deben diligenciarse", Toast.LENGTH_LONG).show();
                } else {
                    int pesoPlastico = Integer.parseInt(quantity.getText().toString());
                    int costoPlastico = Integer.parseInt(price.getText().toString());
                    String monthplastico = months.getSelectedItem().toString();
                    int total = pesoPlastico * costoPlastico;
                    String serial = idUser + monthplastico;
                   plastic materialPlastico = new plastic(serial,pesoPlastico,costoPlastico,total,monthplastico,idUser);
                    registerplastico(materialPlastico);
                    Toast.makeText(getApplicationContext(), "Registro exitoso",
                            Toast.LENGTH_LONG).show();


                }

            }
        });

    }

    public void registerplastico(plastic material) {
        File plasticFile = new File(getFilesDir(), "plastic.txt");

        try {
            FileWriter writer = new FileWriter(plasticFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    material.getSERIAL()+","+
                            material.getQuantity()+","+
                            material.getPrice()+","+
                            material.getTotal()+","+
                            material.getMonth()+","+
                            material.getIdUser()


            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}