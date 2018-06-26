package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsFragment extends Fragment {

    private String aux_id = "";
    private String aux_nombre = "";
    private String aux_clase = "";
    private String aux_raza = "";
    private String aux_alineamiento = "";
    private String aux_nivel = "";
    private String aux_deidad = "";
    private String aux_sexo = "";
    private String aux_campaña = "";
    private String aux_experiencia = "";
    private String aux_tamaño = "";
    private String aux_low = "0";
    private String aux_high = "";
    private String aux_controlAct = "";
    private String aux_fza     = "";
    private String aux_des     = "";
    private String aux_con     = "";
    private String aux_int     = "";
    private String aux_sab     = "";
    private String aux_car     = "";
    private String aux_mod_fza = "";
    private String aux_mod_des = "";
    private String aux_mod_con = "";
    private String aux_mod_int = "";
    private String aux_mod_sab = "";
    private String aux_mod_car = "";
    private String aux_pts_hab = "";
    private String aux_pg = "";
    private String aux_velocidad = "";
    private String aux_heridas = "";
    private String aux_ca = "";
    private String aux_toque = "";
    private String aux_iniciativa = "";
    private String aux_desprevenido = "";
    private String aux_ataque = "";
    private String aux_presa = "";
    private String aux_resConjuros = "";
    private String aux_redDanio = "";
    private String aux_bonfAtaque = "";
    private String aux_bonfDistancia = "";
    private String aux_salvFortaleza = "";
    private String aux_salvReflejos = "";
    private String aux_salvVoluntad = "";

    private int control = 0;

    private DBHelper dbHelper = null;
    private SQLiteDatabase db;

    private TextView textViewNombrePj;
    private TextView textViewNivelPj;
    private TextView textViewClase;
    private TextView textViewRaza;
    private TextView textViewAlineamiento;
    private TextView textViewDeidad;
    private TextView textViewTamaño;
    private TextView textViewSexo;
    private TextView textViewCampaña;
    private TextView textViewLow;
    private TextView textViewHigh;
    private TextView textViewExp;
    private TextView TVPuntCaractFza;
    private TextView TVModCaracFza;
    private TextView TVPuntCaractDes;
    private TextView TVModCaractDes;
    private TextView TVPuntCaractCon;
    private TextView TVModCaractCon;
    private TextView TVPuntCaractInt;
    private TextView TVModCaractInt;
    private TextView TVPuntCaractSab;
    private TextView TVModCaractSab;
    private TextView TVPuntCaractCar;
    private TextView TVModCaractCar;
    private TextView textViewPGTotales;
    private TextView textViewVelocidad;
    private TextView textViewHeridas;
    private TextView tvCATotal;
    private TextView tvToque;
    private TextView tvIniciativa;
    private TextView tvDesprevenido;
    private TextView tvAtaque;
    private TextView tvPresa;
    private TextView tvResConjuros;
    private TextView tvRedDanio;
    private TextView tvBonfAtaque;
    private TextView tvBonfDist;
    private TextView tvSalvFortaleza;
    private TextView tvSalvReflejos;
    private TextView tvSalvVoluntad;

    private Button buttonFza, buttonDes, buttonCon, buttonInt, buttonSab, buttonCar, buttonHeridas,
            buttonPG, buttonVelocidad, buttonCA, buttonToque, buttonIniciativa, buttonDesp, buttonATQ,
            buttonPresa, buttonResConj, buttonRedDanio, buttonBonfATQ, buttonBonfDist, buttonFortaleza,
            buttonReflejos, buttonVoluntad;
    private ProgressBar progressBarExp;
    private FloatingActionButton fabExp, fabStats, fabVida, fabAtaque, fabSalvacion;

    private PJFragment pjFragment = new PJFragment();

    private String[] opciones = new String[]{"Nuevo", "Borrar"};


    public StatsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        if(view != null) {

            dbHelper              = new DBHelper(getActivity());
            db                    = dbHelper.getWritableDatabase();

            textViewNombrePj     = view.findViewById(R.id.textViewNombrePj);
            textViewNivelPj      = view.findViewById(R.id.textViewNivelPj);
            textViewClase        = view.findViewById(R.id.textViewClase);
            textViewRaza         = view.findViewById(R.id.textViewRaza);
            textViewAlineamiento = view.findViewById(R.id.textViewAlineamiento);
            textViewDeidad       = view.findViewById(R.id.textViewDeidad);
            textViewTamaño       = view.findViewById(R.id.textViewTamaño);
            textViewSexo         = view.findViewById(R.id.textViewSexo);
            textViewCampaña      = view.findViewById(R.id.textViewCampaña);
            textViewLow          = view.findViewById(R.id.textViewLow);
            textViewHigh         = view.findViewById(R.id.textViewHigh);
            textViewExp          = view.findViewById(R.id.textViewExp);
            TVPuntCaractFza      = view.findViewById(R.id.TVPuntCaractFza);
            TVModCaracFza        = view.findViewById(R.id.TVModCaracFza);
            TVPuntCaractDes      = view.findViewById(R.id.TVPuntCaractDes);
            TVModCaractDes       = view.findViewById(R.id.TVModCaractDes);
            TVPuntCaractCon      = view.findViewById(R.id.TVPuntCaractCon);
            TVModCaractCon       = view.findViewById(R.id.TVModCaractCon);
            TVPuntCaractInt      = view.findViewById(R.id.TVPuntCaractInt);
            TVModCaractInt       = view.findViewById(R.id.TVModCaractInt);
            TVPuntCaractSab      = view.findViewById(R.id.TVPuntCaractSab);
            TVModCaractSab       = view.findViewById(R.id.TVModCaractSab);
            TVPuntCaractCar      = view.findViewById(R.id.TVPuntCaractCar);
            TVModCaractCar       = view.findViewById(R.id.TVModCaractCar);
            textViewPGTotales    = view.findViewById(R.id.textViewPGTotales);
            textViewVelocidad    = view.findViewById(R.id.textViewVelocidad);
            textViewHeridas      = view.findViewById(R.id.textViewHeridas);
            tvCATotal            = view.findViewById(R.id.tvCATotal);
            tvToque              = view.findViewById(R.id.tvToque);
            tvIniciativa         = view.findViewById(R.id.tvIniciativa);
            tvDesprevenido       = view.findViewById(R.id.tvDesp);
            tvAtaque             = view.findViewById(R.id.textViewATQ);
            tvPresa              = view.findViewById(R.id.textViewPresa);
            tvResConjuros        = view.findViewById(R.id.textViewResConj);
            tvRedDanio           = view.findViewById(R.id.textViewRedDaño);
            tvBonfAtaque         = view.findViewById(R.id.textViewBonfATQ);
            tvBonfDist           = view.findViewById(R.id.textViewBonfDist);
            tvSalvFortaleza      = view.findViewById(R.id.textViewFortaleza);
            tvSalvReflejos       = view.findViewById(R.id.textViewReflejos);
            tvSalvVoluntad       = view.findViewById(R.id.textViewVoluntad);

            buttonFza            = view.findViewById(R.id.buttonFue);
            buttonDes            = view.findViewById(R.id.buttonDes);
            buttonCon            = view.findViewById(R.id.buttonCon);
            buttonInt            = view.findViewById(R.id.buttonInt);
            buttonSab            = view.findViewById(R.id.buttonSab);
            buttonCar            = view.findViewById(R.id.buttonCar);
            buttonHeridas        = view.findViewById(R.id.buttonHeridas);
            buttonPG             = view.findViewById(R.id.buttonPG);
            buttonVelocidad      = view.findViewById(R.id.buttonVelocidad);
            buttonCA             = view.findViewById(R.id.buttonCA);
            buttonToque          = view.findViewById(R.id.buttonToque);
            buttonIniciativa     = view.findViewById(R.id.buttonIniciativa);
            buttonDesp           = view.findViewById(R.id.buttonDesp);
            buttonATQ            = view.findViewById(R.id.buttonATQ);
            buttonPresa          = view.findViewById(R.id.buttonPresa);
            buttonResConj        = view.findViewById(R.id.buttonResConj);
            buttonRedDanio       = view.findViewById(R.id.buttonRedDaño);
            buttonBonfATQ        = view.findViewById(R.id.buttonBonfAtq);
            buttonBonfDist       = view.findViewById(R.id.buttonBonfDist);
            buttonFortaleza      = view.findViewById(R.id.buttonaFortaleza);
            buttonReflejos       = view.findViewById(R.id.buttonaReflejos);
            buttonVoluntad       = view.findViewById(R.id.buttonaVoluntad);

            progressBarExp       = view.findViewById(R.id.progressBarExp);
            fabExp               = view.findViewById(R.id.experienciaFab);
            fabStats             = view.findViewById(R.id.statsFab);
            fabVida              = view.findViewById(R.id.vidaFab);
            fabAtaque            = view.findViewById(R.id.ataqueFab);
            fabSalvacion         = view.findViewById(R.id.salvacionFab);

            recuperarEstadisticasPJ();

            fabExp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fabExpMetodo("  Agregar/quitar experiencia");
                }
            });

            fabStats.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fabStatsOpciones(opciones);
                }
            });

            fabVida.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fabVidaOpciones(opciones);
                }
            });

            fabAtaque.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fabAtaqueOpciones(opciones);
                }
            });

            fabSalvacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fabSalvacionOpciones(opciones);
                }
            });

            buttonFza.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editarFuerza("  Modificar fuerza");
                }
            });

            buttonDes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editarDes("  Modificar destreza");
                }
            });
            buttonCon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editarCon("  Modificar constitución");
                }
            });
            buttonInt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editarInt("  Modificar inteligencia");
                }
            });
            buttonSab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editarSab("  Modificar sabiduría");
                }
            });
            buttonCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editarCar("  Modificar carisma");
                }
            });

            buttonHeridas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opcionesParaHeridas(opciones);
                }
            });

            buttonPG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 1;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonVelocidad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 2;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonCA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 3;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonToque.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 4;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonIniciativa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 5;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonDesp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 6;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonATQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 7;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonPresa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 8;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonResConj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 9;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonRedDanio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 10;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonBonfATQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 11;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonBonfDist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 12;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonFortaleza.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 13;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonReflejos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 14;
                    opcionesBotonesSueltos(opciones,control);
                }
            });

            buttonVoluntad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 15;
                    opcionesBotonesSueltos(opciones,control);
                }
            });


        }

        return view;
    }

    public void opcionesBotonesSueltos(String[] opciones, final int control){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){
                    modificarBotonesSueltos("  Nuevos stats", control);

                } else if(position == 1){
                    borrarBotonesSueltos("  Reiniciar stats", "¿Desea reiniciar todos los stats?", control);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void modificarBotonesSueltos(String title, final int control){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_botones_sueltos, null);
        builder.setView(viewInflated);

        final TextView textViewTitle          = viewInflated.findViewById(R.id.tvTitleBotonesSueltos);
        final Button   buttonModificarSueltos = viewInflated.findViewById(R.id.buttonModificarSueltos);
        final EditText editTextPuntos         = viewInflated.findViewById(R.id.editTextPuntos);

        textViewTitle.setText(title);

        String nombreButton;
        String puntos;

        switch (control){

            case 1:
                nombreButton = "PG";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 2:
                nombreButton = "Velocidad";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 3:
                nombreButton = "CA";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 4:
                nombreButton = "Toque";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 5:
                nombreButton = "Iniciativa";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 6:
                nombreButton = "Desprevenido";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 7:
                nombreButton = "ATQ";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 8:
                nombreButton = "PRESA";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 9:
                nombreButton = "R.CO.";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 10:
                nombreButton = "RED DAÑO";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 11:
                nombreButton = "B.ATQ";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 12:
                nombreButton = "BONF DIST";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 13:
                nombreButton = "FORTALEZA";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 14:
                nombreButton = "REFLEJOS";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            case 15:
                nombreButton = "VOLUNTAD";
                buttonModificarSueltos.setText(nombreButton);
                puntos = recuperarPuntoSuelto(control);
                editTextPuntos.setText(puntos);
                break;
            default: nombreButton = "";
                buttonModificarSueltos.setText(nombreButton);
                editTextPuntos.setText("");
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntuacion = editTextPuntos.getText().toString();

                actualizarBotonesSueltosPuntuaciones(control, puntuacion);

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

    public String recuperarPuntoSuelto(int control){

        String devolver = "";

        try{
            dbHelper = new DBHelper(getActivity());
            db = dbHelper.getReadableDatabase();

            switch (control) {
                case 1:
                    Cursor a = db
                            .rawQuery("SELECT _id, pg FROM personaje WHERE controlAct='1'",null);

                    if(a.moveToFirst()){

                        do {
                            aux_id = a.getString(0);
                            aux_pg = a.getString(1);

                        }while (a.moveToNext());
                    }

                    break;

                case 2:
                    Cursor b = db
                            .rawQuery("SELECT _id, velocidad FROM personaje WHERE controlAct='1'",null);

                    if(b.moveToFirst()){

                        do {
                            aux_id        = b.getString(0);
                            aux_velocidad = b.getString(1);
                            devolver = aux_velocidad;

                        }while (b.moveToNext());
                    }

                    break;

                case 3:
                    Cursor c = db
                            .rawQuery("SELECT _id, ca FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()){

                        do {
                            aux_id        = c.getString(0);
                            aux_ca = c.getString(1);
                            devolver = aux_ca;

                        }while (c.moveToNext());
                    }

                    break;

                case 4:
                    Cursor d = db
                            .rawQuery("SELECT _id, toque FROM personaje WHERE controlAct='1'",null);

                    if(d.moveToFirst()){

                        do {
                            aux_id    = d.getString(0);
                            aux_toque = d.getString(1);
                            devolver = aux_toque;

                        }while (d.moveToNext());
                    }

                    break;

                case 5:
                    Cursor e = db
                            .rawQuery("SELECT _id, iniciativa FROM personaje WHERE controlAct='1'",null);

                    if(e.moveToFirst()){

                        do {
                            aux_id    = e.getString(0);
                            aux_iniciativa = e.getString(1);
                            devolver = aux_iniciativa;

                        }while (e.moveToNext());
                    }

                    break;

                case 6:
                    Cursor f = db
                            .rawQuery("SELECT _id, desprevenido FROM personaje WHERE controlAct='1'",null);

                    if(f.moveToFirst()){

                        do {
                            aux_id    = f.getString(0);
                            aux_desprevenido = f.getString(1);
                            devolver = aux_desprevenido;

                        }while (f.moveToNext());
                    }

                    break;
                case 7:
                    Cursor g = db
                            .rawQuery("SELECT _id, ataque FROM personaje WHERE controlAct='1'",null);

                    if(g.moveToFirst()){

                        do {
                            aux_id     = g.getString(0);
                            aux_ataque = g.getString(1);
                            devolver = aux_ataque;

                        }while (g.moveToNext());
                    }

                    break;
                case 8:
                    Cursor h = db
                            .rawQuery("SELECT _id, presa FROM personaje WHERE controlAct='1'",null);

                    if(h.moveToFirst()){

                        do {
                            aux_id    = h.getString(0);
                            aux_presa = h.getString(1);
                            devolver = aux_presa;

                        }while (h.moveToNext());
                    }

                    break;
                case 9:
                    Cursor i = db
                            .rawQuery("SELECT _id, resConjuros FROM personaje WHERE controlAct='1'",null);

                    if(i.moveToFirst()){

                        do {
                            aux_id    = i.getString(0);
                            aux_resConjuros = i.getString(1);
                            devolver = aux_resConjuros;

                        }while (i.moveToNext());
                    }

                    break;
                case 10:
                    Cursor j = db
                            .rawQuery("SELECT _id, redDanio FROM personaje WHERE controlAct='1'",null);

                    if(j.moveToFirst()){

                        do {
                            aux_id    = j.getString(0);
                            aux_redDanio = j.getString(1);
                            devolver = aux_redDanio;

                        }while (j.moveToNext());
                    }

                    break;
                case 11:
                    Cursor k = db
                            .rawQuery("SELECT _id, bonfAtaque FROM personaje WHERE controlAct='1'",null);

                    if(k.moveToFirst()){

                        do {
                            aux_id    = k.getString(0);
                            aux_bonfAtaque = k.getString(1);
                            devolver = aux_bonfAtaque;

                        }while (k.moveToNext());
                    }

                    break;
                case 12:
                    Cursor l = db
                            .rawQuery("SELECT _id, bonfDistancia FROM personaje WHERE controlAct='1'",null);

                    if(l.moveToFirst()){

                        do {
                            aux_id    = l.getString(0);
                            aux_bonfDistancia = l.getString(1);
                            devolver = aux_bonfDistancia;

                        }while (l.moveToNext());
                    }

                    break;
                case 13:
                    Cursor m = db
                            .rawQuery("SELECT _id, salvFortaleza FROM personaje WHERE controlAct='1'",null);

                    if(m.moveToFirst()){

                        do {
                            aux_id    = m.getString(0);
                            aux_salvFortaleza = m.getString(1);
                            devolver = aux_salvFortaleza;

                        }while (m.moveToNext());
                    }

                    break;
                case 14:
                    Cursor n = db
                            .rawQuery("SELECT _id, salvReflejos FROM personaje WHERE controlAct='1'",null);

                    if(n.moveToFirst()){

                        do {
                            aux_id    = n.getString(0);
                            aux_salvReflejos = n.getString(1);
                            devolver = aux_salvReflejos;

                        }while (n.moveToNext());
                    }

                    break;
                case 15:
                    Cursor o = db
                            .rawQuery("SELECT _id, salvVoluntad FROM personaje WHERE controlAct='1'",null);

                    if(o.moveToFirst()){

                        do {
                            aux_id    = o.getString(0);
                            aux_salvVoluntad = o.getString(1);
                            devolver = aux_salvVoluntad;

                        }while (o.moveToNext());
                    }

                    break;
            }

        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }
        return devolver;
    }

    public void actualizarBotonesSueltosPuntuaciones(int control, String puntuacion){

        ContentValues values = new ContentValues();

        try{

            dbHelper = new DBHelper(getActivity());
            db = dbHelper.getReadableDatabase();

            Cursor c = db
                    .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

            if(c.moveToFirst()){

                do {
                    aux_id = c.getString(0);


                }while (c.moveToNext());
            }

            switch (control) {
                case 1:
                    values.put("pg",puntuacion);
                    break;
                case 2:
                    values.put("velocidad",puntuacion);
                    break;
                case 3:
                    values.put("ca",puntuacion);
                    break;
                case 4:
                    values.put("toque",puntuacion);
                    break;
                case 5:
                    values.put("iniciativa",puntuacion);
                    break;
                case 6:
                    values.put("desprevenido",puntuacion);
                    break;
                case 7:
                    values.put("ataque",puntuacion);
                    break;
                case 8:
                    values.put("presa",puntuacion);
                    break;
                case 9:
                    values.put("resConjuros",puntuacion);
                    break;
                case 10:
                    values.put("redDanio",puntuacion);
                    break;
                case 11:
                    values.put("bonfAtaque",puntuacion);
                    break;
                case 12:
                    values.put("bonfDistancia",puntuacion);
                    break;
                case 13:
                    values.put("salvFortaleza",puntuacion);
                    break;
                case 14:
                    values.put("salvReflejos",puntuacion);
                    break;
                case 15:
                    values.put("salvVoluntad",puntuacion);
                    break;
            }

            db.update("personaje", values, "_id='" + aux_id + "'", null);
            getActivity().recreate();

        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }

    }

    public void borrarBotonesSueltos(String title, String message, int control){

        ContentValues values = new ContentValues();

        try{

            dbHelper = new DBHelper(getActivity());
            db = dbHelper.getReadableDatabase();

            Cursor c = db
                    .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

            if(c.moveToFirst()){

                do {
                    aux_id = c.getString(0);


                }while (c.moveToNext());
            }

            switch (control) {
                case 1:
                    values.put("pg","0");
                    break;

                case 2:
                    values.put("velocidad","0");
                    break;

                case 3:
                    values.put("ca","0");
                    break;

                case 4:
                    values.put("toque","0");
                    break;

                case 5:
                    values.put("iniciativa","0");
                    break;

                case 6:
                    values.put("desprevenido","0");
                    break;
                case 7:
                    values.put("ataque","0");
                    break;
                case 8:
                    values.put("presa","0");
                    break;
                case 9:
                    values.put("resConjuros","0");
                    break;
                case 10:
                    values.put("redDanio","0");
                    break;
                case 11:
                    values.put("bonfAtaque","0");
                    break;
                case 12:
                    values.put("bonfDistancia","0");
                    break;
                case 13:
                    values.put("salvFortaleza","0");
                    break;
                case 14:
                    values.put("salvReflejos","0");
                    break;
                case 15:
                    values.put("salvVoluntad","0");
                    break;
            }

            db.update("personaje", values, "_id='" + aux_id + "'", null);
            getActivity().recreate();

        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }

    }


    /**
     * Método que recupera todos los stats del personaje
     *
     * ----->....Falta agregar muchos....<-----
     *
     *
     */

    public void recuperarEstadisticasPJ(){

        try {

            db = dbHelper.getReadableDatabase();
            Cursor c = db
                    .rawQuery("SELECT * FROM personaje WHERE controlAct='1'", null);

            if(c.moveToFirst()){
                do{

                    aux_id            = c.getString(0);
                    aux_nombre        = c.getString(1);
                    aux_clase         = c.getString(2);
                    aux_nivel         = c.getString(3);
                    aux_raza          = c.getString(4);
                    aux_alineamiento  = c.getString(5);
                    aux_deidad        = c.getString(6);
                    aux_tamaño        = c.getString(7);
                    aux_sexo          = c.getString(8);
                    aux_experiencia   = c.getString(9);
                    aux_low           = c.getString(10);
                    aux_high          = c.getString(11);
                    aux_campaña       = c.getString(12);
                    aux_controlAct    = c.getString(13);
                    aux_fza           = c.getString(14);
                    aux_des           = c.getString(15);
                    aux_con           = c.getString(16);
                    aux_int           = c.getString(17);
                    aux_sab           = c.getString(18);
                    aux_car           = c.getString(19);
                    aux_mod_fza       = c.getString(20);
                    aux_mod_des       = c.getString(21);
                    aux_mod_con       = c.getString(22);
                    aux_mod_int       = c.getString(23);
                    aux_mod_sab       = c.getString(24);
                    aux_mod_car       = c.getString(25);
                    aux_pts_hab       = c.getString(26);
                    aux_pg            = c.getString(27);
                    aux_velocidad     = c.getString(28);
                    aux_heridas       = c.getString(29);
                    aux_ca            = c.getString(30);
                    aux_toque         = c.getString(31);
                    aux_iniciativa    = c.getString(32);
                    aux_desprevenido  = c.getString(33);
                    aux_ataque        = c.getString(34);
                    aux_presa         = c.getString(35);
                    aux_resConjuros   = c.getString(36);
                    aux_redDanio      = c.getString(37);
                    aux_bonfAtaque    = c.getString(38);
                    aux_bonfDistancia = c.getString(39);
                    aux_salvFortaleza = c.getString(40);
                    aux_salvReflejos  = c.getString(41);
                    aux_salvVoluntad  = c.getString(42);


                }while (c.moveToNext());

                textViewNombrePj.setText(aux_nombre);
                textViewNivelPj.setText("Nivel "+aux_nivel);
                textViewClase.setText(aux_clase);
                textViewRaza.setText(aux_raza);
                textViewAlineamiento.setText(aux_alineamiento);
                textViewDeidad.setText(aux_deidad);
                textViewTamaño.setText(aux_tamaño);
                textViewSexo.setText(aux_sexo);
                textViewCampaña.setText(aux_campaña);
                textViewLow.setText(aux_low);
                textViewHigh.setText(aux_high);
                textViewExp.setText(aux_experiencia);
                TVPuntCaractFza.setText(aux_fza);
                TVModCaracFza.setText(aux_mod_fza);
                TVPuntCaractDes.setText(aux_des);
                TVModCaractDes.setText(aux_mod_des);
                TVPuntCaractCon.setText(aux_con);
                TVModCaractCon.setText(aux_mod_con);
                TVPuntCaractInt.setText(aux_int);
                TVModCaractInt.setText(aux_mod_int);
                TVPuntCaractSab.setText(aux_sab);
                TVModCaractSab.setText(aux_mod_sab);
                TVPuntCaractCar.setText(aux_car);
                TVModCaractCar.setText(aux_mod_car);
                textViewPGTotales.setText(aux_pg);
                textViewVelocidad.setText(aux_velocidad);
                textViewHeridas.setText(aux_heridas);
                tvCATotal.setText(aux_ca);
                tvToque.setText(aux_toque);
                tvIniciativa.setText(aux_iniciativa);
                tvDesprevenido.setText(aux_desprevenido);
                tvAtaque.setText(aux_ataque);
                tvPresa.setText(aux_presa);
                tvResConjuros.setText(aux_resConjuros);
                tvRedDanio.setText(aux_redDanio);
                tvBonfAtaque.setText(aux_bonfAtaque);
                tvBonfDist.setText(aux_bonfDistancia);
                tvSalvFortaleza.setText(aux_salvFortaleza);
                tvSalvReflejos.setText(aux_salvReflejos);
                tvSalvVoluntad.setText(aux_salvVoluntad);

                //Refrescar la progressBar
                progressBarExp.post(new Runnable() {
                    @Override
                    public void run() {

                        if(!aux_nombre.equals("")){

                            int exp = Integer.parseInt(aux_experiencia);
                            int high = Integer.parseInt(aux_high);

                            if (exp == high) {

                                progressBarExp.setProgress(0);

                            } else if (exp == high / 2) {

                                progressBarExp.setProgress(50);

                            } else {

                                exp = (exp * 100) / high;
                                progressBarExp.setProgress(exp);

                            }
                        } else {
                            progressBarExp.setProgress(0);
                        }
                    }
                });

            }

        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        } finally {
            db.close();
        }
    }

    /**
     * Método del FAB de experiencia
     *
     * @param title
     */

    public void fabExpMetodo(final String title){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fab_experiencia, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog       = viewInflated.findViewById(R.id.textViewTitleDialogFabExp);
        final EditText editTextDialogExperiencia = viewInflated.findViewById(R.id.editTextDialogExperiencia);

        textViewTitleDialog.setText(title);

        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String addExp = editTextDialogExperiencia.getText().toString();
                if(!addExp.isEmpty()) {
                    int addEXPInt = Integer.parseInt(addExp);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db.rawQuery("SELECT _id, nivelPj, expPj, expLow, expHigh FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {
                                aux_id = c.getString(0);
                                aux_nivel = c.getString(1);
                                aux_experiencia = c.getString(2);
                                aux_low = c.getString(3);
                                aux_high = c.getString(4);

                                int experiencia = Integer.parseInt(aux_experiencia);
                                experiencia = experiencia + addEXPInt;
                                aux_experiencia = String.valueOf(experiencia);

                                int high = Integer.parseInt(aux_high);

                                if (verificarNivelExpAlSumar(high, experiencia)) {

                                    //Subo un nivel
                                    int nivel = Integer.parseInt(aux_nivel);
                                    nivel = nivel + 1;
                                    aux_nivel = String.valueOf(nivel);

                                    //Verifico si la exp = 0 o exp > high

                                    if (aux_experiencia.equals(aux_high)) {

                                        aux_experiencia = "0";

                                    } else if (experiencia > high) {

                                        experiencia = experiencia - high;
                                        aux_experiencia = String.valueOf(experiencia);

                                    }

                                    //Cambio el high
                                    aux_high = pjFragment.cambiarHighSegunNivel(aux_nivel);
                                    //Agrego los cambios a la base de datos

                                    ContentValues values = new ContentValues();
                                    values.put("nivelPj", aux_nivel);
                                    values.put("expPj", aux_experiencia);
                                    values.put("expLow", aux_low);
                                    values.put("expHigh", aux_high);
                                    db.update("personaje", values, "_id='" + aux_id + "'", null);
                                    getActivity().recreate();

                                } else {

                                    //Agrego los cambios a la base de datos
                                    ContentValues values = new ContentValues();
                                    values.put("expPj", aux_experiencia);
                                    db.update("personaje", values, "_id='" + aux_id + "'", null);
                                    getActivity().recreate();
                                }

                            } while (c.moveToNext());

                        }


                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                }else{
                    Toast.makeText(getContext(),"Inserte la experiencia",Toast.LENGTH_SHORT).show();
                    fabExpMetodo("  Agregar/quitar experiencia");
                }
            }
        });

        builder.setNegativeButton("Quitar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String dismExp = editTextDialogExperiencia.getText().toString();
                if(!dismExp.isEmpty()) {
                    int dismEXPInt = Integer.parseInt(dismExp);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db.rawQuery("SELECT _id, nivelPj, expPj, expLow, expHigh FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {
                                aux_id = c.getString(0);
                                aux_nivel = c.getString(1);
                                aux_experiencia = c.getString(2);
                                aux_low = c.getString(3);
                                aux_high = c.getString(4);

                                int experiencia = Integer.parseInt(aux_experiencia);
                                experiencia = experiencia - dismEXPInt;
                                aux_experiencia = String.valueOf(experiencia);

                                if (verificarNivelExpAlRestar(aux_low, experiencia)) {

                                    aux_experiencia = aux_low;
                                    //Agrego los cambios a la base de datos

                                    ContentValues values = new ContentValues();
                                    values.put("expPj", aux_experiencia);
                                    db.update("personaje", values, "_id='" + aux_id + "'", null);
                                    getActivity().recreate();

                                } else {

                                    //Agrego los cambios a la base de datos
                                    ContentValues values = new ContentValues();
                                    values.put("expPj", aux_experiencia);
                                    db.update("personaje", values, "_id='" + aux_id + "'", null);
                                    getActivity().recreate();
                                }

                            } while (c.moveToNext());
                        }

                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Inserte la experiencia",Toast.LENGTH_SHORT).show();
                    fabExpMetodo("  Agregar/quitar experiencia");
                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Método que verifica si al agregar Experiencia, subís de nivel.
     *
     * @param aux_high
     * @param experiencia
     * @return
     */

    public Boolean verificarNivelExpAlSumar(int aux_high, int experiencia){

        return experiencia >= aux_high;

    }

    /**
     * Método que controla no restar nivel al restar Exp.
     *
     * @param aux_low
     * @param experiencia
     * @return
     */

    public Boolean verificarNivelExpAlRestar(String aux_low, int experiencia){

        int low = Integer.parseInt(aux_low);

        return experiencia <= low;

    }

    public void fabStatsOpciones(String[] opciones_stats){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones_stats, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){
                    fabStatsNuevo("  Nuevos stats");

                } else if(position == 1){
                    fabStatsBorrar("  Reiniciar stats", "¿Desea reiniciar todos los stats?");
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * Dialog de opciones para el FAB de vida.
     *
     * @param opciones
     */

    public void fabVidaOpciones(String[] opciones){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                if(position == 0){
                    fabVidaNuevo("  Nuevos stats");

                } else if(position == 1){
                    fabVidaBorrar(" Reiniciar stats", "¿Desea reiniciar todos los stats?");
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * Dialog de opciones para el FAB de ataque.
     *
     * @param opciones
     */

    public void fabAtaqueOpciones(String[] opciones){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                if(position == 0){
                    fabAtaqueNuevo("  Nuevos stats");

                } else if(position == 1){
                    fabAtaqueBorrar(" Reiniciar stats", "¿Desea reiniciar todos los stats?");
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void fabSalvacionOpciones(String[] opciones){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                if(position == 0){
                    fabSalvacionNuevo("  Nuevos stats");

                } else if(position == 1){
                    fabSalvacionBorrar(" Reiniciar stats", "¿Desea reiniciar todos los stats?");
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * Método que reinicia a 0 todos los stats
     *
     * @param title
     * @param message
     */

    public void fabStatsBorrar(String title, String message){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if(title !=null){
            builder.setTitle(title);
        }

        if(message !=null){
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {

                    db = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id, puntFza, puntDes, puntCon, puntInt, puntSab, puntCar, modFza, modDes, modCon, modInt, modSab, modCar FROM personaje WHERE controlAct='1'", null);

                    if (c.moveToFirst()) {

                        do {

                            aux_id = c.getString(0);

                            ContentValues values = new ContentValues();
                            values.put("puntFza", "0");
                            values.put("puntDes", "0");
                            values.put("puntCon", "0");
                            values.put("puntInt", "0");
                            values.put("puntSab", "0");
                            values.put("puntCar", "0");
                            values.put("modFza", "0");
                            values.put("modDes", "0");
                            values.put("modCon", "0");
                            values.put("modInt", "0");
                            values.put("modSab", "0");
                            values.put("modCar", "0");
                            db.update("personaje", values, "_id='" + aux_id + "'", null);
                            recuperarEstadisticasPJ();

                        } while (c.moveToNext());
                        getActivity().recreate();
                    }
                } catch (Exception e) {
                    Log.e("Error", "Error: " + e.getMessage());
                } finally {
                    db.close();
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

    /**
     * Método del FAB de vida (nuevo)
     *
     * @param title
     */

    public void fabVidaNuevo(String title){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fab_vida, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog  = viewInflated.findViewById(R.id.tvDialogFabVidaTitle);
        final EditText editTextPG           = viewInflated.findViewById(R.id.editTextPG);
        final EditText editTextVelocidad    = viewInflated.findViewById(R.id.editTextVelocidad);
        final EditText editTextCA           = viewInflated.findViewById(R.id.editTextCA);
        final EditText editTextToque        = viewInflated.findViewById(R.id.editTextToque);
        final EditText editTextIniciativa   = viewInflated.findViewById(R.id.editTextIniciativa);
        final EditText editTextDesprevenido = viewInflated.findViewById(R.id.editTextDesprevenido);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String pg = editTextPG.getText().toString();
                String velocidad = editTextVelocidad.getText().toString();
                String ca = editTextCA.getText().toString();
                String toque = editTextToque.getText().toString();
                String iniciativa = editTextIniciativa.getText().toString();
                String desprevenido = editTextDesprevenido.getText().toString();

                try{

                    dbHelper = new DBHelper(getActivity());
                    db       = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()){

                        do{

                            aux_id = c.getString(0);

                        }while (c.moveToNext());

                        ContentValues values = new ContentValues();
                        values.put("pg", pg);
                        values.put("velocidad", velocidad);
                        values.put("ca", ca);
                        values.put("toque", toque);
                        values.put("iniciativa", iniciativa);
                        values.put("desprevenido", desprevenido);
                        db.update("personaje", values,"_id='" + aux_id + "'",null);
                        recuperarEstadisticasPJ();
                    }

                    getActivity().recreate();

                }catch (Exception e){
                    Log.e("Error","Error: "+e.getMessage());
                }finally {
                    db.close();
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

    /**
     * Método del FAB de vida (borrar)
     * @param title
     */

    public void fabVidaBorrar(String title, String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if(title !=null){
            builder.setTitle(title);
        }

        if(message !=null){
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    dbHelper = new DBHelper(getActivity());
                    db = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'", null);

                    if (c.moveToFirst()) {

                        do {

                            aux_id = c.getString(0);

                            ContentValues values = new ContentValues();
                            values.put("pg", "0");
                            values.put("velocidad", "0");
                            values.put("heridas", "");
                            values.put("ca", "0");
                            values.put("toque", "0");
                            values.put("iniciativa", "0");
                            values.put("desprevenido", "0");
                            db.update("personaje", values, "_id='" + aux_id + "'", null);
                            recuperarEstadisticasPJ();

                        } while (c.moveToNext());
                        getActivity().recreate();
                    }
                } catch (Exception e) {
                    Log.e("Error", "Error: " + e.getMessage());
                } finally {
                    db.close();
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

    /**
     * Método del FAB de ataque (nuevo)
     *
     * @param title
     */

    private void fabAtaqueNuevo(String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fab_ataque, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog   = viewInflated.findViewById(R.id.tvDialogFabAtaqueTitle);
        final EditText editTextATQ           = viewInflated.findViewById(R.id.editTextATQ);
        final EditText editTextPresa         = viewInflated.findViewById(R.id.editTextPresa);
        final EditText editTextResConj       = viewInflated.findViewById(R.id.editTextResConj);
        final EditText editTextRedDanio      = viewInflated.findViewById(R.id.editTextRedDaño);
        final EditText editTextBonfAtaque    = viewInflated.findViewById(R.id.editTextBonfAtaque);
        final EditText editTextBonfDistancia = viewInflated.findViewById(R.id.editTextBonfDistancia);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String atq = editTextATQ.getText().toString();
                String presa = editTextPresa.getText().toString();
                String resConj = editTextResConj.getText().toString();
                String redDanio = editTextRedDanio.getText().toString();
                String bonfAtq = editTextBonfAtaque.getText().toString();
                String bonfDist = editTextBonfDistancia.getText().toString();

                try{

                    dbHelper = new DBHelper(getActivity());
                    db       = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()){

                        do{

                            aux_id = c.getString(0);

                        }while (c.moveToNext());

                        ContentValues values = new ContentValues();
                        values.put("ataque", atq);
                        values.put("presa", presa);
                        values.put("resConjuros", resConj);
                        values.put("redDanio", redDanio);
                        values.put("bonfAtaque", bonfAtq);
                        values.put("bonfDistancia", bonfDist);
                        db.update("personaje", values,"_id='" + aux_id + "'",null);
                        recuperarEstadisticasPJ();
                    }

                    getActivity().recreate();

                }catch (Exception e){
                    Log.e("Error","Error: "+e.getMessage());
                }finally {
                    db.close();
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

    /**
     * Método del FAB de ataque (borrar)
     *
     * @param title
     */

    private void fabAtaqueBorrar(String title, String message){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if(title !=null){
            builder.setTitle(title);
        }

        if(message !=null){
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    dbHelper = new DBHelper(getActivity());
                    db = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'", null);

                    if (c.moveToFirst()) {

                        do {

                            aux_id = c.getString(0);

                            ContentValues values = new ContentValues();
                            values.put("ataque", "0");
                            values.put("presa", "0");
                            values.put("resConjuros", "0");
                            values.put("redDanio", "0");
                            values.put("bonfAtaque", "0");
                            values.put("bonfDistancia", "0");
                            db.update("personaje", values, "_id='" + aux_id + "'", null);
                            recuperarEstadisticasPJ();

                        } while (c.moveToNext());
                        getActivity().recreate();
                    }
                } catch (Exception e) {
                    Log.e("Error", "Error: " + e.getMessage());
                } finally {
                    db.close();
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

    /**
     * Método del FAB de salvación (nuevo)
     *
     * @param title
     */

    private void fabSalvacionNuevo(String title){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fab_salvacion, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog   = viewInflated.findViewById(R.id.tvDialogFabSalvacionTitle);
        final EditText editTextFortaleza     = viewInflated.findViewById(R.id.editTextFortaleza);
        final EditText editTextReflejos      = viewInflated.findViewById(R.id.editTextReflejos);
        final EditText editTextVoluntad      = viewInflated.findViewById(R.id.editTextVoluntad);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String fort = editTextFortaleza.getText().toString();
                String refl = editTextReflejos.getText().toString();
                String volu = editTextVoluntad.getText().toString();

                try{

                    dbHelper = new DBHelper(getActivity());
                    db       = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()){

                        do{

                            aux_id = c.getString(0);

                        }while (c.moveToNext());

                        ContentValues values = new ContentValues();
                        values.put("salvFortaleza", fort);
                        values.put("salvReflejos", refl);
                        values.put("salvVoluntad", volu);
                        db.update("personaje", values,"_id='" + aux_id + "'",null);
                        recuperarEstadisticasPJ();
                    }

                    getActivity().recreate();

                }catch (Exception e){
                    Log.e("Error","Error: "+e.getMessage());
                }finally {
                    db.close();
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

    /**
     * Método del FAB de salvación (borrar)
     *
     * @param title
     */

    private void fabSalvacionBorrar(String title, String message){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if(title !=null){
            builder.setTitle(title);
        }

        if(message !=null){
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try{

                    dbHelper = new DBHelper(getActivity());
                    db       = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()){

                        do{

                            aux_id = c.getString(0);

                        }while (c.moveToNext());

                        ContentValues values = new ContentValues();
                        values.put("salvFortaleza", "0");
                        values.put("salvReflejos", "0");
                        values.put("salvVoluntad", "0");
                        db.update("personaje", values,"_id='" + aux_id + "'",null);
                        recuperarEstadisticasPJ();
                    }

                    getActivity().recreate();

                }catch (Exception e){
                    Log.e("Error","Error: "+e.getMessage());
                }finally {
                    db.close();
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


    /**
     * Diálogo de opciones para el boton heridas
     *
     * @param opciones
     */

    public void opcionesParaHeridas(String[] opciones){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                if(position == 0){
                    editarHeridas("  Modificar heridas");

                } else if(position == 1){
                    borrarHeridas(" Borrar heridas", "¿Desea borrar todas las heridas?");
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Método del FAB de stats
     *
     * @param title
     */

    public void fabStatsNuevo(String title){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fab_stats_seek, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog = viewInflated.findViewById(R.id.tvDialogStatsTitle);
        final TextView textViewFZA         = viewInflated.findViewById(R.id.textViewSeekFZA);
        final TextView textViewDES         = viewInflated.findViewById(R.id.textViewSeekDES);
        final TextView textViewCON         = viewInflated.findViewById(R.id.textViewSeekCON);
        final TextView textViewINT         = viewInflated.findViewById(R.id.textViewSeekINT);
        final TextView textViewSAB         = viewInflated.findViewById(R.id.textViewSeekSAB);
        final TextView textViewCAR         = viewInflated.findViewById(R.id.textViewSeekCAR);

        final SeekBar  seekBarFZA          = viewInflated.findViewById(R.id.seekBarFZA);
        final SeekBar  seekBarDES          = viewInflated.findViewById(R.id.seekBarDES);
        final SeekBar  seekBarCON          = viewInflated.findViewById(R.id.seekBarCON);
        final SeekBar  seekBarINT          = viewInflated.findViewById(R.id.seekBarINT);
        final SeekBar  seekBarSAB          = viewInflated.findViewById(R.id.seekBarSAB);
        final SeekBar  seekBarCAR          = viewInflated.findViewById(R.id.seekBarCAR);

        textViewTitleDialog.setText(title);

        textViewFZA.setText(String.valueOf(seekBarFZA.getProgress()));
        textViewDES.setText(String.valueOf(seekBarDES.getProgress()));
        textViewCON.setText(String.valueOf(seekBarCON.getProgress()));
        textViewINT.setText(String.valueOf(seekBarINT.getProgress()));
        textViewSAB.setText(String.valueOf(seekBarSAB.getProgress()));
        textViewCAR.setText(String.valueOf(seekBarCAR.getProgress()));

        seekBarFZA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progreso = String.valueOf(progressValue);
                textViewFZA.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textViewFZA.setText(progreso);
            }
        });
        seekBarDES.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progreso = String.valueOf(progressValue);
                textViewDES.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textViewDES.setText(progreso);
            }
        });
        seekBarCON.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progreso = String.valueOf(progressValue);
                textViewCON.setText(progreso);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textViewCON.setText(progreso);
            }
        });
        seekBarINT.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progreso = String.valueOf(progressValue);
                textViewINT.setText(progreso);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textViewINT.setText(progreso);
            }
        });
        seekBarSAB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progreso = String.valueOf(progressValue);
                textViewSAB.setText(progreso);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textViewSAB.setText(progreso);
            }
        });
        seekBarCAR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progreso = String.valueOf(progressValue);
                textViewCAR.setText(progreso);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textViewCAR.setText(progreso);
            }
        });

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String FZA = textViewFZA.getText().toString();
                String DES = textViewDES.getText().toString();
                String CON = textViewCON.getText().toString();
                String INT = textViewINT.getText().toString();
                String SAB = textViewSAB.getText().toString();
                String CAR = textViewCAR.getText().toString();

                if(!FZA.isEmpty() || !DES.isEmpty() || !CON.isEmpty() || !INT.isEmpty() || !SAB.isEmpty() || !CAR.isEmpty()) {

                    String modFZA = modificadorCaractSegunPuntuacion(FZA);
                    String modDES = modificadorCaractSegunPuntuacion(DES);
                    String modCON = modificadorCaractSegunPuntuacion(CON);
                    String modINT = modificadorCaractSegunPuntuacion(INT);
                    String modSAB = modificadorCaractSegunPuntuacion(SAB);
                    String modCAR = modificadorCaractSegunPuntuacion(CAR);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT _id, puntFza, puntDes, puntCon, puntInt, puntSab, puntCar, modFza, modDes, modCon, modInt, modSab, modCar FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {

                                aux_id = c.getString(0);

                                ContentValues values = new ContentValues();
                                values.put("puntFza", FZA);
                                values.put("puntDes", DES);
                                values.put("puntCon", CON);
                                values.put("puntInt", INT);
                                values.put("puntSab", SAB);
                                values.put("puntCar", CAR);
                                values.put("modFza", modFZA);
                                values.put("modDes", modDES);
                                values.put("modCon", modCON);
                                values.put("modInt", modINT);
                                values.put("modSab", modSAB);
                                values.put("modCar", modCAR);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);
                                recuperarEstadisticasPJ();

                            } while (c.moveToNext());
                            getActivity().recreate();
                        }
                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Ingrese todos los stats", Toast.LENGTH_SHORT).show();
                    fabStatsNuevo("  Modificar Stats");
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Método que devuelve el modificador según la puntuación
     *
     * @param punt
     * @return
     */

    public String modificadorCaractSegunPuntuacion(String punt){

        /* Este metodo se tiene que modificar en la parte de conjuros
           ya que a partir del 10-11 aumentan los conjuros adicionales
           basta con agregar un campo a db de conjuros adicionales y
           asignarle el valor correspondiente según sea la puntCarac */

        int puntuacion = Integer.parseInt(punt);

        if(puntuacion == 0){
            punt = "0";
        }
        if(puntuacion == 1){
            punt = "-5";
        }
        if(puntuacion == 2 || puntuacion == 3){
            punt = "-4";
        }
        if(puntuacion == 4 || puntuacion == 5){
            punt = "-3";
        }
        if(puntuacion == 6 || puntuacion == 7){
            punt = "-2";
        }
        if(puntuacion == 8 || puntuacion == 9){
            punt = "-1";
        }
        if(puntuacion == 10 || puntuacion == 11){
            punt = "0";
        }
        if(puntuacion == 12 || puntuacion == 13){
            punt = "+1";
        }
        if(puntuacion == 14 || puntuacion == 15){
            punt = "+2";
        }
        if(puntuacion == 16 || puntuacion == 17){
            punt = "+3";
        }
        if(puntuacion == 18 || puntuacion == 19){
            punt = "+4";
        }
        if(puntuacion == 20 || puntuacion == 21){
            punt = "+5";
        }
        if(puntuacion == 22 || puntuacion == 23){
            punt = "+6";
        }
        if(puntuacion == 24 || puntuacion == 25){
            punt = "+7";
        }
        if(puntuacion == 26 || puntuacion == 27){
            punt = "+8";
        }
        if(puntuacion == 28 || puntuacion == 29){
            punt = "+9";
        }
        if(puntuacion == 30 || puntuacion == 31){
            punt = "+10";
        }
        if(puntuacion == 32 || puntuacion == 33){
            punt = "+11";
        }
        if(puntuacion == 34 || puntuacion == 35){
            punt = "+12";
        }
        if(puntuacion == 36 || puntuacion == 37){
            punt = "+13";
        }
        if(puntuacion == 38 || puntuacion == 39){
            punt = "+14";
        }
        if(puntuacion == 40 || puntuacion == 41){
            punt = "+15";
        }
        if(puntuacion == 42 || puntuacion == 43){
            punt = "+16";
        }
        if(puntuacion == 44 || puntuacion == 45){
            punt = "+17";
        }
        if(puntuacion == 46 || puntuacion == 47){
            punt = "+18";
        }
        if(puntuacion == 48 || puntuacion == 49){
            punt = "+19";
        }
        if(puntuacion == 50){
            punt = "+20";
        }
        if(puntuacion > 50){
            Toast.makeText(getContext(),"En mantenimineto, puntuacion máx 50", Toast.LENGTH_SHORT).show();
            return null;
        }

        return punt;
    }

    /**
     * Método que edita la punt y mod de FZA.
     *
     */

    public void editarFuerza(String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_puntuaciones_modificadores, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog = viewInflated.findViewById(R.id.tvDialogEditarPuntMod);
        final SeekBar  seekBarEditor       = viewInflated.findViewById(R.id.seekBarEditor);
        final Button   buttonEditor        = viewInflated.findViewById(R.id.buttonEditar);
        final TextView textViewEditor      = viewInflated.findViewById(R.id.textViewEditor);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        textViewEditor.setText(TVPuntCaractFza.getText().toString());
        seekBarEditor.setProgress(Integer.parseInt(TVPuntCaractFza.getText().toString()));

        seekBarEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean d) {
                progreso = String.valueOf(progressValue);
                textViewEditor.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewEditor.setText(progreso);
            }
        });

        buttonEditor.setText("FUE");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntuacion  = textViewEditor.getText().toString();

                if(!puntuacion.isEmpty()) {
                    String modificador = modificadorCaractSegunPuntuacion(puntuacion);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT _id, puntFza, modFza FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {

                                aux_id = c.getString(0);
                                ContentValues values = new ContentValues();
                                values.put("puntFza", puntuacion);
                                values.put("modFza", modificador);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);
                                recuperarEstadisticasPJ();
                            } while (c.moveToNext());
                            getActivity().recreate();
                        }

                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Ingrese un valor para fuerza",Toast.LENGTH_SHORT).show();
                    editarFuerza("  Modificar fuerza");
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

    /**
     * Método que edita la punt y mod de DES.
     *
     */

    public void editarDes(String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_puntuaciones_modificadores, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog = viewInflated.findViewById(R.id.tvDialogEditarPuntMod);
        final SeekBar  seekBarEditor       = viewInflated.findViewById(R.id.seekBarEditor);
        final Button   buttonEditor        = viewInflated.findViewById(R.id.buttonEditar);
        final TextView textViewEditor      = viewInflated.findViewById(R.id.textViewEditor);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        textViewEditor.setText(TVPuntCaractDes.getText().toString());

        seekBarEditor.setProgress(Integer.parseInt(TVPuntCaractDes.getText().toString()));

        seekBarEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean d) {
                progreso = String.valueOf(progressValue);
                textViewEditor.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewEditor.setText(progreso);
            }
        });

        buttonEditor.setText("DES");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntuacion  = textViewEditor.getText().toString();

                if(!puntuacion.isEmpty()) {
                    String modificador = modificadorCaractSegunPuntuacion(puntuacion);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT _id, puntDes, modDes FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {

                                aux_id = c.getString(0);
                                ContentValues values = new ContentValues();
                                values.put("puntDes", puntuacion);
                                values.put("modDes", modificador);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);
                                recuperarEstadisticasPJ();
                            } while (c.moveToNext());
                            getActivity().recreate();
                        }

                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Ingrese un valor para destreza",Toast.LENGTH_SHORT).show();
                    editarDes("  Modificar destreza");
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

    /**
     * Método que edita la punt y mod de CON.
     *
     */

    public void editarCon(String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_puntuaciones_modificadores, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog = viewInflated.findViewById(R.id.tvDialogEditarPuntMod);
        final SeekBar  seekBarEditor       = viewInflated.findViewById(R.id.seekBarEditor);
        final Button   buttonEditor        = viewInflated.findViewById(R.id.buttonEditar);
        final TextView textViewEditor      = viewInflated.findViewById(R.id.textViewEditor);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        textViewEditor.setText(TVPuntCaractCon.getText().toString());

        seekBarEditor.setProgress(Integer.parseInt(TVPuntCaractCon.getText().toString()));

        seekBarEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean d) {
                progreso = String.valueOf(progressValue);
                textViewEditor.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewEditor.setText(progreso);
            }
        });

        buttonEditor.setText("CON");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntuacion  = textViewEditor.getText().toString();

                if(!puntuacion.isEmpty()) {
                    String modificador = modificadorCaractSegunPuntuacion(puntuacion);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT _id, puntCon, modCon FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {

                                aux_id = c.getString(0);
                                ContentValues values = new ContentValues();
                                values.put("puntCon", puntuacion);
                                values.put("modCon", modificador);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);
                                recuperarEstadisticasPJ();
                            } while (c.moveToNext());
                            getActivity().recreate();
                        }

                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Ingrese un valor para constitución",Toast.LENGTH_SHORT).show();
                    editarCon("  Modificar constitución");
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

    /**
     * Método que edita la punt y mod de INT.
     *
     */

    public void editarInt(String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_puntuaciones_modificadores, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog = viewInflated.findViewById(R.id.tvDialogEditarPuntMod);
        final SeekBar  seekBarEditor       = viewInflated.findViewById(R.id.seekBarEditor);
        final Button   buttonEditor        = viewInflated.findViewById(R.id.buttonEditar);
        final TextView textViewEditor      = viewInflated.findViewById(R.id.textViewEditor);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        textViewEditor.setText(TVPuntCaractInt.getText().toString());

        seekBarEditor.setProgress(Integer.parseInt(TVPuntCaractInt.getText().toString()));

        seekBarEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean d) {
                progreso = String.valueOf(progressValue);
                textViewEditor.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewEditor.setText(progreso);
            }
        });

        buttonEditor.setText("INT");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntuacion  = textViewEditor.getText().toString();

                if(!puntuacion.isEmpty()) {

                    String modificador = modificadorCaractSegunPuntuacion(puntuacion);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT _id, puntInt, modInt FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {

                                aux_id = c.getString(0);
                                ContentValues values = new ContentValues();
                                values.put("puntInt", puntuacion);
                                values.put("modInt", modificador);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);
                                recuperarEstadisticasPJ();
                            } while (c.moveToNext());
                            getActivity().recreate();
                        }

                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Ingrese un valor para inteligencia",Toast.LENGTH_SHORT).show();
                    editarInt("  Modificar inteligencia");
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

    /**
     * Método que edita la punt y mod de SAB.
     *
     */

    public void editarSab(String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_puntuaciones_modificadores, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog = viewInflated.findViewById(R.id.tvDialogEditarPuntMod);
        final SeekBar  seekBarEditor       = viewInflated.findViewById(R.id.seekBarEditor);
        final Button   buttonEditor        = viewInflated.findViewById(R.id.buttonEditar);
        final TextView textViewEditor      = viewInflated.findViewById(R.id.textViewEditor);

        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        textViewEditor.setText(TVPuntCaractSab.getText().toString());

        seekBarEditor.setProgress(Integer.parseInt(TVPuntCaractSab.getText().toString()));

        seekBarEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean d) {
                progreso = String.valueOf(progressValue);
                textViewEditor.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewEditor.setText(progreso);
            }
        });

        buttonEditor.setText("SAB");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntuacion  = textViewEditor.getText().toString();

                if(!puntuacion.isEmpty()) {
                    String modificador = modificadorCaractSegunPuntuacion(puntuacion);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT _id, puntSab, modSab FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {

                                aux_id = c.getString(0);
                                ContentValues values = new ContentValues();
                                values.put("puntSab", puntuacion);
                                values.put("modSab", modificador);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);
                                recuperarEstadisticasPJ();
                            } while (c.moveToNext());
                            getActivity().recreate();
                        }

                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Ingrese un valor para sabiduría",Toast.LENGTH_SHORT).show();
                    editarSab("  Modificar sabiduría");
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

    /**
     * Método que edita las heridas
     * @param  title
     */

    public void editarHeridas(String title){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_heridas, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);
        final TextView tvTitleHeridas  = viewInflated.findViewById(R.id.tvTitleHeridas);
        final EditText editTextHeridas = viewInflated.findViewById(R.id.editTextHeridas);

        tvTitleHeridas.setText(title);

        try{

            dbHelper = new DBHelper(getActivity());
            db = dbHelper.getReadableDatabase();

            Cursor c = db
                    .rawQuery("SELECT heridas FROM personaje WHERE controlAct='1'",null);

            if(c.moveToFirst()){
                do {
                    aux_heridas = c.getString(0);

                }while (c.moveToNext());

                if(!aux_heridas.equals("")){
                    editTextHeridas.setText(aux_heridas);
                } else {
                    editTextHeridas.setText("");
                }

            }

        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        }finally {
            db.close();
        }


        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String heridas = editTextHeridas.getText().toString();

                try {

                    dbHelper = new DBHelper(getActivity());
                    db = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()){

                        do{
                            aux_id = c.getString(0);

                        }while (c.moveToNext());

                        ContentValues values = new ContentValues();
                        values.put("heridas", heridas);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        recuperarEstadisticasPJ();

                    }

                }catch (Exception e){
                    Log.e("Error","Error: "+e.getMessage());
                }finally {
                    db.close();
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

    public void borrarHeridas(String title, String message){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if(title !=null){
            builder.setTitle(title);
        }

        if(message !=null){
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    dbHelper = new DBHelper(getActivity());
                    db = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'", null);

                    if (c.moveToFirst()) {

                        do {

                            aux_id = c.getString(0);

                            ContentValues values = new ContentValues();
                            values.put("heridas", "");
                            db.update("personaje", values, "_id='" + aux_id + "'", null);
                            recuperarEstadisticasPJ();

                        } while (c.moveToNext());
                        getActivity().recreate();
                    }
                } catch (Exception e) {
                    Log.e("Error", "Error: " + e.getMessage());
                } finally {
                    db.close();
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


    /**
     * Método que edita la punt y mod de CAR.
     * @param title
     */

    public void editarCar(String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_puntuaciones_modificadores, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialog = viewInflated.findViewById(R.id.tvDialogEditarPuntMod);
        final SeekBar  seekBarEditor       = viewInflated.findViewById(R.id.seekBarEditor);
        final Button   buttonEditor        = viewInflated.findViewById(R.id.buttonEditar);
        final TextView textViewEditor      = viewInflated.findViewById(R.id.textViewEditor);
        textViewTitleDialog.setText(title);
        builder.setCancelable(true);

        textViewEditor.setText(TVPuntCaractCar.getText().toString());

        seekBarEditor.setProgress(Integer.parseInt(TVPuntCaractCar.getText().toString()));

        seekBarEditor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            String progreso = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean d) {
                progreso = String.valueOf(progressValue);
                textViewEditor.setText(progreso);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewEditor.setText(progreso);
            }
        });

        buttonEditor.setText("CAR");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntuacion  = textViewEditor.getText().toString();

                if(!puntuacion.isEmpty()) {
                    String modificador = modificadorCaractSegunPuntuacion(puntuacion);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT _id, puntCar, modCar FROM personaje WHERE controlAct='1'", null);

                        if (c.moveToFirst()) {

                            do {

                                aux_id = c.getString(0);
                                ContentValues values = new ContentValues();
                                values.put("puntCar", puntuacion);
                                values.put("modCar", modificador);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);
                                recuperarEstadisticasPJ();
                            } while (c.moveToNext());
                            getActivity().recreate();
                        }

                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
                } else {
                    Toast.makeText(getContext(),"Ingrese un valor para carisma",Toast.LENGTH_SHORT).show();
                    editarDes("  Modificar carisma");
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


}
