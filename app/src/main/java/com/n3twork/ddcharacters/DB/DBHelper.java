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

    private static final int DATABASE_VERSION = 19;
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
    private static final String COLUMNA_ATAQUE = "ataque"; //34
    private static final String COLUMNA_PRESA = "presa"; //35
    private static final String COLUMNA_RES_CONJUROS = "resConjuros"; //36
    private static final String COLUMNA_RED_DANIO = "redDanio"; //37
    private static final String COLUMNA_BONF_ATAQUE = "bonfAtaque"; //38
    private static final String COLUMNA_BONF_DISTANCIA = "bonfDistancia"; //39
    private static final String COLUMNA_SALV_FORTALEZA = "salvFortaleza"; //40
    private static final String COLUMNA_SALV_REFLEJOS = "salvReflejos"; //41
    private static final String COLUMNA_SALV_VOLUNTAD = "salvVoluntad"; //42
    private static final String COLUMNA_VALOR_CERRADURA = "cerradura"; //43
    private static final String COLUMNA_VALOR_ARTE = "arte"; //44
    private static final String COLUMNA_VALOR_INTENCIONES = "intenciones"; //45
    private static final String COLUMNA_VALOR_AVISTAR = "avistar"; //46
    private static final String COLUMNA_VALOR_BUSCAR = "buscar"; //47
    private static final String COLUMNA_VALOR_CONCENTRACION = "concentracion"; //48
    private static final String COLUMNA_VALOR_CONJUROS = "conjuros"; //49
    private static final String COLUMNA_VALOR_ESCRITURA = "escritura"; //50
    private static final String COLUMNA_VALOR_DIPLOMACIA = "diplomacia"; //51
    private static final String COLUMNA_VALOR_DISFRAZ = "disfraz"; //52
    private static final String COLUMNA_VALOR_ENGANIO = "enganio"; //53
    private static final String COLUMNA_VALOR_EQUILIBRIO = "equilibrio"; //54
    private static final String COLUMNA_VALOR_ESCAPISMO = "escapismo"; //55
    private static final String COLUMNA_VALOR_ESCONDERSE = "esconderse"; //56
    private static final String COLUMNA_VALOR_ESCUCHAR = "escuchar"; //57
    private static final String COLUMNA_VALOR_FALSIFICAR = "falsificar"; //58
    private static final String COLUMNA_VALOR_INTERPRETAR1 = "interpretar1"; //59
    private static final String COLUMNA_VALOR_INTERPRETAR2 = "interpretar2"; //60
    private static final String COLUMNA_VALOR_INTERPRETAR3 = "interpretar3"; //61
    private static final String COLUMNA_VALOR_INTIMIDAR = "intimidar"; //62
    private static final String COLUMNA_VALOR_MECANISMO = "mecanismo"; //63
    private static final String COLUMNA_VALOR_MANOS = "manos"; //64
    private static final String COLUMNA_VALOR_MONTAR = "montar"; //65
    private static final String COLUMNA_VALOR_SIGILO = "sigilo"; //66
    private static final String COLUMNA_VALOR_NADAR = "nadar"; //67
    private static final String COLUMNA_VALOR_OFICIO = "oficio"; //68
    private static final String COLUMNA_VALOR_PIRUETAS = "piruetas"; //69
    private static final String COLUMNA_VALOR_INFO = "info"; //70
    private static final String COLUMNA_VALOR_SAB_ARCANO = "arcano"; //71
    private static final String COLUMNA_VALOR_SAB_ARQ = "arquitectura"; //72
    private static final String COLUMNA_VALOR_SAB_DUNGEONS = "dungeons"; //73
    private static final String COLUMNA_VALOR_SAB_GEO = "geografia"; //74
    private static final String COLUMNA_VALOR_SAB_HISTORIA = "historia"; //75
    private static final String COLUMNA_VALOR_SAB_LOCAL = "local"; //76
    private static final String COLUMNA_VALOR_SAB_PLANOS = "planos"; //77
    private static final String COLUMNA_VALOR_SAB_NATURAL = "naturaleza"; //78
    private static final String COLUMNA_VALOR_SAB_NOBLEZA = "nobleza"; //79
    private static final String COLUMNA_VALOR_SAB_RELIGION = "religion"; //80
    private static final String COLUMNA_VALOR_SALTAR = "saltar"; //81
    private static final String COLUMNA_VALOR_SANAR = "sanar"; //82
    private static final String COLUMNA_VALOR_SUPERVIVENCIA = "supervivencia"; //83
    private static final String COLUMNA_VALOR_TASACION = "tasacion"; //84
    private static final String COLUMNA_VALOR_ANIMALES = "animales"; //85
    private static final String COLUMNA_VALOR_TREPAR = "trepar"; //86
    private static final String COLUMNA_VALOR_OBJETOMAG = "objetoMagico"; //87
    private static final String COLUMNA_VALOR_CUERDAS = "cuerdas"; //88

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
            COLUMNA_DESPREVENIDO + " TEXT NOT NULL, " +
            COLUMNA_ATAQUE + " TEXT NOT NULL, " +
            COLUMNA_PRESA + " TEXT NOT NULL, " +
            COLUMNA_RES_CONJUROS + " TEXT NOT NULL, " +
            COLUMNA_RED_DANIO + " TEXT NOT NULL, " +
            COLUMNA_BONF_ATAQUE + " TEXT NOT NULL, " +
            COLUMNA_BONF_DISTANCIA + " TEXT NOT NULL, " +
            COLUMNA_SALV_FORTALEZA + " TEXT NOT NULL, " +
            COLUMNA_SALV_REFLEJOS + " TEXT NOT NULL, " +
            COLUMNA_SALV_VOLUNTAD + " TEXT NOT NULL, " +
            COLUMNA_VALOR_CERRADURA + " TEXT NOT NULL, " +
            COLUMNA_VALOR_ARTE + " TEXT NOT NULL, " +
            COLUMNA_VALOR_INTENCIONES + " TEXT NOT NULL, " +
            COLUMNA_VALOR_AVISTAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_BUSCAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_CONCENTRACION + " TEXT NOT NULL, " +
            COLUMNA_VALOR_CONJUROS + " TEXT NOT NULL, " +
            COLUMNA_VALOR_ESCRITURA + " TEXT NOT NULL, " +
            COLUMNA_VALOR_DIPLOMACIA + " TEXT NOT NULL, " +
            COLUMNA_VALOR_DISFRAZ + " TEXT NOT NULL, " +
            COLUMNA_VALOR_ENGANIO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_EQUILIBRIO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_ESCAPISMO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_ESCONDERSE + " TEXT NOT NULL, " +
            COLUMNA_VALOR_ESCUCHAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_FALSIFICAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_INTERPRETAR1 + " TEXT NOT NULL, " +
            COLUMNA_VALOR_INTERPRETAR2 + " TEXT NOT NULL, " +
            COLUMNA_VALOR_INTERPRETAR3 + " TEXT NOT NULL, " +
            COLUMNA_VALOR_INTIMIDAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_MECANISMO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_MANOS + " TEXT NOT NULL, " +
            COLUMNA_VALOR_MONTAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SIGILO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_NADAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_OFICIO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_PIRUETAS + " TEXT NOT NULL, " +
            COLUMNA_VALOR_INFO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_ARCANO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_ARQ + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_DUNGEONS + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_GEO + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_HISTORIA + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_LOCAL + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_PLANOS + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_NATURAL + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_NOBLEZA + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SAB_RELIGION + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SALTAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SANAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_SUPERVIVENCIA + " TEXT NOT NULL, " +
            COLUMNA_VALOR_TASACION + " TEXT NOT NULL, " +
            COLUMNA_VALOR_ANIMALES + " TEXT NOT NULL, " +
            COLUMNA_VALOR_TREPAR + " TEXT NOT NULL, " +
            COLUMNA_VALOR_OBJETOMAG + " TEXT NOT NULL, " +
            COLUMNA_VALOR_CUERDAS + " TEXT NOT NULL " +
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
        values.put(COLUMNA_ATAQUE, personaje.get_ataque());
        values.put(COLUMNA_PRESA, personaje.get_presa());
        values.put(COLUMNA_RES_CONJUROS, personaje.get_resConjuros());
        values.put(COLUMNA_RED_DANIO, personaje.get_redDanio());
        values.put(COLUMNA_BONF_ATAQUE, personaje.get_bonfAtaque());
        values.put(COLUMNA_BONF_DISTANCIA, personaje.get_bonfDistancia());
        values.put(COLUMNA_SALV_FORTALEZA, personaje.get_salvFortaleza());
        values.put(COLUMNA_SALV_REFLEJOS, personaje.get_salvReflejos());
        values.put(COLUMNA_SALV_VOLUNTAD, personaje.get_salvVoluntad());
        values.put(COLUMNA_VALOR_CERRADURA, personaje.get_cerradura());
        values.put(COLUMNA_VALOR_ARTE, personaje.get_arte());
        values.put(COLUMNA_VALOR_INTENCIONES, personaje.get_intenciones());
        values.put(COLUMNA_VALOR_AVISTAR, personaje.get_avistar());
        values.put(COLUMNA_VALOR_BUSCAR, personaje.get_buscar());
        values.put(COLUMNA_VALOR_CONCENTRACION, personaje.get_concentracion());
        values.put(COLUMNA_VALOR_CONJUROS, personaje.get_concConjuros());
        values.put(COLUMNA_VALOR_ESCRITURA, personaje.get_escritura());
        values.put(COLUMNA_VALOR_DIPLOMACIA, personaje.get_diplomacia());
        values.put(COLUMNA_VALOR_DISFRAZ, personaje.get_disfrazarse());
        values.put(COLUMNA_VALOR_ENGANIO, personaje.get_enganiar());
        values.put(COLUMNA_VALOR_EQUILIBRIO, personaje.get_equilibrio());
        values.put(COLUMNA_VALOR_ESCAPISMO, personaje.get_escapismo());
        values.put(COLUMNA_VALOR_ESCONDERSE, personaje.get_esconderse());
        values.put(COLUMNA_VALOR_ESCUCHAR, personaje.get_escuchar());
        values.put(COLUMNA_VALOR_FALSIFICAR, personaje.get_falsificar());
        values.put(COLUMNA_VALOR_INTERPRETAR1, personaje.get_interpretar1());
        values.put(COLUMNA_VALOR_INTERPRETAR2, personaje.get_interpretar2());
        values.put(COLUMNA_VALOR_INTERPRETAR3, personaje.get_interpretar3());
        values.put(COLUMNA_VALOR_INTIMIDAR, personaje.get_intimidar());
        values.put(COLUMNA_VALOR_MECANISMO, personaje.get_mecanismo());
        values.put(COLUMNA_VALOR_MANOS, personaje.get_manos());
        values.put(COLUMNA_VALOR_MONTAR, personaje.get_montar());
        values.put(COLUMNA_VALOR_SIGILO, personaje.get_sigilo());
        values.put(COLUMNA_VALOR_NADAR, personaje.get_nadar());
        values.put(COLUMNA_VALOR_OFICIO, personaje.get_oficio());
        values.put(COLUMNA_VALOR_PIRUETAS, personaje.get_piruetas());
        values.put(COLUMNA_VALOR_INFO, personaje.get_info());
        values.put(COLUMNA_VALOR_SAB_ARCANO, personaje.get_arcano());
        values.put(COLUMNA_VALOR_SAB_ARQ, personaje.get_arquitectura());
        values.put(COLUMNA_VALOR_SAB_DUNGEONS, personaje.get_dungeons());
        values.put(COLUMNA_VALOR_SAB_GEO, personaje.get_geografia());
        values.put(COLUMNA_VALOR_SAB_HISTORIA, personaje.get_historia());
        values.put(COLUMNA_VALOR_SAB_LOCAL, personaje.get_local());
        values.put(COLUMNA_VALOR_SAB_PLANOS, personaje.get_planos());
        values.put(COLUMNA_VALOR_SAB_NATURAL, personaje.get_naturaleza());
        values.put(COLUMNA_VALOR_SAB_NOBLEZA, personaje.get_nobleza());
        values.put(COLUMNA_VALOR_SAB_RELIGION, personaje.get_religion());
        values.put(COLUMNA_VALOR_SALTAR, personaje.get_saltar());
        values.put(COLUMNA_VALOR_SANAR, personaje.get_sanar());
        values.put(COLUMNA_VALOR_SUPERVIVENCIA, personaje.get_supervivencia());
        values.put(COLUMNA_VALOR_TASACION, personaje.get_tasacion());
        values.put(COLUMNA_VALOR_ANIMALES, personaje.get_animales());
        values.put(COLUMNA_VALOR_TREPAR, personaje.get_trepar());
        values.put(COLUMNA_VALOR_OBJETOMAG, personaje.get_objMagico());
        values.put(COLUMNA_VALOR_CUERDAS, personaje.get_cuerdas());
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
