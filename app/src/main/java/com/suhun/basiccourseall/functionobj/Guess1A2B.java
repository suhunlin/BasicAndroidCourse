package com.suhun.basiccourseall.functionobj;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Guess1A2B {
    public String tag = Guess1A2B.class.getSimpleName();
    private Context context;
    private Resources res;
    private Button[] guess1A2BBtn;
    private EditText userInputET;
    private TextView logTV;
    private String answer;
    private int answerLen;
    private int selectWhich;
    public Guess1A2B(Context context, Resources res, Button[] guess1A2BBtn, EditText userInputET, TextView logTV){
        this.context = context;
        this.res = res;
        this.guess1A2BBtn = guess1A2BBtn;
        this.userInputET = userInputET;
        this.logTV = logTV;
        answerLen = 4;
        answer = createAnswer();
        Log.d(tag, "The answer is " + answer);
    }

    private String createAnswer(){
        HashSet<Integer> numSet = new HashSet<>();
        while(numSet.size()<answerLen){
            numSet.add(new Random().nextInt(10));
        }
        LinkedList<Integer> numList = new LinkedList<>();
        for(Integer num:numSet){
            numList.add(num);
        }
        Collections.shuffle(numList);
        StringBuffer stringBuffer = new StringBuffer();
        for(Integer num:numList){
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }

    public void showGuess1A2BResult(){
        String userInput = userInputET.getText().toString();
        String result = userInput + ":" + checkAnswer() + "\n";
        logTV.append(result);
        if(checkAnswer().equals(answerLen+"A0B")){
            new AlertDialog.Builder(context)
                    .setTitle("Guess Result")
                    .setMessage("You got it!!!\nReset Game?")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            resetGuessAB();
                            userInputET.setText("");
                        }
                    })
                    .setNeutralButton("Cancel", null)
                    .show();
        }else{
            new AlertDialog.Builder(context)
                    .setTitle("Guess Result")
                    .setMessage(result)
                    .setPositiveButton("Ok", null)
                    .show();
            userInputET.setText("");
        }
    }

    public void showGuess1A2BReset(){
        new AlertDialog.Builder(context)
                .setTitle("Reset Game?")
                .setMessage("Are yout sure?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetGuessAB();
                        userInputET.setText("");
                    }
                })
                .setNeutralButton("Cancel", null)
                .show();
    }

    public void showGuess1A2BSetting(){
        String[] lenSelect = {"2", "3", "4", "5"};
        int checkedItem = 0;
        for(int i=0;i<lenSelect.length;i++){
            if(lenSelect[i].equals(String.valueOf(answerLen))){
                checkedItem = i;
            }
        }
        new AlertDialog.Builder(context)
                .setTitle("Setting Answer Length")
                .setSingleChoiceItems(lenSelect, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(tag, "----which----" + which);
                        selectWhich = which;
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        answerLen = Integer.valueOf(lenSelect[selectWhich]);
                        resetGuessAB();
                    }
                })
                .setNeutralButton("Cancel", null)
                .setCancelable(false)
                .show();
    }
    private String checkAnswer(){
        int a=0, b=0;
        if(userInputET.getText()!=null){
            String userInput = userInputET.getText().toString();
            Log.d(tag, "The user input is " + userInput);
            for(int i=0;i<answerLen;i++){
                if(answer.charAt(i)==userInput.charAt(i)){
                    a++;
                }else if(answer.contains(""+userInput.charAt(i))){
                    b++;
                }
            }
        }else{
            Log.d(tag, "The user input empty!!!");
        }
        return String.format("%dA%dB", a, b);
    }

    public void resetGuessAB(){
        answer = createAnswer();
        Log.d(tag, "The answer is " + answer);
        logTV.setText("");
    }
}
