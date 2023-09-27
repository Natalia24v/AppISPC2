package com.curso.android.app.practica.aplicacionispc;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

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
