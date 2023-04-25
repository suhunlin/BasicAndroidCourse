package com.suhun.basiccourseall.functionobj;

import android.content.Context;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.suhun.basiccourseall.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    private Context context;
    private Button[] buttons;
    private TextView clock;
    private ListView lap;
    private boolean isStart;
    private int timeCounter;
    private Timer timer = new Timer();
    private MyTask myTask;
    private SimpleAdapter simpleAdapter;
    private LinkedList<HashMap<String, String>> list;
    private String[] from = {"itemKey"};
    int[] to = {R.id.list_item};

    private class MyTask extends TimerTask{
        @Override
        public void run() {
            timeCounter+=1;
            clock.setText(counterToClock());
        }
    }

    public StopWatch(Context context, Button[] buttons, TextView clock, ListView lap){
        this.context = context;
        this.buttons = buttons;
        this.clock = clock;
        this.lap = lap;
        list = new LinkedList<>();
        initListView();
    }

    private void initListView(){
        simpleAdapter = new SimpleAdapter(context, list, R.layout.item, from, to);
        lap.setAdapter(simpleAdapter);
    }
    public void showLeftBtn(){doLeftBtnFun(); };

    private void doLeftBtnFun(){
        if(isStart){
            doLap();
        }else{
            doReset();
        }
    }

    private void doLap(){
        HashMap<String, String> item = new HashMap<>();
        item.put(from[0], clock.getText().toString());
        list.add(0,item);
        simpleAdapter.notifyDataSetChanged();
    }

    private void doReset(){
        list.clear();
        simpleAdapter.notifyDataSetChanged();
    }
    public void showRightBtn(){
        doRightBtnfun();
    }
    private void doRightBtnfun(){
        isStart = !isStart;
        if(isStart){
            buttons[0].setText("Lap");
            buttons[1].setText("Stop");
            doStart();
        }else{
            buttons[0].setText("Reset");
            buttons[1].setText("Start");
            doStop();
        }
    }

    private void doStart(){
        if(myTask == null){
            myTask = new MyTask();
            timer.schedule(myTask, 10, 10);
        }
    }

    private void doStop(){
        if(myTask != null){
            myTask.cancel();
            myTask = null;
            timeCounter = 0;
            clock.setText("00:00:00.0");
        }
    }

    public String counterToClock(){
        int ms = timeCounter%100;
        int ts = timeCounter/100;
        int hh = ts/(60*60);
        int mm = (ts - hh*60*60)/60;
        int ss =ts %60;
        return String.format("%d:%d:%d.%d", hh, mm, ss, ms);
    }
}
