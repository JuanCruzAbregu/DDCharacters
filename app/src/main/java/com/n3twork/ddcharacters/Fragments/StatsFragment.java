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
import android.widget.ImageButton;
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
    private Button buttonFza, buttonDes, buttonCon, buttonInt, buttonSab, buttonCar;
    private ProgressBar progressBarExp;
    private FloatingActionButton fabExp, fabStats;

    private PJFragment pjFragment = new PJFragment();

    private String[] opciones_stats = new String[]{"Nuevo", "Borrar"};


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
            buttonFza            = view.findViewById(R.id.buttonFue);
            buttonDes            = view.findViewById(R.id.buttonDes);
            buttonCon            = view.findViewById(R.id.buttonCon);
            buttonInt            = view.findViewById(R.id.buttonInt);
            buttonSab            = view.findViewById(R.id.buttonSab);
            buttonCar            = view.findViewById(R.id.buttonCar);
            progressBarExp       = view.findViewById(R.id.progressBarExp);
            fabExp               = view.findViewById(R.id.experienciaFab);
            fabStats             = view.findViewById(R.id.statsFab);

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
                    fabStatsOpciones(opciones_stats);
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
        }

        return view;
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

                    aux_id           = c.getString(0);
                    aux_nombre       = c.getString(1);
                    aux_clase        = c.getString(2);
                    aux_nivel        = c.getString(3);
                    aux_raza         = c.getString(4);
                    aux_alineamiento = c.getString(5);
                    aux_deidad       = c.getString(6);
                    aux_tamaño       = c.getString(7);
                    aux_sexo         = c.getString(8);
                    aux_experiencia  = c.getString(9);
                    aux_low          = c.getString(10);
                    aux_high         = c.getString(11);
                    aux_campaña      = c.getString(12);
                    aux_controlAct   = c.getString(13);
                    aux_fza          = c.getString(14);
                    aux_des          = c.getString(15);
                    aux_con          = c.getString(16);
                    aux_int          = c.getString(17);
                    aux_sab          = c.getString(18);
                    aux_car          = c.getString(19);
                    aux_mod_fza      = c.getString(20);
                    aux_mod_des      = c.getString(21);
                    aux_mod_con      = c.getString(22);
                    aux_mod_int      = c.getString(23);
                    aux_mod_sab      = c.getString(24);
                    aux_mod_car      = c.getString(25);


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
                }
                if(position == 1){
                    fabStatsBorrar("  Reiniciar stats", "¿Desea reiniciar todos los stats?");
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
     * Método que edita la punt y mod de CAR.
     *
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
