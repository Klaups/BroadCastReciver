package com.example.liisi.broadcastreciver;


import java.util.Date;
/**
 * Created by Liisi on 21-May-16.
 */

public class DayStatistic implements IEntity {

    private long _id;
    private String _dayStamp;
    private long _dayCounter;
    private long _operandId;

    public DayStatistic(){

    }

    public DayStatistic(String date, long daycount, long operandId){
        setDayStamp(date);
        setDayCounter(daycount);
        setOperandId(operandId);
    }

    public long getId(){
        return this._id;
    }

    public void setId(long id){
        this._id = id;
    }

    public String getDayStamp(){
        return this._dayStamp;
    }

    public void setDayStamp(String dayStamp){
        this._dayStamp = dayStamp;
    }

    public long getOperandId(){
        return this._operandId;
    }

    public void setOperandId(long operandId){
        this._operandId = operandId;
    }

    public long getDayCounter(){
        return this._dayCounter;
    }

    public void setDayCounter(long dayCounter){
        this._dayCounter = dayCounter;
    }
}
