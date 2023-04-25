package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.suhun.basiccourseall.functionobj.StopWatch;

public class StopWatchActivity extends AppCompatActivity {
    private String tag = StopWatchActivity.class.getSimpleName();
    private int[] buttonId = {R.id.leftButton, R.id.rightButton};
    private Button[] buttons = new Button[buttonId.length];
    private TextView clockView;
    private ListView stopWatchLog;
    private StopWatch stopWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        initView();
        stopWatch = new StopWatch(this, buttons, clockView, stopWatchLog);
    }

    private void initView(){
        for(int i=0;i<buttonId.length;i++){
            buttons[i] = findViewById(buttonId[i]);
        }
        clockView = findViewById(R.id.clock);
        stopWatchLog = findViewById(R.id.stopWatchLap);
    }

    public void leftButtonFun(View view){
        stopWatch.showLeftBtn();
    }

    public void rightButtonFun(View view){
        stopWatch.showRightBtn();
    }

    public void exitStopWatch(View view){
        finish();
    }
}