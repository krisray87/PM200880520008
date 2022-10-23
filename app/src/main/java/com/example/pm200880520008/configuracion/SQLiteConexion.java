package com.example.pm200880520008.configuracion;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pm200880520008.tablas.transacciones;

public class SQLiteConexion extends SQLiteOpenHelper
{
    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory,int version)
    {
        super (context,dbname,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(transacciones.cTcontactos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL(transacciones.droptcontactos);
    onCreate(db);
    }


}
