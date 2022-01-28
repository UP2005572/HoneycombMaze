package com.example.honeycombmaze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FallenOutScreen extends AppCompatActivity {

    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fallen_out_screen);

        button = findViewById(R.id.restartButton);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startFromFail = new Intent(FallenOutScreen.this, InChamberActivity.class);
                startActivity(startFromFail);
            }
        });
    }

    @Override
    public void onBackPressed(){
        //nothing happens
    }
}