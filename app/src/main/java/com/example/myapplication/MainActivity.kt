package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    EditText etage;
    EditText etcountry;
    ImageButton saveToRealtimeDatabase;
    DatabaseReference databaseReference;
    ImageButton startbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etname = findViewById(R.id.etname);
        etage = findViewById(R.id.etage);
        etcountry = findViewById(R.id.etcountry);
        saveToRealtimeDatabase = (ImageButton) findViewById(R.id.saveToRealtimeDatabase);
        startbutton = (ImageButton) findViewById(R.id.startbutton);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openComicPage1();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        saveToRealtimeDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUserData();
            }
        });


    }

    public void openComicPage1(){
        Intent comicpage1 = new Intent(this, ComicPage1.class);
        startActivity(comicpage1);
    }

    public void insertUserData(){

        String name = etname.getText().toString();
        String age = etage.getText().toString();
        String country = etcountry.getText().toString();

        Users users = new Users(name,age,country);

        databaseReference.push().setValue(users);
        Toast.makeText(MainActivity.this,"Data inserted!",Toast.LENGTH_SHORT).show();
    }
}