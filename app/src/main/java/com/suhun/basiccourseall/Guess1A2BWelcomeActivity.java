package com.suhun.basiccourseall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Guess1A2BWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess1_a2_bwelcome);
    }

    public void go1A2BGame(View view){
        Intent intent = new Intent(this, Guess1A2BActivity.class);
        startActivity(intent);
        finish();
    }
}