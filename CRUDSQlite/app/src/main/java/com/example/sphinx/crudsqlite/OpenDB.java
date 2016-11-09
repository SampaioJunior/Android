package com.example.sphinx.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenDB extends SQLiteOpenHelper{

    private String scriptSqlCreate = "CREATE TABLE USER(ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT NOT NULL," +
            " CPF TEXT NOT NULL, TELEFONE TEXT NOT NULL, EMAIL TEXT NOT NULL)";
    private String scriptSqlDelete = "DROP TABLE IF EXISTS USER";

    public OpenDB(Context ctx) {
        super(ctx, "dbUser", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scriptSqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptSqlDelete);
        onCreate(db);
    }
}
