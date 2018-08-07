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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.n3twork.ddcharacters.Adapters.EquipoAdaptador;
import com.n3twork.ddcharacters.Clases.Equipo;
import com.n3twork.ddcharacters.Clases.OtrosEquipos;
import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

import java.sql.BatchUpdateException;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipFragment extends Fragment {

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    private FloatingActionButton armaFab, armaduraFab, escudoFab, otrosFab;
    private String[] opciones_armas = new String[]{"Arma 1", "Arma 2", "Arma 3", "Arma 4", "Arma 5"};
    private String[] opciones_escudo = new String[]{"Escudo/Obj. protector 2", "Obj. protector 3", "Obj. protector 4"};
    private String[] opciones_posesiones = new String[]{"Borrar"};

    private TextView textViewArma1, textViewDanio1, textViewCritico1, textViewTipo1, textViewPeso1, textViewAlcance1, textViewNotas1, textViewMunicion1;
    private ProgressBar progressBarMunicion1;

    private TextView textViewArma2, textViewDanio2, textViewCritico2, textViewTipo2, textViewPeso2, textViewAlcance2, textViewNotas2, textViewMunicion2;
    private ProgressBar progressBarMunicion2, progressBarMunicion3, progressBarMunicion4, progressBarMunicion5;

    private TextView textViewArma3, textViewDanio3, textViewCritico3, textViewTipo3, textViewPeso3, textViewAlcance3, textViewNotas3, textViewMunicion3;
    private TextView textViewArma4, textViewDanio4, textViewCritico4, textViewTipo4, textViewPeso4, textViewAlcance4, textViewNotas4, textViewMunicion4;
    private TextView textViewArma5, textViewDanio5, textViewCritico5, textViewTipo5, textViewPeso5, textViewAlcance5, textViewNotas5, textViewMunicion5;

    private TextView textViewArmadura, textViewCA, textViewDesMax, textViewTipoArmadura, textViewPesoArmadura,
            textViewPenalizador, textViewVelocidadArm, textViewFalloConj, textViewPropEsp;

    private TextView textViewEscudo, textViewEscudoCA, textViewEscudoDesMax, textViewFalloConjEsc, textViewPenalizadorEsc,
            textViewPropEspEsc, textViewPesoEsc;

    private TextView textViewObjProtector3, textViewObjCA3, textViewObjPeso3, textViewPropEspObj3;
    private TextView textViewObjProtector4, textViewObjCA4, textViewObjPeso4, textViewPropEspObj4;

    private TextView textViewCargaLigera, textViewCargaMedia, textViewCargaPesada, textViewCargaCabeza, textViewCargaSuelo, textViewCargaEmpArr;

    private EquipoAdaptador equipoAdaptador;

    private ListView listViewOtrasPosesiones;

    private Button buttonMunicion, buttonMunicion2, buttonMunicion3, buttonMunicion4, buttonMunicion5, buttonCopper, buttonPlata, buttonOro, buttonPlatino;

    private TextView tvIdentOtrosEquipo;

    private String aux_id = "";
    private String aux_arma1 = "";
    private String aux_danio1 = "";
    private String aux_critico1 = "";
    private String aux_tipo1 = "";
    private String aux_peso1 = "";
    private String aux_alcance1 = "";
    private String aux_notas1 = "";
    private String aux_municion1 = "";
    private String aux_arma2 = "";
    private String aux_danio2 = "";
    private String aux_critico2 = "";
    private String aux_tipo2 = "";
    private String aux_peso2 = "";
    private String aux_alcance2 = "";
    private String aux_notas2 = "";
    private String aux_municion2 = "";
    private String aux_arma3 = "";
    private String aux_danio3 = "";
    private String aux_critico3 = "";
    private String aux_tipo3 = "";
    private String aux_peso3 = "";
    private String aux_alcance3 = "";
    private String aux_notas3 = "";
    private String aux_municion3 = "";
    private String aux_arma4 = "";
    private String aux_danio4 = "";
    private String aux_critico4 = "";
    private String aux_tipo4 = "";
    private String aux_peso4 = "";
    private String aux_alcance4 = "";
    private String aux_notas4 = "";
    private String aux_municion4 = "";
    private String aux_arma5 = "";
    private String aux_danio5 = "";
    private String aux_critico5 = "";
    private String aux_tipo5 = "";
    private String aux_peso5 = "";
    private String aux_alcance5 = "";
    private String aux_notas5 = "";
    private String aux_municion5 = "";
    private String aux_armadura = "";
    private String aux_ca = "";
    private String aux_desMax = "";
    private String aux_tipo = "";
    private String aux_pen = "";
    private String aux_velocidad = "";
    private String aux_peso = "";
    private String aux_fallo = "";
    private String aux_esp = "";
    private String aux_obj2Escudo = "";
    private String aux_obj2Ca = "";
    private String aux_obj2DesMax = "";
    private String aux_obj2Fallo = "";
    private String aux_obj2Pen = "";
    private String aux_obj2Esp = "";
    private String aux_obj2Peso = "";
    private String aux_obj3Obj = "";
    private String aux_obj3Ca = "";
    private String aux_obj3Peso = "";
    private String aux_obj3Esp = "";
    private String aux_obj4Obj = "";
    private String aux_obj4Ca = "";
    private String aux_obj4Peso = "";
    private String aux_obj4Esp = "";
    private String aux_ligero = "";
    private String aux_medio   = "";
    private String aux_pesado = "";
    private String aux_cabeza = "";
    private String aux_suelo   = "";
    private String aux_empujar = "";
    private String aux_pc = "";
    private String aux_pp = "";
    private String aux_po = "";
    private String aux_ppt = "";
    private String aux_fza = "";
    private String aux_ident = "";

    private int control;
    public EquipFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equip, container, false);

        if(view != null) {

            dbHelper                = new DBHelper(getActivity());
            db                      = dbHelper.getWritableDatabase();
            listViewOtrasPosesiones = view.findViewById(android.R.id.list);
            textViewCargaLigera     = view.findViewById(R.id.textViewCargaLigera);
            textViewCargaMedia      = view.findViewById(R.id.textViewCargaMedia);
            textViewCargaPesada     = view.findViewById(R.id.textViewCargaPesada);
            textViewCargaCabeza     = view.findViewById(R.id.textViewCargaCabeza);
            textViewCargaSuelo      = view.findViewById(R.id.textViewCargaSuelo);
            textViewCargaEmpArr     = view.findViewById(R.id.textViewCargaEmpArr);
            armaFab                 = view.findViewById(R.id.armaFab);
            armaduraFab             = view.findViewById(R.id.armaduraFab);
            escudoFab               = view.findViewById(R.id.escudoFab);
            otrosFab                = view.findViewById(R.id.otrosFab);
            textViewArma1           = view.findViewById(R.id.textViewArma);
            textViewDanio1          = view.findViewById(R.id.textViewDaño);
            textViewCritico1        = view.findViewById(R.id.textViewCritico);
            textViewTipo1           = view.findViewById(R.id.textViewTipo);
            textViewPeso1           = view.findViewById(R.id.textViewPeso);
            textViewAlcance1        = view.findViewById(R.id.textViewAlcance);
            textViewNotas1          = view.findViewById(R.id.textViewNotas);
            textViewMunicion1       = view.findViewById(R.id.textViewMunicion1);
            progressBarMunicion1    = view.findViewById(R.id.progressBarMunicion1);
            buttonMunicion          = view.findViewById(R.id.buttonMunicion);
            textViewArma2           = view.findViewById(R.id.textViewArmaII);
            textViewDanio2          = view.findViewById(R.id.textViewDañoII);
            textViewCritico2        = view.findViewById(R.id.textViewCriticoII);
            textViewTipo2           = view.findViewById(R.id.textViewTipoII);
            textViewPeso2           = view.findViewById(R.id.textViewPesoII);
            textViewAlcance2        = view.findViewById(R.id.textViewAlcanceII);
            textViewNotas2          = view.findViewById(R.id.textViewNotasII);
            textViewMunicion2       = view.findViewById(R.id.textViewMunicion2);
            progressBarMunicion2    = view.findViewById(R.id.progressBarMunicion2);
            textViewArma3           = view.findViewById(R.id.textViewArmaIII);
            textViewDanio3          = view.findViewById(R.id.textViewDañoIII);
            textViewCritico3        = view.findViewById(R.id.textViewCriticoIII);
            textViewTipo3           = view.findViewById(R.id.textViewTipoIII);
            textViewPeso3           = view.findViewById(R.id.textViewPesoIII);
            textViewAlcance3        = view.findViewById(R.id.textViewAlcanceIII);
            textViewNotas3          = view.findViewById(R.id.textViewNotasIII);
            textViewMunicion3       = view.findViewById(R.id.textViewMunicion3);
            progressBarMunicion3    = view.findViewById(R.id.progressBarMunicion3);
            textViewArma4           = view.findViewById(R.id.textViewArmaIV);
            textViewDanio4          = view.findViewById(R.id.textViewDañoIV);
            textViewCritico4        = view.findViewById(R.id.textViewCriticoIV);
            textViewTipo4           = view.findViewById(R.id.textViewTipoIV);
            textViewPeso4           = view.findViewById(R.id.textViewPesoIV);
            textViewAlcance4        = view.findViewById(R.id.textViewAlcanceIV);
            textViewNotas4          = view.findViewById(R.id.textViewNotasIV);
            textViewMunicion4       = view.findViewById(R.id.textViewMunicion4);
            progressBarMunicion4    = view.findViewById(R.id.progressBarMunicion4);
            textViewArma5           = view.findViewById(R.id.textViewArmaV);
            textViewDanio5          = view.findViewById(R.id.textViewDañoV);
            textViewCritico5        = view.findViewById(R.id.textViewCriticoV);
            textViewTipo5           = view.findViewById(R.id.textViewTipoV);
            textViewPeso5           = view.findViewById(R.id.textViewPesoV);
            textViewAlcance5        = view.findViewById(R.id.textViewAlcanceV);
            textViewNotas5          = view.findViewById(R.id.textViewNotasV);
            textViewMunicion5       = view.findViewById(R.id.textViewMunicion5);
            progressBarMunicion5    = view.findViewById(R.id.progressBarMunicion5);
            textViewEscudo          = view.findViewById(R.id.textViewEscudo);
            textViewEscudoCA        = view.findViewById(R.id.textViewEscudoCA);
            textViewEscudoDesMax    = view.findViewById(R.id.textViewEscudoDesMax);
            textViewFalloConjEsc    = view.findViewById(R.id.textViewFalloConjEsc);
            textViewPenalizadorEsc  = view.findViewById(R.id.textViewPenalizadorEsc);
            textViewPropEspEsc      = view.findViewById(R.id.textViewPropEspEsc);
            textViewPesoEsc         = view.findViewById(R.id.textViewPesoEsc);
            textViewObjProtector3   = view.findViewById(R.id.textViewObjProtector3);
            textViewObjCA3          = view.findViewById(R.id.textViewObjCA3);
            textViewObjPeso3        = view.findViewById(R.id.textViewObjPeso3);
            textViewPropEspObj3     = view.findViewById(R.id.textViewPropEspObj3);
            textViewObjProtector4   = view.findViewById(R.id.textViewObjProtector4);
            textViewObjCA4          = view.findViewById(R.id.textViewObjCA4);
            textViewObjPeso4        = view.findViewById(R.id.textViewObjPeso4);
            textViewPropEspObj4     = view.findViewById(R.id.textViewPropEspObj4);
            buttonMunicion2         = view.findViewById(R.id.buttonMunicion2);
            buttonMunicion3         = view.findViewById(R.id.buttonMunicion3);
            buttonMunicion4         = view.findViewById(R.id.buttonMunicion4);
            buttonMunicion5         = view.findViewById(R.id.buttonMunicion5);
            buttonCopper            = view.findViewById(R.id.buttonCopper);
            buttonPlata             = view.findViewById(R.id.buttonPlata);
            buttonOro               = view.findViewById(R.id.buttonOro);
            buttonPlatino           = view.findViewById(R.id.buttonPlatino);
            textViewArmadura        = view.findViewById(R.id.textViewArmadura);
            textViewCA              = view.findViewById(R.id.textViewCA);
            textViewDesMax          = view.findViewById(R.id.textViewDesMax);
            textViewTipoArmadura    = view.findViewById(R.id.textViewTipoArmadura);
            textViewPenalizador     = view.findViewById(R.id.textViewPenalizador);
            textViewVelocidadArm    = view.findViewById(R.id.textViewVelocidadArm);
            textViewPesoArmadura    = view.findViewById(R.id.textViewPesoArmadura);
            textViewFalloConj       = view.findViewById(R.id.textViewFalloConj);
            textViewPropEsp         = view.findViewById(R.id.textViewPropEsp);


            //Metodo para recuperar la atencion del listView para poder scrollear
            listViewOtrasPosesiones.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);

                    return false;
                }
            });

            aux_id = recuperarIDpersonaje();

            recuperarTodosLosEquipos(aux_id);

            cargasSegunFuerza();

            buttonMunicion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 1;
                    dialogButtonMunicion("  Modificar munición", control, aux_id);
                }
            });

            buttonMunicion2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 2;
                    dialogButtonMunicion("  Modificar munición", control, aux_id);
                }
            });

            buttonMunicion3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 3;
                    dialogButtonMunicion("  Modificar munición", control, aux_id);
                }
            });

            buttonMunicion4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 4;
                    dialogButtonMunicion("  Modificar munición", control, aux_id);
                }
            });

            buttonMunicion5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 5;
                    dialogButtonMunicion("  Modificar munición", control, aux_id);
                }
            });

            armaFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFabArmas(opciones_armas, aux_id);
                }
            });

            armaduraFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFabArmadura("  Modificar armadura" , aux_id);
                }
            });

            escudoFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFabEscudo(opciones_escudo, aux_id);
                }
            });

            otrosFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFabOtros( "  Otras posesiones", aux_id);
                }
            });

            buttonCopper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 1;
                    dialogAgregarTesoro("  Modificar tesoro", control, aux_id, "Bronce");
                }
            });

            buttonPlata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 2;
                    dialogAgregarTesoro("  Modificar tesoro", control, aux_id, "Plata");
                }
            });

            buttonOro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 3;
                    dialogAgregarTesoro("  Modificar tesoro", control, aux_id, "Oro");
                }
            });

            buttonPlatino.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 4;
                    dialogAgregarTesoro("  Modificar tesoro", control, aux_id, "Platino");
                }
            });

        }

        return view;
    }

    private void recuperarTodosLosEquipos(String id){

        try{

            db = dbHelper.getReadableDatabase();
            Cursor c = db
                    .rawQuery("SELECT * FROM equipo WHERE _id='" + id + "'",null);

            if(c.moveToFirst()){

                do{
                    aux_arma1      = c.getString(1 );
                    aux_danio1     = c.getString(2 );
                    aux_critico1   = c.getString(3 );
                    aux_tipo1      = c.getString(4 );
                    aux_peso1      = c.getString(5 );
                    aux_alcance1   = c.getString(6 );
                    aux_notas1     = c.getString(7 );
                    aux_municion1  = c.getString(8 );
                    aux_arma2      = c.getString(9 );
                    aux_danio2     = c.getString(10);
                    aux_critico2   = c.getString(11);
                    aux_tipo2      = c.getString(12);
                    aux_peso2      = c.getString(13);
                    aux_alcance2   = c.getString(14);
                    aux_notas2     = c.getString(15);
                    aux_municion2  = c.getString(16);
                    aux_arma3      = c.getString(17);
                    aux_danio3     = c.getString(18);
                    aux_critico3   = c.getString(19);
                    aux_tipo3      = c.getString(20);
                    aux_peso3      = c.getString(21);
                    aux_alcance3   = c.getString(22);
                    aux_notas3     = c.getString(23);
                    aux_municion3  = c.getString(24);
                    aux_arma4      = c.getString(25);
                    aux_danio4     = c.getString(26);
                    aux_critico4   = c.getString(27);
                    aux_tipo4      = c.getString(28);
                    aux_peso4      = c.getString(29);
                    aux_alcance4   = c.getString(30);
                    aux_notas4     = c.getString(31);
                    aux_municion4  = c.getString(32);
                    aux_arma5      = c.getString(33);
                    aux_danio5     = c.getString(34);
                    aux_critico5   = c.getString(35);
                    aux_tipo5      = c.getString(36);
                    aux_peso5      = c.getString(37);
                    aux_alcance5   = c.getString(38);
                    aux_notas5     = c.getString(39);
                    aux_municion5  = c.getString(40);
                    aux_armadura   = c.getString(41);
                    aux_ca         = c.getString(42);
                    aux_desMax     = c.getString(43);
                    aux_tipo       = c.getString(44);
                    aux_pen        = c.getString(45);
                    aux_velocidad  = c.getString(46);
                    aux_peso       = c.getString(47);
                    aux_fallo      = c.getString(48);
                    aux_esp        = c.getString(49);
                    aux_obj2Escudo = c.getString(50);
                    aux_obj2Ca     = c.getString(51);
                    aux_obj2DesMax = c.getString(52);
                    aux_obj2Fallo  = c.getString(53);
                    aux_obj2Pen    = c.getString(54);
                    aux_obj2Esp    = c.getString(55);
                    aux_obj2Peso   = c.getString(56);
                    aux_obj3Obj    = c.getString(57);
                    aux_obj3Ca     = c.getString(58);
                    aux_obj3Peso   = c.getString(59);
                    aux_obj3Esp    = c.getString(60);
                    aux_obj4Obj    = c.getString(61);
                    aux_obj4Ca     = c.getString(62);
                    aux_obj4Peso   = c.getString(63);
                    aux_obj4Esp    = c.getString(64);
                    aux_ligero     = c.getString(65);
                    aux_medio      = c.getString(66);
                    aux_pesado     = c.getString(67);
                    aux_cabeza     = c.getString(68);
                    aux_suelo      = c.getString(69);
                    aux_empujar    = c.getString(70);
                    aux_pc         = c.getString(71);
                    aux_pp         = c.getString(72);
                    aux_po         = c.getString(73);
                    aux_ppt        = c.getString(74);

                }while (c.moveToNext());

                textViewArma1.setText(aux_arma1);
                textViewDanio1.setText(aux_danio1);
                textViewCritico1.setText(aux_critico1);
                textViewTipo1.setText(aux_tipo1);
                textViewPeso1.setText(aux_peso1);
                textViewAlcance1.setText(aux_alcance1);
                textViewNotas1.setText(aux_notas1);
                textViewMunicion1.setText(aux_municion1);
                textViewArma2.setText(aux_arma2);
                textViewDanio2.setText(aux_danio2);
                textViewCritico2.setText(aux_critico2);
                textViewTipo2.setText(aux_tipo2);
                textViewPeso2.setText(aux_peso2);
                textViewAlcance2.setText(aux_alcance2);
                textViewNotas2.setText(aux_notas2);
                textViewMunicion2.setText(aux_municion2);
                textViewArma3.setText(aux_arma3);
                textViewDanio3.setText(aux_danio3);
                textViewCritico3.setText(aux_critico3);
                textViewTipo3.setText(aux_tipo3);
                textViewPeso3.setText(aux_peso3);
                textViewAlcance3.setText(aux_alcance3);
                textViewNotas3.setText(aux_notas3);
                textViewMunicion3.setText(aux_municion3);
                textViewArma4.setText(aux_arma4);
                textViewDanio4.setText(aux_danio4);
                textViewCritico4.setText(aux_critico4);
                textViewTipo4.setText(aux_tipo4);
                textViewPeso4.setText(aux_peso4);
                textViewAlcance4.setText(aux_alcance4);
                textViewNotas4.setText(aux_notas4);
                textViewMunicion4.setText(aux_municion4);
                textViewArma5.setText(aux_arma5);
                textViewDanio5.setText(aux_danio5);
                textViewCritico5.setText(aux_critico5);
                textViewTipo5.setText(aux_tipo5);
                textViewPeso5.setText(aux_peso5);
                textViewAlcance5.setText(aux_alcance5);
                textViewNotas5.setText(aux_notas5);
                textViewMunicion5.setText(aux_municion5);
                textViewArmadura.setText(aux_armadura);
                textViewCA.setText(aux_ca);
                textViewDesMax.setText(aux_desMax);
                textViewTipoArmadura.setText(aux_tipo);
                textViewPenalizador.setText(aux_pen);
                textViewVelocidadArm.setText(aux_velocidad);
                textViewPesoArmadura.setText(aux_peso);
                textViewFalloConj.setText(aux_fallo);
                textViewPropEsp.setText(aux_esp);
                textViewEscudo.setText(aux_obj2Escudo);
                textViewEscudoCA.setText(aux_obj2Ca);
                textViewEscudoDesMax.setText(aux_obj2DesMax);
                textViewFalloConjEsc.setText(aux_obj2Fallo);
                textViewPenalizadorEsc.setText(aux_obj2Pen);
                textViewPropEspEsc.setText(aux_obj2Esp);
                textViewPesoEsc.setText(aux_obj2Peso);
                textViewObjProtector3.setText(aux_obj3Obj);
                textViewObjCA3.setText(aux_obj3Ca);
                textViewObjPeso3.setText(aux_obj3Peso);
                textViewPropEspObj3.setText(aux_obj3Esp);
                textViewObjProtector4.setText(aux_obj4Obj);
                textViewObjCA4.setText(aux_obj4Ca);
                textViewObjPeso4.setText(aux_obj4Peso);
                textViewPropEspObj4.setText(aux_obj4Esp);
                textViewCargaLigera.setText(aux_ligero);
                textViewCargaMedia.setText(aux_medio);
                textViewCargaPesada.setText(aux_pesado);
                textViewCargaCabeza.setText(aux_cabeza);
                textViewCargaSuelo.setText(aux_suelo);
                textViewCargaEmpArr.setText(aux_empujar);
                buttonCopper.setText(aux_pc);
                buttonPlata.setText(aux_pp);
                buttonOro.setText(aux_po);
                buttonPlatino.setText(aux_ppt);

                progressBarMunicion1.post(new Runnable() {
                    @Override
                    public void run() {

                        progressBarMunicion1.setProgress(Integer.parseInt(textViewMunicion1.getText().toString()));
                        progressBarMunicion2.setProgress(Integer.parseInt(textViewMunicion2.getText().toString()));
                        progressBarMunicion3.setProgress(Integer.parseInt(textViewMunicion3.getText().toString()));
                        progressBarMunicion4.setProgress(Integer.parseInt(textViewMunicion4.getText().toString()));
                        progressBarMunicion5.setProgress(Integer.parseInt(textViewMunicion5.getText().toString()));

                    }
                });

                Cursor cursor = dbHelper.obtenerTodasOtrasPosesiones();

                String[] from = new String[]{
                        "_id",
                        "otrasObjeto",
                        "otrasPagina",
                        "otrasPeso",
                        "otrasValor",
                        "otrasMoneda"
                };

                int[] to = new int[]{
                        R.id.identOtrosEquipo,
                        R.id.textViewObjeto,
                        R.id.textViewPagina,
                        R.id.textViewPeso,
                        R.id.textViewValor,
                        R.id.textViewTipoMoneda
                };

                equipoAdaptador = new EquipoAdaptador(getContext(), cursor, from, to, 0);
                listViewOtrasPosesiones.setAdapter(equipoAdaptador);

                listViewOtrasPosesiones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                        TextView textViewIdentOtrosObjetos = view.findViewById(R.id.identOtrosEquipo);

                        aux_ident = textViewIdentOtrosObjetos.getText().toString();

                        dialogOpcionesListaPosesiones(opciones_posesiones, aux_ident);


                        return true;
                    }
                });


            }


        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        }finally {
            db.close();
        }


    }

    private void dialogOpcionesListaPosesiones(String[] opciones_posesiones, final String aux_ident){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones_posesiones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int pos) {

                if(pos == 0){

                    try {
                        db = dbHelper.getWritableDatabase();
                        db.delete("otrosEquipos", "_id='" + aux_ident + "'", null);
                        recuperarTodosLosEquipos(aux_id);

                    }catch (Exception e){
                        Log.e("Error", "Error: "+e.getMessage());
                    }

                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void dialogFabArmas(String[] opciones_armas, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones_armas, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                switch (position) {

                    case 0:
                        control = 1;
                        dialogFabModificarArma("  Modificar Arma 1", control, aux_id);
                        break;

                    case 1:
                        control = 2;
                        dialogFabModificarArma("  Modificar Arma 2", control, aux_id);
                        break;

                    case 2:
                        control = 3;
                        dialogFabModificarArma("  Modificar Arma 3", control, aux_id);
                        break;

                    case 3:
                        control = 4;
                        dialogFabModificarArma("  Modificar Arma 4", control, aux_id);
                        break;

                    case 4:
                        control = 5;
                        dialogFabModificarArma("  Modificar Arma 5", control, aux_id);
                        break;
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void dialogFabModificarArma(String title, final int control, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_editar_armas, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);
        final TextView textViewTitulo       = viewInflated.findViewById(R.id.tvDialogArmasTitulo);
        final EditText editTextArma         = viewInflated.findViewById(R.id.editTextArma);
        final EditText editTextDanio        = viewInflated.findViewById(R.id.editTextDanio);
        final EditText editTextCritico      = viewInflated.findViewById(R.id.editTextCritico);
        final EditText editTextTipoArma     = viewInflated.findViewById(R.id.editTextTipoArma);
        final EditText editTextPesoArma     = viewInflated.findViewById(R.id.editTextPesoArma);
        final EditText editTextAlcanceArma  = viewInflated.findViewById(R.id.editTextAlcanceArma);
        final EditText editTextNotasArma    = viewInflated.findViewById(R.id.editTextNotasArma);
        final SeekBar  seekBarMunicionArma  = viewInflated.findViewById(R.id.seekBarMunicionArma);
        final TextView textViewMunicionArma = viewInflated.findViewById(R.id.textViewMunicionArma);

        textViewTitulo.setText(title);

        switch (control){

            case 1:

                seekBarMunicionArma.setProgress(Integer.parseInt(textViewMunicion1.getText().toString()));
                textViewMunicionArma.setText(textViewMunicion1.getText().toString());
                break;

            case 2:

                seekBarMunicionArma.setProgress(Integer.parseInt(textViewMunicion2.getText().toString()));
                textViewMunicionArma.setText(textViewMunicion2.getText().toString());
                break;

            case 3:

                seekBarMunicionArma.setProgress(Integer.parseInt(textViewMunicion3.getText().toString()));
                textViewMunicionArma.setText(textViewMunicion3.getText().toString());
                break;

            case 4:

                seekBarMunicionArma.setProgress(Integer.parseInt(textViewMunicion4.getText().toString()));
                textViewMunicionArma.setText(textViewMunicion4.getText().toString());
                break;

            case 5:

                seekBarMunicionArma.setProgress(Integer.parseInt(textViewMunicion5.getText().toString()));
                textViewMunicionArma.setText(textViewMunicion5.getText().toString());
                break;

        }

        seekBarMunicionArma.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progreso = String.valueOf(progressValue);
                textViewMunicionArma.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewMunicionArma.setText(progreso);
            }
        });

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ContentValues values = new ContentValues();

                String arma     = editTextArma.getText().toString();
                String danio    = editTextDanio.getText().toString();
                String critico  = editTextCritico.getText().toString();
                String tipo     = editTextTipoArma.getText().toString();
                String peso     = editTextPesoArma.getText().toString();
                String alcance  = editTextAlcanceArma.getText().toString();
                String notas    = editTextNotasArma.getText().toString();
                String municion = textViewMunicionArma.getText().toString();


                db = dbHelper.getReadableDatabase();

                switch (control){
                    case 1:

                        values.put("arma1Arma",arma);
                        values.put("arma1Danio",danio);
                        values.put("arma1Critico",critico);
                        values.put("arma1Tipo",tipo);
                        values.put("arma1Peso",peso);
                        values.put("arma1Alcance",alcance);
                        values.put("arma1Notas",notas);
                        values.put("arma1Municion",municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        getActivity().recreate();
                        break;

                    case 2:

                        values.put("arma2Arma",arma);
                        values.put("arma2Danio",danio);
                        values.put("arma2Critico",critico);
                        values.put("arma2Tipo",tipo);
                        values.put("arma2Peso",peso);
                        values.put("arma2Alcance",alcance);
                        values.put("arma2Notas",notas);
                        values.put("arma2Municion",municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        getActivity().recreate();
                        break;

                    case 3:

                        values.put("arma3Arma",arma);
                        values.put("arma3Danio",danio);
                        values.put("arma3Critico",critico);
                        values.put("arma3Tipo",tipo);
                        values.put("arma3Peso",peso);
                        values.put("arma3Alcance",alcance);
                        values.put("arma3Notas",notas);
                        values.put("arma3Municion",municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        getActivity().recreate();
                        break;

                    case 4:

                        values.put("arma4Arma",arma);
                        values.put("arma4Danio",danio);
                        values.put("arma4Critico",critico);
                        values.put("arma4Tipo",tipo);
                        values.put("arma4Peso",peso);
                        values.put("arma4Alcance",alcance);
                        values.put("arma4Notas",notas);
                        values.put("arma4Municion",municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        getActivity().recreate();
                        break;


                    case 5:

                        values.put("arma5Arma",arma);
                        values.put("arma5Danio",danio);
                        values.put("arma5Critico",critico);
                        values.put("arma5Tipo",tipo);
                        values.put("arma5Peso",peso);
                        values.put("arma5Alcance",alcance);
                        values.put("arma5Notas",notas);
                        values.put("arma5Municion",municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        getActivity().recreate();
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

    private void dialogButtonMunicion(String title, final int control, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_municion, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView textViewTitleMunicion  = viewInflated.findViewById(R.id.textViewTitleMunicion);
        final SeekBar  seekBarMunicionEditor  = viewInflated.findViewById(R.id.seekBarMunicionEditor);
        final TextView textViewMunicionEditor = viewInflated.findViewById(R.id.textViewMunicionEditor);

        textViewTitleMunicion.setText(title);

        String municion;

        switch (control){
            case 1:

                municion = textViewMunicion1.getText().toString();
                textViewMunicionEditor.setText(municion);

                seekBarMunicionEditor.setProgress(Integer.parseInt(municion));

                seekBarMunicionEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    String progreso;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                        progreso = String.valueOf(progressValue);
                        textViewMunicionEditor.setText(progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textViewMunicionEditor.setText(progreso);
                    }
                });

                break;

            case 2:

                municion = textViewMunicion2.getText().toString();
                textViewMunicionEditor.setText(municion);

                seekBarMunicionEditor.setProgress(Integer.parseInt(municion));

                seekBarMunicionEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    String progreso;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                        progreso = String.valueOf(progressValue);
                        textViewMunicionEditor.setText(progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textViewMunicionEditor.setText(progreso);
                    }
                });

                break;

            case 3:

                municion = textViewMunicion3.getText().toString();
                textViewMunicionEditor.setText(municion);

                seekBarMunicionEditor.setProgress(Integer.parseInt(municion));

                seekBarMunicionEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    String progreso;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                        progreso = String.valueOf(progressValue);
                        textViewMunicionEditor.setText(progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textViewMunicionEditor.setText(progreso);
                    }
                });

                break;

            case 4:

                municion = textViewMunicion4.getText().toString();
                textViewMunicionEditor.setText(municion);

                seekBarMunicionEditor.setProgress(Integer.parseInt(municion));

                seekBarMunicionEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    String progreso;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                        progreso = String.valueOf(progressValue);
                        textViewMunicionEditor.setText(progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textViewMunicionEditor.setText(progreso);
                    }
                });

                break;

            case 5:

                municion = textViewMunicion5.getText().toString();
                textViewMunicionEditor.setText(municion);

                seekBarMunicionEditor.setProgress(Integer.parseInt(municion));

                seekBarMunicionEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    String progreso;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                        progreso = String.valueOf(progressValue);
                        textViewMunicionEditor.setText(progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textViewMunicionEditor.setText(progreso);
                    }
                });

                break;

        }

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String municion;
                ContentValues values = new ContentValues();

                db = dbHelper.getReadableDatabase();

                switch (control) {

                    case 1:

                        municion = textViewMunicionEditor.getText().toString();
                        values.put("arma1Municion", municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);
                        break;

                    case 2:

                        municion = textViewMunicionEditor.getText().toString();
                        values.put("arma2Municion", municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);
                        break;

                    case 3:

                        municion = textViewMunicionEditor.getText().toString();
                        values.put("arma3Municion", municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);
                        break;

                    case 4:

                        municion = textViewMunicionEditor.getText().toString();
                        values.put("arma4Municion", municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);
                        break;

                    case 5:

                        municion = textViewMunicionEditor.getText().toString();
                        values.put("arma5Municion", municion);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);
                        break;


                }

                getActivity().recreate();


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

    private String recuperarIDpersonaje(){

        try{

            db = dbHelper.getReadableDatabase();
            Cursor c = db
                    .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

            if (c.moveToFirst()){

                do {

                    aux_id = c.getString(0);

                }while (c.moveToNext());

            }


        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        }finally {
            db.close();
        }

        return aux_id;

    }

    private void dialogFabArmadura(String title, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_editar_armadura, null);
        builder.setView(viewInflated);

        final TextView textViewTitleArmadura = viewInflated.findViewById(R.id.tvDialogArmaduraTitulo);
        final EditText editTextArmadura      = viewInflated.findViewById(R.id.editTextArmadura);
        final EditText editTextCA            = viewInflated.findViewById(R.id.editTextCA);
        final EditText editTextDesMax        = viewInflated.findViewById(R.id.editTextDestrezaMaximaArmadura);
        final EditText editTextTipo          = viewInflated.findViewById(R.id.editTextTipoArmadura);
        final EditText editTextPen           = viewInflated.findViewById(R.id.editTextPenalizadorArmadura);
        final EditText editTextVelocidad     = viewInflated.findViewById(R.id.editTextVelocidadArmadura);
        final EditText editTextPeso          = viewInflated.findViewById(R.id.editTextPesoArmadura);
        final EditText editTextFallo         = viewInflated.findViewById(R.id.editTextFalloArmadura);
        final EditText editTextEsp           = viewInflated.findViewById(R.id.editTextEspArmadura);

        textViewTitleArmadura.setText(title);

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String armadura  = editTextArmadura.getText().toString();
                String ca        = editTextCA.getText().toString();
                String desMax    = editTextDesMax.getText().toString();
                String tipo      = editTextTipo.getText().toString();
                String pen       = editTextPen.getText().toString();
                String velocidad = editTextVelocidad.getText().toString();
                String peso      = editTextPeso.getText().toString();
                String fallo     = editTextFallo.getText().toString();
                String esp       = editTextEsp.getText().toString();

                db = dbHelper.getReadableDatabase();

                ContentValues values = new ContentValues();

                values.put("armaduraArmadura", armadura);
                values.put("armaduraCA", ca);
                values.put("armaduraDesMax", desMax);
                values.put("armaduraTipo", tipo);
                values.put("armaduraPen", pen);
                values.put("armaduraVelocidad", velocidad);
                values.put("armaduraPeso", peso);
                values.put("armaduraFallo", fallo);
                values.put("armaduraEsp", esp);

                db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                getActivity().recreate();

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

    private void dialogFabEscudo(String[] opciones_escudo, final String aux_id){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setItems(opciones_escudo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                if (position == 0){

                    dialogEscudoObjProtector2("  Modificar escudo/objeto 2", aux_id);

                } else if (position == 1){

                    control = 1;
                    dialogObjProtector("  Objeto 3", aux_id, control);

                } else if (position == 2){

                    control = 2;
                    dialogObjProtector("  Objeto 4", aux_id, control);

                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void dialogEscudoObjProtector2(String title, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_editar_objeto2_escudo, null);
        builder.setView(viewInflated);
        builder.setCancelable(true);

        final TextView textViewTitle        = viewInflated.findViewById(R.id.tvDialogEscudoTitulo);
        final EditText editTextEscudo       = viewInflated.findViewById(R.id.editTextEscudo);
        final EditText editTextCAEscudo     = viewInflated.findViewById(R.id.editTextCAEscudo);
        final EditText editTextDesMaxEscudo = viewInflated.findViewById(R.id.editTextDestrezaMaximaEscudo);
        final EditText editTextFalloEscudo  = viewInflated.findViewById(R.id.editTextFalloEscudo);
        final EditText editTextPenEscudo    = viewInflated.findViewById(R.id.editTextPenEscudo);
        final EditText editTextEspEscudo    = viewInflated.findViewById(R.id.editTextEspEscudo);
        final EditText editTextPesoEscudo   = viewInflated.findViewById(R.id.editTextPesoEscudo);

        textViewTitle.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String escudo = editTextEscudo.getText().toString();
                String ca     = editTextCAEscudo.getText().toString();
                String desMax = editTextDesMaxEscudo.getText().toString();
                String fallo  = editTextFalloEscudo.getText().toString();
                String pen    = editTextPenEscudo.getText().toString();
                String esp    = editTextEspEscudo.getText().toString();
                String peso   = editTextPesoEscudo.getText().toString();

                db = dbHelper.getReadableDatabase();

                ContentValues values = new ContentValues();

                values.put("obj2Escudo", escudo);
                values.put("obj2Ca", ca);
                values.put("obj2DesMax", desMax);
                values.put("obj2Fallo", fallo);
                values.put("obj2Pen", pen);
                values.put("obj2Esp", esp);
                values.put("obj2Peso", peso);

                db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                getActivity().recreate();

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

    private void dialogObjProtector(String title, final String aux_id, final int control){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_editar_objeto3, null);
        builder.setView(viewInflated);
        builder.setCancelable(true);

        final TextView textViewTitle            = viewInflated.findViewById(R.id.tvDialogObjProtectorTitulo);
        final EditText editTextObjProtector     = viewInflated.findViewById(R.id.editTextObjProtector);
        final EditText editTextCAObjProtector   = viewInflated.findViewById(R.id.editTextCAObjProtector);
        final EditText editTextPesoObjProtector = viewInflated.findViewById(R.id.editTextPesoObjProtector);
        final EditText editTextEspObjProtector  = viewInflated.findViewById(R.id.editTextEspObjProtector);

        textViewTitle.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String objProtec = editTextObjProtector.getText().toString();
                String ca        = editTextCAObjProtector.getText().toString();
                String peso      = editTextPesoObjProtector.getText().toString();
                String esp       = editTextEspObjProtector.getText().toString();

                db = dbHelper.getReadableDatabase();

                ContentValues values = new ContentValues();

                if(control == 1) {

                    values.put("obj3Obj", objProtec);
                    values.put("obj3Ca", ca);
                    values.put("obj3Peso", peso);
                    values.put("obj3Esp", esp);

                    db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                } else if(control == 2) {

                    values.put("obj4Obj", objProtec);
                    values.put("obj4Ca", ca);
                    values.put("obj4Peso", peso);
                    values.put("obj4Esp", esp);

                    db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                }

                getActivity().recreate();

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

    private void dialogFabOtros(String title, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fab_otras_posesiones, null);
        builder.setView(viewInflated);
        builder.setCancelable(true);

        final TextView textViewTitle       = viewInflated.findViewById(R.id.tvDialogOtrasTitulo);
        final EditText editTextObjetoOtras = viewInflated.findViewById(R.id.editTextObjetoOtras);
        final EditText editTextPaginaOtras = viewInflated.findViewById(R.id.editTextPaginaOtras);
        final EditText editTextPesoOtras   = viewInflated.findViewById(R.id.editTextPesoOtras);
        final EditText editTextValorOtras  = viewInflated.findViewById(R.id.editTextValorOtras);
        final RadioButton rbPlatino        = viewInflated.findViewById(R.id.rbPlatino);
        final RadioButton rbOro            = viewInflated.findViewById(R.id.rbOro);
        final RadioButton rbPlata          = viewInflated.findViewById(R.id.rbPlata);
        final RadioButton rbBronce         = viewInflated.findViewById(R.id.rbBronce);

        textViewTitle.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String objeto = editTextObjetoOtras.getText().toString();
                String pagina = editTextPaginaOtras.getText().toString();
                String peso   = editTextPesoOtras.getText().toString();
                String valor  = editTextValorOtras.getText().toString();
                String moneda = modificarMonedaSegunRB(rbPlatino, rbOro, rbPlata, rbBronce);
                int id        = Integer.parseInt(aux_id);

                agregarOtrasPosesiones(objeto, pagina, peso, valor, moneda, id);
                recuperarTodosLosEquipos(aux_id);

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

    private String modificarMonedaSegunRB(RadioButton rbPlatino, RadioButton rbOro, RadioButton rbPlata, RadioButton rbBronce){

        String moneda = "";

        if(rbPlatino.isChecked()){

            moneda = "ppt";

        }else if(rbOro.isChecked()){

            moneda = "po";

        }else if(rbPlata.isChecked()){

            moneda = "pp";

        }else if(rbBronce.isChecked()){

            moneda = "pc";

        }

        return moneda;
    }

    private void agregarOtrasPosesiones(String objeto, String pagina, String peso, String valor, String moneda, int id){

        OtrosEquipos otrosEquipos = new OtrosEquipos(objeto, pagina, peso, valor, moneda, id);

        dbHelper = new DBHelper(getContext());

        dbHelper.addOtrosEquipos(otrosEquipos);


    }

    private void dialogAgregarTesoro(String title, final int control, final String aux_id, String moneda){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_agregar_tesoro, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView textViewTitle  = viewInflated.findViewById(R.id.tvTitleTesoro);
        final EditText editTextTesoro = viewInflated.findViewById(R.id.editTextTesoro);
        final TextView textViewTesoro = viewInflated.findViewById(R.id.textViewTesoro);

        textViewTesoro.setText(moneda);
        textViewTitle.setText(title);

        switch (control){

            case 1:

                editTextTesoro.setText(buttonCopper.getText().toString());

                break;

            case 2:

                editTextTesoro.setText(buttonPlata.getText().toString());

                break;

            case 3:

                editTextTesoro.setText(buttonOro.getText().toString());

                break;

            case 4:

                editTextTesoro.setText(buttonPlatino.getText().toString());

                break;

        }


        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String tesoro = editTextTesoro.getText().toString();

                db = dbHelper.getReadableDatabase();

                ContentValues values = new ContentValues();

                switch (control){

                    case 1:

                        values.put("tesoroPc", tesoro);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 2:

                        values.put("tesoroPp", tesoro);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 3:

                        values.put("tesoroPo", tesoro);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 4:

                        values.put("tesoroPpt", tesoro);
                        db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                }

                getActivity().recreate();

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

    public void cargasSegunFuerza(){

        try{

            db = dbHelper.getReadableDatabase();

            Cursor c = db
                    .rawQuery("SELECT puntFza FROM personaje WHERE controlAct='1'",null);

            if(c.moveToFirst()){

                do{

                    aux_fza = c.getString(0);

                }while (c.moveToNext());

            }

            switch (aux_fza){

                case "0":

                    aux_ligero  = "0 lb";
                    aux_medio   = "0 lb";
                    aux_pesado  = "0 lb";
                    aux_cabeza  = "0 lb";
                    aux_suelo   = "0 lb";
                    aux_empujar = "0 lb";

                    break;

                case "1":

                    aux_ligero  = "3 lb";
                    aux_medio   = "6 lb";
                    aux_pesado  = "10 lb";
                    aux_cabeza  = "10 lb";
                    aux_suelo   = "20 lb";
                    aux_empujar = "50 lb";

                    break;

                case "2":

                    aux_ligero  = "6 lb";
                    aux_medio   = "13 lb";
                    aux_pesado  = "20 lb";
                    aux_cabeza  = "20 lb";
                    aux_suelo   = "40 lb";
                    aux_empujar = "100 lb";

                    break;

                case "3":

                    aux_ligero  = "10 lb";
                    aux_medio   = "20 lb";
                    aux_pesado  = "30 lb";
                    aux_cabeza  = "30 lb";
                    aux_suelo   = "60 lb";
                    aux_empujar = "150 lb";

                    break;

                case "4":

                    aux_ligero  = "13 lb";
                    aux_medio   = "26 lb";
                    aux_pesado  = "40 lb";
                    aux_cabeza  = "40 lb";
                    aux_suelo   = "80 lb";
                    aux_empujar = "200 lb";

                    break;

                case "5":

                    aux_ligero  = "16 lb";
                    aux_medio   = "33 lb";
                    aux_pesado  = "50 lb";
                    aux_cabeza  = "50 lb";
                    aux_suelo   = "100 lb";
                    aux_empujar = "250 lb";

                    break;

                case "6":

                   aux_ligero  = "20 lb";
                   aux_medio   = "40 lb";
                   aux_pesado  = "60 lb";
                   aux_cabeza  = "60 lb";
                   aux_suelo   = "120 lb";
                   aux_empujar = "300 lb";

                    break;

                case "7":

                    aux_ligero  = "23 lb";
                    aux_medio   = "46 lb";
                    aux_pesado  = "70 lb";
                    aux_cabeza  = "70 lb";
                    aux_suelo   = "140 lb";
                    aux_empujar = "350 lb";

                    break;

                case "8":

                    aux_ligero  = "26 lb";
                    aux_medio   = "53 lb";
                    aux_pesado  = "80 lb";
                    aux_cabeza  = "80 lb";
                    aux_suelo   = "160 lb";
                    aux_empujar = "400 lb";

                    break;

                case "9":

                    aux_ligero  = "30 lb";
                    aux_medio   = "60 lb";
                    aux_pesado  = "90 lb";
                    aux_cabeza  = "90 lb";
                    aux_suelo   = "180 lb";
                    aux_empujar = "450 lb";

                    break;

                case "10":

                    aux_ligero  = "33 lb";
                    aux_medio   = "66 lb";
                    aux_pesado  = "100 lb";
                    aux_cabeza  = "100 lb";
                    aux_suelo   = "200 lb";
                    aux_empujar = "500 lb";

                    break;

                case "11":

                    aux_ligero  = "38 lb";
                    aux_medio   = "76 lb";
                    aux_pesado  = "115 lb";
                    aux_cabeza  = "115 lb";
                    aux_suelo   = "230 lb";
                    aux_empujar = "575 lb";

                    break;

                case "12":

                    aux_ligero  = "43 lb";
                    aux_medio   = "86 lb";
                    aux_pesado  = "130 lb";
                    aux_cabeza  = "130 lb";
                    aux_suelo   = "260 lb";
                    aux_empujar = "650 lb";

                    break;

                case "13":

                    aux_ligero  = "50 lb";
                    aux_medio   = "100 lb";
                    aux_pesado  = "150 lb";
                    aux_cabeza  = "150 lb";
                    aux_suelo   = "300 lb";
                    aux_empujar = "750 lb";

                    break;

                case "14":

                    aux_ligero  = "58 lb";
                    aux_medio   = "116 lb";
                    aux_pesado  = "175 lb";
                    aux_cabeza  = "175 lb";
                    aux_suelo   = "350 lb";
                    aux_empujar = "875 lb";

                    break;

                case "15":

                    aux_ligero  = "66 lb";
                    aux_medio   = "133 lb";
                    aux_pesado  = "200 lb";
                    aux_cabeza  = "200 lb";
                    aux_suelo   = "400 lb";
                    aux_empujar = "1000 lb";

                    break;

                case "16":

                    aux_ligero  = "76 lb";
                    aux_medio   = "153 lb";
                    aux_pesado  = "230 lb";
                    aux_cabeza  = "230 lb";
                    aux_suelo   = "460 lb";
                    aux_empujar = "1150 lb";

                    break;

                case "17":

                    aux_ligero  = "86 lb";
                    aux_medio   = "173 lb";
                    aux_pesado  = "260 lb";
                    aux_cabeza  = "260 lb";
                    aux_suelo   = "520 lb";
                    aux_empujar = "1300 lb";

                    break;

                case "18":

                    aux_ligero  = "100 lb";
                    aux_medio   = "200 lb";
                    aux_pesado  = "300 lb";
                    aux_cabeza  = "300 lb";
                    aux_suelo   = "600 lb";
                    aux_empujar = "1500 lb";

                    break;

                case "19":

                    aux_ligero  = "116 lb";
                    aux_medio   = "233 lb";
                    aux_pesado  = "350 lb";
                    aux_cabeza  = "350 lb";
                    aux_suelo   = "700 lb";
                    aux_empujar = "1750 lb";

                    break;

                case "20":

                    aux_ligero  = "133 lb";
                    aux_medio   = "266 lb";
                    aux_pesado  = "400 lb";
                    aux_cabeza  = "400 lb";
                    aux_suelo   = "800 lb";
                    aux_empujar = "2000 lb";

                    break;

                case "21":

                    aux_ligero  = "153 lb";
                    aux_medio   = "306 lb";
                    aux_pesado  = "460 lb";
                    aux_cabeza  = "460 lb";
                    aux_suelo   = "920 lb";
                    aux_empujar = "2300 lb";

                    break;

                case "22":

                    aux_ligero  = "173 lb";
                    aux_medio   = "346 lb";
                    aux_pesado  = "520 lb";
                    aux_cabeza  = "520 lb";
                    aux_suelo   = "1040 lb";
                    aux_empujar = "2600 lb";

                    break;

                case "23":

                    aux_ligero  = "200 lb";
                    aux_medio   = "400 lb";
                    aux_pesado  = "600 lb";
                    aux_cabeza  = "600 lb";
                    aux_suelo   = "1200 lb";
                    aux_empujar = "3000 lb";

                    break;

                case "24":

                    aux_ligero  = "233 lb";
                    aux_medio   = "466 lb";
                    aux_pesado  = "700 lb";
                    aux_cabeza  = "700 lb";
                    aux_suelo   = "1400 lb";
                    aux_empujar = "3500 lb";

                    break;

                case "25":

                    aux_ligero  = "266 lb";
                    aux_medio   = "533 lb";
                    aux_pesado  = "800 lb";
                    aux_cabeza  = "800 lb";
                    aux_suelo   = "1600 lb";
                    aux_empujar = "4000 lb";

                    break;

                case "26":

                    aux_ligero  = "306 lb";
                    aux_medio   = "613 lb";
                    aux_pesado  = "920 lb";
                    aux_cabeza  = "920 lb";
                    aux_suelo   = "1840 lb";
                    aux_empujar = "4600 lb";

                    break;

                case "27":

                    aux_ligero  = "346 lb";
                    aux_medio   = "693 lb";
                    aux_pesado  = "1040 lb";
                    aux_cabeza  = "1040 lb";
                    aux_suelo   = "2080 lb";
                    aux_empujar = "5200 lb";

                    break;

                case "28":

                    aux_ligero  = "400 lb";
                    aux_medio   = "800 lb";
                    aux_pesado  = "1200 lb";
                    aux_cabeza  = "1200 lb";
                    aux_suelo   = "2400 lb";
                    aux_empujar = "6000 lb";

                    break;

                case "29":

                    aux_ligero  = "466 lb";
                    aux_medio   = "933 lb";
                    aux_pesado  = "1400 lb";
                    aux_cabeza  = "1400 lb";
                    aux_suelo   = "2800 lb";
                    aux_empujar = "7000 lb";

                    break;

                case "30":

                    aux_ligero  = "500 lb";
                    aux_medio   = "1000 lb";
                    aux_pesado  = "1500 lb";
                    aux_cabeza  = "1500 lb";
                    aux_suelo   = "3000 lb";
                    aux_empujar = "7500 lb";

                    break;

                case "40":

                    aux_ligero  = "2000 lb";
                    aux_medio   = "4000 lb";
                    aux_pesado  = "6000 lb";
                    aux_cabeza  = "12000 lb";
                    aux_suelo   = "30000 lb";
                    aux_empujar = "30000 lb";

                    break;

                case "50":

                    aux_ligero  = "8000 lb";
                    aux_medio   = "16000 lb";
                    aux_pesado  = "24000 lb";
                    aux_cabeza  = "24000 lb";
                    aux_suelo   = "48000 lb";
                    aux_empujar = "120000 lb";

                    break;

            }

            ContentValues values = new ContentValues();

            values.put("pesoLigero", aux_ligero);
            values.put("pesoMedio", aux_medio);
            values.put("pesoPesado", aux_pesado);
            values.put("pesoCabeza", aux_cabeza);
            values.put("pesoSuelo", aux_suelo);
            values.put("pesoArrastrar", aux_empujar);

            db.update("equipo", values, "idPersonaje='" + aux_id + "'", null);


        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }


    }


}
