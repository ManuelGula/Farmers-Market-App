package com.example.ali_meysammohebbi.farmersvendorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    Intent intent, intent2, intent3;
    ImageButton imageButton, cartButton;
    int carnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        // Setup Intents destination here
        intent = new Intent(this, Products.class);
        intent2 = new Intent(this, cartPage.class);
        intent3 = getIntent();
        carnum = intent3.getIntExtra("Quantitos", 0);
        TextView item = findViewById(R.id.itemH);

        item.setText(""+carnum);



        // Linking image buttons to their ids
        imageButton = (ImageButton) findViewById(R.id.honeyH);
        cartButton = (ImageButton) findViewById(R.id.cartBH);

        // Click listener for the buttons
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("quantity", carnum);
                startActivity(intent);
            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra("qt1", carnum);
                startActivity(intent2);
            }
        });
    }
}
