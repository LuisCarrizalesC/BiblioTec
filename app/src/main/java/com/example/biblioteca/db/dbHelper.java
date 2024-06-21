package com.example.biblioteca.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.text.Spannable;

import androidx.annotation.Nullable;

/**Crear la base de datos **/
//extends es para heredar en java
public class dbHelper extends SQLiteOpenHelper {
    //TIPO DE VALOR QUE SE VA A GUARDAR EN LA VARIABLE
    //
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "BiblioTec";
    public static final String DATABASE_TABLE = "Libros";

    public dbHelper (@Nullable Context context){
        //se usa super para extraer el constructor de la clase padre
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creacion de tabla
        //EN DATABASE_TABLE TENEMOS NUESTRA TABLA LIBROS
     sqLiteDatabase.execSQL(" CREATE TABLE " + DATABASE_TABLE + "(" +
             "ISBN INTEGER PRIMARY KEY,"+
             "TITULO VARCHAR (100),"+
             "AUTOR VARCHAR (100),"+
             "EDITORIAL VARCHAR (50),"+
             "GENERO VARCHAR (30),"+
             "A_PUBLICACION INT,"+
             "NO_PAGINAS INT )");
    }
    //ACTUALIZAR TABLA
    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDatabase, int i, int j){

        SQLiteDatabase.execSQL("DROP TABLE"+ DATABASE_TABLE);
        onCreate(SQLiteDatabase);
    }
}
