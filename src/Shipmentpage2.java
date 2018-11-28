package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Shipmentpage2 extends AppCompatActivity {
    Button cont;
    double shipping = 5.00;
    Intent intent, intent2;
    double cartPrice;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipmentpage2);
        intent2 = getIntent();
        cartPrice = intent2.getDoubleExtra("priceT", 9.99);
        intent= new Intent(this,ShipmentPage.class);
        bundle = new Bundle();
        cont=findViewById(R.id.cont);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putDouble("priceT", cartPrice);
                bundle.putDouble("shipping",shipping);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked

        if(checked){
            if(view.getId() == R.id.Express) shipping=20.00;
            else shipping=5.00;
        }

//        switch (view.getId()) {
//
//            case R.id.Express:
//
//                if (checked)
//                    shipping=20;
//                break;
//            case R.id.standard:
//                if (checked)
//                    shipping =5;
//                break;
//
//        }
    }



}