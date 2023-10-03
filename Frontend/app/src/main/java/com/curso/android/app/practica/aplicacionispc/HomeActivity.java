package com.curso.android.app.practica.aplicacionispc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button btnContacto, btnSacarTurno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnContacto = findViewById(R.id.btnContacto);

        btnContacto.setOnClickListener(v -> {

            Intent intentContacto  = new Intent(this, Contact.class);
            startActivity(intentContacto);
        });

        btnSacarTurno = findViewById(R.id.btnSacarTurno);

        btnSacarTurno.setOnClickListener(v -> {
            Intent intentSacarTurno = new Intent(this, formularioTurno.class);
            startActivity(intentSacarTurno);
        });

    }
}