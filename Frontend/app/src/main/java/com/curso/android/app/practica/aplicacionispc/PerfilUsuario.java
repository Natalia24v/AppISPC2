package com.curso.android.app.practica.aplicacionispc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.curso.android.app.practica.aplicacionispc.databinding.ActivityPerfilUsuarioBinding;

public class PerfilUsuario extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPerfilUsuarioBinding binding;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPerfilUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        // Inicializa el DBHelper
        dbHelper = new DatabaseHelper(this);

        // Obtén una instancia de lectura de la base de datos
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Realiza una consulta SQL para obtener los datos del usuario
        Cursor cursor = db.query(
                DatabaseHelper.TABLE_USUARIO,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
            int apellidoIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_APELLIDO);
            int emailIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL);

            if (nameIndex >= 0) {
                String nombre = cursor.getString(nameIndex);
                binding.textViewNombre.setText("Nombre: " + nombre);
            }

            if (apellidoIndex >= 0) {
                String apellido = cursor.getString(apellidoIndex);
                binding.textViewApellido.setText("Apellido: " + apellido);
            }

            if (emailIndex >= 0) {
                String email = cursor.getString(emailIndex);
                binding.textViewEmail.setText("Email: " + email);
            }
        }

        cursor.close();
        db.close();


    }


}
