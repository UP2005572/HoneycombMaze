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

        //BeeAnimation(1);
    }




    protected InputStream getCSVRes(){
        Resources res = getResources();
        return res.openRawResource(R.raw.backend);
    }

    public void ShowButton(ImageView button){
        button.setVisibility(View.VISIBLE);
    }

    public void GoneButton(ImageView button) {button.setVisibility(View.GONE);}

    public void HideButton(ImageView button){
        button.setVisibility(View.INVISIBLE);
    }




    protected void BeeAnimation(int direction){
        ImageView bee = (ImageView) findViewById(R.id.bee);
        float xPos = bee.getX();
        float yPos = bee.getY();

       /*GoneButton((ImageView) findViewById(R.id.tButton));
        GoneButton((ImageView) findViewById(R.id.trButton));
        GoneButton((ImageView) findViewById(R.id.brButton));
        GoneButton((ImageView) findViewById(R.id.bButton));
        GoneButton((ImageView) findViewById(R.id.blButton));
        GoneButton((ImageView) findViewById(R.id.tlButton));*/


        switch(direction){
            case 1:
                bee.setRotation(bee.getRotation()+90);
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