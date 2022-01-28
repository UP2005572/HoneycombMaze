package com.example.honeycombmaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SuccessfulRun extends AppCompatActivity {

    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_run);

        button = findViewById(R.id.playAgainButton);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startFromWin = new Intent(SuccessfulRun.this, InChamberActivity.class);
                startActivity(startFromWin);
            }
        });
    }

    @Override
    public void onBackPressed(){
        //nothing happens
    }
}