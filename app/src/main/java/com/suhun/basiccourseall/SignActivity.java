package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.suhun.basiccourseall.functionobj.SignView;

public class SignActivity extends AppCompatActivity {
    Button clearSignBtn, undoSignBun, redoSignBtn, exitSignBtn;
    SignView signView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        initView();
    }

    private void initView(){
        clearSignBtn = findViewById(R.id.signClear);
        undoSignBun = findViewById(R.id.signUndo);
        redoSignBtn = findViewById(R.id.signRedo);
        exitSignBtn = findViewById(R.id.signExit);
        signView = findViewById(R.id.signName);
    }

    public void clearSign(View view){
        signView.clearView();
    }

    public void undoSign(View view){
        signView.undoView();
    }

    public void redoSign(View view){
        signView.redoView();
    }

    public void exitSign(View view){
        finish();
    }
}