package com.example.honeycombmaze;

import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class InChamberActivity extends AppCompatActivity {

    NodeMap nodeMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_chamber);

        InputStream in_s = getCSVRes();
        nodeMap = new NodeMap(in_s);

        BeeAnimation(1);
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




    protected void BeeAnimation(int direction){
        ImageView bee = (ImageView) findViewById(R.id.bee);
        float xPos = bee.getX();
        float yPos = bee.getY();

        HideButton((ImageView) findViewById(R.id.tButton));
        HideButton((ImageView) findViewById(R.id.trButton));
        HideButton((ImageView) findViewById(R.id.brButton));
        HideButton((ImageView) findViewById(R.id.bButton));
        HideButton((ImageView) findViewById(R.id.blButton));
        HideButton((ImageView) findViewById(R.id.tlButton));


        switch(direction){
            case 1:
                bee.setRotation(45);
                for (int i=0; i == 1000; i++){
                    xPos -= 1;
                    yPos += 1;
                    bee.setX(xPos);
                    bee.setY(yPos);
                }
            case 2:
                bee.setRotation(135);
            case 3:
                bee.setRotation(180);
            case 4:
                bee.setRotation(-135);
            case 5:
                bee.setRotation(-45);
        }

    }
}