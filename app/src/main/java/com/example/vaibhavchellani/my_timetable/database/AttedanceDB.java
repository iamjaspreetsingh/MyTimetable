package com.example.vaibhavchellani.my_timetable.database;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.vaibhavchellani.my_timetable.MainActivity;

/**
 * Created by vaibhavchellani on 1/17/17.
 */

public class AttedanceDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "attendanceDB.db";
    private static final int DATABASE_VERSION=11;
    ContentValues values=new ContentValues();
    // TODO change all column names to caps like lecture 1
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DAY="DAY";
    public static final String COLUMN_LECTURE1="TEN_THIRTY";
    public static final String COLUMN_LECTURE2="Eleven_twentyfive";
    public static final String COLUMN_LECTURE3="Twelve_twenty";
    public static final String COLUMN_LECTURE4="Twelve_fifty";
    public static final String COLUMN_LECTURE5="One_fourtyfive";
    public static final String COLUMN_LECTURE6="Two_forty";
    public static final String COLUMN_LECTURE7="Three_thirtyfive";
    public static final String COLUMN_LECTURE8="Four_thirty";
    public static final String COLUMN_LECTURE9="Four_forty";
    public static final String COLUMN_LECTURE10="Five_thirtyfive";

    //todo add new columns like columnlecture1-ID AND ADD VALUES IN THEM

    public static final String COLUMN_SUBJECT="SUBJECTS";
    public static final String COLUMN_PRESENT_COUNTER="PRESENT";
    public static final String COLUMN_ABSENT_COUNTER="ABSENT";
    public static final String COLUMN_NO_CLASS="NO_LECTURE";


    public static final String TABLE_CHECK_CLASS = "check_class";
    public static final String TABLE_ATTENDANCE = "attendance";
    public static final String IT_EVE_2[]={"10:30","11:25","12:30","12:50","1:45","2:40","3:35","4:30","5:35"};
    public AttedanceDB(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_STRING="CREATE TABLE IF NOT EXISTS " + TABLE_CHECK_CLASS + " ( "
                +COLUMN_ID + " INTEGER, "
                +COLUMN_DAY + " TEXT, "
                +COLUMN_LECTURE1 + " TEXT, "
                +COLUMN_LECTURE2 +" TEXT, "
                +COLUMN_LECTURE3 + " TEXT, "
                +COLUMN_LECTURE4 + " TEXT, "
                +COLUMN_LECTURE5 + " TEXT, "
                +COLUMN_LECTURE6 + " TEXT, "
                +COLUMN_LECTURE7 + " TEXT, "
                +COLUMN_LECTURE8 + " TEXT, "
                +COLUMN_LECTURE9 + " TEXT, "
                +COLUMN_LECTURE10 + " TEXT "
                + ");";
        Log.d(" ", "QUERY IS "+ SQL_CREATE_STRING);
        sqLiteDatabase.execSQL(SQL_CREATE_STRING);

        final String SQL_CREATE_ATTENDANCE="CREATE TABLE IF NOT EXISTS "+ TABLE_ATTENDANCE + " ( "
                +COLUMN_ID + " INTEGER, "
                +COLUMN_SUBJECT + " TEXT, "
                +COLUMN_PRESENT_COUNTER + " INTEGER DEFAULT 0 , "
                +COLUMN_ABSENT_COUNTER + " INTEGER DEFAULT 0 , "
                +COLUMN_NO_CLASS + " INTEGER DEFAULT 0 "
                + ");";
        sqLiteDatabase.execSQL(SQL_CREATE_ATTENDANCE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_CHECK_CLASS);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_ATTENDANCE);
        onCreate(sqLiteDatabase);
    }

    public void make_attendance_table(){
        SQLiteDatabase db=getWritableDatabase();
        values.put(COLUMN_ID,1);
        values.put(COLUMN_SUBJECT,"CS");
        db.insert(TABLE_ATTENDANCE,null,values);
        values.put(COLUMN_ID,2);
        values.put(COLUMN_SUBJECT,"AM");
        db.insert(TABLE_ATTENDANCE,null,values);
        values.put(COLUMN_ID,3);
        values.put(COLUMN_SUBJECT,"TOC");
        db.insert(TABLE_ATTENDANCE,null,values);
        values.put(COLUMN_ID,4);
        values.put(COLUMN_SUBJECT,"COA");
        db.insert(TABLE_ATTENDANCE,null,values);
        values.put(COLUMN_ID,5);
        values.put(COLUMN_SUBJECT,"DBMS");
        db.insert(TABLE_ATTENDANCE,null,values);
        values.put(COLUMN_ID,6);
        values.put(COLUMN_SUBJECT,"OOPS");
        db.insert(TABLE_ATTENDANCE,null,values);
        db.close();
    }
    public void addrow_check_class(){
        SQLiteDatabase db=getWritableDatabase();
        String ROW1 = "INSERT INTO " + TABLE_CHECK_CLASS + " Values (1,'MONDAY','AM(P1)/C304    COA(P2)/A107     DBMS(P3)/A102','AM(P1)/C304     COA(P2)/A107     DBMS(P3)/A102','BREAK','OOPS(L) / C301','DBMS/B204','AM(L)/C204','TOC(L)/C204','BREAK','DBMS(P1)/A102     AM(P2)/C304     COA(P3)/A107','DBMS(P1)/A102     AM(P2)/C304     COA(P3)/A107')";
        db.execSQL(ROW1);
        ROW1 = "INSERT INTO " + TABLE_CHECK_CLASS + " Values (2,'TUESDAY','AM(T1)/B204    CS(T2)/D201 ','CS(L)/****','BREAK','TOC(L)/C204','COA(L)/C204','AM(L)/C204','OOPS/C204','BREAK','COA(P1)/A107     DBMS(P2)/A102     AM(P3)/C304','COA(P1)/A107     DBMS(P2)/A102     AM(P3)/C304')";
        db.execSQL(ROW1);
        ROW1 = "INSERT INTO " + TABLE_CHECK_CLASS + " Values (3,'WEDNESDAY','DBMS(T2)/C302','COA(T2)/C302','BREAK','COA(T1)/A304   TOC(T2)/A103','DBMS(L)/B201','OOPS(L)/C204','AM(L)/C204','BREAK','TOC(L)/C204','null')";
        db.execSQL(ROW1);
        ROW1 = "INSERT INTO " + TABLE_CHECK_CLASS + " Values (4,'THURSDAY','OOPS(P2)/C305','OOPS(P2)/C305','BREAK','CS(T1)/C302','TOC(T1)/C302','CS(L)/C204','COA(L)/C204','BREAK','CS(P3)/A306','CS(P3)/A306')";
        db.execSQL(ROW1);
        ROW1 = "INSERT INTO " + TABLE_CHECK_CLASS + " Values (5,'FRIDAY','OOPS(P1)/C305     CS(P2)/A306','OOPS(P1)/C305     CS(P2)/A306','BREAK','DBMS(L)/C301','DBMS(T1)/C305     AM(T2)/C301','CS(L)/C204','COA(L)/C204','BREAK','CS(P1)/A306     OOPS(P3)/C305','CS(P1)/A306     OOPS(P3)/C305')";
        db.execSQL(ROW1);
        db.close();


    }

    public String databaseToString(String Table_Name,String day){

        SQLiteDatabase db=getWritableDatabase();
        String TAG=TABLE_CHECK_CLASS;
        Log.d(TAG, "getTableAsString called");
        String tableString = "";
        Cursor allRows  = db.rawQuery("select * from "+Table_Name+ " where " + COLUMN_DAY + "= '"+day+"' ",null);
        if (allRows.moveToFirst() ){
            String[] columnNames = allRows.getColumnNames();
                for (String name: columnNames) {
                    tableString += String.format("%s:    %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n\n";
        }


        return tableString;

    }

    public String getTableAsString(String tableName) {
        SQLiteDatabase db=getWritableDatabase();
        String TAG=TABLE_CHECK_CLASS;
        Log.d(TAG, "getTableAsString called");
        String tableString = "";
        Cursor allRows  = db.rawQuery("SELECT * FROM " + tableName, null);
        if (allRows.moveToFirst() ){
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name: columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n\n";

            } while (allRows.moveToNext());
        }
        return tableString;
    }
    public void deleteTable(String TABLE_NAME){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME +  " WHERE 1 ");
        make_attendance_table();
    }


    public int numberOfColumns(String tableName) {
        int result = 0;
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(tableName, null, null, null, null, null, null);
            result = cursor.getColumnCount();
            if (result < 0) {
                result = 0;
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return result;
    }

    public int  add_attendance(String subject,String Column_name){
        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from "+TABLE_ATTENDANCE+ " where " + COLUMN_SUBJECT + "= '"+subject+"' " ;// why not leave out the WHERE  clause?
        int newvalue=0;
        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();
        if (recordSet.getString(recordSet.getColumnIndex(Column_name)) != null) {
            newvalue= recordSet.getInt(recordSet.getColumnIndex(Column_name));

        }
        newvalue+=1;
        String new_query="update "+TABLE_ATTENDANCE+" set "+Column_name+" = "+newvalue+" where "+ COLUMN_SUBJECT + "= '"+subject+"' " ;
        db.execSQL(new_query);
        db.close();
        return newvalue;
    }
    public int subtract_attendance(String subject,String Column_name){
        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from "+TABLE_ATTENDANCE+ " where " + COLUMN_SUBJECT + "= '"+subject+"' " ;// why not leave out the WHERE  clause?
        int newvalue=0;
        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();
        if (recordSet.getString(recordSet.getColumnIndex(Column_name)) != null) {
            newvalue= recordSet.getInt(recordSet.getColumnIndex(Column_name));

        }
        if(newvalue>=0)
        newvalue-=1;
        else
        newvalue=-1;

        String new_query="update "+TABLE_ATTENDANCE+" set "+Column_name+" = "+newvalue+" where "+ COLUMN_SUBJECT + "= '"+subject+"' " ;
        db.execSQL(new_query);
        db.close();
        return newvalue;

    }
    public String view_attendance(String Column_name, String subject){
        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from "+TABLE_ATTENDANCE+ " where " + COLUMN_SUBJECT + "= '"+subject+"' " ;// why not leave out the WHERE  clause?
        String dbString=" ";
        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results

            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex(Column_name)) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex(Column_name));
                dbString += "\n";
            }


        db.close();
        return dbString;
    }
    public int getAttendanceInInt(String Column_name,String subject ){
        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from "+TABLE_ATTENDANCE+ " where " + COLUMN_SUBJECT + "= '"+subject+"' " ;// why not leave out the WHERE  clause?
        int newvalue=0;
        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();
        if (recordSet.getString(recordSet.getColumnIndex(Column_name)) != null) {
            newvalue= recordSet.getInt(recordSet.getColumnIndex(Column_name));

        }

        db.close();

        return newvalue;
    }
    public String getNextClass(String Column_name,String day){
        if(day.equalsIgnoreCase("SATURDAY")||day.equalsIgnoreCase("SUNDAY"))
        {
            return "No Class Today";
        }
        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from "+TABLE_CHECK_CLASS+ " where " + COLUMN_DAY + "= '"+day+"' " ;// why not leave out the WHERE  clause?
        String next_class="";
        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();
        if (recordSet.getString(recordSet.getColumnIndex(Column_name)) != null) {
            next_class= recordSet.getString(recordSet.getColumnIndex(Column_name));

        }
        db.close();
        return next_class;
    }

}