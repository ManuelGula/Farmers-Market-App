package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Products extends AppCompatActivity {
    Intent intent, intent2, intent3;
    int cartupdate;
    TextView items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        // initialize intents
        intent = new Intent(this, ProductToCart.class);
        intent2 = new Intent(this, cartPage.class);
        intent3 = getIntent();
        cartupdate = intent3.getIntExtra("quantity",0);
        items = findViewById(R.id.items);

        items.setText(""+cartupdate);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //code for back button

    }

    // Goes to product details --> ProductToCart page
    public void onHoneyClick(View view){
        intent.putExtra("quantity2", cartupdate);
        startActivity(intent);
    }

    // Goes to Cart
    public void onCartClick(View view) {
        intent2.putExtra("qt1", cartupdate);
        startActivity(intent2);
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
}
