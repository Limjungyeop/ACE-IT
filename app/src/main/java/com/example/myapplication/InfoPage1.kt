package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoPage1 extends AppCompatActivity {

    ImageButton backtomenubutton;
    ImageButton rightbutton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page1);

        rightbutton4 = (ImageButton) findViewById(R.id.rightbutton4);
        backtomenubutton = (ImageButton) findViewById(R.id.backtomenubutton);

        backtomenubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

        rightbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoPage2();
            }
        });

    }
    public void openMenu() {
        Intent menu = new Intent(this, Menu.class);
        startActivity(menu);
    }
    public void openInfoPage2() {
        Intent infopage2 = new Intent(this, InfoPage2.class);
        startActivity(infopage2);
    }
}