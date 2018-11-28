package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;


public class summary extends AppCompatActivity {
    Button CandCshop,placeO;
    Intent intent, intent2;
    double orderTotal, tax, subtot, priceT, ship;
    TextView summary,info;
    FileOutputStream outputStream;
    int orderid=0;
    String name= "Jeena K", paymentType;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        CandCshop=findViewById(R.id.cancelshop);
        placeO=findViewById(R.id.placeorder);

        summary=findViewById(R.id.summTot);
        info=findViewById(R.id.info);

        intent2=getIntent();
        bundle = intent2.getExtras();

        ship = bundle.getDouble("shipping");
        priceT = bundle.getDouble("priceT");
        paymentType = bundle.getString("Payment");



        subtot=priceT+ship;
        tax=0.12*subtot;
        orderTotal=priceT+ship+tax;




        summary.setText("Shipping to:\nAddress:\n\nDelivery by:\nItems:\nShipping fee:\nSubtotal:\nTax:\nOrder Total:");

        String content = String.format("%s\n123 Street,Kelowna ave\nJan 20,2019\n$%.2f\n$%.2f\n$%.2f\n$%.2f\n$%.2f", name, priceT, ship, subtot, tax, orderTotal);
        info.setText(content);

        CandCshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(summary.this, HomePage.class);
                startActivity(intent);
            }
        });

        placeO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String my_file="Records.txt";
                    String filecontents= String.format("OrderId:%d,Name:%s,Total:%.2f,PaymentType:%s\n", orderid ,name,orderTotal,paymentType);

                    outputStream = openFileOutput(my_file, Context.MODE_APPEND);
                    outputStream.write(filecontents.getBytes());
                    outputStream.close();

                    intent = new Intent(summary.this, HomePage.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Your order has been placed", Toast.LENGTH_LONG).show();

                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }
}
