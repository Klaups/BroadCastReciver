package com.example.liisi.broadcastreciver;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Liisi on 21-May-16.
 */


public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String TAG = MySQLiteHelper.class.getName();
    private  final Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Calculator";

    //OPERANDTYPE table
    public static final String TABLE_OPERANDTYPE = "operandtype";
    public static final String COLUMN_OPERANDTYPE_ID = "_id";
    public static final String COLUMN_OPERANDTYPE_OPERAND = "operand";
    public static final String COLUMN_OPERANDTYPE_LIFETIMECOUNTER = "lifetimecounter";

    public static final String[] ALLCOLUMNS_OPERANDTYPE = {COLUMN_OPERANDTYPE_ID,
            COLUMN_OPERANDTYPE_OPERAND, COLUMN_OPERANDTYPE_LIFETIMECOUNTER};

    //DAYSTATISTIC table
    public static final String TABLE_DAYSTATISTIC = "daystatistic";
    public static final String COLUMN_DAYSTATISTIC_ID = "_id";
    public static final String COLUMN_DAYSTATISTIC_DAYSTAMP = "daystamp";
    public static final String COLUMN_DAYSTATISTIC_DAYCOUNTER = "daycounter";
    public static final String COLUMN_DAYSTATISTIC_OPERANDID = "operand_id";

    public static final String[] ALLCOLUMNS_DAYSTATISTIC = {COLUMN_DAYSTATISTIC_ID,
            COLUMN_DAYSTATISTIC_DAYSTAMP, COLUMN_DAYSTATISTIC_DAYCOUNTER,
            COLUMN_DAYSTATISTIC_OPERANDID};


    //OPERATION table
    public static final String TABLE_OPERATION = "operation";
    public static final String COLUMN_OPERATION_ID = "_id";
    public static final String COLUMN_OPERATION_NUM1 = "number1";
    public static final String COLUMN_OPERATION_NUM2 = "number2";
    public static final String COLUMN_OPERATION_RES = "result";
    public static final String COLUMN_OPERATION_TIMESTAMP = "timestamp";
    public static final String COLUMN_OPERATION_OPERANDID = "operand_id";

    public static final String[] ALLCOLUMNS_OPERATION = {COLUMN_OPERATION_ID,
            COLUMN_OPERATION_NUM1, COLUMN_OPERATION_NUM2, COLUMN_OPERATION_RES,
            COLUMN_OPERATION_TIMESTAMP, COLUMN_OPERATION_OPERANDID};

    //DATABASE TABLES CREATE COMMAND
    private static final String CREATE_TABLE_OPERANDTYPE = "CREATE TABLE "
            + TABLE_OPERANDTYPE + "(" +
            COLUMN_OPERANDTYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_OPERANDTYPE_OPERAND + " TEXT," +
            COLUMN_OPERANDTYPE_LIFETIMECOUNTER + " INTEGER);";

    private static final String CREATE_TABLE_OPERATION = "CREATE TABLE "
            + TABLE_OPERATION + "(" +
            COLUMN_OPERATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_OPERATION_NUM1  + " DOUBLE," +
            COLUMN_OPERATION_NUM2 + " DOUBLE," +
            COLUMN_OPERATION_RES + " DOUBLE," +
            COLUMN_OPERATION_TIMESTAMP + " TEXT," +
            COLUMN_OPERATION_OPERANDID + " INTEGER);";

    private static final String CREATE_TABLE_DAYSTATISTIC = "CREATE TABLE "
            + TABLE_OPERANDTYPE + "(" +
            COLUMN_DAYSTATISTIC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_DAYSTATISTIC_DAYSTAMP + " TEXT," +
            COLUMN_DAYSTATISTIC_DAYCOUNTER + " INTEGER," +
            COLUMN_DAYSTATISTIC_OPERANDID + " ITNEGER);";

    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public void dropCreateDatabase(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAYSTATISTIC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OPERANDTYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OPERATION);

        db.execSQL(CREATE_TABLE_DAYSTATISTIC);
        db.execSQL(CREATE_TABLE_OPERANDTYPE);
        db.execSQL(CREATE_TABLE_OPERATION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_OPERANDTYPE);
        db.execSQL(CREATE_TABLE_OPERATION);
        db.execSQL(CREATE_TABLE_DAYSTATISTIC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OPERANDTYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OPERATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAYSTATISTIC);
        onCreate(db);
    }
}
