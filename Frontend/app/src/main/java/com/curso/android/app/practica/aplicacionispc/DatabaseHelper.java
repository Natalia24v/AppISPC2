package com.curso.android.app.practica.aplicacionispc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydb.db";
    private static final int DATABASE_VERSION = 1;

    // Tabla Usuario
    public static final String TABLE_USUARIO = "Usuario";
    public static final String COLUMN_USUARIO_ID = "usuario_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_CONTRASENA = "contrasena";

    // Tabla Sucursales
    public static final String TABLE_SUCURSALES = "sucursales";
    public static final String COLUMN_SUCURSALES_ID = "sucursales_id";
    public static final String COLUMN_TURNO_ID = "turno_id";
    public static final String COLUMN_DIRECCION = "direccion";

    // Tabla Turnos
    public static final String TABLE_TURNOS = "Turnos";
    public static final String COLUMN_TURNOS_ID = "turnos_id";
    public static final String COLUMN_ESTA_DISPONIBLE = "esta_disponible";
    public static final String COLUMN_DIA = "dia";
    public static final String COLUMN_HORARIO = "horario";
    public static final String COLUMN_TIPO_SERVICIO = "tipo_servicio";
    public static final String COLUMN_SUCURSAL_ID = "sucursal_id"; // Corregido el nombre de la columna

    // Tabla Trabajadores
    public static final String TABLE_TRABAJADORES = "trabajadores";
    public static final String COLUMN_TRABAJADORES_ID = "trabajadores_id";
    public static final String COLUMN_ESTA_DISPONIBLE_TRABAJADORES = "esta_disponible";
    public static final String COLUMN_TURNO_ID_TRABAJADORES = "turno_id";
    public static final String COLUMN_SUCURSAL_ID_TRABAJADORES = "sucursal_id";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear las tablas
        db.execSQL("CREATE TABLE " + TABLE_USUARIO + " ("
                + COLUMN_USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_APELLIDO + " TEXT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_CONTRASENA + " TEXT);");

        db.execSQL("CREATE TABLE " + TABLE_SUCURSALES + " ("
                + COLUMN_SUCURSALES_ID + " INTEGER NOT NULL, "
                + COLUMN_TURNO_ID + " INTEGER NOT NULL, "
                + COLUMN_DIRECCION + " VARCHAR(45), "  // No se especifica "NULL" aquí
                + "PRIMARY KEY (" + COLUMN_SUCURSALES_ID + "), "
                + "FOREIGN KEY (" + COLUMN_TURNO_ID + ") "
                + "REFERENCES " + TABLE_TURNOS + " (" + COLUMN_TURNOS_ID + ") "
                + "ON DELETE NO ACTION ON UPDATE NO ACTION);");


        db.execSQL("CREATE TABLE " + TABLE_TURNOS + " ("
                + COLUMN_TURNOS_ID + " INTEGER NOT NULL, "
                + COLUMN_ESTA_DISPONIBLE + " TINYINT NOT NULL DEFAULT 1, "
                + COLUMN_DIA + " DATE, "
                + COLUMN_HORARIO + " VARCHAR(45), "
                + COLUMN_TIPO_SERVICIO + " VARCHAR(45), "  // Agregar una coma después de "VARCHAR(45)"
                + COLUMN_SUCURSAL_ID + " INTEGER, "  // Agregar una coma después de "INTEGER"
                + COLUMN_USUARIO_ID + " INTEGER, "  // Agregar una coma antes de "INTEGER"
                + "PRIMARY KEY (" + COLUMN_TURNOS_ID + "), "
                + "FOREIGN KEY (" + COLUMN_SUCURSAL_ID + ") "
                + "REFERENCES " + TABLE_SUCURSALES + " (" + COLUMN_SUCURSALES_ID + ") "
                + "ON DELETE NO ACTION ON UPDATE NO ACTION, "
                + "FOREIGN KEY (" + COLUMN_USUARIO_ID + ") "
                + "REFERENCES " + TABLE_USUARIO + " (" + COLUMN_USUARIO_ID + ") "
                + "ON DELETE NO ACTION ON UPDATE NO ACTION);");


        db.execSQL("CREATE TABLE " + TABLE_TRABAJADORES + " ("
                + COLUMN_TRABAJADORES_ID + " INTEGER NOT NULL, "
                + COLUMN_NAME + " VARCHAR(255) NOT NULL, "
                + COLUMN_APELLIDO + " VARCHAR(45), "
                + COLUMN_ESTA_DISPONIBLE_TRABAJADORES + " TINYINT, "
                + COLUMN_TURNO_ID_TRABAJADORES + " INTEGER, "
                + COLUMN_SUCURSAL_ID_TRABAJADORES + " INTEGER, "
                + "PRIMARY KEY (" + COLUMN_TRABAJADORES_ID + "), "
                + "FOREIGN KEY (" + COLUMN_SUCURSAL_ID_TRABAJADORES + ") "
                + "REFERENCES " + TABLE_SUCURSALES + " (" + COLUMN_SUCURSALES_ID + ") "
                + "ON DELETE NO ACTION ON UPDATE NO ACTION, "
                + "FOREIGN KEY (" + COLUMN_TURNO_ID_TRABAJADORES + ") "
                + "REFERENCES " + TABLE_TURNOS + " (" + COLUMN_TURNOS_ID + ") "
                + "ON DELETE NO ACTION ON UPDATE NO ACTION);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejar actualizaciones de la base de datos aquí
    }
}
