package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoPage4 extends AppCompatActivity {

    ImageButton rightbutton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page4);

        rightbutton7 = (ImageButton) findViewById(R.id.rightbutton7);

        rightbutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoPage5();
            }
        });
    }

    public void openInfoPage5() {
        Intent infopage5 = new Intent(this, InfoPage5.class);
        startActivity(infopage5);
    }
}