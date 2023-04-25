package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
    }

    public void clearSign(View view){

    }

    public void undoSign(View view){

    }

    public void redoSign(View view){

    }

    public void exitSign(View view){
        finish();
    }
}