package com.igordurmic.noteudemicourse;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PointCollector implements View.OnTouchListener{

    private List<Point> points = new ArrayList<Point>();
    private PointCollectorListener listener;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int x = Math.round(event.getX());
        int y = Math.round(event.getY());

        String msg = String.format("Cordidants: (%d, %d", x, y);

        Log.d(MainActivity.debugtag, msg);

        points.add(new Point(x,y));

        if (points.size() == 4){
            if (listener !=null){
                listener.pointsCollected(points);
                points.clear();
            }
        }

        return false;
    }

        public void setListener(PointCollectorListener listener) {
            this.listener = listener;
        }
}
