package com.suhun.basiccourseall.functionobj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.suhun.basiccourseall.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class BallGameView extends View {
    private String tag = BallGameView.class.getSimpleName();
    private Resources res;
    private boolean isInitBall;
    private Ball ball;
    private LinkedList<Ball> balls = new LinkedList<>();
    private class Ball{
        private int[] ballId = {R.drawable.ball0, R.drawable.ball1, R.drawable.ball2, R.drawable.ball3};
        private Bitmap ballbmp;
        private int ballW, ballH;
        private float ballX, ballY;
        public Ball(Resources res,float ballX, float ballY){
            this.ballX = ballX; this.ballY = ballY;
            this.ballW = (int)(getWidth()/12.0); this.ballH = ballW;
            this.ballbmp = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(res, ballId[new Random().nextInt(4)])
                    ,ballW, ballH, false);
        }
    }
    public BallGameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.ballgame_bg);
        res = context.getResources();
    }

    private void initBall(){
        isInitBall = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isInitBall){
            initBall();
        }
        if(ball!=null){
            for(Ball ball:balls){
                canvas.drawBitmap(ball.ballbmp, ball.ballX, ball.ballY, null);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            ball = new Ball(res, event.getX(), event.getY());
            balls.add(ball);
            postInvalidate();
        }
        return true;
    }
}
