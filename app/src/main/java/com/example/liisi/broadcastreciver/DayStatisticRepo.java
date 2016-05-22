package com.example.liisi.broadcastreciver;



import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;
/**
 * Created by Liisi on 21-May-16.
 */
public class DayStatisticRepo extends Repo<DayStatistic> {

    public DayStatisticRepo(SQLiteDatabase database, String tableName, String[] allColumns){
        super(database, tableName, allColumns);
    }

    @Override
    public DayStatistic cursorToEntity(Cursor cursor) {
        DayStatistic stat = new DayStatistic();
        stat.setId(cursor.getLong(0));
        stat.setDayStamp(cursor.getString(1));
        stat.setDayCounter(cursor.getLong(2));
        stat.setOperandId(cursor.getLong(3));
        return stat;
    }

    @Override
    public ContentValues entityToContentValues(DayStatistic stat) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MySQLiteHelper.COLUMN_DAYSTATISTIC_DAYSTAMP, stat.getDayStamp());
        contentValues.put(MySQLiteHelper.COLUMN_DAYSTATISTIC_DAYCOUNTER, stat.getDayCounter());
        contentValues.put(MySQLiteHelper.COLUMN_DAYSTATISTIC_OPERANDID, stat.getOperandId());

        return contentValues;
    }

}
