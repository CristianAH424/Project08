package com.example.projecto08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projecto08.models.producto;

import java.util.ArrayList;

public class StatisticActivity2 extends AppCompatActivity {
    EditText name,prize,quantity;
    Button register,end;
    TextView totalValvue;
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic2);

        name=findViewById(R.id.editTextProducto);
        prize=findViewById(R.id.editTextPrecio);
        quantity=findViewById(R.id.editTextCantidad);
        register=findViewById(R.id.buttonRegistrar);
        end=findViewById(R.id.buttonFinalizar);
        totalValvue=findViewById(R.id.tvTotalValue);
        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        table=findViewById(R.id.tableProducts);

        ArrayList<producto> factura=new ArrayList<>();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre= name.getText().toString();
                String precio= prize.getText().toString();
                String cantidad=quantity.getText().toString();

                if(nombre.isEmpty() || precio.isEmpty() || cantidad.isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Todos los campos deben diligenciarse", Toast.LENGTH_LONG).show();
                }else{
                    int precioNew= Integer.parseInt(precio);
                    int cantidadNew=Integer.parseInt(cantidad);
                    producto nuevo= new producto(nombre,precioNew,cantidadNew);
                    factura.add(nuevo);
                    llenarTabla(nuevo);
                    calcularTotal(factura);
                    limpiar();
                }



            }
        });
    }
    public void llenarTabla(producto producto){
        int valor= producto.getCantidad()*producto.getPrecio();

        TableRow fila= new TableRow(this);

        TextView celda1= new TextView(this);
        celda1.setText(producto.getNombre());
        celda1.setWidth(110);
        celda1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        fila.addView(celda1);

        TextView celda2=new TextView(this);
        celda2.setText(producto.getCantidad()+ "");
        celda2.setWidth(85);
        celda2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        fila.addView(celda2);


        TextView celda3= new TextView(this);
        celda3.setText(producto.getPrecio()+"");
        celda3.setWidth(88);
        celda3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        fila.addView(celda3);


        TextView celda4=new TextView(this);
        celda4.setText(valor+"");
        celda4.setWidth(85);
        celda4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        fila.addView(celda4);


        table.addView(fila);
    }

    public void limpiar(){
        name.setText("");
        prize.setText("");
        quantity.setText("");
    }

    public void calcularTotal(ArrayList<producto>compra){
        int valor=0;
        for (producto i: compra){
            valor+= i.getPrecio()*i.getCantidad();
        }
        totalValvue.setText(valor+"");
    }

}
