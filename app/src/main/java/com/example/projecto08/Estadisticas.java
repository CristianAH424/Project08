package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.projecto08.models.User;
import com.example.projecto08.models.cardboard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {
    ImageView salirHome;
    TableLayout TableCarboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        salirHome= findViewById(R.id.imgSalir2);
        TableCarboard= findViewById(R.id.TableCarboard);

        Intent receive= getIntent();
        String userID= receive.getStringExtra("idUser");

        File cardboardFile= new File(getFilesDir(),"cardboard.txt");

        ArrayList<cardboard> listcardboard = materialCardboar(cardboardFile, userID);
        inflatecardboardTable(listcardboard);
        Intent salidaHome = new Intent(getApplicationContext(), Home.class);

        salirHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(salidaHome);
            }
        });

    }


    private void inflatecardboardTable(ArrayList<cardboard> list) {

        System.out.println("inflate");
        System.out.println(list.size());


        int total=0;
        String promedio="";
        System.out.println("Antes");
        for (cardboard i:list){
            TableRow row=new TableRow(this);
            TextView quantity=new TextView(this);
            TextView price=new TextView(this);
            TextView month= new TextView(this);
            TextView tot= new TextView(this);
            TextView average= new TextView(this);

            quantity.setText(i.getQuantity()+"");
            price.setText(i.getPrice()+"");
            month.setText(i.getMonth());
            tot.setText(i.getTotal()+"");
            total= totalcardboard(list);


            System.out.println(total+"-"+i.getQuantity());
            row.addView(month);
            row.addView(quantity);
            row.addView(price);
            row.addView(average);

           TableCarboard.addView(row);

        }


    }


    public ArrayList<cardboard> materialCardboar(File cardboard, String id){
       ArrayList<cardboard> list=new ArrayList<>();
        try {
            FileReader reader=new FileReader(cardboard);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line;
            System.out.println(reader.toString());
            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                if (id.equals(data[3])){
                    System.out.println(line);
                    int quantity= Integer.parseInt(data[0]);
                    int price= Integer.parseInt(data[1]);
                    String month=data[2];
                    cardboard obj= new cardboard(quantity,price,month,id);
                    list.add(obj);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    private int totalcardboard(ArrayList<cardboard> list) {
        int total=0;
        for (cardboard i: list){
            total+=i.getQuantity();
        }return total;
    }


}


