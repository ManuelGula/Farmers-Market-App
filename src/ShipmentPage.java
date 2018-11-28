package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ShipmentPage extends AppCompatActivity {
    Intent intent, intent2;
    double ship;
    double priceT;
    Bundle bundle, bundle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_page);
        intent2 = getIntent();
        bundle2 = intent2.getExtras();
        ship = bundle2.getDouble("shipping");
        priceT = bundle2.getDouble("priceT");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //code for back button
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //method for back button, WILL NEED TO CHANGE TO CORRECT ACTIVITY
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        bundle = new Bundle();
        intent = new Intent(this, Paymentpage.class);

        bundle.putDouble("shipping", ship);
        bundle.putDouble("priceT", priceT);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void onClickHome(View view){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) { //method for back button
        return true;
    }
    }

