package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.projecto08.models.cardboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {
    TableLayout carton;
    TextView username;
    ImageView salirHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

       carton = findViewById(R.id.materiales12);
        salirHome= findViewById(R.id.imgSalir2);



        Intent receive = getIntent();
        String userID = receive.getStringExtra("idUser");

        File cardboardFile = new File(getFilesDir(), "cardboard.txt");


        ArrayList<cardboard> list = matarialCardboard(cardboardFile, userID);
        inflateWaterTable(list);



    }

    public void inflateWaterTable(ArrayList<cardboard> list) {
        System.out.println("inflate");
        System.out.println(list.size());

        int total = 0;
        String averageValue = "";
        System.out.println("Antes");
        for (cardboard i : list) {
            TableRow row = new TableRow(this);
            TextView quantity = new TextView(this);
            quantity.setWidth(97);
            quantity.setTextSize(14);
            quantity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView price = new TextView(this);
            price.setTextSize(14);
            price.setWidth(96);
            price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView month = new TextView(this);
            month.setWidth(105);
            month.setTextSize(14);
            month.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            quantity.setText(i.getQuantity()+"");
            price.setText(i.getPrice()+"");
            TextView totalM = new TextView(this);
            totalM.setWidth(90);
            totalM.setTextSize(14);
            totalM.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);




            System.out.println(total + " - " + i.getQuantity() + " - " + averageValue);
            row.addView(month);
            row.addView(quantity);
            row.addView(price);
            row.addView(totalM);

            cardboard.addView(row);
        }
        System.out.println("Fin");
    }

    private int totalcarton(ArrayList<cardboard> list) {
        return 0;
    }


    public ArrayList<cardboard> matarialCardboard(File carton, String id) {
        ArrayList<cardboard> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(carton);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            System.out.println(reader.toString());
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (id.equals(data[3])) {
                    System.out.println(line);
                    int quantity= Integer.parseInt(data[0]);
                    int price= Integer.parseInt(data[1]);
                    String month = (data[2]);
                    int totalM =Integer.parseInt(data[3]);
                    cardboard obj = new cardboard( "",quantity,price,month,totalM,id);
                    list.add(obj);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }




    public String total(int total, int quantity) {
        if (total == 0) {
            return "Error";
        } else {
            double total_d = total;
            double quantity_d = quantity;
            double avg = (quantity_d / total_d) * 100; //2.3698
            DecimalFormat df = new DecimalFormat("#.##");// 2.36
            // df.setRoundingMode(RoundingMode.FLOOR); 2.37
            return df.format(avg);
        }
    }
}




