package com.suhun.basiccourseall.functionobj;

import android.content.res.Resources;
import android.widget.TextView;

import java.util.Random;
import java.util.TreeSet;

public class Lottery {
    private Resources res;
    private TextView[] lotteryNum;
    public Lottery(Resources res, TextView[] lotteryNum){
        this.res = res;
        this.lotteryNum = lotteryNum;
    }

    public void showLotteryNum(){
        int[] lottery = createLottery();
        for(int i=0;i<lottery.length;i++){
            this.lotteryNum[i].setText(""+lottery[i]);
        }
    }

    private int[] createLottery(){
        TreeSet<Integer> numSet = new TreeSet<>();
        while(numSet.size()<lotteryNum.length){
            numSet.add(new Random().nextInt(49) + 1);
        }
        int[] temp = new int[lotteryNum.length];
        int i = 0;
        for(Integer num:numSet){
            temp[i++] = num;
        }
        return temp;
    }
}
