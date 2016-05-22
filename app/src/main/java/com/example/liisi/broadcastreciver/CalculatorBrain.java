package com.example.liisi.broadcastreciver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculatorBrain extends BroadcastReceiver {

    private UOW uow;
    private Repo repo;

    private MySQLiteHelper helper;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(isOrderedBroadcast()){
            double savedValue = 0;

            DateFormat df = new SimpleDateFormat("yyyyMMdd  HH:mm");
            String sdt = df.format(new Date(System.currentTimeMillis()));

            Bundle extras = intent.getExtras();
            if(extras != null){
                char operator = extras.getChar("operator");
                double a = extras.getDouble("number1");
                double b = extras.getDouble("number2");

                switch (operator) {
                    case '+':
                        savedValue = a + b;
                        break;
                    case '-':
                        savedValue = a - b;
                        break;
                    case '*':
                        savedValue = a * b;
                        break;
                    case '/':
                        savedValue = a / b;
                        break;
                }
                if(savedValue == Double.POSITIVE_INFINITY){

                } else {
                    savedValue = round(savedValue);

                }

            }
            setResultCode(Activity.RESULT_OK);
            setResultData(String.valueOf(savedValue));
        }
    }

    public double round(double a) {
        return (double) Math.round(a * 100.0) / 100.0;
    }
}