package com.example.liisi.broadcastreciver;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Liisi on 21-May-16.
 */


public class OperandTypeRepo extends Repo<OperandType> {

    public OperandTypeRepo(SQLiteDatabase database, String tableName, String[] allColumns){
        super(database, tableName, allColumns);
    }

    @Override
    public OperandType cursorToEntity(Cursor cursor) {
        OperandType operandType = new OperandType();
        operandType.setId(cursor.getLong(0));
        operandType.setOperand(cursor.getString(1));
        operandType.setCounter(cursor.getLong(2));

        return operandType;
    }

    @Override
    public ContentValues entityToContentValues(OperandType entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_OPERANDTYPE_OPERAND, entity.getOperand());
        contentValues.put(MySQLiteHelper.COLUMN_OPERANDTYPE_LIFETIMECOUNTER, entity.getCounter());

        return contentValues;
    }
}