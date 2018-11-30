package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsFragment extends Fragment {

    //47 TextView
    DBHelper dbHelper = null;
    SQLiteDatabase db;

    private String aux_id = "";
    private String aux_clase = "";
    private String aux_campaña = "";
    private String aux_tamaño = "";
    private String aux_ptsHab = "";
    private String aux_modificador = "";
    private String aux_rango = "";
    private String aux_varios = "";
    private String aux_pts_hab = "";
    private String aux_total = "";
    private String aux_cerradura = "";
    private String aux_arte = "";
    private String aux_intenciones = "";
    private String aux_avistar = "";
    private String aux_buscar = "";
    private String aux_concentracion = "";
    private String aux_conjuros = "";
    private String aux_escritura = "";
    private String aux_diplomacia = "";
    private String aux_disfraz = "";
    private String aux_enganio = "";
    private String aux_equilibrio = "";
    private String aux_escapismo = "";
    private String aux_esconderse = "";
    private String aux_escuchar = "";
    private String aux_falsificar = "";
    private String aux_interpretar1 = "";
    private String aux_interpretar2 = "";
    private String aux_interpretar3 = "";
    private String aux_intimidar = "";
    private String aux_mecanismo = "";
    private String aux_manos = "";
    private String aux_montar = "";
    private String aux_sigilo = "";
    private String aux_nadar = "";
    private String aux_oficio = "";
    private String aux_piruetas = "";
    private String aux_info = "";
    private String aux_arcano = "";
    private String aux_arq = "";
    private String aux_dungeons = "";
    private String aux_geo = "";
    private String aux_historia = "";
    private String aux_local = "";
    private String aux_planos = "";
    private String aux_natural = "";
    private String aux_nobleza = "";
    private String aux_religion = "";
    private String aux_saltar = "";
    private String aux_sanar = "";
    private String aux_supervivencia = "";
    private String aux_tasacion = "";
    private String aux_animales = "";
    private String aux_trepar = "";
    private String aux_objMag = "";
    private String aux_cuerdas = "";

    private int control = 0;

    private CheckBox checkCerradura;
    private CheckBox checkArte;
    private CheckBox checkIntenciones;
    private CheckBox checkAvistar;
    private CheckBox checkBuscar;
    private CheckBox checkConcentracion;
    private CheckBox checkConjuros;
    private CheckBox checkDesfEscritura;
    private CheckBox checkDiplomacia;
    private CheckBox checkDisfraz;
    private CheckBox checkEnganiar;
    private CheckBox checkEquilibrio;
    private CheckBox checkEscapismo;
    private CheckBox checkEsconderse;
    private CheckBox checkEscuchar;
    private CheckBox checkFalsificar;
    private CheckBox checkInterpretar1;
    private CheckBox checkInterpretar2;
    private CheckBox checkInterpretar3;
    private CheckBox checkIntimidar;
    private CheckBox checkInutilizarMeq;
    private CheckBox checkJuegoManos;
    private CheckBox checkMontar;
    private CheckBox checkSigilo;
    private CheckBox checkNadar;
    private CheckBox checkOficio;
    private CheckBox checkPiruetas;
    private CheckBox checkReunirInfo;
    private CheckBox checkSaberArcano;
    private CheckBox checkSaberIng;
    private CheckBox checkSaberDung;
    private CheckBox checkSaberGeo;
    private CheckBox checkSaberHistoria;
    private CheckBox checkSaberLocal;
    private CheckBox checkSaberPlanos;
    private CheckBox checkSaberNat;
    private CheckBox checkSaberNobleza;
    private CheckBox checkSaberReligion;
    private CheckBox checkSaltar;
    private CheckBox checkSanar;
    private CheckBox checkSuperv;
    private CheckBox checkTasacion;
    private CheckBox checkAnimales;
    private CheckBox checkTrepar;
    private CheckBox checkObjMagico;
    private CheckBox checkCuerdas;

    private Button btnCerradura;
    private Button btnArte;
    private Button btnIntenciones;
    private Button btnAvistar;
    private Button btnBuscar;
    private Button btnConcentracion;
    private Button btnConjuros;
    private Button btnDesfEscritura;
    private Button btnDiplomacia;
    private Button btnDisfraz;
    private Button btnEnganiar;
    private Button btnEquilibrio;
    private Button btnEscapismo;
    private Button btnEsconderse;
    private Button btnEscuchar;
    private Button btnFalsificar;
    private Button btnInterpretar1;
    private Button btnInterpretar2;
    private Button btnInterpretar3;
    private Button btnIntimidar;
    private Button btnInutilizarMec;
    private Button btnJuegoManos;
    private Button btnMontar;
    private Button btnSigilo;
    private Button btnNadar;
    private Button btnOficio;
    private Button btnPiruetas;
    private Button btnReunirInfo;
    private Button btnSaberArcano;
    private Button btnSaberIng;
    private Button btnSaberDung;
    private Button btnSaberGeo;
    private Button btnSaberHistoria;
    private Button btnSaberLocal;
    private Button btnSaberPlanos;
    private Button btnSaberNat;
    private Button btnSaberNobleza;
    private Button btnSaberReligion;
    private Button btnSaltar;
    private Button btnSanar;
    private Button btnSuperv;
    private Button btnTasacion;
    private Button btnAnimales;
    private Button btnTrepar;
    private Button btnObjMagico;
    private Button btnCuerdas;

    public SkillsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skills, container, false);

        if(view !=null){

            dbHelper = new DBHelper(getActivity());
            db = dbHelper.getWritableDatabase();

            // Son 46 checkbox
            checkCerradura      = view.findViewById(R.id.checkCerradura);
            checkArte           = view.findViewById(R.id.checkArte);
            checkIntenciones    = view.findViewById(R.id.checkIntenciones);
            checkAvistar        = view.findViewById(R.id.checkAvistar);
            checkBuscar         = view.findViewById(R.id.checkBuscar);
            checkConcentracion  = view.findViewById(R.id.checkConcentracion);
            checkConjuros       = view.findViewById(R.id.checkConjuros);
            checkDesfEscritura  = view.findViewById(R.id.checkDesfEscritura);
            checkDiplomacia     = view.findViewById(R.id.checkDiplomacia);
            checkDisfraz        = view.findViewById(R.id.checkDisfraz);
            checkEnganiar       = view.findViewById(R.id.checkEngañar);
            checkEquilibrio     = view.findViewById(R.id.checkEquilibrio);
            checkEscapismo      = view.findViewById(R.id.checkEscapismo);
            checkEsconderse     = view.findViewById(R.id.checkEsconderse);
            checkEscuchar       = view.findViewById(R.id.checkEscuchar);
            checkFalsificar     = view.findViewById(R.id.checkFalsificar);
            checkInterpretar1   = view.findViewById(R.id.checkInterpretar1);
            checkInterpretar2   = view.findViewById(R.id.checkInterpretar2);
            checkInterpretar3   = view.findViewById(R.id.checkInterpretar3);
            checkIntimidar      = view.findViewById(R.id.checkIntimidar);
            checkInutilizarMeq  = view.findViewById(R.id.checkInutilizarMeq);
            checkJuegoManos     = view.findViewById(R.id.checkJuegoManos);
            checkMontar         = view.findViewById(R.id.checkMontar);
            checkSigilo         = view.findViewById(R.id.checkSigilo);
            checkNadar          = view.findViewById(R.id.checkNadar);
            checkOficio         = view.findViewById(R.id.checkOficio);
            checkPiruetas       = view.findViewById(R.id.checkPiruetas);
            checkReunirInfo     = view.findViewById(R.id.checkReunirInfo);
            checkSaberArcano    = view.findViewById(R.id.checkSaberArcano);
            checkSaberIng       = view.findViewById(R.id.checkSaberIng);
            checkSaberDung      = view.findViewById(R.id.checkSaberDung);
            checkSaberGeo       = view.findViewById(R.id.checkSaberGeo);
            checkSaberHistoria  = view.findViewById(R.id.checkSaberHistoria);
            checkSaberLocal     = view.findViewById(R.id.checkSaberLocal);
            checkSaberPlanos    = view.findViewById(R.id.checkSaberPlanos);
            checkSaberNat       = view.findViewById(R.id.checkSaberNat);
            checkSaberNobleza   = view.findViewById(R.id.checkSaberNobleza);
            checkSaberReligion  = view.findViewById(R.id.checkSaberReligion);
            checkSaltar         = view.findViewById(R.id.checkSaltar);
            checkSanar          = view.findViewById(R.id.checkSanar);
            checkSuperv         = view.findViewById(R.id.checkSuperv);
            checkTasacion       = view.findViewById(R.id.checkTasacion);
            checkAnimales       = view.findViewById(R.id.checkAnimales);
            checkTrepar         = view.findViewById(R.id.checkTrepar);
            checkObjMagico      = view.findViewById(R.id.checkObjMagico);
            checkCuerdas        = view.findViewById(R.id.checkCuerdas);

            // Son 46 botones
            btnCerradura     = view.findViewById(R.id.btnValorCerradura);
            btnArte          = view.findViewById(R.id.btnValorArte);
            btnIntenciones   = view.findViewById(R.id.btnValorIntenciones);
            btnAvistar       = view.findViewById(R.id.btnValorAvistar);
            btnBuscar        = view.findViewById(R.id.btnValorBuscar);
            btnConcentracion = view.findViewById(R.id.btnValorConcentracion);
            btnConjuros      = view.findViewById(R.id.btnValorConjuros);
            btnDesfEscritura = view.findViewById(R.id.btnValorDesfEscritura);
            btnDiplomacia    = view.findViewById(R.id.btnValorDiplomacia);
            btnDisfraz       = view.findViewById(R.id.btnValorDisfraz);
            btnEnganiar      = view.findViewById(R.id.btnValorEngañar);
            btnEquilibrio    = view.findViewById(R.id.btnValorEquilibrio);
            btnEscapismo     = view.findViewById(R.id.btnValorEscapismo);
            btnEsconderse    = view.findViewById(R.id.btnValorEsconderse);
            btnEscuchar      = view.findViewById(R.id.btnValorEscuchar);
            btnFalsificar    = view.findViewById(R.id.btnValorFalsificar);
            btnInterpretar1  = view.findViewById(R.id.btnValorInterpretar1);
            btnInterpretar2  = view.findViewById(R.id.btnValorInterpretar2);
            btnInterpretar3  = view.findViewById(R.id.btnValorInterpretar3);
            btnIntimidar     = view.findViewById(R.id.btnValorIntimidar);
            btnInutilizarMec = view.findViewById(R.id.btnValorInutilizarMeq);
            btnJuegoManos    = view.findViewById(R.id.btnValorJuegoManos);
            btnMontar        = view.findViewById(R.id.btnValorMontar);
            btnSigilo        = view.findViewById(R.id.btnValorSigilo);
            btnNadar         = view.findViewById(R.id.btnValorNadar);
            btnOficio        = view.findViewById(R.id.btnValorOficio);
            btnPiruetas      = view.findViewById(R.id.btnValorPiruetas);
            btnReunirInfo    = view.findViewById(R.id.btnValorReunirInfo);
            btnSaberArcano   = view.findViewById(R.id.btnValorSaberArcano);
            btnSaberIng      = view.findViewById(R.id.btnValorSaberIng);
            btnSaberDung     = view.findViewById(R.id.btnValorSaberDung);
            btnSaberGeo      = view.findViewById(R.id.btnValorSaberGeo);
            btnSaberHistoria = view.findViewById(R.id.btnValorSaberHistoria);
            btnSaberLocal    = view.findViewById(R.id.btnValorSaberLocal);
            btnSaberPlanos   = view.findViewById(R.id.btnValorSaberPlanos);
            btnSaberNat      = view.findViewById(R.id.btnValorSaberNat);
            btnSaberNobleza  = view.findViewById(R.id.btnValorSaberNobleza);
            btnSaberReligion = view.findViewById(R.id.btnValorSaberReligion);
            btnSaltar        = view.findViewById(R.id.btnValorSaltar);
            btnSanar         = view.findViewById(R.id.btnValorSanar);
            btnSuperv        = view.findViewById(R.id.btnValorSuperv);
            btnTasacion      = view.findViewById(R.id.btnValorTasacion);
            btnAnimales      = view.findViewById(R.id.btnValorAnimales);
            btnTrepar        = view.findViewById(R.id.btnValorTrepar);
            btnObjMagico     = view.findViewById(R.id.btnValorObjMagico);
            btnCuerdas       = view.findViewById(R.id.btnValorCuerdas);

            recuperarTodosSkills();

            btnCerradura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    control = 1;

                    modificarPuntosHabilidad(control);

                }
            });

            btnArte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 2;

                    modificarPuntosHabilidad(control);
                }
            });

            btnIntenciones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 3;

                    modificarPuntosHabilidad(control);
                }
            });
            btnAvistar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 4;

                    modificarPuntosHabilidad(control);
                }
            });
            btnBuscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 5;

                    modificarPuntosHabilidad(control);
                }
            });
            btnConcentracion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 6;

                    modificarPuntosHabilidad(control);
                }
            });
            btnConjuros.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 7;

                    modificarPuntosHabilidad(control);
                }
            });
            btnDesfEscritura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 8;

                    modificarPuntosHabilidad(control);
                }
            });
            btnDiplomacia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 9;

                    modificarPuntosHabilidad(control);
                }
            });
            btnDisfraz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 10;

                    modificarPuntosHabilidad(control);
                }
            });
            btnEnganiar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 11;

                    modificarPuntosHabilidad(control);
                }
            });
            btnEquilibrio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 12;

                    modificarPuntosHabilidad(control);
                }
            });
            btnEscapismo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 13;

                    modificarPuntosHabilidad(control);
                }
            });
            btnEsconderse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 14;

                    modificarPuntosHabilidad(control);
                }
            });
            btnEscuchar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 15;

                    modificarPuntosHabilidad(control);
                }
            });
            btnFalsificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 16;

                    modificarPuntosHabilidad(control);
                }
            });
            btnInterpretar1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 17;

                    modificarPuntosHabilidad(control);
                }
            });
            btnInterpretar2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 18;

                    modificarPuntosHabilidad(control);
                }
            });
            btnInterpretar3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 19;

                    modificarPuntosHabilidad(control);
                }
            });
            btnIntimidar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 20;

                    modificarPuntosHabilidad(control);
                }
            });
            btnInutilizarMec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 21;

                    modificarPuntosHabilidad(control);
                }
            });
            btnJuegoManos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 22;

                    modificarPuntosHabilidad(control);
                }
            });
            btnMontar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 23;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSigilo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 24;

                    modificarPuntosHabilidad(control);
                }
            });
            btnNadar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 25;

                    modificarPuntosHabilidad(control);
                }
            });
            btnOficio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 26;

                    modificarPuntosHabilidad(control);
                }
            });
            btnPiruetas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 27;

                    modificarPuntosHabilidad(control);
                }
            });
            btnReunirInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 28;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberArcano.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 29;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberIng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 30;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberDung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 31;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberGeo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 32;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberHistoria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 33;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberLocal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 34;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberPlanos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 35;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberNat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 36;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberNobleza.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 37;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaberReligion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 38;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSaltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 39;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSanar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 40;

                    modificarPuntosHabilidad(control);
                }
            });
            btnSuperv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 41;

                    modificarPuntosHabilidad(control);
                }
            });
            btnTasacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 42;

                    modificarPuntosHabilidad(control);
                }
            });
            btnAnimales.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 43;

                    modificarPuntosHabilidad(control);
                }
            });
            btnTrepar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 44;

                    modificarPuntosHabilidad(control);
                }
            });
            btnObjMagico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 45;

                    modificarPuntosHabilidad(control);
                }
            });

            btnCuerdas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 46;

                    modificarPuntosHabilidad(control);
                }
            });



        }

        return view;
    }

    public void recuperarTodosSkills(){

        try {
            dbHelper = new DBHelper(getActivity());
            db = dbHelper.getReadableDatabase();

            Cursor c = db
                    .rawQuery("SELECT _id, clasePj, ptsHab, cerradura, arte, intenciones, avistar, buscar, concentracion, conjuros, escritura, diplomacia, disfraz, enganio, equilibrio, escapismo, esconderse, escuchar, falsificar, interpretar1, interpretar2, interpretar3, intimidar, mecanismo, manos, montar, sigilo, nadar, oficio, piruetas, info, arcano, arquitectura, dungeons, geografia, historia, local, planos, naturaleza, nobleza, religion, saltar, sanar, supervivencia, tasacion, animales, trepar, objetoMagico, cuerdas FROM personaje WHERE controlAct='1'", null);

            if (c.moveToFirst()) {
                do {
                    aux_id = c.getString(0);
                    aux_clase = c.getString(1);
                    aux_ptsHab = c.getString(2);
                    aux_cerradura = c.getString(3);
                    aux_arte = c.getString(4);
                    aux_intenciones = c.getString(5);
                    aux_avistar = c.getString(6);
                    aux_buscar = c.getString(7);
                    aux_concentracion = c.getString(8);
                    aux_conjuros = c.getString(9);
                    aux_escritura = c.getString(10);
                    aux_diplomacia = c.getString(11);
                    aux_disfraz = c.getString(12);
                    aux_enganio = c.getString(13);
                    aux_equilibrio = c.getString(14);
                    aux_escapismo = c.getString(15);
                    aux_esconderse = c.getString(16);
                    aux_escuchar = c.getString(17);
                    aux_falsificar = c.getString(18);
                    aux_interpretar1 = c.getString(19);
                    aux_interpretar2 = c.getString(20);
                    aux_interpretar3 = c.getString(21);
                    aux_intimidar = c.getString(22);
                    aux_mecanismo = c.getString(23);
                    aux_manos = c.getString(24);
                    aux_montar = c.getString(25);
                    aux_sigilo = c.getString(26);
                    aux_nadar = c.getString(27);
                    aux_oficio = c.getString(28);
                    aux_piruetas = c.getString(29);
                    aux_info = c.getString(30);
                    aux_arcano = c.getString(31);
                    aux_arq = c.getString(32);
                    aux_dungeons = c.getString(33);
                    aux_geo = c.getString(34);
                    aux_historia = c.getString(35);
                    aux_local = c.getString(36);
                    aux_planos = c.getString(37);
                    aux_natural = c.getString(38);
                    aux_nobleza = c.getString(39);
                    aux_religion = c.getString(40);
                    aux_saltar = c.getString(41);
                    aux_sanar = c.getString(42);
                    aux_supervivencia = c.getString(43);
                    aux_tasacion = c.getString(44);
                    aux_animales = c.getString(45);
                    aux_trepar = c.getString(46);
                    aux_objMag = c.getString(47);
                    aux_cuerdas = c.getString(48);

                } while (c.moveToNext());

                btnCerradura.setText(aux_cerradura);
                btnArte.setText(aux_arte);
                btnIntenciones.setText(aux_intenciones);
                btnAvistar.setText(aux_avistar);
                btnBuscar.setText(aux_buscar);
                btnConcentracion.setText(aux_concentracion);
                btnConjuros.setText(aux_conjuros);
                btnDesfEscritura.setText(aux_escritura);
                btnDiplomacia.setText(aux_diplomacia);
                btnDisfraz.setText(aux_disfraz);
                btnEnganiar.setText(aux_enganio);
                btnEquilibrio.setText(aux_equilibrio);
                btnEscapismo.setText(aux_escapismo);
                btnEsconderse.setText(aux_esconderse);
                btnEscuchar.setText(aux_escuchar);
                btnFalsificar.setText(aux_falsificar);
                btnInterpretar1.setText(aux_interpretar1);
                btnInterpretar2.setText(aux_interpretar2);
                btnInterpretar3.setText(aux_interpretar3);
                btnIntimidar.setText(aux_intimidar);
                btnInutilizarMec.setText(aux_mecanismo);
                btnJuegoManos.setText(aux_manos);
                btnMontar.setText(aux_montar);
                btnSigilo.setText(aux_sigilo);
                btnNadar.setText(aux_nadar);
                btnOficio.setText(aux_oficio);
                btnPiruetas.setText(aux_piruetas);
                btnReunirInfo.setText(aux_info);
                btnSaberArcano.setText(aux_arcano);
                btnSaberIng.setText(aux_arq);
                btnSaberDung.setText(aux_dungeons);
                btnSaberGeo.setText(aux_geo);
                btnSaberHistoria.setText(aux_historia);
                btnSaberLocal.setText(aux_local);
                btnSaberPlanos.setText(aux_planos);
                btnSaberNat.setText(aux_natural);
                btnSaberNobleza.setText(aux_nobleza);
                btnSaberReligion.setText(aux_religion);
                btnSaltar.setText(aux_saltar);
                btnSanar.setText(aux_sanar);
                btnSuperv.setText(aux_supervivencia);
                btnTasacion.setText(aux_tasacion);
                btnAnimales.setText(aux_animales);
                btnTrepar.setText(aux_trepar);
                btnObjMagico.setText(aux_objMag);
                btnCuerdas.setText(aux_cuerdas);

                habilidadesPorClase(aux_clase);
            }

        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        }finally {
            dbHelper.cerrar();
        }

    }

    public void habilidadesPorClase(String clase){

        if(clase.equals("Guerrero")){
            checkArte.setChecked(true);
            checkIntimidar.setChecked(true);
            checkMontar.setChecked(true);
            checkNadar.setChecked(true);
            checkSaltar.setChecked(true);
            checkAnimales.setChecked(true);
            checkTrepar.setChecked(true);
            checkCerradura.setChecked(false);
            checkIntenciones.setChecked(false);
            checkAvistar.setChecked(false);
            checkBuscar.setChecked(false);
            checkConcentracion.setChecked(false);
            checkConjuros.setChecked(false);
            checkDesfEscritura.setChecked(false);
            checkDiplomacia.setChecked(false);
            checkDisfraz.setChecked(false);
            checkEnganiar.setChecked(false);
            checkEquilibrio.setChecked(false);
            checkEscapismo.setChecked(false);
            checkEsconderse.setChecked(false);
            checkEscuchar.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInterpretar1.setChecked(false);
            checkInterpretar2.setChecked(false);
            checkInterpretar3.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkSigilo.setChecked(false);
            checkOficio.setChecked(false);
            checkPiruetas.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkSaberArcano.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberDung.setChecked(false);
            checkSaberGeo.setChecked(false);
            checkSaberHistoria.setChecked(false);
            checkSaberLocal.setChecked(false);
            checkSaberPlanos.setChecked(false);
            checkSaberNat.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaberReligion.setChecked(false);
            checkSanar.setChecked(false);
            checkSuperv.setChecked(false);
            checkTasacion.setChecked(false);
            checkObjMagico.setChecked(false);
            checkCuerdas.setChecked(false);

        }else if(clase.equals("Explorador")){
            checkArte.setChecked(true);
            checkAvistar.setChecked(true);
            checkBuscar.setChecked(true);
            checkConcentracion.setChecked(true);
            checkEsconderse.setChecked(true);
            checkEscuchar.setChecked(true);
            checkMontar.setChecked(true);
            checkSigilo.setChecked(true);
            checkNadar.setChecked(true);
            checkOficio.setChecked(true);
            checkSaberDung.setChecked(true);
            checkSaberGeo.setChecked(true);
            checkSaberNat.setChecked(true);
            checkSaltar.setChecked(true);
            checkSanar.setChecked(true);
            checkSuperv.setChecked(true);
            checkAnimales.setChecked(true);
            checkTrepar.setChecked(true);
            checkCuerdas.setChecked(true);
            checkIntimidar.setChecked(false);
            checkCerradura.setChecked(false);
            checkIntenciones.setChecked(false);
            checkConjuros.setChecked(false);
            checkDesfEscritura.setChecked(false);
            checkDiplomacia.setChecked(false);
            checkDisfraz.setChecked(false);
            checkEnganiar.setChecked(false);
            checkEquilibrio.setChecked(false);
            checkEscapismo.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInterpretar1.setChecked(false);
            checkInterpretar2.setChecked(false);
            checkInterpretar3.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkPiruetas.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkSaberArcano.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberHistoria.setChecked(false);
            checkSaberLocal.setChecked(false);
            checkSaberPlanos.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaberReligion.setChecked(false);
            checkTasacion.setChecked(false);
            checkObjMagico.setChecked(false);

        } else if(clase.equals("Bárbaro" )|| clase.equals("Barbaro")){

            checkArte.setChecked(true);
            checkEscuchar.setChecked(true);
            checkIntimidar.setChecked(true);
            checkMontar.setChecked(true);
            checkNadar.setChecked(true);
            checkSaltar.setChecked(true);
            checkSuperv.setChecked(true);
            checkAnimales.setChecked(true);
            checkTrepar.setChecked(true);
            checkCerradura.setChecked(false);
            checkIntenciones.setChecked(false);
            checkAvistar.setChecked(false);
            checkBuscar.setChecked(false);
            checkConcentracion.setChecked(false);
            checkConjuros.setChecked(false);
            checkDesfEscritura.setChecked(false);
            checkDiplomacia.setChecked(false);
            checkDisfraz.setChecked(false);
            checkEnganiar.setChecked(false);
            checkEquilibrio.setChecked(false);
            checkEscapismo.setChecked(false);
            checkEsconderse.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInterpretar1.setChecked(false);
            checkInterpretar2.setChecked(false);
            checkInterpretar3.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkSigilo.setChecked(false);
            checkOficio.setChecked(false);
            checkPiruetas.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkSaberArcano.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberDung.setChecked(false);
            checkSaberGeo.setChecked(false);
            checkSaberHistoria.setChecked(false);
            checkSaberLocal.setChecked(false);
            checkSaberPlanos.setChecked(false);
            checkSaberNat.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaberReligion.setChecked(false);
            checkSanar.setChecked(false);
            checkTasacion.setChecked(false);
            checkObjMagico.setChecked(false);
            checkCuerdas.setChecked(false);

        }else if(clase.equals("Bardo")){

            checkArte.setChecked(true);
            checkIntenciones.setChecked(true);
            checkConcentracion.setChecked(true);
            checkConjuros.setChecked(true);
            checkDesfEscritura.setChecked(true);
            checkDiplomacia.setChecked(true);
            checkDisfraz.setChecked(true);
            checkEnganiar.setChecked(true);
            checkEquilibrio.setChecked(true);
            checkEscapismo.setChecked(true);
            checkEsconderse.setChecked(true);
            checkEscuchar.setChecked(true);
            checkInterpretar1.setChecked(true);
            checkInterpretar2.setChecked(true);
            checkInterpretar3.setChecked(true);
            checkJuegoManos.setChecked(true);
            checkSigilo.setChecked(true);
            checkNadar.setChecked(true);
            checkOficio.setChecked(true);
            checkPiruetas.setChecked(true);
            checkReunirInfo.setChecked(true);
            checkSaberArcano.setChecked(true);
            checkSaberIng.setChecked(true);
            checkSaberDung.setChecked(true);
            checkSaberGeo.setChecked(true);
            checkSaberHistoria.setChecked(true);
            checkSaberLocal.setChecked(true);
            checkSaberPlanos.setChecked(true);
            checkSaberNat.setChecked(true);
            checkSaberNobleza.setChecked(true);
            checkSaberReligion.setChecked(true);
            checkSaltar.setChecked(true);
            checkTasacion.setChecked(true);
            checkTrepar.setChecked(true);
            checkObjMagico.setChecked(true);
            checkIntimidar.setChecked(false);
            checkMontar.setChecked(false);
            checkSuperv.setChecked(false);
            checkAnimales.setChecked(false);
            checkCerradura.setChecked(false);
            checkAvistar.setChecked(false);
            checkBuscar.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkSanar.setChecked(false);
            checkCuerdas.setChecked(false);

        } else if(clase.equals("Clérico")||clase.equals("Clerigo")){

            checkArte.setChecked(true);
            checkConcentracion.setChecked(true);
            checkConjuros.setChecked(true);
            checkDiplomacia.setChecked(true);
            checkOficio.setChecked(true);
            checkSaberArcano.setChecked(true);
            checkSaberHistoria.setChecked(true);
            checkSaberPlanos.setChecked(true);
            checkSaberReligion.setChecked(true);
            checkSanar.setChecked(true);
            checkIntenciones.setChecked(false);
            checkDesfEscritura.setChecked(false);
            checkDisfraz.setChecked(false);
            checkEnganiar.setChecked(false);
            checkEquilibrio.setChecked(false);
            checkEscapismo.setChecked(false);
            checkEsconderse.setChecked(false);
            checkEscuchar.setChecked(false);
            checkInterpretar1.setChecked(false);
            checkInterpretar2.setChecked(false);
            checkInterpretar3.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkSigilo.setChecked(false);
            checkNadar.setChecked(false);
            checkPiruetas.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberDung.setChecked(false);
            checkSaberGeo.setChecked(false);
            checkSaberLocal.setChecked(false);
            checkSaberNat.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaltar.setChecked(false);
            checkTasacion.setChecked(false);
            checkTrepar.setChecked(false);
            checkObjMagico.setChecked(false);
            checkIntimidar.setChecked(false);
            checkMontar.setChecked(false);
            checkSuperv.setChecked(false);
            checkAnimales.setChecked(false);
            checkCerradura.setChecked(false);
            checkAvistar.setChecked(false);
            checkBuscar.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkCuerdas.setChecked(false);

        } else if(clase.equals("Druida")){

            checkArte.setChecked(true);
            checkAvistar.setChecked(true);
            checkConcentracion.setChecked(true);
            checkConjuros.setChecked(true);
            checkDiplomacia.setChecked(true);
            checkEscuchar.setChecked(true);
            checkMontar.setChecked(true);
            checkNadar.setChecked(true);
            checkOficio.setChecked(true);
            checkSaberNat.setChecked(true);
            checkSanar.setChecked(true);
            checkSuperv.setChecked(true);
            checkAnimales.setChecked(true);
            checkSaberArcano.setChecked(false);
            checkSaberHistoria.setChecked(false);
            checkSaberPlanos.setChecked(false);
            checkSaberReligion.setChecked(false);
            checkIntenciones.setChecked(false);
            checkDesfEscritura.setChecked(false);
            checkDisfraz.setChecked(false);
            checkEnganiar.setChecked(false);
            checkEquilibrio.setChecked(false);
            checkEscapismo.setChecked(false);
            checkEsconderse.setChecked(false);
            checkInterpretar1.setChecked(false);
            checkInterpretar2.setChecked(false);
            checkInterpretar3.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkSigilo.setChecked(false);
            checkPiruetas.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberDung.setChecked(false);
            checkSaberGeo.setChecked(false);
            checkSaberLocal.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaltar.setChecked(false);
            checkTasacion.setChecked(false);
            checkTrepar.setChecked(false);
            checkObjMagico.setChecked(false);
            checkIntimidar.setChecked(false);
            checkCerradura.setChecked(false);
            checkBuscar.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkCuerdas.setChecked(false);

        } else if(clase.equals("Hechicero")){

            checkArte.setChecked(true);
            checkConcentracion.setChecked(true);
            checkConjuros.setChecked(true);
            checkEnganiar.setChecked(true);
            checkOficio.setChecked(true);
            checkAvistar.setChecked(true);
            checkDiplomacia.setChecked(true);
            checkEscuchar.setChecked(true);
            checkMontar.setChecked(true);
            checkNadar.setChecked(true);
            checkSaberArcano.setChecked(true);
            checkSaberNat.setChecked(false);
            checkSanar.setChecked(false);
            checkSuperv.setChecked(false);
            checkAnimales.setChecked(false);
            checkSaberHistoria.setChecked(false);
            checkSaberPlanos.setChecked(false);
            checkSaberReligion.setChecked(false);
            checkIntenciones.setChecked(false);
            checkDesfEscritura.setChecked(false);
            checkDisfraz.setChecked(false);
            checkEquilibrio.setChecked(false);
            checkEscapismo.setChecked(false);
            checkEsconderse.setChecked(false);
            checkInterpretar1.setChecked(false);
            checkInterpretar2.setChecked(false);
            checkInterpretar3.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkSigilo.setChecked(false);
            checkPiruetas.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberDung.setChecked(false);
            checkSaberGeo.setChecked(false);
            checkSaberLocal.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaltar.setChecked(false);
            checkTasacion.setChecked(false);
            checkTrepar.setChecked(false);
            checkObjMagico.setChecked(false);
            checkIntimidar.setChecked(false);
            checkCerradura.setChecked(false);
            checkBuscar.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkCuerdas.setChecked(false);

        }else if(clase.equals("Mago")){

            checkArte.setChecked(true);
            checkConcentracion.setChecked(true);
            checkConjuros.setChecked(true);
            checkDesfEscritura.setChecked(true);
            checkOficio.setChecked(true);
            checkSaberHistoria.setChecked(true);
            checkSaberPlanos.setChecked(true);
            checkSaberReligion.setChecked(true);
            checkSaberIng.setChecked(true);
            checkSaberDung.setChecked(true);
            checkSaberGeo.setChecked(true);
            checkSaberLocal.setChecked(true);
            checkSaberNobleza.setChecked(true);
            checkSaberArcano.setChecked(true);
            checkSaberNat.setChecked(true);
            checkEnganiar.setChecked(false);
            checkAvistar.setChecked(false);
            checkDiplomacia.setChecked(false);
            checkEscuchar.setChecked(false);
            checkMontar.setChecked(false);
            checkNadar.setChecked(false);
            checkSanar.setChecked(false);
            checkSuperv.setChecked(false);
            checkAnimales.setChecked(false);
            checkIntenciones.setChecked(false);
            checkDisfraz.setChecked(false);
            checkEquilibrio.setChecked(false);
            checkEscapismo.setChecked(false);
            checkEsconderse.setChecked(false);
            checkInterpretar1.setChecked(false);
            checkInterpretar2.setChecked(false);
            checkInterpretar3.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkSigilo.setChecked(false);
            checkPiruetas.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkSaltar.setChecked(false);
            checkTasacion.setChecked(false);
            checkTrepar.setChecked(false);
            checkObjMagico.setChecked(false);
            checkIntimidar.setChecked(false);
            checkCerradura.setChecked(false);
            checkBuscar.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkCuerdas.setChecked(false);

        } else if(clase.equals("Monje")){

            checkArte.setChecked(true);
            checkIntenciones.setChecked(true);
            checkAvistar.setChecked(true);
            checkConcentracion.setChecked(true);
            checkDiplomacia.setChecked(true);
            checkEquilibrio.setChecked(true);
            checkEscapismo.setChecked(true);
            checkEsconderse.setChecked(true);
            checkEscuchar.setChecked(true);
            checkInterpretar1.setChecked(true);
            checkInterpretar2.setChecked(true);
            checkInterpretar3.setChecked(true);
            checkSigilo.setChecked(true);
            checkNadar.setChecked(true);
            checkOficio.setChecked(true);
            checkPiruetas.setChecked(true);
            checkSaberArcano.setChecked(true);
            checkSaberReligion.setChecked(true);
            checkSaltar.setChecked(true);
            checkTrepar.setChecked(true);
            checkConjuros.setChecked(false);
            checkDesfEscritura.setChecked(false);
            checkSaberHistoria.setChecked(false);
            checkSaberPlanos.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberDung.setChecked(false);
            checkSaberGeo.setChecked(false);
            checkSaberLocal.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaberNat.setChecked(false);
            checkEnganiar.setChecked(false);
            checkMontar.setChecked(false);
            checkSanar.setChecked(false);
            checkSuperv.setChecked(false);
            checkAnimales.setChecked(false);
            checkDisfraz.setChecked(false);
            checkJuegoManos.setChecked(false);
            checkReunirInfo.setChecked(false);
            checkTasacion.setChecked(false);
            checkObjMagico.setChecked(false);
            checkIntimidar.setChecked(false);
            checkCerradura.setChecked(false);
            checkBuscar.setChecked(false);
            checkFalsificar.setChecked(false);
            checkInutilizarMeq.setChecked(false);
            checkCuerdas.setChecked(false);

        }else if(clase.equals("Paladín")){

            checkCerradura.setChecked(true);
            checkArte.setChecked(true);
            checkIntenciones.setChecked(true);
            checkAvistar.setChecked(true);
            checkBuscar.setChecked(true);
            checkDesfEscritura.setChecked(true);
            checkDiplomacia.setChecked(true);
            checkDisfraz.setChecked(true);
            checkEnganiar.setChecked(true);
            checkEquilibrio.setChecked(true);
            checkEscapismo.setChecked(true);
            checkEsconderse.setChecked(true);
            checkEscuchar.setChecked(true);
            checkFalsificar.setChecked(true);
            checkInterpretar1.setChecked(true);
            checkInterpretar2.setChecked(true);
            checkInterpretar3.setChecked(true);
            checkIntimidar.setChecked(true);
            checkInutilizarMeq.setChecked(true);
            checkJuegoManos.setChecked(true);
            checkSigilo.setChecked(true);
            checkNadar.setChecked(true);
            checkOficio.setChecked(true);
            checkPiruetas.setChecked(true);
            checkReunirInfo.setChecked(true);
            checkSaberLocal.setChecked(true);
            checkSaltar.setChecked(true);
            checkTasacion.setChecked(true);
            checkTrepar.setChecked(true);
            checkObjMagico.setChecked(true);
            checkCuerdas.setChecked(true);
            checkConcentracion.setChecked(false);
            checkMontar.setChecked(false);
            checkSaberNobleza.setChecked(false);
            checkSaberReligion.setChecked(false);
            checkSanar.setChecked(false);
            checkAnimales.setChecked(false);
            checkSaberArcano.setChecked(false);
            checkConjuros.setChecked(false);
            checkSaberHistoria.setChecked(false);
            checkSaberPlanos.setChecked(false);
            checkSaberIng.setChecked(false);
            checkSaberDung.setChecked(false);
            checkSaberGeo.setChecked(false);
            checkSaberNat.setChecked(false);
            checkSuperv.setChecked(false);
        }

        checkArte.setClickable(false);
        checkIntimidar.setClickable(false);
        checkMontar.setClickable(false);
        checkNadar.setClickable(false);
        checkSaltar.setClickable(false);
        checkAnimales.setClickable(false);
        checkTrepar.setClickable(false);
        checkCerradura.setClickable(false);
        checkIntenciones.setClickable(false);
        checkAvistar.setClickable(false);
        checkBuscar.setClickable(false);
        checkConcentracion.setClickable(false);
        checkConjuros.setClickable(false);
        checkDesfEscritura.setClickable(false);
        checkDiplomacia.setClickable(false);
        checkDisfraz.setClickable(false);
        checkEnganiar.setClickable(false);
        checkEquilibrio.setClickable(false);
        checkEscapismo.setClickable(false);
        checkEsconderse.setClickable(false);
        checkEscuchar.setClickable(false);
        checkFalsificar.setClickable(false);
        checkInterpretar1.setClickable(false);
        checkInterpretar2.setClickable(false);
        checkInterpretar3.setClickable(false);
        checkInutilizarMeq.setClickable(false);
        checkJuegoManos.setClickable(false);
        checkSigilo.setClickable(false);
        checkOficio.setClickable(false);
        checkPiruetas.setClickable(false);
        checkReunirInfo.setClickable(false);
        checkSaberArcano.setClickable(false);
        checkSaberIng.setClickable(false);
        checkSaberDung.setClickable(false);
        checkSaberGeo.setClickable(false);
        checkSaberHistoria.setClickable(false);
        checkSaberLocal.setClickable(false);
        checkSaberPlanos.setClickable(false);
        checkSaberNat.setClickable(false);
        checkSaberNobleza.setClickable(false);
        checkSaberReligion.setClickable(false);
        checkSanar.setClickable(false);
        checkSuperv.setClickable(false);
        checkTasacion.setClickable(false);
        checkObjMagico.setClickable(false);
        checkCuerdas.setClickable(false);
    }

    private void modificarPuntosHabilidad(int control){

        db = dbHelper.getReadableDatabase();
        Cursor c;

        switch (control) {

            case 1: //Cerradura

            c = db
                    .rawQuery("SELECT _id, ptsHab, cerradura, cerraduraCarac, cerraduraRango, cerraduraVarios FROM personaje WHERE controlAct='1'", null);

            if (c.moveToFirst()) {
                do {

                    aux_id = c.getString(0);
                    aux_pts_hab = c.getString(1);
                    aux_total = c.getString(2);
                    aux_modificador = c.getString(3);
                    aux_rango = c.getString(4);
                    aux_varios = c.getString(5);

                } while (c.moveToNext());
            }

            dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);

            break;

            case 2: //Arte

                c = db
                        .rawQuery("SELECT _id, ptsHab, arte, arteCarac, arteRango, arteVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;
            case 3: //Intenciones

                c = db
                        .rawQuery("SELECT _id, ptsHab, intenciones, intencionesCarac, intencionesRango, intencionesVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 4: //Avistar

                c = db
                        .rawQuery("SELECT _id, ptsHab, avistar, avistarCarac, avistarRango, avistarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 5: //Buscar

                c = db
                        .rawQuery("SELECT _id, ptsHab, buscar, buscarCarac, buscarRango, buscarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 6: //Concentracion

                c = db
                        .rawQuery("SELECT _id, ptsHab, concentracion, concentracionCarac, concentracionRango, concentracionVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 7: //Conjuros

                c = db
                        .rawQuery("SELECT _id, ptsHab, conjuros, conjurosCarac, conjurosRango, conjurosVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 8: //Escritura

                c = db
                        .rawQuery("SELECT _id, ptsHab, escritura, escrituraCarac, escrituraRango, escrituraVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 9: //Diplomacia

                c = db
                        .rawQuery("SELECT _id, ptsHab, diplomacia, diplomaciaCarac, diplomaciaRango, diplomaciaVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 10: //Disfraz

                c = db
                        .rawQuery("SELECT _id, ptsHab, disfraz, disfrazCarac, disfrazRango, disfrazVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 11: //Engañar

                c = db
                        .rawQuery("SELECT _id, ptsHab, enganio, enganioCarac, enganioRango, enganioVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 12: //Equilibrio

                c = db
                        .rawQuery("SELECT _id, ptsHab, equilibrio, equilibrioCarac, equilibrioRango, equilibrioVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 13: //Escapismo

                c = db
                        .rawQuery("SELECT _id, ptsHab, escapismo, escapismoCarac, escapismoRango, escapismoVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 14: //Esconderse

                c = db
                        .rawQuery("SELECT _id, ptsHab, esconderse, esconderseCarac, esconderseRango, esconderseVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 15: //Escuchar

                c = db
                        .rawQuery("SELECT _id, ptsHab, escuchar, escucharCarac, escucharRango, escucharVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 16: //Falsificar

                c = db
                        .rawQuery("SELECT _id, ptsHab, falsificar, falsificarCarac, falsificarRango, falsificarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 17: //Interepretar1

                c = db
                        .rawQuery("SELECT _id, ptsHab, interpretar1, interpretar1Carac, interpretar1Rango, interpretar1Varios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 18: //Interepretar2

                c = db
                        .rawQuery("SELECT _id, ptsHab, interpretar2, interpretar2Carac, interpretar2Rango, interpretar2Varios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 19: //Interepretar3

                c = db
                        .rawQuery("SELECT _id, ptsHab, interpretar3, interpretar3Carac, interpretar3Rango, interpretar3Varios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 20: //Intimidar

                c = db
                        .rawQuery("SELECT _id, ptsHab, intimidar, intimidarCarac, intimidarRango, intimidarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 21: //Mecanismo

                c = db
                        .rawQuery("SELECT _id, ptsHab, mecanismo, mecanismoCarac, mecanismoRango, mecanismoVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 22: //Manos

                c = db
                        .rawQuery("SELECT _id, ptsHab, manos, manosCarac, mmanosRango, manosVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 23: //Montar

                c = db
                        .rawQuery("SELECT _id, ptsHab, montar, montarCarac, montarRango, montarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 24: //Sigilo

                c = db
                        .rawQuery("SELECT _id, ptsHab, sigilo, sigiloCarac, sigiloRango, sigiloVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 25: //Nadar

                c = db
                        .rawQuery("SELECT _id, ptsHab, nadar, nadarCarac, nadarRango, nadarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 26: //Oficio

                c = db
                        .rawQuery("SELECT _id, ptsHab, oficio, oficioCarac, oficioRango, oficioVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 27: //Piruetas

                c = db
                        .rawQuery("SELECT _id, ptsHab, piruetas, piruetasCarac, piruetasRango, piruetasVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 28: //Info

                c = db
                        .rawQuery("SELECT _id, ptsHab, info, infoCarac, infoRango, infoVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 29: //Arcano

                c = db
                        .rawQuery("SELECT _id, ptsHab, arcano, arcanoCarac, arcanoRango, arcanoVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 30: //Arquitectura

                c = db
                        .rawQuery("SELECT _id, ptsHab, arquitectura, arqCarac, arqRango, arqVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 31: //Dungeons

                c = db
                        .rawQuery("SELECT _id, ptsHab, dungeons, dungeonsCarac, dungeonsRango, dungeonsVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 32: //Geografía

                c = db
                        .rawQuery("SELECT _id, ptsHab, geografia, geoCarac, geoRango, geoVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 33: //Historia

                c = db
                        .rawQuery("SELECT _id, ptsHab, historia, historiaCarac, historiaRango, historiaVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 34: //Local

                c = db
                        .rawQuery("SELECT _id, ptsHab, local, localCarac, localRango, localVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 35: //Planos

                c = db
                        .rawQuery("SELECT _id, ptsHab, planos, planosCarac, planosRango, planosVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 36: //Naturaleza

                c = db
                        .rawQuery("SELECT _id, ptsHab, naturaleza, naturalCarac, naturalRango, naturalVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 37: //Nobleza

                c = db
                        .rawQuery("SELECT _id, ptsHab, nobleza, noblezaCarac, noblezaRango, noblezaVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 38: //Religión

                c = db
                        .rawQuery("SELECT _id, ptsHab, religion, religionCarac, religionRango, religionVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 39: //Saltar

                c = db
                        .rawQuery("SELECT _id, ptsHab, saltar, saltarCarac, saltarRango, saltarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 40: //Sanar

                c = db
                        .rawQuery("SELECT _id, ptsHab, sanar, sanarCarac, sanarRango, sanarVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 41: //Supervicencia

                c = db
                        .rawQuery("SELECT _id, ptsHab, supervivencia, supervivenciaCarac, supervivenciaRango, supervivenciaVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 42: //Tasacion

                c = db
                        .rawQuery("SELECT _id, ptsHab, tasacion, tasacionCarac, tasacionRango, tasacionVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 43: //Animales

                c = db
                        .rawQuery("SELECT _id, ptsHab, animales, animalesCarac, animalesRango, animalesVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 44: //Trepar

                c = db
                        .rawQuery("SELECT _id, ptsHab, trepar, treparCarac, treparRango, treparVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 45: //Objeto Magico

                c = db
                        .rawQuery("SELECT _id, ptsHab, objetoMagico, objMagCarac, objMagRango, objMagVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;

            case 46: //Cuerdas

                c = db
                        .rawQuery("SELECT _id, ptsHab, cuerdas, cuerdasCarac, cuerdasRango, cuerdasVarios FROM personaje WHERE controlAct='1'", null);

                if (c.moveToFirst()) {
                    do {

                        aux_id = c.getString(0);
                        aux_pts_hab = c.getString(1);
                        aux_total = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango = c.getString(4);
                        aux_varios = c.getString(5);

                    } while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);
                break;
        }
    }


    private void dialogModificarHabilidades(String title, String modificador, String rangos, String valor_varios, final int control, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_modificadores_habilidades, null);
        builder.setView(viewInflated);

        final TextView textViewTitle   = viewInflated.findViewById(R.id.tvTitleHabilidades);
        final EditText editTextModCar  = viewInflated.findViewById(R.id.editTextModCaracHab);
        final EditText editTextRangos  = viewInflated.findViewById(R.id.editTextRangos);
        final EditText editTextVarios  = viewInflated.findViewById(R.id.editTextModVariosHab);

        textViewTitle.setText(title);
        builder.setCancelable(true);

//        editTextModCar.setText(modificador);
//        editTextRangos.setText(rangos);
//        editTextVarios.setText(valor_varios);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                final String modif  = editTextModCar.getText().toString();
                final String rango  = editTextRangos.getText().toString();
                final String varios = editTextVarios.getText().toString();

                if(modif.equals("")||rango.equals("")||varios.equals("")){
                    return;
                }

                final String total = devolverSumaDePuntos(modif, rango, varios);

                ContentValues values = new ContentValues();

                switch (control){

                    case 1:
                        values.put("cerradura", total);
                        values.put("cerraduraCarac", modif);
                        values.put("cerraduraRango", rango);
                        values.put("cerraduraVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnCerradura.setText(total);
                        break;


                    case 2:
                        values.put("arte", total);
                        values.put("arteCarac", modif);
                        values.put("arteRango", rango);
                        values.put("arteVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnArte.setText(total);
                        break;

                    case 3:
                        values.put("intenciones", total);
                        values.put("intencionesCarac", modif);
                        values.put("intencionesRango", rango);
                        values.put("intencionesVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnIntenciones.setText(total);
                        break;

                    case 4:
                        values.put("avistar", total);
                        values.put("avistarCarac", modif);
                        values.put("avistarRango", rango);
                        values.put("avistarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnAvistar.setText(total);
                        break;

                    case 5:
                        values.put("buscar", total);
                        values.put("buscarCarac", modif);
                        values.put("buscarRango", rango);
                        values.put("buscarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnBuscar.setText(total);
                        break;

                    case 6:
                        values.put("concentracion", total);
                        values.put("concentracionCarac", modif);
                        values.put("concentracionRango", rango);
                        values.put("concentracionVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnConcentracion.setText(total);
                        break;

                    case 7:
                        values.put("conjuros", total);
                        values.put("conjurosCarac", modif);
                        values.put("conjurosRango", rango);
                        values.put("conjurosVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnConjuros.setText(total);
                        break;

                    case 8:
                        values.put("escritura", total);
                        values.put("escrituraCarac", modif);
                        values.put("escrituraRango", rango);
                        values.put("escrituraVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnDesfEscritura.setText(total);
                        break;

                    case 9:
                        values.put("diplomacia", total);
                        values.put("diplomaciaCarac", modif);
                        values.put("diplomaciaRango", rango);
                        values.put("diplomaciaVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnDiplomacia.setText(total);
                        break;

                    case 10:
                        values.put("disfraz", total);
                        values.put("disfrazCarac", modif);
                        values.put("disfrazRango", rango);
                        values.put("disfrazVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnDisfraz.setText(total);
                        break;

                    case 11:
                        values.put("enganio", total);
                        values.put("enganioCarac", modif);
                        values.put("enganioRango", rango);
                        values.put("enganioVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnEnganiar.setText(total);
                        break;

                    case 12:
                        values.put("equilibrio", total);
                        values.put("equilibrioCarac", modif);
                        values.put("equilibrioRango", rango);
                        values.put("equilibrioVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnEquilibrio.setText(total);
                        break;

                    case 13:
                        values.put("escapismo", total);
                        values.put("escapismoCarac", modif);
                        values.put("escapismoRango", rango);
                        values.put("escapismoVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnEscapismo.setText(total);
                        break;

                    case 14:
                        values.put("esconderse", total);
                        values.put("esconderseCarac", modif);
                        values.put("esconderseRango", rango);
                        values.put("esconderseVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnEsconderse.setText(total);
                        break;

                    case 15:
                        values.put("escuchar", total);
                        values.put("escucharCarac", modif);
                        values.put("escucharRango", rango);
                        values.put("escucharVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnEscuchar.setText(total);
                        break;

                    case 16:
                        values.put("falsificar", total);
                        values.put("falsificarCarac", modif);
                        values.put("falsificarRango", rango);
                        values.put("falsificarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnFalsificar.setText(total);
                        break;

                    case 17:
                        values.put("interpretar1", total);
                        values.put("interpretar1Carac", modif);
                        values.put("interpretar1Rango", rango);
                        values.put("interpretar1Varios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnInterpretar1.setText(total);
                        break;

                    case 18:
                        values.put("interpretar2", total);
                        values.put("interpretar2Carac", modif);
                        values.put("interpretar2Rango", rango);
                        values.put("interpretar2Varios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnInterpretar2.setText(total);
                        break;

                    case 19:
                        values.put("interpretar3", total);
                        values.put("interpretar3Carac", modif);
                        values.put("interpretar3Rango", rango);
                        values.put("interpretar3Varios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnInterpretar3.setText(total);
                        break;

                    case 20:
                        values.put("intimidar", total);
                        values.put("intimidarCarac", modif);
                        values.put("intimidarRango", rango);
                        values.put("intimidarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnIntimidar.setText(total);
                        break;

                    case 21:
                        values.put("mecanismo", total);
                        values.put("mecanismoCarac", modif);
                        values.put("mecanismoRango", rango);
                        values.put("mecanismoVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnInutilizarMec.setText(total);
                        break;

                    case 22:
                        values.put("manos", total);
                        values.put("manosCarac", modif);
                        values.put("manosRango", rango);
                        values.put("manosVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnJuegoManos.setText(total);
                        break;

                    case 23:
                        values.put("montar", total);
                        values.put("montarCarac", modif);
                        values.put("montarRango", rango);
                        values.put("montarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnMontar.setText(total);
                        break;

                    case 24:
                        values.put("sigilo", total);
                        values.put("sigiloCarac", modif);
                        values.put("sigiloRango", rango);
                        values.put("sigiloVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSigilo.setText(total);
                        break;

                    case 25:
                        values.put("nadar", total);
                        values.put("nadarCarac", modif);
                        values.put("nadarRango", rango);
                        values.put("nadarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnNadar.setText(total);
                        break;

                    case 26:
                        values.put("oficio", total);
                        values.put("oficioCarac", modif);
                        values.put("oficioRango", rango);
                        values.put("oficioVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnOficio.setText(total);
                        break;

                    case 27:
                        values.put("piruetas", total);
                        values.put("piruetasCarac", modif);
                        values.put("piruetasRango", rango);
                        values.put("piruetasVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnPiruetas.setText(total);
                        break;

                    case 28:
                        values.put("info", total);
                        values.put("infoCarac", modif);
                        values.put("infoRango", rango);
                        values.put("infoVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnReunirInfo.setText(total);
                        break;

                    case 29:
                        values.put("arcano", total);
                        values.put("arcanoCarac", modif);
                        values.put("arcanoRango", rango);
                        values.put("arcanoVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberArcano.setText(total);
                        break;

                    case 30:
                        values.put("arquitectura", total);
                        values.put("arqCarac", modif);
                        values.put("arqRango", rango);
                        values.put("arqVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberIng.setText(total);
                        break;

                    case 31:
                        values.put("dungeons", total);
                        values.put("dungeonsCarac", modif);
                        values.put("dungeonsRango", rango);
                        values.put("dungeonsVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberDung.setText(total);
                        break;

                    case 32:
                        values.put("geografia", total);
                        values.put("geoCarac", modif);
                        values.put("geoRango", rango);
                        values.put("geoVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberGeo.setText(total);
                        break;

                    case 33:
                        values.put("historia", total);
                        values.put("historiaCarac", modif);
                        values.put("historiaRango", rango);
                        values.put("historiaVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberHistoria.setText(total);
                        break;

                    case 34:
                        values.put("local", total);
                        values.put("localCarac", modif);
                        values.put("localRango", rango);
                        values.put("localVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberLocal.setText(total);
                        break;

                    case 35:
                        values.put("planos", total);
                        values.put("planosCarac", modif);
                        values.put("planosRango", rango);
                        values.put("planosVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberPlanos.setText(total);
                        break;

                    case 36:
                        values.put("naturaleza", total);
                        values.put("naturalCarac", modif);
                        values.put("naturalRango", rango);
                        values.put("naturalVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberNat.setText(total);
                        break;

                    case 37:
                        values.put("nobleza", total);
                        values.put("noblezaCarac", modif);
                        values.put("noblezaRango", rango);
                        values.put("noblezaVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberNobleza.setText(total);
                        break;

                    case 38:
                        values.put("religion", total);
                        values.put("religionCarac", modif);
                        values.put("religionRango", rango);
                        values.put("religionVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaberReligion.setText(total);
                        break;

                    case 39:
                        values.put("saltar", total);
                        values.put("saltarCarac", modif);
                        values.put("saltarRango", rango);
                        values.put("saltarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSaltar.setText(total);
                        break;

                    case 40:
                        values.put("sanar", total);
                        values.put("sanarCarac", modif);
                        values.put("sanarRango", rango);
                        values.put("sanarVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSanar.setText(total);
                        break;

                    case 41:
                        values.put("supervivencia", total);
                        values.put("supervivenciaCarac", modif);
                        values.put("supervivenciaRango", rango);
                        values.put("supervivenciaVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnSuperv.setText(total);
                        break;

                    case 42:
                        values.put("tasacion", total);
                        values.put("tasacionCarac", modif);
                        values.put("tasacionRango", rango);
                        values.put("tasacionVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnTasacion.setText(total);
                        break;

                    case 43:
                        values.put("animales", total);
                        values.put("animalesCarac", modif);
                        values.put("animalesRango", rango);
                        values.put("animalesVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnAnimales.setText(total);
                        break;

                    case 44:
                        values.put("trepar", total);
                        values.put("treparCarac", modif);
                        values.put("treparRango", rango);
                        values.put("treparVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnTrepar.setText(total);
                        break;

                    case 45:
                        values.put("objetoMagico", total);
                        values.put("objMagCarac", modif);
                        values.put("objMagRango", rango);
                        values.put("objMagVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnObjMagico.setText(total);
                        break;

                    case 46:
                        values.put("cuerdas", total);
                        values.put("cuerdasCarac", modif);
                        values.put("cuerdasRango", rango);
                        values.put("cuerdasVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnCuerdas.setText(total);
                        break;
                }

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private String devolverSumaDePuntos(String numero1, String numero2, String numero3){

        String total;

        int result;
        int number1 = Integer.parseInt(numero1);
        int number2 = Integer.parseInt(numero2);
        int number3 = Integer.parseInt(numero3);

        result = number1 + number2 + number3;

        total = String.valueOf(result);

        return total;

    }


}
