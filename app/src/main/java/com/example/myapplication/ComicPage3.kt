package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ComicPage3 extends AppCompatActivity {

    ImageButton leftbutton2;
    ImageButton rightbutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_page3);

        rightbutton3 = (ImageButton) findViewById(R.id.rightbutton3);
        leftbutton2 = (ImageButton) findViewById(R.id.leftbutton2);

        leftbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openComicPage2();
            }
        });

        rightbutton3.setOnClickListener(new View.OnClickListener() {
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
    public void openComicPage2() {
        Intent comicpage2 = new Intent(this, ComicPage2.class);
        startActivity(comicpage2);
    }
}