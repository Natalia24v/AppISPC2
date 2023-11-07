package com.curso.android.app.practica.aplicacionispc;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Text;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro); // Asegúrate de que el nombre del diseño XML sea correcto

        // Configura el botón de registro para iniciar la actividad principal
        Button btnEnviarRegistro = findViewById(R.id.btnEnviarRegistro);
        btnEnviarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicializa el DBHelper
                DatabaseHelper dbHelper = new DatabaseHelper(Registro.this);

                // Obtiene una instancia de escritura de la base de datos
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                // Crea un ContentValues con los valores que deseas insertar
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_NAME, "Nombre de Prueba");
                values.put(DatabaseHelper.COLUMN_APELLIDO, "Apellido de Prueba");
                values.put(DatabaseHelper.COLUMN_EMAIL, "prueba@email.com");

                // Inserta los valores en la tabla
                long newRowId = db.insert(DatabaseHelper.TABLE_USUARIO, null, values);

                // Cierra la base de datos cuando hayas terminado
                db.close();

                // Iniciar la actividad principal
                Intent intent = new Intent(Registro.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton arrowBackRegistro = findViewById(R.id.toolbar_iconRegistro);
        arrowBackRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    }

