package com.abneralcantara.vacinaja2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "cadastro.db";

    public DBHelper(Context context)
    {
        super(context, "cadastro.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB)
    {
        MyDB.execSQL("create Table person(nome TEXT, email TEXT primary key, senha TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1)
    {
        MyDB.execSQL("drop Table if exists person");
    }

    public Boolean insertData(String nome, String email, String senha)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("email", email);
        contentValues.put("senha", senha);
        long result = MyDB.insert("person", null, contentValues);

        if (result == -1)
        {
            return false;
        } else
        {
            return true;
        }
    }

    public Boolean checkemail(String email)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where email = ?", new String[]{email});
        if(cursor.getCount()>0)
        {
            return true;
        } else
        {
            return false;
        }

    }
    public Boolean checksenha(String senha)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where senha = ?", new String[]{senha});
        if(cursor.getCount()>0)
        {
            return true;
        } else
        {
            return false;
        }

    }
}