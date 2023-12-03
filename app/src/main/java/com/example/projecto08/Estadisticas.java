package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projecto08.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {
    ImageView salirHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        salirHome= findViewById(R.id.imgSalir2);

        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        Intent salidaHome = new Intent(getApplicationContext(), Home.class);

        salirHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(salidaHome);
            }
        });



    }
    public ArrayList<Carton> listCarton(File carton,String User) {
        ArrayList<Carton> list = new ArrayList<>();

        try {
            FileReader reader = new FileReader((carton));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String cadena;

            while ((cadena = bufferedReader.readLine()) != null) {//36;48 miuntos clase 17
                String[] data = cadena.split(",");
                if (data[4].equals(User)) {


                    String SERIAL = data[0];
                    int quantity = Integer.parseInt(data[1]);
                    int price = Integer.parseInt(data[2]);
                    String month = data[3];
                    String idUser = data[4];




                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}


