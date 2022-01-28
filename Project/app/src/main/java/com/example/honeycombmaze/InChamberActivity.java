package com.example.honeycombmaze;

import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class InChamberActivity extends AppCompatActivity {

    NodeMap nodeMap;

    ImageView tButton;
    ImageView trButton;
    ImageView brButton;
    ImageView bButton;
    ImageView blButton;
    ImageView tlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_chamber);

        InputStream in_s = getCSVRes();
        nodeMap = new NodeMap(in_s);

        tButton = findViewById(R.id.tButton);
        trButton = findViewById(R.id.trButton);
        brButton = findViewById(R.id.brButton);
        bButton = findViewById(R.id.bButton);
        blButton = findViewById(R.id.blButton);
        tlButton = findViewById(R.id.tlButton);


        tButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ChangeNode(1);
            }
        });

        trButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ChangeNode(2);
            }
        });

        brButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ChangeNode(3);
            }
        });

        bButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ChangeNode(4);
            }
        });

        blButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ChangeNode(5);
            }
        });

        tlButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ChangeNode(6);
            }
        });

        ChooseButtons();
    }

    @Override
    public void onBackPressed(){
       //nothing happens
    }

    protected void ChangeNode(int decision){
        HideDirButtons();
        nodeMap.decision(decision);
        CheckStatus(nodeMap.GetCurrentNode().getID());
        if (nodeMap.GetCurrentNode().getID() != 102 && nodeMap.GetCurrentNode().getID() != 101 ) {
            ChooseButtons();
        }
    }

    public void ChooseButtons(){
        if (nodeMap.GetCurrentNode().getID() == 0) {HideDirButtons();}

        if (nodeMap.GetCurrentNode().gettID() != -1){
            ShowButton(tButton);
        }
        if (nodeMap.GetCurrentNode().getTrID() != -1){
            ShowButton(trButton);
        }
        if (nodeMap.GetCurrentNode().getBrID() != -1){
            ShowButton(brButton);
        }
        if (nodeMap.GetCurrentNode().getbID() != -1){
            ShowButton(bButton);
        }
        if (nodeMap.GetCurrentNode().getBlID() != -1){
            ShowButton(blButton);
        }
        if (nodeMap.GetCurrentNode().getTlID() != -1){
            ShowButton(tlButton);
        }
    }

    protected void CheckStatus(int nodeID){
        switch(nodeID){
            case 102:
                Intent toLossScreen = new Intent(InChamberActivity.this, FallenOutScreen.class);
                startActivity(toLossScreen);
                break;
            case 101:
                Intent toSuccessScreen = new Intent(InChamberActivity.this, SuccessfulRun.class);
                startActivity(toSuccessScreen);
                break;
        }
    }

    protected InputStream getCSVRes(){
        Resources res = getResources();
        return res.openRawResource(R.raw.backend);
    }

    public void ShowButton(ImageView button){
        button.setVisibility(View.VISIBLE);
    }

    public void HideButton(ImageView button){
        button.setVisibility(View.INVISIBLE);
    }

    public void HideDirButtons(){
        HideButton(tButton);
        HideButton(trButton);
        HideButton(brButton);
        HideButton(bButton);
        HideButton(blButton);
        HideButton(tlButton);
    }

}