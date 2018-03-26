package com.n3twork.ddcharacters.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.n3twork.ddcharacters.Clases.Personaje;

/**
 * Created by N3TWORK on 21/2/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 15;
    private static final String DATABASE_NAME = "dnd.db";

    private static final String TABLA_PERSONAJE = "personaje";
    private static final String COLUMNA_ID_PJ = "_id"; //0
    private static final String COLUMNA_NOMBRE_PJ = "nombrePj"; //1
    private static final String COLUMNA_CLASE_PJ = "clasePj"; //2
    private static final String COLUMNA_NIVEL_PJ = "nivelPj"; //3
    private static final String COLUMNA_RAZA_PJ = "razaPj"; //4
    private static final String COLUMNA_ALINEAMIENTO_PJ = "alineamientoPj"; //5
    private static final String COLUMNA_DEIDAD = "deidadPj"; //6
    private static final String COLUMNA_TAMAÑO_PJ = "tamañoPj"; //7
    private static final String COLUMNA_SEXO_PJ = "sexoPj"; //8
    private static final String COLUMNA_EXP_PJ = "expPj"; //9
    private static final String COLUMNA_EXP_LOW = "expLow"; //10
    private static final String COLUMNA_EXP_HIGH = "expHigh"; //11
    private static final String COLUMNA_CAMPAÑA_PJ = "campañaPj"; //12
    private static final String COLUMNA_CONTROL_ACT = "controlAct"; //13
    private static final String COLUMNA_PUNT_FZA = "puntFza"; //14
    private static final String COLUMNA_PUNT_DES = "puntDes"; //15
    private static final String COLUMNA_PUNT_CON = "puntCon"; //16
    private static final String COLUMNA_PUNT_INT = "puntInt"; //17
    private static final String COLUMNA_PUNT_SAB = "puntSab"; //18
    private static final String COLUMNA_PUNT_CAR = "puntCar"; //19
    private static final String COLUMNA_MOD_FZA = "modFza"; //20
    private static final String COLUMNA_MOD_DES = "modDes"; //21
    private static final String COLUMNA_MOD_CON = "modCon"; //22
    private static final String COLUMNA_MOD_INT = "modInt"; //23
    private static final String COLUMNA_MOD_SAB = "modSab"; //24
    private static final String COLUMNA_MOD_CAR = "modCar"; //25
    private static final String COLUMNA_PUNTOS_HABILIDAD = "ptsHab"; //26
    private static final String COLUMNA_PG = "pg"; //27
    private static final String COLUMNA_VELOCIDAD = "velocidad"; //28
    private static final String COLUMNA_HERIDAS = "heridas"; //29
    private static final String COLUMNA_CA = "ca"; //30
    private static final String COLUMNA_TOQUE = "toque"; //31
    private static final String COLUMNA_INICIATIVA = "iniciativa"; //32
    private static final String COLUMNA_DESPREVENIDO = "desprevenido"; //33

    public String ctPj = "CREATE TABLE " + TABLA_PERSONAJE + "(" +
            COLUMNA_ID_PJ + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_NOMBRE_PJ + " TEXT NOT NULL, " +
            COLUMNA_CLASE_PJ + " TEXT NOT NULL, " +
            COLUMNA_NIVEL_PJ + " TEXT NOT NULL, " +
            COLUMNA_RAZA_PJ + " TEXT NOT NULL, " +
            COLUMNA_ALINEAMIENTO_PJ + " TEXT NOT NULL, " +
            COLUMNA_DEIDAD + " TEXT, " +
            COLUMNA_TAMAÑO_PJ + " TEXT NOT NULL, " +
            COLUMNA_SEXO_PJ + " TEXT NOT NULL, " +
            COLUMNA_EXP_PJ + " TEXT NOT NULL, " +
            COLUMNA_EXP_LOW + " TEXT NOT NULL, " +
            COLUMNA_EXP_HIGH + " TEXT NOT NULL, " +
            COLUMNA_CAMPAÑA_PJ + " TEXT NOT NULL, " +
            COLUMNA_CONTROL_ACT + " TEXT NOT NULL, " +
            COLUMNA_PUNT_FZA + " TEXT NOT NULL, " +
            COLUMNA_PUNT_DES + " TEXT NOT NULL, " +
            COLUMNA_PUNT_CON + " TEXT NOT NULL, " +
            COLUMNA_PUNT_INT + " TEXT NOT NULL, " +
            COLUMNA_PUNT_SAB + " TEXT NOT NULL, " +
            COLUMNA_PUNT_CAR + " TEXT NOT NULL, " +
            COLUMNA_MOD_FZA + " TEXT NOT NULL, " +
            COLUMNA_MOD_DES + " TEXT NOT NULL, " +
            COLUMNA_MOD_CON + " TEXT NOT NULL, " +
            COLUMNA_MOD_INT + " TEXT NOT NULL, " +
            COLUMNA_MOD_SAB + " TEXT NOT NULL, " +
            COLUMNA_MOD_CAR + " TEXT NOT NULL, " +
            COLUMNA_PUNTOS_HABILIDAD + " TEXT NOT NULL, " +
            COLUMNA_PG + " TEXT NOT NULL, " +
            COLUMNA_VELOCIDAD + " TEXT NOT NULL, " +
            COLUMNA_HERIDAS + " TEXT NOT NULL, " +
            COLUMNA_CA + " TEXT NOT NULL, " +
            COLUMNA_TOQUE + " TEXT NOT NULL, " +
            COLUMNA_INICIATIVA + " TEXT NOT NULL, " +
            COLUMNA_DESPREVENIDO + " TEXT NOT NULL " +
            ");";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ctPj);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PERSONAJE);

        db.execSQL(ctPj);
    }

    /**
     * Método que inserta un nuevo registro de pj en la tabla de db.
     *
     * @param personaje
     */

    public void addPersonaje(Personaje personaje){
        ContentValues values = new ContentValues();
        values.put(COLUMNA_NOMBRE_PJ, personaje.get_nombrePj());
        values.put(COLUMNA_CLASE_PJ, personaje.get_clasePj());
        values.put(COLUMNA_NIVEL_PJ, personaje.get_nivelPj());
        values.put(COLUMNA_RAZA_PJ, personaje.get_razaPj());
        values.put(COLUMNA_ALINEAMIENTO_PJ, personaje.get_alineamientoPj());
        values.put(COLUMNA_DEIDAD, personaje.get_deidadPj());
        values.put(COLUMNA_TAMAÑO_PJ, personaje.get_tamañoPj());
        values.put(COLUMNA_SEXO_PJ, personaje.get_sexoPj());
        values.put(COLUMNA_EXP_PJ, personaje.get_expPj());
        values.put(COLUMNA_EXP_LOW, personaje.get_expLow());
        values.put(COLUMNA_EXP_HIGH, personaje.get_expHigh());
        values.put(COLUMNA_CAMPAÑA_PJ, personaje.get_campañaPj());
        values.put(COLUMNA_CONTROL_ACT, personaje.get_controlAct());
        values.put(COLUMNA_PUNT_FZA, personaje.get_puntFZA());
        values.put(COLUMNA_PUNT_DES, personaje.get_puntDES());
        values.put(COLUMNA_PUNT_CON, personaje.get_puntCON());
        values.put(COLUMNA_PUNT_INT, personaje.get_puntINT());
        values.put(COLUMNA_PUNT_SAB, personaje.get_puntSAB());
        values.put(COLUMNA_PUNT_CAR, personaje.get_puntCAR());
        values.put(COLUMNA_MOD_FZA, personaje.get_modFZA());
        values.put(COLUMNA_MOD_DES, personaje.get_modDES());
        values.put(COLUMNA_MOD_CON, personaje.get_modCON());
        values.put(COLUMNA_MOD_INT, personaje.get_modINT());
        values.put(COLUMNA_MOD_SAB, personaje.get_modSAB());
        values.put(COLUMNA_MOD_CAR, personaje.get_modCAR());
        values.put(COLUMNA_PUNTOS_HABILIDAD, personaje.get_ptsHab());
        values.put(COLUMNA_PG, personaje.get_pg());
        values.put(COLUMNA_VELOCIDAD, personaje.get_velocidad());
        values.put(COLUMNA_HERIDAS, personaje.get_heridas());
        values.put(COLUMNA_CA, personaje.get_ca());
        values.put(COLUMNA_TOQUE, personaje.get_toque());
        values.put(COLUMNA_INICIATIVA, personaje.get_iniciativa());
        values.put(COLUMNA_DESPREVENIDO, personaje.get_desprevenido());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PERSONAJE, null, values);
        db.close();
    }

    /**
     * Método que devuelve todos los PJ en un Cursor.
     *
     * @return
     */

    public Cursor obtenerTodosPersonajes(){
        String[] columnas = new String[]{
                COLUMNA_ID_PJ, COLUMNA_NOMBRE_PJ, COLUMNA_CLASE_PJ, COLUMNA_NIVEL_PJ, COLUMNA_RAZA_PJ, COLUMNA_ALINEAMIENTO_PJ,
                COLUMNA_DEIDAD, COLUMNA_TAMAÑO_PJ, COLUMNA_SEXO_PJ, COLUMNA_EXP_PJ, COLUMNA_EXP_LOW, COLUMNA_EXP_HIGH,
                COLUMNA_CAMPAÑA_PJ, COLUMNA_CONTROL_ACT
        };
        Cursor cursor = this.getReadableDatabase().query(TABLA_PERSONAJE, columnas, null, null, null, null, null);
        if(cursor !=null){
            cursor.moveToFirst();
        }

        return cursor;
    }

    /**
     * Metodo publico que cierra la base de datos
     */
    public void cerrar(){
        this.close();
    }

}
