package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoPage3 extends AppCompatActivity {

    ImageButton rightbutton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page3);

        rightbutton6 = (ImageButton) findViewById(R.id.rightbutton6);

        rightbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoPage4();
            }
        });
    }

    public void openInfoPage4() {
        Intent infopage4 = new Intent(this, InfoPage4.class);
        startActivity(infopage4);
    }
}