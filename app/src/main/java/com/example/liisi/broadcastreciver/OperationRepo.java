package com.example.liisi.broadcastreciver;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Liisi on 21-May-16.
 */

public class OperationRepo extends Repo<Operation> {

    public OperationRepo(SQLiteDatabase database, String tableName, String[] allColumns){
        super(database, tableName, allColumns);
    }

    @Override
    public Operation cursorToEntity(Cursor cursor) {
        Operation operation = new Operation();
        operation.setId(cursor.getLong(0));
        operation.setNum1(cursor.getFloat(1));
        operation.setNum2(cursor.getFloat(2));
        operation.setRes(cursor.getFloat(3));
        operation.setTimeStamp(cursor.getString(4));
        operation.setOperandId(cursor.getLong(5));

        return operation;
    }

    @Override
    public ContentValues entityToContentValues(Operation entity) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_NUM1, entity.getNum1());
        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_NUM2, entity.getNum2());
        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_RES, entity.getRes());
        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_TIMESTAMP, entity.getTimeStamp());
        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_OPERANDID, entity.getOperandId());

        return contentValues;
    }
}