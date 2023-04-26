package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.suhun.basiccourseall.functionobj.BallGameView;

public class BallGameActivity extends AppCompatActivity {
    private Button stopBtn;
    private BallGameView ballGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_game);
        stopBtn = findViewById(R.id.stopBallGame);
        ballGameView = findViewById(R.id.ballGameView);
    }

    public void stopBallGame(View view){
        ballGameView.stopBallGame();
    }
}