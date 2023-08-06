package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    ImageButton storybutton;
    ImageButton playbutton;
    ImageButton bookbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        storybutton = (ImageButton) findViewById(R.id.storybutton);
        playbutton = (ImageButton) findViewById(R.id.playbutton);
        bookbutton = (ImageButton) findViewById(R.id.bookbutton);

        storybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openComicPage1();
            }
        });

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz();
            }
        });

        bookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoPage1();
            }
        });
    }

    public void openComicPage1(){
        Intent comicpage1 = new Intent(this, ComicPage1.class);
        startActivity(comicpage1);
    }

    public void openQuiz(){
        Intent quiz = new Intent(this, Quiz.class);
        startActivity(quiz);
    }

    public void openInfoPage1(){
        Intent infopage1 = new Intent(this, InfoPage1.class);
        startActivity(infopage1);
    }
}