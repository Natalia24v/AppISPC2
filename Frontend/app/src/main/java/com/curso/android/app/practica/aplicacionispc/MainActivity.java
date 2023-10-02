package com.curso.android.app.practica.aplicacionispc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Button btnEnviar;
    private View linkRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = findViewById(R.id.btnEnviar);

//        Cambiar Registro por el nombre de la pantalla de Home
        btnEnviar.setOnClickListener(v -> {
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        });

        linkRegistro = findViewById(R.id.linkRegistro);

        linkRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad principal
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
            });
        }
    }

