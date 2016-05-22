package com.example.liisi.broadcastreciver;

/**
 * Created by Liisi on 21-May-16.
 */


public class OperandType implements IEntity {
    private long _id;
    private String _operand;
    private long _lifeTimeCounter;

    public OperandType(){

    }

    public OperandType(String operand, long Counter){
        setOperand(operand);
        setCounter(Counter);
    }

    public long getId(){
        return this._id;
    }

    public void setId(long id){
        this._id = id;
    }

    public String getOperand(){
        return this._operand;
    }

    public void setOperand(String operand){ this._operand = operand; }

    public long getCounter(){
        return this._lifeTimeCounter;
    }

    public void setCounter(long counter){
        this._lifeTimeCounter = counter;
    }

}
