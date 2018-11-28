package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Paymentpage extends AppCompatActivity {
    Button cont1;
    String payopt="Visa";
    RadioGroup radgrp;
    Intent intent, intent2;
    Bundle bundle, bundle2;
    double priceT, ship;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentpage);
        cont1 = findViewById(R.id.cont1);

        intent2 = getIntent();
        bundle2 = intent2.getExtras();
        ship = bundle2.getDouble("shipping");
        priceT = bundle2.getDouble("priceT");

        intent = new Intent(this, summary.class);
        bundle = new Bundle();
        radgrp = findViewById(R.id.radioGroup);

        cont1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radgrp.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Select payment method", Toast.LENGTH_SHORT).show();
                } else {

                    bundle.putDouble("shipping", ship);
                    bundle.putDouble("priceT", priceT);
                    bundle.putString("Payment", payopt);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked

        if(checked){
            if(view.getId() == R.id.mastCard) payopt = "Master Card";
            else payopt = "Visa";
        }


//        switch (view.getId()) {
//            case R.id.mastCard:
//                if (checked)
//                    payopt="MasterCard";
//                break;
//            case R.id.VIsacard:
//                if (checked)
//                    payopt="Visa";
//                break;
//
//        }

    }
}
