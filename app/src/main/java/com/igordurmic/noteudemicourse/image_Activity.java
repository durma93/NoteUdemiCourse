package com.igordurmic.noteudemicourse;

import android.content.DialogInterface;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class image_Activity extends AppCompatActivity implements PointCollectorListener{

    private PointCollector pointCollector = new PointCollector();
    private Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_);

        addtouchlistener();

        showPrompt();

        pointCollector.setListener(this);
    }

    private void showPrompt(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setTitle("Naslov poruke");
        builder.setMessage("Pruka bre jebi se u dupe smrdljivo");

        AlertDialog dig = builder.create();

        dig.show();

    }


    private void addtouchlistener(){

       ImageView imageView = (ImageView) findViewById(R.id.imageView);

       imageView.setOnTouchListener(pointCollector);
    }

    @Override
    public void pointsCollected(List<Point> points) {
        Log.d(MainActivity.debugtag, "collected points:" +points.size());
    }
}
