package com.suhun.basiccourseall;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public String tag = MainActivity.class.getSimpleName();
    private ActivityResultLauncher goStartCallBalk =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Log.d(tag, "---Go Back Main Activity---");

                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lottery(View view){
        Intent intent = new Intent(this, LotteryActivity.class);
        goStartCallBalk.launch(intent);
    }

    public void guess1A2BWelcome(View view){
        Intent intent = new Intent(this, Guess1A2BWelcomeActivity.class);
        goStartCallBalk.launch(intent);
    }
}