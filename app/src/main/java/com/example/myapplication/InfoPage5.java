package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoPage5 extends AppCompatActivity {

    ImageButton backtomenubutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page5);

        backtomenubutton2 = (ImageButton) findViewById(R.id.backtomenubutton2);

        backtomenubutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });
    }
    public void openMenu() {
        Intent menu = new Intent(this, Menu.class);
        startActivity(menu);
    }
}