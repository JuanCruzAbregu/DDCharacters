package com.n3twork.ddcharacters.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.n3twork.ddcharacters.Clases.Conjuros;
import com.n3twork.ddcharacters.Clases.Equipo;
import com.n3twork.ddcharacters.Clases.OtrosConjuros;
import com.n3twork.ddcharacters.Clases.OtrosEquipos;
import com.n3twork.ddcharacters.Clases.Personaje;

/**
 * Created by N3TWORK on 21/2/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 38;
    private static final String DATABASE_NAME = "dnd.db";

    private static final String TABLA_PERSONAJE = "personaje";
    private static final String COLUMNA_ID_PJ = "_id"; //0
    private static final String COLUMNA_NOMBRE_PJ = "nombrePj"; //1
    private static final String COLUMNA_CLASE_PJ = "clasePj"; //2
    private static final String COLUMNA_NIVEL_PJ = "nivelPj"; //3
    private static final String COLUMNA_RAZA_PJ = "razaPj"; //4
    private static final String COLUMNA_ALINEAMIENTO_PJ = "alineamientoPj"; //5
    private static final String COLUMNA_DEIDAD = "deidadPj"; //6
    private static final String COLUMNA_TAMANIO_PJ = "tamañoPj"; //7
    private static final String COLUMNA_SEXO_PJ = "sexoPj"; //8
    private static final String COLUMNA_EXP_PJ = "expPj"; //9
    private static final String COLUMNA_EXP_LOW = "expLow"; //10
    private static final String COLUMNA_EXP_HIGH = "expHigh"; //11
    private static final String COLUMNA_CAMPANIA_PJ = "campañaPj"; //12
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
    private static final String COLUMNA_CERR_CARAC = "cerraduraCarac"; //89
    private static final String COLUMNA_CERR_RANGO = "cerraduraRango"; //90
    private static final String COLUMNA_CERR_VARIOS = "cerraduraVarios"; //91
    private static final String COLUMNA_ARTE_CARAC  = "arteCarac"; //92
    private static final String COLUMNA_ARTE_RANGO  = "arteRango"; //93
    private static final String COLUMNA_ARTE_VARIOS = "arteVarios"; //94
    private static final String COLUMNA_INTENCIONES_CARAC  = "intencionesCarac"; //95
    private static final String COLUMNA_INTENCIONES_RANGO  = "intencionesRango"; //96
    private static final String COLUMNA_INTENCIONES_VARIOS = "intencionesVarios"; //97
    private static final String COLUMNA_AVISTAR_CARAC  = "avistarCarac"; //98
    private static final String COLUMNA_AVISTAR_RANGO  = "avistarRango"; //99
    private static final String COLUMNA_AVISTAR_VARIOS = "avistarVarios"; //100
    private static final String COLUMNA_BUSCAR_CARAC  = "buscarCarac"; //101
    private static final String COLUMNA_BUSCAR_RANGO  = "buscarRango"; //102
    private static final String COLUMNA_BUSCAR_VARIOS = "buscarVarios"; //103
    private static final String COLUMNA_CONCENTRACION_CARAC  = "concentracionCarac"; //104
    private static final String COLUMNA_CONCENTRACION_RANGO  = "concentracionRango"; //105
    private static final String COLUMNA_CONCENTRACION_VARIOS = "concentracionVarios"; //106
    private static final String COLUMNA_CONJUROS_CARAC  = "conjurosCarac"; //107
    private static final String COLUMNA_CONJUROS_RANGO  = "conjurosRango"; //108
    private static final String COLUMNA_CONJUROS_VARIOS = "conjurosVarios"; //109
    private static final String COLUMNA_ESCRITURA_CARAC  = "escrituraCarac"; //110
    private static final String COLUMNA_ESCRITURA_RANGO  = "escrituraRango"; //111
    private static final String COLUMNA_ESCRITURA_VARIOS = "escrituraVarios"; //112
    private static final String COLUMNA_DIPLOMACIA_CARAC  = "diplomaciaCarac"; //113
    private static final String COLUMNA_DIPLOMACIA_RANGO  = "diplomaciaRango"; //114
    private static final String COLUMNA_DIPLOMACIA_VARIOS = "diplomaciaVarios"; //115
    private static final String COLUMNA_DISFRAZ_CARAC  = "disfrazCarac"; //116
    private static final String COLUMNA_DISFRAZ_RANGO  = "disfrazRango"; //117
    private static final String COLUMNA_DISFRAZ_VARIOS = "disfrazVarios"; //118
    private static final String COLUMNA_ENGANIO_CARAC  = "enganioCarac"; //119
    private static final String COLUMNA_ENGANIO_RANGO  = "enganioRango"; //120
    private static final String COLUMNA_ENGANIO_VARIOS = "enganioVarios"; //121
    private static final String COLUMNA_EQUILIBRIO_CARAC  = "equilibrioCarac"; //122
    private static final String COLUMNA_EQUILIBRIO_RANGO  = "equilibrioRango"; //123
    private static final String COLUMNA_EQUILIBRIO_VARIOS = "equilibrioVarios"; //124
    private static final String COLUMNA_ESCAPISMO_CARAC  = "escapismoCarac"; //125
    private static final String COLUMNA_ESCAPISMO_RANGO  = "escapismoRango"; //126
    private static final String COLUMNA_ESCAPISMO_VARIOS = "escapismoVarios"; //127
    private static final String COLUMNA_ESCONDERSE_CARAC  = "esconderseCarac"; //128
    private static final String COLUMNA_ESCONDERSE_RANGO  = "esconderseRango"; //129
    private static final String COLUMNA_ESCONDERSE_VARIOS = "esconderseVarios"; //130
    private static final String COLUMNA_ESCUCHAR_CARAC = "escucharCarac"; //131
    private static final String COLUMNA_ESCUCHAR_RANGO = "escucharRango"; //132
    private static final String COLUMNA_ESCUCHAR_VARIOS = "escucharVarios"; //133
    private static final String COLUMNA_FALSIFICAR_CARAC  = "falsificarCarac"; //134
    private static final String COLUMNA_FALSIFICAR_RANGO  = "falsificarRango"; //135
    private static final String COLUMNA_FALSIFICAR_VARIOS = "falsificarVarios"; //136
    private static final String COLUMNA_INTERPRETAR1_CARAC  = "interpretar1Carac"; //137
    private static final String COLUMNA_INTERPRETAR1_RANGO  = "interpretar1Rango"; //138
    private static final String COLUMNA_INTERPRETAR1_VARIOS = "interpretar1Varios"; //139
    private static final String COLUMNA_INTERPRETAR2_CARAC  = "interpretar2Carac"; //140
    private static final String COLUMNA_INTERPRETAR2_RANGO  = "interpretar2Rango"; //141
    private static final String COLUMNA_INTERPRETAR2_VARIOS = "interpretar2Varios"; //142
    private static final String COLUMNA_INTERPRETAR3_CARAC  = "interpretar3Carac"; //143
    private static final String COLUMNA_INTERPRETAR3_RANGO  = "interpretar3Rango"; //144
    private static final String COLUMNA_INTERPRETAR3_VARIOS = "interpretar3Varios"; //145
    private static final String COLUMNA_INTIMIDAR_CARAC  = "intimidarCarac"; //146
    private static final String COLUMNA_INTIMIDAR_RANGO  = "intimidarRango"; //147
    private static final String COLUMNA_INTIMIDAR_VARIOS = "intimidarVarios"; //148
    private static final String COLUMNA_MECANISMO_CARAC  = "mecanismoCarac"; //149
    private static final String COLUMNA_MECANISMO_RANGO  = "mecanismoRango"; //150
    private static final String COLUMNA_MECANISMO_VARIOS = "mecanismoVarios"; //151
    private static final String COLUMNA_MANOS_CARAC  = "manosCarac"; //152
    private static final String COLUMNA_MANOS_RANGO  = "manosRango"; //153
    private static final String COLUMNA_MANOS_VARIOS = "manosVarios"; //154
    private static final String COLUMNA_MONTAR_CARAC  = "montarCarac"; //155
    private static final String COLUMNA_MONTAR_RANGO  = "montarRango"; //156
    private static final String COLUMNA_MONTAR_VARIOS = "montarVarios"; //157
    private static final String COLUMNA_SIGILO_CARAC  = "sigiloCarac"; //158
    private static final String COLUMNA_SIGILO_RANGO  = "sigiloRango"; //159
    private static final String COLUMNA_SIGILO_VARIOS = "sigiloVarios"; //160
    private static final String COLUMNA_NADAR_CARAC  = "nadarCarac"; //161
    private static final String COLUMNA_NADAR_RANGO  = "nadarRango"; //162
    private static final String COLUMNA_NADAR_VARIOS = "nadarVarios"; //163
    private static final String COLUMNA_OFICIO_CARAC  = "oficioCarac"; //164
    private static final String COLUMNA_OFICIO_RANGO  = "oficioRango"; //165
    private static final String COLUMNA_OFICIO_VARIOS = "oficioVarios"; //166
    private static final String COLUMNA_PIRUETAS_CARAC  = "piruetasCarac"; //167
    private static final String COLUMNA_PIRUETAS_RANGO  = "piruetasRango"; //168
    private static final String COLUMNA_PIRUETAS_VARIOS = "piruetasVarios"; //169
    private static final String COLUMNA_INFO_CARAC  = "infoCarac"; //170
    private static final String COLUMNA_INFO_RANGO  = "infoRango"; //171
    private static final String COLUMNA_INFO_VARIOS = "infoVarios"; //172
    private static final String COLUMNA_ARCANO_CARAC  = "arcanoCarac"; //173
    private static final String COLUMNA_ARCANO_RANGO  = "arcanoRango"; //174
    private static final String COLUMNA_ARCANO_VARIOS = "arcanoVarios"; //175
    private static final String COLUMNA_ARQ_CARAC  = "arqCarac"; //176
    private static final String COLUMNA_ARQ_RANGO  = "arqRango"; //177
    private static final String COLUMNA_ARQ_VARIOS = "arqVarios"; //178
    private static final String COLUMNA_DUNGEONS_CARAC  = "dungeonsCarac"; //179
    private static final String COLUMNA_DUNGEONS_RANGO  = "dungeonsRango"; //180
    private static final String COLUMNA_DUNGEONS_VARIOS = "dungeonsVarios"; //181
    private static final String COLUMNA_GEO_CARAC  = "geoCarac"; //182
    private static final String COLUMNA_GEO_RANGO  = "geoRango"; //183
    private static final String COLUMNA_GEO_VARIOS = "geoVarios"; //184
    private static final String COLUMNA_HISTORIA_CARAC  = "historiaCarac"; //185
    private static final String COLUMNA_HISTORIA_RANGO  = "historiaRango"; //186
    private static final String COLUMNA_HISTORIA_VARIOS = "historiaVarios"; //187
    private static final String COLUMNA_LOCAL_CARAC  = "localCarac"; //188
    private static final String COLUMNA_LOCAL_RANGO  = "localRango"; //189
    private static final String COLUMNA_LOCAL_VARIOS = "localVarios"; //190
    private static final String COLUMNA_PLANOS_CARAC  = "planosCarac"; //191
    private static final String COLUMNA_PLANOS_RANGO  = "planosRango"; //192
    private static final String COLUMNA_PLANOS_VARIOS = "planosVarios"; //193
    private static final String COLUMNA_NATURAL_CARAC  = "naturalCarac"; //194
    private static final String COLUMNA_NATURAL_RANGO  = "naturalRango"; //195
    private static final String COLUMNA_NATURAL_VARIOS = "naturalVarios"; //196
    private static final String COLUMNA_NOBLEZA_CARAC  = "noblezaCarac"; //197
    private static final String COLUMNA_NOBLEZA_RANGO  = "noblezaRango"; //198
    private static final String COLUMNA_NOBLEZA_VARIOS = "noblezaVarios"; //199
    private static final String COLUMNA_RELIGION_CARAC  = "religionCarac"; //200
    private static final String COLUMNA_RELIGION_RANGO  = "religionRango"; //201
    private static final String COLUMNA_RELIGION_VARIOS = "religionVarios"; //202
    private static final String COLUMNA_SALTAR_CARAC  = "saltarCarac"; //203
    private static final String COLUMNA_SALTAR_RANGO  = "saltarRango"; //204
    private static final String COLUMNA_SALTAR_VARIOS = "saltarVarios"; //205
    private static final String COLUMNA_SANAR_CARAC  = "sanarCarac"; //206
    private static final String COLUMNA_SANAR_RANGO  = "sanarRango"; //207
    private static final String COLUMNA_SANAR_VARIOS = "sanarVarios"; //208
    private static final String COLUMNA_SUPERVIVENCIA_CARAC  = "supervivenciaCarac"; //209
    private static final String COLUMNA_SUPERVIVENCIA_RANGO  = "supervivenciaRango"; //210
    private static final String COLUMNA_SUPERVIVENCIA_VARIOS = "supervivenciaVarios"; //211
    private static final String COLUMNA_TASACION_CARAC  = "tasacionCarac"; //212
    private static final String COLUMNA_TASACION_RANGO  = "tasacionRango"; //213
    private static final String COLUMNA_TASACION_VARIOS = "tasacionVarios"; //214
    private static final String COLUMNA_ANIMALES_CARAC  = "animalesCarac"; //215
    private static final String COLUMNA_ANIMALES_RANGO  = "animalesRango"; //216
    private static final String COLUMNA_ANIMALES_VARIOS = "animalesVarios"; //217
    private static final String COLUMNA_TREPAR_CARAC  = "treparCarac"; //218
    private static final String COLUMNA_TREPAR_RANGO  = "treparRango"; //219
    private static final String COLUMNA_TREPAR_VARIOS = "treparVarios"; //220
    private static final String COLUMNA_OBJ_MAG_CARAC  = "objMagCarac"; //221
    private static final String COLUMNA_OBJ_MAG_RANGO  = "objMagRango"; //222
    private static final String COLUMNA_OBJ_MAG_VARIOS = "objMagVarios"; //223
    private static final String COLUMNA_CUERDAS_CARAC  = "cuerdasCarac"; //224
    private static final String COLUMNA_CUERDAS_RANGO  = "cuerdasRango"; //225
    private static final String COLUMNA_CUERDAS_VARIOS = "cuerdasVarios"; //226

    private static final String TABLA_EQUIPO = "equipo";
    private static final String COLUMN_ID = "_id"; //1
    private static final String COLUMNA_ARMA1_ARMA = "arma1arma"; //2
    private static final String COLUMNA_ARMA1_DANIO = "arma1Danio"; //3
    private static final String COLUMNA_ARMA1_CRITICO = "arma1Critico"; //4
    private static final String COLUMNA_ARMA1_TIPO = "arma1Tipo"; //5
    private static final String COLUMNA_ARMA1_PESO = "arma1Peso"; //6
    private static final String COLUMNA_ARMA1_ALCANCE = "arma1Alcance"; //7
    private static final String COLUMNA_ARMA1_NOTAS = "arma1Notas"; //8
    private static final String COLUMNA_ARMA1_MUNICION = "arma1Municion"; //9
    private static final String COLUMNA_ARMA2_ARMA = "arma2arma"; //10
    private static final String COLUMNA_ARMA2_DANIO = "arma2Danio"; //11
    private static final String COLUMNA_ARMA2_CRITICO = "arma2Critico"; //12
    private static final String COLUMNA_ARMA2_TIPO = "arma2Tipo"; //13
    private static final String COLUMNA_ARMA2_PESO = "arma2Peso"; //14
    private static final String COLUMNA_ARMA2_ALCANCE = "arma2Alcance"; //15
    private static final String COLUMNA_ARMA2_NOTAS = "arma2Notas"; //16
    private static final String COLUMNA_ARMA2_MUNICION = "arma2Municion"; //17
    private static final String COLUMNA_ARMA3_ARMA = "arma3arma"; //18
    private static final String COLUMNA_ARMA3_DANIO = "arma3Danio"; //19
    private static final String COLUMNA_ARMA3_CRITICO = "arma3Critico"; //20
    private static final String COLUMNA_ARMA3_TIPO = "arma3Tipo"; //21
    private static final String COLUMNA_ARMA3_PESO = "arma3Peso"; //22
    private static final String COLUMNA_ARMA3_ALCANCE = "arma3Alcance"; //23
    private static final String COLUMNA_ARMA3_NOTAS = "arma3Notas"; //24
    private static final String COLUMNA_ARMA3_MUNICION = "arma3Municion"; //25
    private static final String COLUMNA_ARMA4_ARMA = "arma4arma"; //26
    private static final String COLUMNA_ARMA4_DANIO = "arma4Danio"; //27
    private static final String COLUMNA_ARMA4_CRITICO = "arma4Critico"; //28
    private static final String COLUMNA_ARMA4_TIPO = "arma4Tipo"; //29
    private static final String COLUMNA_ARMA4_PESO = "arma4Peso"; //30
    private static final String COLUMNA_ARMA4_ALCANCE = "arma4Alcance"; //31
    private static final String COLUMNA_ARMA4_NOTAS = "arma4Notas"; //32
    private static final String COLUMNA_ARMA4_MUNICION = "arma4Municion"; //33
    private static final String COLUMNA_ARMA5_ARMA = "arma5arma"; //34
    private static final String COLUMNA_ARMA5_DANIO = "arma5Danio"; //35
    private static final String COLUMNA_ARMA5_CRITICO = "arma5Critico"; //36
    private static final String COLUMNA_ARMA5_TIPO = "arma5Tipo"; //37
    private static final String COLUMNA_ARMA5_PESO = "arma5Peso"; //38
    private static final String COLUMNA_ARMA5_ALCANCE = "arma5Alcance"; //39
    private static final String COLUMNA_ARMA5_NOTAS = "arma5Notas"; //40
    private static final String COLUMNA_ARMA5_MUNICION = "arma5Municion"; //41
    private static final String COLUMNA_ARMADURA_ARMADURA = "armaduraArmadura"; //42
    private static final String COLUMNA_ARMADURA_CA = "armaduraCA"; //43
    private static final String COLUMNA_ARMADURA_DESMAX = "armaduraDesMax"; //44
    private static final String COLUMNA_ARMADURA_TIPO = "armaduraTipo"; //45
    private static final String COLUMNA_ARMADURA_PEN = "armaduraPen"; //46
    private static final String COLUMNA_ARMADURA_VELOCIDAD = "armaduraVelocidad"; //47
    private static final String COLUMNA_ARMADURA_PESO = "armaduraPeso"; //48
    private static final String COLUMNA_ARMADURA_FALLO = "armaduraFallo"; //49
    private static final String COLUMNA_ARMADURA_ESP = "armaduraEsp"; //50
    private static final String COLUMNA_OBJ2_ESCUDO = "obj2Escudo"; //51
    private static final String COLUMNA_OBJ2_CA = "obj2Ca"; //52
    private static final String COLUMNA_OBJ2_DESMAX = "obj2DesMax"; //53
    private static final String COLUMNA_OBJ2_FALLO = "obj2Fallo"; //54
    private static final String COLUMNA_OBJ2_PEN = "obj2Pen"; //55
    private static final String COLUMNA_OBJ2_ESP = "obj2Esp"; //56
    private static final String COLUMNA_OBJ2_PESO = "obj2Peso"; //57
    private static final String COLUMNA_OBJ3_OBJ = "obj3Obj"; //58
    private static final String COLUMNA_OBJ3_CA = "obj3Ca"; //59
    private static final String COLUMNA_OBJ3_PESO = "obj3Peso"; //60
    private static final String COLUMNA_OBJ3_ESP = "obj3Esp"; //61
    private static final String COLUMNA_OBJ4_OBJ = "obj4Obj"; //62
    private static final String COLUMNA_OBJ4_CA = "obj4Ca"; //63
    private static final String COLUMNA_OBJ4_PESO = "obj4Peso"; //64
    private static final String COLUMNA_OBJ4_ESP = "obj4Esp"; //65
    private static final String COLUMNA_LIGERA = "pesoLigero"; //66
    private static final String COLUMNA_MEDIA = "pesoMedio"; //67
    private static final String COLUMNA_PESADA = "pesoPesado"; //68
    private static final String COLUMNA_CABEZA = "pesoCabeza"; //69
    private static final String COLUMNA_SUELO = "pesoSuelo"; //70
    private static final String COLUMNA_EMPUJAR_ARRASTRAR = "pesoArrastrar"; //71
    private static final String COLUMNA_PC = "tesoroPc"; //72
    private static final String COLUMNA_PP = "tesoroPp"; //73
    private static final String COLUMNA_PO = "tesoroPo"; //74
    private static final String COLUMNA_PPT = "tesoroPpt"; //75
    private static final String COLUMN_ID_PJ = "idPersonaje"; //76

    private static final String TABLA_OTROS_EQUIPOS = "otrosEquipos";
    private static final String _ID = "_id"; //1
    private static final String COLUMNA_OTRAS_OBJETO = "otrasObjeto"; //2
    private static final String COLUMNA_OTRAS_PAGINA = "otrasPagina"; //3
    private static final String COLUMNA_OTRAS_PESO = "otrasPeso"; //4
    private static final String COLUMNA_OTRAS_VALOR = "otrasValor"; //5
    private static final String COLUMNA_OTRAS_MONEDA = "otrasMoneda"; //6
    private static final String _ID_PJ = "idPersonaje"; //7

    private static final String TABLA_CONJUROS = "conjurosTab";
    private static final String _ID_CONJUROS = "_id";
    private static final String COLUMNA_SALV_CONJUROS = "salvacion";
    private static final String COLUMNA_FALLO_CONJUROS = "fallo";
    private static final String COLUMNA_CONOC_CONJUROSLV0 = "conocConjurosCero";
    private static final String COLUMNA_CD_SALVACIONLV0 = "cdSalvacionCero";
    private static final String COLUMNA_DIARIOS_CONJUROSLV0 = "diariosConjurosCero";
    private static final String COLUMNA_ADICIONALESLV0 = "adicionalesComjurosCero";
    private static final String COLUMNA_CONOC_CONJUROSLV1 = "conocConjurosUno";
    private static final String COLUMNA_CD_SALVACIONLV1 = "cdSalvacionUno";
    private static final String COLUMNA_DIARIOS_CONJUROSLV1 = "diariosConjurosUno";
    private static final String COLUMNA_ADICIONALESLV1 = "adicionalesComjurosUno";
    private static final String COLUMNA_CONOC_CONJUROSLV2 = "conocConjurosDos";
    private static final String COLUMNA_CD_SALVACIONLV2 = "cdSalvacionDos";
    private static final String COLUMNA_DIARIOS_CONJUROSLV2 = "diariosConjurosDos";
    private static final String COLUMNA_ADICIONALESLV2 = "adicionalesComjurosDos";
    private static final String COLUMNA_CONOC_CONJUROSLV3 = "conocConjurosTres";
    private static final String COLUMNA_CD_SALVACIONLV3 = "cdSalvacionTres";
    private static final String COLUMNA_DIARIOS_CONJUROSLV3 = "diariosConjurosTres";
    private static final String COLUMNA_ADICIONALESLV3 = "adicionalesComjurosTres";
    private static final String COLUMNA_CONOC_CONJUROSLV4 = "conocConjurosCuatro";
    private static final String COLUMNA_CD_SALVACIONLV4 = "cdSalvacionCuatro";
    private static final String COLUMNA_DIARIOS_CONJUROSLV4 = "diariosConjurosCuatro";
    private static final String COLUMNA_ADICIONALESLV4 = "adicionalesComjurosCuatro";
    private static final String COLUMNA_CONOC_CONJUROSLV5 = "conocConjurosCinco";
    private static final String COLUMNA_CD_SALVACIONLV5 = "cdSalvacionCinco";
    private static final String COLUMNA_DIARIOS_CONJUROSLV5 = "diariosConjurosCinco";
    private static final String COLUMNA_ADICIONALESLV5 = "adicionalesComjurosCinco";
    private static final String COLUMNA_CONOC_CONJUROSLV6 = "conocConjurosSeis";
    private static final String COLUMNA_CD_SALVACIONLV6 = "cdSalvacionSeis";
    private static final String COLUMNA_DIARIOS_CONJUROSLV6 = "diariosConjurosSeis";
    private static final String COLUMNA_ADICIONALESLV6 = "adicionalesComjurosSeis";
    private static final String COLUMNA_CONOC_CONJUROSLV7 = "conocConjurosSiete";
    private static final String COLUMNA_CD_SALVACIONLV7 = "cdSalvacionSiete";
    private static final String COLUMNA_DIARIOS_CONJUROSLV7 = "diariosConjurosSiete";
    private static final String COLUMNA_ADICIONALESLV7 = "adicionalesComjurosSiete";
    private static final String COLUMNA_CONOC_CONJUROSLV8 = "conocConjurosOcho";
    private static final String COLUMNA_CD_SALVACIONLV8 = "cdSalvacionOcho";
    private static final String COLUMNA_DIARIOS_CONJUROSLV8 = "diariosConjurosOcho";
    private static final String COLUMNA_ADICIONALESLV8 = "adicionalesComjurosOcho";
    private static final String COLUMNA_CONOC_CONJUROSLV9 = "conocConjurosNueve";
    private static final String COLUMNA_CD_SALVACIONLV9 = "cdSalvacionNueve";
    private static final String COLUMNA_DIARIOS_CONJUROSLV9 = "diariosConjurosNueve";
    private static final String COLUMNA_ADICIONALESLV9 = "adicionalesComjurosNueve";
    private static final String _IDPJ = "idPersonaje";

    private static final String TABLA_OTROS_CONJUROS = "otrosConjuros";
    private static final String IDENTIFICADOR = "_id";
    private static final String COLUMNA_DOMINIOS = "dominios";
    private static final String COLUMNA_ESCUELA = "escuela";
    private static final String _ID_PERSONAJE = "idPersonaje";


    private String ctPj = "CREATE TABLE " + TABLA_PERSONAJE + "(" +
            COLUMNA_ID_PJ + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_NOMBRE_PJ + " TEXT NOT NULL, " +
            COLUMNA_CLASE_PJ + " TEXT NOT NULL, " +
            COLUMNA_NIVEL_PJ + " TEXT NOT NULL, " +
            COLUMNA_RAZA_PJ + " TEXT NOT NULL, " +
            COLUMNA_ALINEAMIENTO_PJ + " TEXT NOT NULL, " +
            COLUMNA_DEIDAD + " TEXT, " +
            COLUMNA_TAMANIO_PJ + " TEXT NOT NULL, " +
            COLUMNA_SEXO_PJ + " TEXT NOT NULL, " +
            COLUMNA_EXP_PJ + " TEXT NOT NULL, " +
            COLUMNA_EXP_LOW + " TEXT NOT NULL, " +
            COLUMNA_EXP_HIGH + " TEXT NOT NULL, " +
            COLUMNA_CAMPANIA_PJ + " TEXT NOT NULL, " +
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
            COLUMNA_VALOR_CUERDAS + " TEXT NOT NULL, " +
            COLUMNA_CERR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_CERR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_CERR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ARTE_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ARTE_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ARTE_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_INTENCIONES_CARAC + " TEXT NOT NULL, " +
            COLUMNA_INTENCIONES_RANGO + " TEXT NOT NULL, " +
            COLUMNA_INTENCIONES_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_AVISTAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_AVISTAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_AVISTAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_BUSCAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_BUSCAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_BUSCAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_CONCENTRACION_CARAC + " TEXT NOT NULL, " +
            COLUMNA_CONCENTRACION_RANGO + " TEXT NOT NULL, " +
            COLUMNA_CONCENTRACION_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_CONJUROS_CARAC + " TEXT NOT NULL, " +
            COLUMNA_CONJUROS_RANGO + " TEXT NOT NULL, " +
            COLUMNA_CONJUROS_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ESCRITURA_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ESCRITURA_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ESCRITURA_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_DIPLOMACIA_CARAC + " TEXT NOT NULL, " +
            COLUMNA_DIPLOMACIA_RANGO + " TEXT NOT NULL, " +
            COLUMNA_DIPLOMACIA_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_DISFRAZ_CARAC + " TEXT NOT NULL, " +
            COLUMNA_DISFRAZ_RANGO + " TEXT NOT NULL, " +
            COLUMNA_DISFRAZ_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ENGANIO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ENGANIO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ENGANIO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_EQUILIBRIO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_EQUILIBRIO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_EQUILIBRIO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ESCAPISMO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ESCAPISMO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ESCAPISMO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ESCONDERSE_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ESCONDERSE_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ESCONDERSE_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ESCUCHAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ESCUCHAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ESCUCHAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_FALSIFICAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_FALSIFICAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_FALSIFICAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR1_CARAC + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR1_RANGO + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR1_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR2_CARAC + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR2_RANGO + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR2_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR3_CARAC + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR3_RANGO + " TEXT NOT NULL, " +
            COLUMNA_INTERPRETAR3_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_INTIMIDAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_INTIMIDAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_INTIMIDAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_MECANISMO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_MECANISMO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_MECANISMO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_MANOS_CARAC + " TEXT NOT NULL, " +
            COLUMNA_MANOS_RANGO + " TEXT NOT NULL, " +
            COLUMNA_MANOS_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_MONTAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_MONTAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_MONTAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_SIGILO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_SIGILO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_SIGILO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_NADAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_NADAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_NADAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_OFICIO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_OFICIO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_OFICIO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_PIRUETAS_CARAC + " TEXT NOT NULL, " +
            COLUMNA_PIRUETAS_RANGO + " TEXT NOT NULL, " +
            COLUMNA_PIRUETAS_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_INFO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_INFO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_INFO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ARCANO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ARCANO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ARCANO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ARQ_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ARQ_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ARQ_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_DUNGEONS_CARAC + " TEXT NOT NULL, " +
            COLUMNA_DUNGEONS_RANGO + " TEXT NOT NULL, " +
            COLUMNA_DUNGEONS_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_GEO_CARAC + " TEXT NOT NULL, " +
            COLUMNA_GEO_RANGO + " TEXT NOT NULL, " +
            COLUMNA_GEO_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_HISTORIA_CARAC + " TEXT NOT NULL, " +
            COLUMNA_HISTORIA_RANGO + " TEXT NOT NULL, " +
            COLUMNA_HISTORIA_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_LOCAL_CARAC + " TEXT NOT NULL, " +
            COLUMNA_LOCAL_RANGO + " TEXT NOT NULL, " +
            COLUMNA_LOCAL_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_PLANOS_CARAC + " TEXT NOT NULL, " +
            COLUMNA_PLANOS_RANGO + " TEXT NOT NULL, " +
            COLUMNA_PLANOS_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_NATURAL_CARAC + " TEXT NOT NULL, " +
            COLUMNA_NATURAL_RANGO + " TEXT NOT NULL, " +
            COLUMNA_NATURAL_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_NOBLEZA_CARAC + " TEXT NOT NULL, " +
            COLUMNA_NOBLEZA_RANGO + " TEXT NOT NULL, " +
            COLUMNA_NOBLEZA_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_RELIGION_CARAC + " TEXT NOT NULL, " +
            COLUMNA_RELIGION_RANGO + " TEXT NOT NULL, " +
            COLUMNA_RELIGION_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_SALTAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_SALTAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_SALTAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_SANAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_SANAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_SANAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_SUPERVIVENCIA_CARAC + " TEXT NOT NULL, " +
            COLUMNA_SUPERVIVENCIA_RANGO + " TEXT NOT NULL, " +
            COLUMNA_SUPERVIVENCIA_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_TASACION_CARAC + " TEXT NOT NULL, " +
            COLUMNA_TASACION_RANGO + " TEXT NOT NULL, " +
            COLUMNA_TASACION_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_ANIMALES_CARAC + " TEXT NOT NULL, " +
            COLUMNA_ANIMALES_RANGO + " TEXT NOT NULL, " +
            COLUMNA_ANIMALES_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_TREPAR_CARAC + " TEXT NOT NULL, " +
            COLUMNA_TREPAR_RANGO + " TEXT NOT NULL, " +
            COLUMNA_TREPAR_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_OBJ_MAG_CARAC + " TEXT NOT NULL, " +
            COLUMNA_OBJ_MAG_RANGO + " TEXT NOT NULL, " +
            COLUMNA_OBJ_MAG_VARIOS + " TEXT NOT NULL, " +
            COLUMNA_CUERDAS_CARAC + " TEXT NOT NULL, " +
            COLUMNA_CUERDAS_RANGO + " TEXT NOT NULL, " +
            COLUMNA_CUERDAS_VARIOS + " TEXT NOT NULL " +
            ");";


    private String ctEq = "CREATE TABLE " + TABLA_EQUIPO + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_ARMA1_ARMA + " TEXT NOT NULL, " +
            COLUMNA_ARMA1_DANIO + " TEXT NOT NULL, " +
            COLUMNA_ARMA1_CRITICO + " TEXT NOT NULL, " +
            COLUMNA_ARMA1_TIPO + " TEXT NOT NULL, " +
            COLUMNA_ARMA1_PESO + " TEXT NOT NULL, " +
            COLUMNA_ARMA1_ALCANCE + " TEXT NOT NULL, " +
            COLUMNA_ARMA1_NOTAS + " TEXT NOT NULL, " +
            COLUMNA_ARMA1_MUNICION + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_ARMA + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_DANIO + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_CRITICO + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_TIPO + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_PESO + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_ALCANCE + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_NOTAS + " TEXT NOT NULL, " +
            COLUMNA_ARMA2_MUNICION + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_ARMA + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_DANIO + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_CRITICO + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_TIPO + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_PESO + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_ALCANCE + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_NOTAS + " TEXT NOT NULL, " +
            COLUMNA_ARMA3_MUNICION + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_ARMA + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_DANIO + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_CRITICO + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_TIPO + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_PESO + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_ALCANCE + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_NOTAS + " TEXT NOT NULL, " +
            COLUMNA_ARMA4_MUNICION + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_ARMA + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_DANIO + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_CRITICO + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_TIPO + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_PESO + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_ALCANCE + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_NOTAS + " TEXT NOT NULL, " +
            COLUMNA_ARMA5_MUNICION + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_ARMADURA + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_CA + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_DESMAX + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_TIPO + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_PEN + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_VELOCIDAD + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_PESO + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_FALLO + " TEXT NOT NULL, " +
            COLUMNA_ARMADURA_ESP + " TEXT NOT NULL, " +
            COLUMNA_OBJ2_ESCUDO + " TEXT NOT NULL, " +
            COLUMNA_OBJ2_CA + " TEXT NOT NULL, " +
            COLUMNA_OBJ2_DESMAX + " TEXT NOT NULL, " +
            COLUMNA_OBJ2_FALLO + " TEXT NOT NULL, " +
            COLUMNA_OBJ2_PEN + " TEXT NOT NULL, " +
            COLUMNA_OBJ2_ESP + " TEXT NOT NULL, " +
            COLUMNA_OBJ2_PESO + " TEXT NOT NULL, " +
            COLUMNA_OBJ3_OBJ + " TEXT NOT NULL, " +
            COLUMNA_OBJ3_CA + " TEXT NOT NULL, " +
            COLUMNA_OBJ3_PESO + " TEXT NOT NULL, " +
            COLUMNA_OBJ3_ESP + " TEXT NOT NULL, " +
            COLUMNA_OBJ4_OBJ + " TEXT NOT NULL, " +
            COLUMNA_OBJ4_CA + " TEXT NOT NULL, " +
            COLUMNA_OBJ4_PESO + " TEXT NOT NULL, " +
            COLUMNA_OBJ4_ESP + " TEXT NOT NULL, " +
            COLUMNA_LIGERA + " TEXT NOT NULL, " +
            COLUMNA_MEDIA + " TEXT NOT NULL, " +
            COLUMNA_PESADA + " TEXT NOT NULL, " +
            COLUMNA_CABEZA + " TEXT NOT NULL, " +
            COLUMNA_SUELO + " TEXT NOT NULL, " +
            COLUMNA_EMPUJAR_ARRASTRAR + " TEXT NOT NULL, " +
            COLUMNA_PC + " TEXT NOT NULL, " +
            COLUMNA_PP + " TEXT NOT NULL, " +
            COLUMNA_PO + " TEXT NOT NULL, " +
            COLUMNA_PPT + " TEXT NOT NULL, " +
            COLUMN_ID_PJ + " INTEGER, " +
            "FOREIGN KEY("+ COLUMN_ID_PJ + ") REFERENCES " + TABLA_PERSONAJE + "(" + COLUMNA_ID_PJ + ")" +
            ");";

    private String ctOtEq = "CREATE TABLE " + TABLA_OTROS_EQUIPOS + "(" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_OTRAS_OBJETO + " TEXT NOT NULL, " +
            COLUMNA_OTRAS_PAGINA + " TEXT NOT NULL, " +
            COLUMNA_OTRAS_PESO + " TEXT NOT NULL, " +
            COLUMNA_OTRAS_VALOR + " TEXT NOT NULL, " +
            COLUMNA_OTRAS_MONEDA + " TEXT NOT NULL, " +
            _ID_PJ + " INTEGER, " +
            "FOREIGN KEY("+ _ID_PJ + ") REFERENCES " + TABLA_PERSONAJE + "(" + COLUMNA_ID_PJ + ")" +
            ");";

    private String ctConj = "CREATE TABLE " + TABLA_CONJUROS + "(" +
            _ID_CONJUROS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_SALV_CONJUROS + " TEXT, " +
            COLUMNA_FALLO_CONJUROS + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV0 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV0 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV0 + " TEXT, " +
            COLUMNA_ADICIONALESLV0 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV1 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV1 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV1 + " TEXT, " +
            COLUMNA_ADICIONALESLV1 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV2 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV2 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV2 + " TEXT, " +
            COLUMNA_ADICIONALESLV2 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV3 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV3 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV3 + " TEXT, " +
            COLUMNA_ADICIONALESLV3 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV4 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV4 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV4 + " TEXT, " +
            COLUMNA_ADICIONALESLV4 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV5 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV5 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV5 + " TEXT, " +
            COLUMNA_ADICIONALESLV5 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV6 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV6 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV6 + " TEXT, " +
            COLUMNA_ADICIONALESLV6 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV7 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV7 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV7 + " TEXT, " +
            COLUMNA_ADICIONALESLV7 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV8 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV8 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV8 + " TEXT, " +
            COLUMNA_ADICIONALESLV8 + " TEXT, " +
            COLUMNA_CONOC_CONJUROSLV9 + " TEXT, " +
            COLUMNA_CD_SALVACIONLV9 + " TEXT, " +
            COLUMNA_DIARIOS_CONJUROSLV9 + " TEXT, " +
            COLUMNA_ADICIONALESLV9 + " TEXT, " +
            _IDPJ + " INTEGER, " +
            "FOREIGN KEY("+ _IDPJ + ") REFERENCES " + TABLA_PERSONAJE + "(" + COLUMNA_ID_PJ + ")" +
            ")";

    private String ctOtCOnj = "CREATE TABLE " + TABLA_OTROS_CONJUROS + "(" +
            IDENTIFICADOR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_DOMINIOS + " TEXT, " +
            COLUMNA_ESCUELA + " TEXT, " +
            _ID_PERSONAJE + " INTEGER, " +
            "FOREIGN KEY("+ _ID_PERSONAJE + ") REFERENCES " + TABLA_PERSONAJE + "(" + COLUMNA_ID_PJ + ")" +
            ")";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ctPj);
        db.execSQL(ctEq);
        db.execSQL(ctOtEq);
        db.execSQL(ctConj);
        db.execSQL(ctOtCOnj);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PERSONAJE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_EQUIPO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_OTROS_EQUIPOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CONJUROS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_OTROS_CONJUROS);

        db.execSQL(ctPj);
        db.execSQL(ctEq);
        db.execSQL(ctOtEq);
        db.execSQL(ctConj);
        db.execSQL(ctOtCOnj);
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
        values.put(COLUMNA_TAMANIO_PJ, personaje.get_tamanioPj());
        values.put(COLUMNA_SEXO_PJ, personaje.get_sexoPj());
        values.put(COLUMNA_EXP_PJ, personaje.get_expPj());
        values.put(COLUMNA_EXP_LOW, personaje.get_expLow());
        values.put(COLUMNA_EXP_HIGH, personaje.get_expHigh());
        values.put(COLUMNA_CAMPANIA_PJ, personaje.get_campaniaPj());
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
        values.put(COLUMNA_CERR_CARAC, personaje.get_cerraduraCarac());
        values.put(COLUMNA_CERR_RANGO, personaje.get_cerraduraRango());
        values.put(COLUMNA_CERR_VARIOS, personaje.get_cerraduraVarios());
        values.put(COLUMNA_ARTE_CARAC, personaje.get_arteCarac());
        values.put(COLUMNA_ARTE_RANGO, personaje.get_arteRango());
        values.put(COLUMNA_ARTE_VARIOS, personaje.get_arteVarios());
        values.put(COLUMNA_INTENCIONES_CARAC, personaje.get_intencionesCarac());
        values.put(COLUMNA_INTENCIONES_RANGO, personaje.get_intencionesRango());
        values.put(COLUMNA_INTENCIONES_VARIOS, personaje.get_intencionesVarios());
        values.put(COLUMNA_AVISTAR_CARAC, personaje.get_avistarCarac());
        values.put(COLUMNA_AVISTAR_RANGO, personaje.get_avistarRango());
        values.put(COLUMNA_AVISTAR_VARIOS, personaje.get_avistarVarios());
        values.put(COLUMNA_BUSCAR_CARAC, personaje.get_buscarCarac());
        values.put(COLUMNA_BUSCAR_RANGO, personaje.get_buscarRango());
        values.put(COLUMNA_BUSCAR_VARIOS, personaje.get_buscarVarios());
        values.put(COLUMNA_CONCENTRACION_CARAC, personaje.get_concentracionCarac());
        values.put(COLUMNA_CONCENTRACION_RANGO, personaje.get_concentracionRango());
        values.put(COLUMNA_CONCENTRACION_VARIOS, personaje.get_concentracionVarios());
        values.put(COLUMNA_CONJUROS_CARAC, personaje.get_conjurosCarac());
        values.put(COLUMNA_CONJUROS_RANGO, personaje.get_conjurosRango());
        values.put(COLUMNA_CONJUROS_VARIOS, personaje.get_conjurosVarios());
        values.put(COLUMNA_ESCRITURA_CARAC, personaje.get_escrituraCarac());
        values.put(COLUMNA_ESCRITURA_RANGO, personaje.get_escrituraRango());
        values.put(COLUMNA_ESCRITURA_VARIOS, personaje.get_escrituraVarios());
        values.put(COLUMNA_DIPLOMACIA_CARAC, personaje.get_diplomaciaCarac());
        values.put(COLUMNA_DIPLOMACIA_RANGO, personaje.get_diplomaciaRango());
        values.put(COLUMNA_DIPLOMACIA_VARIOS, personaje.get_diplomaciaVarios());
        values.put(COLUMNA_DISFRAZ_CARAC, personaje.get_disfrazCarac());
        values.put(COLUMNA_DISFRAZ_RANGO, personaje.get_disfrazRango());
        values.put(COLUMNA_DISFRAZ_VARIOS, personaje.get_disfrazVarios());
        values.put(COLUMNA_ENGANIO_CARAC, personaje.get_enganioCarac());
        values.put(COLUMNA_ENGANIO_RANGO, personaje.get_enganioRango());
        values.put(COLUMNA_ENGANIO_VARIOS, personaje.get_enganioVarios());
        values.put(COLUMNA_EQUILIBRIO_CARAC, personaje.get_equilibrioCarac());
        values.put(COLUMNA_EQUILIBRIO_RANGO, personaje.get_equilibrioRango());
        values.put(COLUMNA_EQUILIBRIO_VARIOS, personaje.get_equilibrioVarios());
        values.put(COLUMNA_ESCAPISMO_CARAC, personaje.get_escapismoCarac());
        values.put(COLUMNA_ESCAPISMO_RANGO, personaje.get_escapismoRango());
        values.put(COLUMNA_ESCAPISMO_VARIOS, personaje.get_escapismoVarios());
        values.put(COLUMNA_ESCONDERSE_CARAC, personaje.get_esconderseCarac());
        values.put(COLUMNA_ESCONDERSE_RANGO, personaje.get_esconderseRango());
        values.put(COLUMNA_ESCONDERSE_VARIOS, personaje.get_esconderseVarios());
        values.put(COLUMNA_ESCUCHAR_CARAC, personaje.get_escucharCarac());
        values.put(COLUMNA_ESCUCHAR_RANGO, personaje.get_escucharRango());
        values.put(COLUMNA_ESCUCHAR_VARIOS, personaje.get_escucharVarios());
        values.put(COLUMNA_FALSIFICAR_CARAC, personaje.get_falsificarCarac());
        values.put(COLUMNA_FALSIFICAR_RANGO, personaje.get_falsificarRango());
        values.put(COLUMNA_FALSIFICAR_VARIOS, personaje.get_falsificarVarios());
        values.put(COLUMNA_INTERPRETAR1_CARAC, personaje.get_interpretar1Carac());
        values.put(COLUMNA_INTERPRETAR1_RANGO, personaje.get_interpretar1Rango());
        values.put(COLUMNA_INTERPRETAR1_VARIOS, personaje.get_interpretar1Varios());
        values.put(COLUMNA_INTERPRETAR2_CARAC, personaje.get_interpretar2Carac());
        values.put(COLUMNA_INTERPRETAR2_RANGO, personaje.get_interpretar2Rango());
        values.put(COLUMNA_INTERPRETAR2_VARIOS, personaje.get_interpretar2Varios());
        values.put(COLUMNA_INTERPRETAR3_CARAC, personaje.get_interpretar3Carac());
        values.put(COLUMNA_INTERPRETAR3_RANGO, personaje.get_interpretar3Rango());
        values.put(COLUMNA_INTERPRETAR3_VARIOS, personaje.get_interpretar3Varios());
        values.put(COLUMNA_INTIMIDAR_CARAC, personaje.get_intimidarCarac());
        values.put(COLUMNA_INTIMIDAR_RANGO, personaje.get_intimidarRango());
        values.put(COLUMNA_INTIMIDAR_VARIOS, personaje.get_intimidarVarios());
        values.put(COLUMNA_MECANISMO_CARAC, personaje.get_mecanismoCarac());
        values.put(COLUMNA_MECANISMO_RANGO, personaje.get_mecanismoRango());
        values.put(COLUMNA_MECANISMO_VARIOS, personaje.get_mecanismoVarios());
        values.put(COLUMNA_MANOS_CARAC, personaje.get_manosCarac());
        values.put(COLUMNA_MANOS_RANGO, personaje.get_manosRango());
        values.put(COLUMNA_MANOS_VARIOS, personaje.get_manosVarios());
        values.put(COLUMNA_MONTAR_CARAC, personaje.get_montarCarac());
        values.put(COLUMNA_MONTAR_RANGO, personaje.get_montarRango());
        values.put(COLUMNA_MONTAR_VARIOS, personaje.get_montarVarios());
        values.put(COLUMNA_SIGILO_CARAC, personaje.get_sigiloCarac());
        values.put(COLUMNA_SIGILO_RANGO, personaje.get_sigiloRango());
        values.put(COLUMNA_SIGILO_VARIOS, personaje.get_sigiloVarios());
        values.put(COLUMNA_NADAR_CARAC, personaje.get_nadarCarac());
        values.put(COLUMNA_NADAR_RANGO, personaje.get_nadarRango());
        values.put(COLUMNA_NADAR_VARIOS, personaje.get_nadarVarios());
        values.put(COLUMNA_OFICIO_CARAC, personaje.get_oficioCarac());
        values.put(COLUMNA_OFICIO_RANGO, personaje.get_oficioRango());
        values.put(COLUMNA_OFICIO_VARIOS, personaje.get_oficioVarios());
        values.put(COLUMNA_PIRUETAS_CARAC, personaje.get_piruetasCarac());
        values.put(COLUMNA_PIRUETAS_RANGO, personaje.get_piruetasRango());
        values.put(COLUMNA_PIRUETAS_VARIOS, personaje.get_piruetasVarios());
        values.put(COLUMNA_INFO_CARAC, personaje.get_infoCarac());
        values.put(COLUMNA_INFO_RANGO, personaje.get_infoRango());
        values.put(COLUMNA_INFO_VARIOS, personaje.get_infoVarios());
        values.put(COLUMNA_ARCANO_CARAC, personaje.get_arcanoCarac());
        values.put(COLUMNA_ARCANO_RANGO, personaje.get_arcanoRango());
        values.put(COLUMNA_ARCANO_VARIOS, personaje.get_arcanoVarios());
        values.put(COLUMNA_ARQ_CARAC, personaje.get_arqCarac());
        values.put(COLUMNA_ARQ_RANGO, personaje.get_arqRango());
        values.put(COLUMNA_ARQ_VARIOS, personaje.get_arqVarios());
        values.put(COLUMNA_DUNGEONS_CARAC, personaje.get_dungeonsCarac());
        values.put(COLUMNA_DUNGEONS_RANGO, personaje.get_dungeonsRango());
        values.put(COLUMNA_DUNGEONS_VARIOS, personaje.get_dungeonsVarios());
        values.put(COLUMNA_GEO_CARAC, personaje.get_geoCarac());
        values.put(COLUMNA_GEO_RANGO, personaje.get_geoRango());
        values.put(COLUMNA_GEO_VARIOS, personaje.get_geoVarios());
        values.put(COLUMNA_HISTORIA_CARAC, personaje.get_historiaCarac());
        values.put(COLUMNA_HISTORIA_RANGO, personaje.get_historiaRango());
        values.put(COLUMNA_HISTORIA_VARIOS, personaje.get_historiaVarios());
        values.put(COLUMNA_LOCAL_CARAC, personaje.get_localCarac());
        values.put(COLUMNA_LOCAL_RANGO, personaje.get_localRango());
        values.put(COLUMNA_LOCAL_VARIOS, personaje.get_localVarios());
        values.put(COLUMNA_PLANOS_CARAC, personaje.get_planosCarac());
        values.put(COLUMNA_PLANOS_RANGO, personaje.get_planosRango());
        values.put(COLUMNA_PLANOS_VARIOS, personaje.get_planosVarios());
        values.put(COLUMNA_NATURAL_CARAC, personaje.get_naturalCarac());
        values.put(COLUMNA_NATURAL_RANGO, personaje.get_naturalRango());
        values.put(COLUMNA_NATURAL_VARIOS, personaje.get_naturalVarios());
        values.put(COLUMNA_NOBLEZA_CARAC, personaje.get_noblezaCarac());
        values.put(COLUMNA_NOBLEZA_RANGO, personaje.get_noblezaRango());
        values.put(COLUMNA_NOBLEZA_VARIOS, personaje.get_noblezaVarios());
        values.put(COLUMNA_RELIGION_CARAC, personaje.get_religionCarac());
        values.put(COLUMNA_RELIGION_RANGO, personaje.get_religionRango());
        values.put(COLUMNA_RELIGION_VARIOS, personaje.get_religionVarios());
        values.put(COLUMNA_SALTAR_CARAC, personaje.get_saltarCarac());
        values.put(COLUMNA_SALTAR_RANGO, personaje.get_saltarRango());
        values.put(COLUMNA_SALTAR_VARIOS, personaje.get_saltarVarios());
        values.put(COLUMNA_SANAR_CARAC, personaje.get_sanarCarac());
        values.put(COLUMNA_SANAR_RANGO, personaje.get_sanarRango());
        values.put(COLUMNA_SANAR_VARIOS, personaje.get_sanarVarios());
        values.put(COLUMNA_SUPERVIVENCIA_CARAC, personaje.get_supervivenciaCarac());
        values.put(COLUMNA_SUPERVIVENCIA_RANGO, personaje.get_supervivenciaRango());
        values.put(COLUMNA_SUPERVIVENCIA_VARIOS, personaje.get_supervivenciaVarios());
        values.put(COLUMNA_TASACION_CARAC, personaje.get_tasacionCarac());
        values.put(COLUMNA_TASACION_RANGO, personaje.get_tasacionRango());
        values.put(COLUMNA_TASACION_VARIOS, personaje.get_tasacionVarios());
        values.put(COLUMNA_ANIMALES_CARAC, personaje.get_animalesCarac());
        values.put(COLUMNA_ANIMALES_RANGO, personaje.get_animalesRango());
        values.put(COLUMNA_ANIMALES_VARIOS, personaje.get_animalesVarios());
        values.put(COLUMNA_TREPAR_CARAC, personaje.get_treparCarac());
        values.put(COLUMNA_TREPAR_RANGO, personaje.get_treparRango());
        values.put(COLUMNA_TREPAR_VARIOS, personaje.get_treparVarios());
        values.put(COLUMNA_OBJ_MAG_CARAC, personaje.get_objMagCarac());
        values.put(COLUMNA_OBJ_MAG_RANGO, personaje.get_objMagRango());
        values.put(COLUMNA_OBJ_MAG_VARIOS, personaje.get_objMagVarios());
        values.put(COLUMNA_CUERDAS_CARAC, personaje.get_cuerdasCarac());
        values.put(COLUMNA_CUERDAS_RANGO, personaje.get_cuerdasRango());
        values.put(COLUMNA_CUERDAS_VARIOS, personaje.get_cuerdasVarios());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PERSONAJE, null, values);
        db.close();
    }

    /**
     * Metodo que inserta un registro de Equipo a la db.
     *
     *
     */


    public void addEquipo(Equipo equipo){
        ContentValues values = new ContentValues();
        values.put(COLUMNA_ARMA1_ARMA, equipo.get_arma1Arma());
        values.put(COLUMNA_ARMA1_DANIO, equipo.get_arma1Danio());
        values.put(COLUMNA_ARMA1_CRITICO, equipo.get_arma1Critico());
        values.put(COLUMNA_ARMA1_TIPO, equipo.get_arma1Tipo());
        values.put(COLUMNA_ARMA1_PESO, equipo.get_arma1Peso());
        values.put(COLUMNA_ARMA1_ALCANCE, equipo.get_arma1Alcance());
        values.put(COLUMNA_ARMA1_NOTAS, equipo.get_arma1Notas());
        values.put(COLUMNA_ARMA1_MUNICION, equipo.get_arma1Municion());
        values.put(COLUMNA_ARMA2_ARMA, equipo.get_arma2Arma());
        values.put(COLUMNA_ARMA2_DANIO, equipo.get_arma2Danio());
        values.put(COLUMNA_ARMA2_CRITICO, equipo.get_arma2Critico());
        values.put(COLUMNA_ARMA2_TIPO, equipo.get_arma2Tipo());
        values.put(COLUMNA_ARMA2_PESO, equipo.get_arma2Peso());
        values.put(COLUMNA_ARMA2_ALCANCE, equipo.get_arma2Alcance());
        values.put(COLUMNA_ARMA2_NOTAS, equipo.get_arma2Notas());
        values.put(COLUMNA_ARMA2_MUNICION, equipo.get_arma2Municion());
        values.put(COLUMNA_ARMA3_ARMA, equipo.get_arma3Arma());
        values.put(COLUMNA_ARMA3_DANIO, equipo.get_arma3Danio());
        values.put(COLUMNA_ARMA3_CRITICO, equipo.get_arma3Critico());
        values.put(COLUMNA_ARMA3_TIPO, equipo.get_arma3Tipo());
        values.put(COLUMNA_ARMA3_PESO, equipo.get_arma3Peso());
        values.put(COLUMNA_ARMA3_ALCANCE, equipo.get_arma3Alcance());
        values.put(COLUMNA_ARMA3_NOTAS, equipo.get_arma3Notas());
        values.put(COLUMNA_ARMA3_MUNICION, equipo.get_arma3Municion());
        values.put(COLUMNA_ARMA4_ARMA, equipo.get_arma4Arma());
        values.put(COLUMNA_ARMA4_DANIO, equipo.get_arma4Danio());
        values.put(COLUMNA_ARMA4_CRITICO, equipo.get_arma4Critico());
        values.put(COLUMNA_ARMA4_TIPO, equipo.get_arma4Tipo());
        values.put(COLUMNA_ARMA4_PESO, equipo.get_arma4Peso());
        values.put(COLUMNA_ARMA4_ALCANCE, equipo.get_arma4Alcance());
        values.put(COLUMNA_ARMA4_NOTAS, equipo.get_arma4Notas());
        values.put(COLUMNA_ARMA4_MUNICION, equipo.get_arma4Municion());
        values.put(COLUMNA_ARMA5_ARMA, equipo.get_arma5Arma());
        values.put(COLUMNA_ARMA5_DANIO, equipo.get_arma5Danio());
        values.put(COLUMNA_ARMA5_CRITICO, equipo.get_arma5Critico());
        values.put(COLUMNA_ARMA5_TIPO, equipo.get_arma5Tipo());
        values.put(COLUMNA_ARMA5_PESO, equipo.get_arma5Peso());
        values.put(COLUMNA_ARMA5_ALCANCE, equipo.get_arma5Alcance());
        values.put(COLUMNA_ARMA5_NOTAS, equipo.get_arma5Notas());
        values.put(COLUMNA_ARMA5_MUNICION, equipo.get_arma5Municion());
        values.put(COLUMNA_ARMADURA_ARMADURA, equipo.get_armaduraArmadura());
        values.put(COLUMNA_ARMADURA_CA, equipo.get_armaduraCa());
        values.put(COLUMNA_ARMADURA_DESMAX, equipo.get_armaduraDesMax());
        values.put(COLUMNA_ARMADURA_TIPO, equipo.get_armaduraTipo());
        values.put(COLUMNA_ARMADURA_PEN, equipo.get_armaduraPen());
        values.put(COLUMNA_ARMADURA_VELOCIDAD, equipo.get_armaduraVelocidad());
        values.put(COLUMNA_ARMADURA_PESO, equipo.get_armaduraPeso());
        values.put(COLUMNA_ARMADURA_FALLO, equipo.get_armaduraFallo());
        values.put(COLUMNA_ARMADURA_ESP, equipo.get_armaduraEsp());
        values.put(COLUMNA_OBJ2_ESCUDO, equipo.get_obj2Escudo());
        values.put(COLUMNA_OBJ2_CA, equipo.get_obj2Ca());
        values.put(COLUMNA_OBJ2_DESMAX, equipo.get_obj2DesMax());
        values.put(COLUMNA_OBJ2_FALLO, equipo.get_obj2Fallo());
        values.put(COLUMNA_OBJ2_PEN, equipo.get_obj2Pen());
        values.put(COLUMNA_OBJ2_ESP, equipo.get_obj2Esp());
        values.put(COLUMNA_OBJ2_PESO, equipo.get_obj2Peso());
        values.put(COLUMNA_OBJ3_OBJ, equipo.get_obj3Obj());
        values.put(COLUMNA_OBJ3_CA, equipo.get_obj3Ca());
        values.put(COLUMNA_OBJ3_PESO, equipo.get_obj3Peso());
        values.put(COLUMNA_OBJ3_ESP, equipo.get_obj3Esp());
        values.put(COLUMNA_OBJ4_OBJ, equipo.get_obj4Obj());
        values.put(COLUMNA_OBJ4_CA, equipo.get_obj4Ca());
        values.put(COLUMNA_OBJ4_PESO, equipo.get_obj4Peso());
        values.put(COLUMNA_OBJ4_ESP, equipo.get_obj4Esp());
        values.put(COLUMNA_LIGERA, equipo.get_otrasLigero());
        values.put(COLUMNA_MEDIA, equipo.get_otrasMedio());
        values.put(COLUMNA_PESADA, equipo.get_otrasPesado());
        values.put(COLUMNA_CABEZA, equipo.get_otrasCabeza());
        values.put(COLUMNA_SUELO, equipo.get_otrasSuelo());
        values.put(COLUMNA_EMPUJAR_ARRASTRAR, equipo.get_otrasEmpujar());
        values.put(COLUMNA_PC, equipo.get_otrasPc());
        values.put(COLUMNA_PP, equipo.get_otrasPp());
        values.put(COLUMNA_PO, equipo.get_otrasPo());
        values.put(COLUMNA_PPT, equipo.get_otrasPpt());
        values.put(COLUMN_ID_PJ, equipo.get_idPersonaje());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_EQUIPO, null, values);
        db.close();

    }

    /**
     * Metodo que inserta un registro de OtrosEquipos a la db.
     *
     *
     */

    public void addOtrosEquipos(OtrosEquipos otrosEquipos){
        ContentValues values = new ContentValues();
        values.put(COLUMNA_OTRAS_OBJETO, otrosEquipos.get_otrasObjeto());
        values.put(COLUMNA_OTRAS_PAGINA, otrosEquipos.get_otrasPagina());
        values.put(COLUMNA_OTRAS_PESO, otrosEquipos.get_otrasPeso());
        values.put(COLUMNA_OTRAS_VALOR, otrosEquipos.get_otrasValor());
        values.put(COLUMNA_OTRAS_MONEDA, otrosEquipos.get_otrasMoneda());
        values.put(_ID_PJ, otrosEquipos.get_idPersonaje());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_OTROS_EQUIPOS, null, values);
        db.close();

    }

    /**
     * Metodo que inserta un registro de Conjuros a la db.
     *
     *
     */

    public void addConjuros(Conjuros conjuros){

        ContentValues values = new ContentValues();
        values.put(COLUMNA_SALV_CONJUROS, conjuros.get_salvConj());
        values.put(COLUMNA_FALLO_CONJUROS, conjuros.get_falloConj());
        values.put(COLUMNA_CONOC_CONJUROSLV0, conjuros.get_concConjLv0());
        values.put(COLUMNA_CD_SALVACIONLV0, conjuros.get_cdConjLv0());
        values.put(COLUMNA_DIARIOS_CONJUROSLV0, conjuros.get_diariosConjLv0());
        values.put(COLUMNA_ADICIONALESLV0, conjuros.get_adicionalesConjLv0());
        values.put(COLUMNA_CONOC_CONJUROSLV1, conjuros.get_concConjLv1());
        values.put(COLUMNA_CD_SALVACIONLV1, conjuros.get_cdConjLv1());
        values.put(COLUMNA_DIARIOS_CONJUROSLV1, conjuros.get_diariosConjLv1());
        values.put(COLUMNA_ADICIONALESLV1, conjuros.get_adicionalesConjLv1());
        values.put(COLUMNA_CONOC_CONJUROSLV2, conjuros.get_concConjLv2());
        values.put(COLUMNA_CD_SALVACIONLV2, conjuros.get_cdConjLv2());
        values.put(COLUMNA_DIARIOS_CONJUROSLV2, conjuros.get_diariosConjLv2());
        values.put(COLUMNA_ADICIONALESLV2, conjuros.get_adicionalesConjLv2());
        values.put(COLUMNA_CONOC_CONJUROSLV3, conjuros.get_concConjLv3());
        values.put(COLUMNA_CD_SALVACIONLV3, conjuros.get_cdConjLv3());
        values.put(COLUMNA_DIARIOS_CONJUROSLV3, conjuros.get_diariosConjLv3());
        values.put(COLUMNA_ADICIONALESLV3, conjuros.get_adicionalesConjLv3());
        values.put(COLUMNA_CONOC_CONJUROSLV4, conjuros.get_concConjLv4());
        values.put(COLUMNA_CD_SALVACIONLV4, conjuros.get_cdConjLv4());
        values.put(COLUMNA_DIARIOS_CONJUROSLV4, conjuros.get_diariosConjLv4());
        values.put(COLUMNA_ADICIONALESLV4, conjuros.get_adicionalesConjLv4());
        values.put(COLUMNA_CONOC_CONJUROSLV5, conjuros.get_concConjLv5());
        values.put(COLUMNA_CD_SALVACIONLV5, conjuros.get_cdConjLv5());
        values.put(COLUMNA_DIARIOS_CONJUROSLV5, conjuros.get_diariosConjLv5());
        values.put(COLUMNA_ADICIONALESLV5, conjuros.get_adicionalesConjLv5());
        values.put(COLUMNA_CONOC_CONJUROSLV6, conjuros.get_concConjLv6());
        values.put(COLUMNA_CD_SALVACIONLV6, conjuros.get_cdConjLv6());
        values.put(COLUMNA_DIARIOS_CONJUROSLV6, conjuros.get_diariosConjLv6());
        values.put(COLUMNA_ADICIONALESLV6, conjuros.get_adicionalesConjLv6());
        values.put(COLUMNA_CONOC_CONJUROSLV7, conjuros.get_concConjLv7());
        values.put(COLUMNA_CD_SALVACIONLV7, conjuros.get_cdConjLv7());
        values.put(COLUMNA_DIARIOS_CONJUROSLV7, conjuros.get_diariosConjLv7());
        values.put(COLUMNA_ADICIONALESLV7, conjuros.get_adicionalesConjLv7());
        values.put(COLUMNA_CONOC_CONJUROSLV8, conjuros.get_concConjLv8());
        values.put(COLUMNA_CD_SALVACIONLV8, conjuros.get_cdConjLv8());
        values.put(COLUMNA_DIARIOS_CONJUROSLV8, conjuros.get_diariosConjLv8());
        values.put(COLUMNA_ADICIONALESLV8, conjuros.get_adicionalesConjLv8());
        values.put(COLUMNA_CONOC_CONJUROSLV9, conjuros.get_concConjLv9());
        values.put(COLUMNA_CD_SALVACIONLV9, conjuros.get_cdConjLv9());
        values.put(COLUMNA_DIARIOS_CONJUROSLV9, conjuros.get_diariosConjLv9());
        values.put(COLUMNA_ADICIONALESLV9, conjuros.get_adicionalesConjLv9());
        values.put(_IDPJ, conjuros.get_idPersojae());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_CONJUROS, null, values);
        db.close();
    }

    /**
     * Metodo que inserta un registro de otrosConjuros a la db.
     *
     *
     */

    public void addOtrosConjuros(OtrosConjuros otrosConjuros){
        ContentValues values = new ContentValues();
        values.put(COLUMNA_DOMINIOS, otrosConjuros.get_dominios());
        values.put(COLUMNA_ESCUELA, otrosConjuros.get_escuela());
        values.put(_ID_PERSONAJE, otrosConjuros.get_idPersonaje());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_OTROS_CONJUROS, null, values);
        db.close();

    }

    /**
     * Método que devuelve todos los PJ en un Cursor.
     *
     * @return cursor
     */

    public Cursor obtenerTodosPersonajes(){
        String[] columnas = new String[]{
                COLUMNA_ID_PJ, COLUMNA_NOMBRE_PJ, COLUMNA_CLASE_PJ, COLUMNA_NIVEL_PJ, COLUMNA_RAZA_PJ, COLUMNA_ALINEAMIENTO_PJ,
                COLUMNA_DEIDAD, COLUMNA_TAMANIO_PJ, COLUMNA_SEXO_PJ, COLUMNA_EXP_PJ, COLUMNA_EXP_LOW, COLUMNA_EXP_HIGH,
                COLUMNA_CAMPANIA_PJ, COLUMNA_CONTROL_ACT
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


    /**
     * Método que devuelve todas las otras posesiones en un Cursor.
     *
     * @return cursor
     */

    public Cursor obtenerTodasOtrasPosesiones(){

        String[] columnas = new String[]{
                COLUMN_ID, COLUMNA_OTRAS_OBJETO, COLUMNA_OTRAS_PAGINA, COLUMNA_OTRAS_PESO, COLUMNA_OTRAS_VALOR, COLUMNA_OTRAS_MONEDA
        };
        Cursor cursor = this.getReadableDatabase().query(TABLA_OTROS_EQUIPOS, columnas, null, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }

        return cursor;

    }

    /**
     * Método que devuelve todos los conjuros en un Cursor.
     *
     * @return cursor
     */

    public Cursor obtenereTodosLosConjuros(){

        String[] columnas = new String[]{
                _ID_CONJUROS, COLUMNA_DOMINIOS, COLUMNA_ESCUELA
        };

        Cursor cursor = this.getReadableDatabase().query(TABLA_OTROS_CONJUROS, columnas, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        return cursor;
    }



}
