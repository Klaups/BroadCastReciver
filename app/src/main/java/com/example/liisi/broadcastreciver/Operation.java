package com.example.liisi.broadcastreciver;

/**
 * Created by Liisi on 21-May-16.
 */

public class Operation implements IEntity {
    private long _id;
    private double _num1;
    private double _num2;
    private double _res;
    private String _timestamp;
    private long _operandId;

    public Operation(){

    }

    public Operation(double n1, double n2, double res, String time, long operandId){
        setNum1(n1);
        setNum2(n2);
        setRes(res);
        setTimeStamp(time);
        setOperandId(operandId);

    }

    public long getId(){
        return this._id;
    }

    public void setId(long id){
        this._id = id;
    }

    public long getOperandId(){
        return this._operandId;
    }

    public void  setOperandId(long operandId){
        this._operandId = operandId;
    }

    public double getNum1(){
        return this._num1;
    }

    public void setNum1(double num1){
        this._num1 = num1;
    }

    public double getNum2(){
        return this._num2;
    }

    public void setNum2(double num2){
        this._num2 = num2;
    }

    public double getRes(){
        return this._res;
    }

    public void setRes(double res){
        this._res = res;
    }

    public String getTimeStamp(){
        return this._timestamp;
    }

    public void setTimeStamp(String timestamp){
        this._timestamp = timestamp;
    }

}