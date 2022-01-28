package com.example.honeycombmaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class IntroScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        ImageView startButton;

        startButton = (ImageView) findViewById(R.id.start);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent startToGame = new Intent(IntroScreen.this, InChamberActivity.class);
                startActivity(startToGame);
            }
        });
    }

    @Override
    public void onBackPressed(){
        //nothing happens
    }
}