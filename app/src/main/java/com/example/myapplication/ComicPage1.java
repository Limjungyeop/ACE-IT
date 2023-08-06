package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ComicPage1 extends AppCompatActivity {

    ImageButton rightbutton1;
    ImageButton homebutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_page1);

        rightbutton1 = (ImageButton) findViewById(R.id.rightbutton1);
        homebutton1 = (ImageButton) findViewById(R.id.homebutton1);

        homebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        rightbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openComicPage2();
            }
        });
    }

    public void openMainActivity(){
        Intent mainactivity = new Intent(this, MainActivity.class);
        startActivity(mainactivity);
    }

    public void openComicPage2() {
        Intent comicpage2 = new Intent(this, ComicPage2.class);
        startActivity(comicpage2);
    }
}