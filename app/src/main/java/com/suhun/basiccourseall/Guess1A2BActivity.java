package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.suhun.basiccourseall.functionobj.Guess1A2B;

public class Guess1A2BActivity extends AppCompatActivity {
    private int[] guess1A2BId = {R.id.guess1A2B, R.id.reset1A2B, R.id.setting1A2B, R.id.exit1A2B};
    private Button[] guess1A2BBtn = new Button[guess1A2BId.length];
    private EditText userInputET;
    private TextView logTV;
    private Guess1A2B guess1A2B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess1_a2_bactivity);
        initView();
        guess1A2B = new Guess1A2B(this, getResources(), guess1A2BBtn, userInputET, logTV);
    }

    private void initView(){
        for(int i=0;i<guess1A2BId.length;i++){
            guess1A2BBtn[i] = findViewById(guess1A2BId[i]);
        }

        userInputET = findViewById(R.id.userInput1A2B);
        logTV = findViewById(R.id.log1A2B);
    }

    public void guess1A2B(View view){
        guess1A2B.showGuess1A2BResult();
    }

    public void reset1A2B(View view){
        guess1A2B.showGuess1A2BReset();
    }

    public void setting1A2B(View view){
        guess1A2B.showGuess1A2BSetting();
    }

    public void exit1A2B(View view){
        finish();
    }
}