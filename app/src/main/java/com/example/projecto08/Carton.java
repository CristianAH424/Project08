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
import android.widget.Toast;

import com.example.projecto08.models.User;
import com.example.projecto08.models.cardboard;
import com.example.projecto08.models.plastic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.zip.ZipEntry;

public class Carton extends AppCompatActivity {

    ImageView salir;
    String serial;
    EditText Costo,Peso,total;
    Spinner Mes,months;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carton);

        salir = findViewById(R.id.imagSalirMc);
        Costo = findViewById(R.id.CostoKg_Carton);
        Peso = findViewById(R.id.Peso_Carton);
        Mes = findViewById(R.id.spinnerMonthElectricity);
        register = findViewById(R.id.btnRegistrar_carton);

        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");


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
                if (Peso.getText().toString().isEmpty() ||
                        Costo.getText().toString().isEmpty() ||
                        Mes.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Todos los Campos deben diligenciarse", Toast.LENGTH_LONG).show();
                } else {
                    int pesoCarton = Integer.parseInt(Peso.getText().toString());
                    int costoCarton = Integer.parseInt(Costo.getText().toString());
                    String monthsCarton = months.getSelectedItem().toString();
                    int totalCarton = Integer.parseInt(total.getText().toString());
                    cardboard materialCarton = new cardboard(serial,pesoCarton,costoCarton,monthsCarton,totalCarton,idUser);
                    registerCarton(materialCarton);
                    Toast.makeText(getApplicationContext(), "Registro exitoso",
                            Toast.LENGTH_LONG).show();
                    cleanView();

                }

            }
        });

    }

    public void registerCarton(cardboard material) {
        File cardboardFile = new File(getFilesDir(), "cardboard.txt");

        try {
            FileWriter writer = new FileWriter(cardboardFile, true);
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



    public void cleanView() {
        Costo.setText("");
        Peso.setText("");
        months.setSelection(0);
    }

}