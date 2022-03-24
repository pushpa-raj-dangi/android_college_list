package com.pushpa.android_college_list.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pushpa.android_college_list.model.College;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;


    public DbHelper(Context c){
        super(c,"colz.db",null,1);
        db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("TAG", "DbHelper: instance created" );

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " +
                "colz(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(255), website VARCHAR(255),lat INTEGER, lang INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS colz.db");
        onCreate(sqLiteDatabase);
    }

    public void insertDataToDb(College college) {
        Log.e("TAG", "insertDataToDb: sdfsdfs Success" );
        ContentValues cv = new ContentValues();
        cv.put("name", college.getName());
        cv.put("website",college.getWebsite());
        cv.put("lat", college.getLat());
        cv.put("lang", college.getLang());
        db.insert("colz", null, cv);
    }


    public List<College> retrieveData() {
        List<College> data = new ArrayList<>();
        String query = "SELECT * FROM colz";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                College st = new College();
                st.setName(cursor.getString(1));
                st.setLang(cursor.getDouble(2));
                st.setLat(cursor.getDouble(3));
                st.setWebsite(cursor.getString(4));
                data.add(st);

            }while(cursor.moveToNext());
        }
        return data;
    }
}
