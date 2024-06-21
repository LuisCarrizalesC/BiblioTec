package com.example.biblioteca.db;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class dbBibliotec extends dbHelper {

    Context context;

    public dbBibliotec(@Nullable Context context) {
        //HEREDANDO DE NUESTRA CLASE PRINCIPAL.
        super(context);
        //ASIGNAMOS EL CONTEXTO ACTUAL CON EL QUE TRAE NUESTRO CONSTRUCTOR
        this.context = context;
    }

    /*public dbBibliotec(@Nullable Context context) {
        super(context);
    }
    */

    //Creamos un constructor con los parametros necesarios para insertar el registro en nuestra tabla
    public long insertarlibro(String titulo, String autor, String editorial, String genero, Integer añopublicacion, Integer paginas) {
        //Creamos un objeto para realizar la escritura de los datos que usaremos
        //creamos un objeto de la clase dbhelper y vamos a escribir en nuestra bd
        dbHelper DBhelper = new dbHelper(context);
        SQLiteDatabase db = DBhelper.getWritableDatabase();
        //tenemos que tenerlo tal cual en la otra base porque sino nos dara error
        ContentValues values = new ContentValues();
        values.put("TITULO", titulo);
        values.put("AUTOR", autor);
        values.put("EDITORIAL", editorial);
        values.put("GENERO", genero);
        values.put("A_PUBLICACION", añopublicacion);
        values.put("NO_PAGINAS", paginas);

        long id = db.insert(DATABASE_TABLE, null, values);
        return id;
    }

    public long eliminarlibro(int ISBN) {
        dbHelper DBHelper = new dbHelper(context);
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        long id = db.delete(DATABASE_TABLE, "ISBN =" + ISBN, null);
        return id;
    }
}
