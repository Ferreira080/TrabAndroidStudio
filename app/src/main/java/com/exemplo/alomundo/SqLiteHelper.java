package com.exemplo.alomundo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqLiteHelper extends SQLiteOpenHelper {

    private static final String name = "db";
    private static final int  version = 1;

    public SqLiteHelper(Context context){
        super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE en_produto (" +
                " Id_Produto INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Nome VARCHAR (100) NOT NULL," +
                " Valor DOUBLE NOT NULL," +
                " Qtde_Estoque INTEGER" +
                ");");

        db.execSQL("CREATE TABLE en_venda (" +
                " Id_Venda INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Nome_Produto VARCHAR (100) NOT NULL," +
                " Valor DOUBLE NOT NULL," +
                " Qtde_Vendido INTEGER" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
