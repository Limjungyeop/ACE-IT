package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ComicPage2 extends AppCompatActivity {

    ImageButton leftbutton1;
    ImageButton rightbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_page2);

        rightbutton2 = (ImageButton) findViewById(R.id.rightbutton2);
        leftbutton1 = (ImageButton) findViewById(R.id.leftbutton1);

        leftbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openComicPage1();
            }
        });

        rightbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openComicPage3();
            }
        });
    }
    public void openComicPage1() {
        Intent comicpage1 = new Intent(this, ComicPage1.class);
        startActivity(comicpage1);
    }

    public void openComicPage3() {
        Intent comicpage3 = new Intent(this, ComicPage3.class);
        startActivity(comicpage3);
    }
}