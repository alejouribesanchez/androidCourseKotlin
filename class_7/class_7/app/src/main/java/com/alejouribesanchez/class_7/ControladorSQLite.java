package com.alejouribesanchez.class_7;

/**
 * Created by alejo on 2/21/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Controlador de operaciones de la base de datos
 */
public class ControladorSQLite extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "preguntas.db";

    private static final int VERSION_ACTUAL = 1;

    private final Context contexto;

    interface Tablas {
        String RESPUESTA = "respuesta"; //NOMBRE DE LA TABLA
    }


    public ControladorSQLite(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String respuesta = Contrato.ColumnasRespuesta.RESPUESTA;

        String scriptCreate = "CREATE TABLE " + Tablas.RESPUESTA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                respuesta + " TEXT UNIQUE NOT NULL)";
        db.execSQL(scriptCreate);

        ContentValues cv = new ContentValues();
        cv.put(respuesta, "A. Castor");
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv);
        cv.put(respuesta, "B. Jaguar");
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv);
        cv.put(respuesta, "C. Elefante");
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv);
        cv.put(respuesta, "D. Rinoceronte");
        db.insert(Tablas.RESPUESTA, BaseColumns._ID, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.RESPUESTA);
        onCreate(db);
    }

    public Cursor getRespuestas() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Tablas.RESPUESTA, null, null, null, null, null, null);
    }
}