package com.suhun.basiccourseall.functionobj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SignView extends View {
    private LinkedList<LinkedList<HashMap<String, Float>>> lines = new LinkedList<>();
    private LinkedList<LinkedList<HashMap<String, Float>>> recycle = new LinkedList<>();
    public SignView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(4);
        for(LinkedList<HashMap<String, Float>> line: lines){
            for(int i=1;i<line.size();i++){
                HashMap<String, Float> po = line.get(i-1);
                HashMap<String, Float> p1 = line.get(i);
                canvas.drawLine(po.get("x"), po.get("y"), p1.get("x"), p1.get("y"), paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        HashMap<String, Float> point = new HashMap<>();
        point.put("x", event.getX());
        point.put("y", event.getY());
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            LinkedList<HashMap<String, Float>> line = new LinkedList<>();
            line.add(point);
            lines.add(line);
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            lines.getLast().add(point);
        }
        invalidate();
        return true;
    }

    public void clearView(){
        lines.clear();
        invalidate();
    }

    public void undoView(){
        if(lines.size()>0){
            recycle.add(lines.removeLast());
            invalidate();
        }
    }

    public void redoView(){
        if(recycle.size()>0){
            lines.add(recycle.removeLast());
            invalidate();
        }
    }
}
