package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProductToCart extends AppCompatActivity {
    EditText quantity;
    String qty;
    TextView cart1;
    Intent intent, intent2, intent3;
    int quant=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_to_cart);

        intent = new Intent(this, HomePage.class);
        intent3 = new Intent(this, cartPage.class);
        intent2 = getIntent();
        quant = intent2.getIntExtra("quantity2", 0);

        quantity = findViewById(R.id.quantity);


        cart1 = findViewById(R.id.itemsb);
        cart1.setText(""+quant);


    }


    public void onAddClick(View view){
        qty = quantity.getText().toString();


        if(qty.equals("0") || qty.equals("00") || qty.length()==0){
            Toast.makeText(getApplicationContext(), "Quantity is 0, choose quantity other than 0.", Toast.LENGTH_LONG).show();
        }
        else {
            int num = Integer.parseInt(qty);
            quant += num;
            cart1.setText(""+quant);
            intent.putExtra("Quantitos", quant);
            startActivity(intent);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //code for back button
    }

    public void onCartClick(View view){
        intent3.putExtra("qt1", quant);
        startActivity(intent3);
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

    public boolean onCreateOptionsMenu(Menu menu) { //method for back button
        return true;
    }

    public void onClickCart(View view){
        Intent intent = new Intent(this, cartPage.class);
        startActivity(intent);
    }
}
