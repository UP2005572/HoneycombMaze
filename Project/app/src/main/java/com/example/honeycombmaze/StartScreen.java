package com.example.honeycombmaze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.*;

public class StartScreen extends AppCompatActivity {

    ImageView startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        startButton = findViewById(R.id.hexagon);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent startToGame = new Intent(StartScreen.this, IntroScreen.class);
                startActivity(startToGame);
            }
        });
    }

    @Override
    public void onBackPressed(){
        //nothing happens
    }
}