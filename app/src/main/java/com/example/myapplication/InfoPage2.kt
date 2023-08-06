package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoPage2 extends AppCompatActivity {

    ImageButton rightbutton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page2);

        rightbutton5 = (ImageButton) findViewById(R.id.rightbutton5);

        rightbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoPage3();
            }
        });
    }

    public void openInfoPage3() {
        Intent infopage3 = new Intent(this, InfoPage3.class);
        startActivity(infopage3);
    }
}