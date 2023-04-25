package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class StopWatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
    }

    public void leftButtonFun(View view){

    }

    public void rightButtonFun(View view){

    }

    public void exitStopWatch(View view){
        finish();
    }
}