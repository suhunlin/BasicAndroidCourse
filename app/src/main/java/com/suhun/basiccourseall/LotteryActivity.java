package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.suhun.basiccourseall.functionobj.Lottery;

public class LotteryActivity extends AppCompatActivity {
    private int[] numId = {R.id.num0, R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5};
    private TextView[] lotteryNum = new TextView[numId.length];
    private Button createButton, exitButton;
    private Lottery lottery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);
        initView();
        lottery = new Lottery(getResources(), lotteryNum);
    }

    private void initView(){
        createButton = findViewById(R.id.create);
        exitButton = findViewById(R.id.exit);
        for(int i=0;i<numId.length;i++){
            lotteryNum[i] = findViewById(numId[i]);
        }
        for(int i=0; i<numId.length;i++){
            lotteryNum[i].setText("-");
        }
    }

    public void create(View view){
        lottery.showLotteryNum();
    }

    public void exit(View view){
        finish();
    }
}