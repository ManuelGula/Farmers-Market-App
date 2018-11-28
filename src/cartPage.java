package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class cartPage extends AppCompatActivity {
    int quantity;
    TextView qCart, subPrice, total;
    final double PRICE = 9.99;
    double priceT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        Intent intent = getIntent();
        quantity = intent.getIntExtra("qt1", 0);
        priceT = quantity * PRICE;
        qCart = findViewById(R.id.quantityEdit);
        subPrice = findViewById(R.id.priceText);
        total = findViewById(R.id.totPrice);
        qCart.setText(""+quantity);
        String formPrice = String.format("%.2f", priceT);
        subPrice.setText(formPrice);
        total.setText(formPrice);


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
        Intent intent = new Intent(this, Shipmentpage2.class);
        intent.putExtra("priceT", priceT);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) { //method for back button
        return true;
    }
}
