package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.biblioteca.db.dbBibliotec;
import com.example.biblioteca.db.dbHelper;

public class MainActivity extends AppCompatActivity {
    Button btnCrear;
    Button btnEliminar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btnGuardar);
        btnEliminar = findViewById(R.id.btnEliminar);
        dbHelper DBHelper = new dbHelper(MainActivity.this);
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        if(db != null){
            Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "" + db + "", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
        }

        ////////Asignamos metodo para que detecte el click del button
        
        //Variable de tipo EditText esto para poder modificar. 
        EditText txtAutor, txtEditorial, txtTitulo, txtPaginas, txtPublicacion, txtGenero, txtISBN;
        //Buscamos desde la vista nuestro ID
        txtTitulo = findViewById(R.id.txtTitulo);
        txtEditorial = findViewById(R.id.txtEditorial);
        txtAutor = findViewById(R.id.txtAutor);
        txtGenero = findViewById(R.id.txtGenero);
        txtPublicacion = findViewById(R.id.txtAPublicacion);
        txtPaginas = findViewById(R.id.txtPaginas);
        txtISBN = findViewById(R.id.txtISBN);
        
        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnEliminar = findViewById(R.id.btnEliminar);

     btnCrear.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View view) {
                                         dbBibliotec DbBibliotec = new dbBibliotec(MainActivity.this);
                                         Long id = DbBibliotec.insertarlibro(txtTitulo.getText().toString(), txtAutor.getText().toString(), txtEditorial.getText().toString(),
                                                 txtGenero.getText().toString(), Integer.valueOf(txtPublicacion.getText().toString()),
                                                 Integer.parseInt(String.valueOf(txtPaginas.getText())));
                                         if (id > 0) {
                                             Toast.makeText(MainActivity.this, "Registro Guardar", Toast.LENGTH_SHORT).show();
                                         } else {
                                             Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                         }
                                     }

                                 });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbBibliotec dbBibliotec = new dbBibliotec(MainActivity.this);
                long id = dbBibliotec.eliminarlibro(Integer.parseInt(txtISBN.getText().toString()));
                if (id > 0) {
                    Toast.makeText(MainActivity.this, "Registro eliminado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Algo salio mal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
