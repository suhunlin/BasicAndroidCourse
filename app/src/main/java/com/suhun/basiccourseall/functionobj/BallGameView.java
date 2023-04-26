package com.suhun.basiccourseall.functionobj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.suhun.basiccourseall.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BallGameView extends View {
    private String tag = BallGameView.class.getSimpleName();
    private Resources res;
    private Ball ball;
    private int dX, dY;
    private LinkedList<Ball> balls = new LinkedList<>();
    private class Ball{
        private int[] ballId = {R.drawable.ball0, R.drawable.ball1, R.drawable.ball2, R.drawable.ball3};
        private Bitmap ballbmp;
        private int ballW, ballH, viewW, viewH;
        private float ballX, ballY, dX, dY;
        private Timer timer = new Timer();
        private BallTask ballTask;
        private boolean isBallMove;
        private class BallTask extends TimerTask{
            @Override
            public void run() {
                if(ballX < 0 || (ballX + ballW) > viewW){
                    dX *= -1;
                }
                if(ballY < 0 || (ballY + ballH) > viewH){
                    dY *= -1;
                }
                ballX += dX;
                ballY += dY;
                postInvalidate();
            }
        }
        public Ball(Resources res,float ballX, float ballY){
            this.viewW = getWidth(); this.viewH = getHeight();
            this.ballX = ballX; this.ballY = ballY;
            this.ballW = (int)(this.viewW/12.0); this.ballH = ballW;
            this.ballbmp = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(res, ballId[new Random().nextInt(4)])
                    ,ballW, ballH, false);
            this.dX = this.dY = 16;
        }

        public void startBallRun(){
            if(!this.isBallMove){
                ballTask = new BallTask();
                timer.schedule(ballTask, 1000, 100);
                this.isBallMove = true;
            }
        }
        public void stopBallRun() {
            if (this.ballTask != null) {
                this.isBallMove = false;
                ballTask.cancel();
                ballTask = null;
            }
        }
    }
    public BallGameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.ballgame_bg);
        res = context.getResources();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(ball!=null){
            for(Ball ball:balls){
                ball.startBallRun();
                canvas.drawBitmap(ball.ballbmp, ball.ballX + ball.dX, ball.ballY + ball.dY, null);
                ball.startBallRun();
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
//        else if(event.getAction() == MotionEvent.ACTION_MOVE){
//            if(balls.size() > 0){
//                for(Ball ball:balls){
//                    ball.stopBallRun();
//                    postInvalidate();
//                }
//            }
//        }
        return true;
    }
}
