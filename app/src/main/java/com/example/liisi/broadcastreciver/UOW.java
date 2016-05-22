package com.example.liisi.broadcastreciver;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Liisi on 21-May-16.
 */


public class UOW {

    // Database fields
    private static SQLiteDatabase database;
    private static MySQLiteHelper dbHelper;

    private final Context context;

    public DayStatisticRepo dayStatisticRepo;
    public OperandTypeRepo operandTypeRepo;
    public OperationRepo operationRepo;

    public UOW(Context context){
        this.context = context;

        dbHelper = new MySQLiteHelper(context);
        database = dbHelper.getWritableDatabase();

        dayStatisticRepo = new DayStatisticRepo(database, dbHelper.TABLE_DAYSTATISTIC, dbHelper.ALLCOLUMNS_DAYSTATISTIC);
        operandTypeRepo = new OperandTypeRepo(database, dbHelper.TABLE_OPERANDTYPE, dbHelper.ALLCOLUMNS_OPERANDTYPE);
        operationRepo = new OperationRepo(database, dbHelper.TABLE_OPERATION, dbHelper.ALLCOLUMNS_OPERATION);
    }

    public void DropCreateDatabase(){
        dbHelper.dropCreateDatabase(database);
    }

    public void SeedData(){

        OperandType plus = operandTypeRepo.add(new OperandType("+", 0));
        OperandType minus = operandTypeRepo.add(new OperandType("-", 0));
        OperandType divide = operandTypeRepo.add(new OperandType("/", 0));
        OperandType multiply = operandTypeRepo.add(new OperandType("*", 0));

    }

}
