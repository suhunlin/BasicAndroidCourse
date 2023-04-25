package com.suhun.basiccourseall.functionobj;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.suhun.basiccourseall.R;

public class BallGameView extends View {
    public BallGameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.ballgame_bg);
    }
}
