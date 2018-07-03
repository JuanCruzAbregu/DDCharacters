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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipFragment extends Fragment {

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    private FloatingActionButton armaFab, armaduraFab;
    private String[] opciones_armas = new String[]{"Arma 1", "Arma 2", "Arma 3", "Arma 4", "Arma 5"};

    private TextView textViewArma1, textViewDanio1, textViewCritico1, textViewTipo1, textViewPeso1, textViewAlcance1, textViewNotas1, textViewMunicion1;
    private ProgressBar progressBarMunicion1;

    private TextView textViewArma2, textViewDanio2, textViewCritico2, textViewTipo2, textViewPeso2, textViewAlcance2, textViewNotas2, textViewMunicion2;
    private ProgressBar progressBarMunicion2, progressBarMunicion3, progressBarMunicion4, progressBarMunicion5;

    private TextView textViewArma3, textViewDanio3, textViewCritico3, textViewTipo3, textViewPeso3, textViewAlcance3, textViewNotas3, textViewMunicion3;
    private TextView textViewArma4, textViewDanio4, textViewCritico4, textViewTipo4, textViewPeso4, textViewAlcance4, textViewNotas4, textViewMunicion4;
    private TextView textViewArma5, textViewDanio5, textViewCritico5, textViewTipo5, textViewPeso5, textViewAlcance5, textViewNotas5, textViewMunicion5;

    private TextView textViewArmadura, textViewCA, textViewDesMax, textViewTipoArmadura, textViewPesoArmadura,
            textViewPenalizador, textViewVelocidadArm, textViewFalloConj, textViewPropEsp;

    private Button buttonMunicion, buttonMunicion2, buttonMunicion3, buttonMunicion4, buttonMunicion5;

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

    private int control;
    public EquipFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equip, container, false);

        if(view != null) {

            dbHelper             = new DBHelper(getActivity());
            db                   = dbHelper.getWritableDatabase();
            armaFab              = view.findViewById(R.id.armaFab);
            armaduraFab          = view.findViewById(R.id.armaduraFab);
            textViewArma1        = view.findViewById(R.id.textViewArma);
            textViewDanio1       = view.findViewById(R.id.textViewDaño);
            textViewCritico1     = view.findViewById(R.id.textViewCritico);
            textViewTipo1        = view.findViewById(R.id.textViewTipo);
            textViewPeso1        = view.findViewById(R.id.textViewPeso);
            textViewAlcance1     = view.findViewById(R.id.textViewAlcance);
            textViewNotas1       = view.findViewById(R.id.textViewNotas);
            textViewMunicion1    = view.findViewById(R.id.textViewMunicion1);
            progressBarMunicion1 = view.findViewById(R.id.progressBarMunicion1);
            buttonMunicion       = view.findViewById(R.id.buttonMunicion);
            textViewArma2        = view.findViewById(R.id.textViewArmaII);
            textViewDanio2       = view.findViewById(R.id.textViewDañoII);
            textViewCritico2     = view.findViewById(R.id.textViewCriticoII);
            textViewTipo2        = view.findViewById(R.id.textViewTipoII);
            textViewPeso2        = view.findViewById(R.id.textViewPesoII);
            textViewAlcance2     = view.findViewById(R.id.textViewAlcanceII);
            textViewNotas2       = view.findViewById(R.id.textViewNotasII);
            textViewMunicion2    = view.findViewById(R.id.textViewMunicion2);
            progressBarMunicion2 = view.findViewById(R.id.progressBarMunicion2);
            textViewArma3        = view.findViewById(R.id.textViewArmaIII);
            textViewDanio3       = view.findViewById(R.id.textViewDañoIII);
            textViewCritico3     = view.findViewById(R.id.textViewCriticoIII);
            textViewTipo3        = view.findViewById(R.id.textViewTipoIII);
            textViewPeso3        = view.findViewById(R.id.textViewPesoIII);
            textViewAlcance3     = view.findViewById(R.id.textViewAlcanceIII);
            textViewNotas3       = view.findViewById(R.id.textViewNotasIII);
            textViewMunicion3    = view.findViewById(R.id.textViewMunicion3);
            progressBarMunicion3 = view.findViewById(R.id.progressBarMunicion3);
            textViewArma4        = view.findViewById(R.id.textViewArmaIV);
            textViewDanio4       = view.findViewById(R.id.textViewDañoIV);
            textViewCritico4     = view.findViewById(R.id.textViewCriticoIV);
            textViewTipo4        = view.findViewById(R.id.textViewTipoIV);
            textViewPeso4        = view.findViewById(R.id.textViewPesoIV);
            textViewAlcance4     = view.findViewById(R.id.textViewAlcanceIV);
            textViewNotas4       = view.findViewById(R.id.textViewNotasIV);
            textViewMunicion4    = view.findViewById(R.id.textViewMunicion4);
            progressBarMunicion4 = view.findViewById(R.id.progressBarMunicion4);
            textViewArma5        = view.findViewById(R.id.textViewArmaV);
            textViewDanio5       = view.findViewById(R.id.textViewDañoV);
            textViewCritico5     = view.findViewById(R.id.textViewCriticoV);
            textViewTipo5        = view.findViewById(R.id.textViewTipoV);
            textViewPeso5        = view.findViewById(R.id.textViewPesoV);
            textViewAlcance5     = view.findViewById(R.id.textViewAlcanceV);
            textViewNotas5       = view.findViewById(R.id.textViewNotasV);
            textViewMunicion5    = view.findViewById(R.id.textViewMunicion5);
            progressBarMunicion5 = view.findViewById(R.id.progressBarMunicion5);
            buttonMunicion2      = view.findViewById(R.id.buttonMunicion2);
            buttonMunicion3      = view.findViewById(R.id.buttonMunicion3);
            buttonMunicion4      = view.findViewById(R.id.buttonMunicion4);
            buttonMunicion5      = view.findViewById(R.id.buttonMunicion5);

            textViewArmadura     = view.findViewById(R.id.textViewArmadura);
            textViewCA           = view.findViewById(R.id.textViewCA);
            textViewDesMax       = view.findViewById(R.id.textViewDesMax);
            textViewTipoArmadura = view.findViewById(R.id.textViewTipoArmadura);
            textViewPenalizador  = view.findViewById(R.id.textViewPenalizador);
            textViewVelocidadArm = view.findViewById(R.id.textViewVelocidadArm);
            textViewPesoArmadura = view.findViewById(R.id.textViewPesoArmadura);
            textViewFalloConj    = view.findViewById(R.id.textViewFalloConj);
            textViewPropEsp      = view.findViewById(R.id.textViewPropEsp);

            aux_id = recuperarIDpersonaje();

            recuperarTodosLosEquipos(aux_id);

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
        }

        return view;
    }

    private void recuperarTodosLosEquipos(String id){

        try{

            db = dbHelper.getReadableDatabase();
            Cursor c = db
                    .rawQuery("SELECT arma1arma, arma1Danio, arma1Critico, arma1Tipo, arma1Peso, arma1Alcance, arma1Notas, arma1Municion, "+
                            "arma2arma, arma2Danio, arma2Critico, arma2Tipo, arma2Peso, arma2Alcance, arma2Notas, arma2Municion, "+
                            "arma3arma, arma3Danio, arma3Critico, arma3Tipo, arma3Peso, arma3Alcance, arma3Notas, arma3Municion, "+
                            "arma4arma, arma4Danio, arma4Critico, arma4Tipo, arma4Peso, arma4Alcance, arma4Notas, arma4Municion, "+
                            "arma5arma, arma5Danio, arma5Critico, arma5Tipo, arma5Peso, arma5Alcance, arma5Notas, arma5Municion, "+
                            "armaduraArmadura, armaduraCA, armaduraDesMax, armaduraTipo, armaduraPen, armaduraVelocidad, armaduraPeso, armaduraFallo, armaduraEsp "+
                            "FROM equipo WHERE _id='" + id + "'",null);

            if(c.moveToFirst()){

                do{
                    aux_arma1     = c.getString(0);
                    aux_danio1    = c.getString(1);
                    aux_critico1  = c.getString(2);
                    aux_tipo1     = c.getString(3);
                    aux_peso1     = c.getString(4);
                    aux_alcance1  = c.getString(5);
                    aux_notas1    = c.getString(6);
                    aux_municion1 = c.getString(7);
                    aux_arma2     = c.getString(8);
                    aux_danio2    = c.getString(9);
                    aux_critico2  = c.getString(10);
                    aux_tipo2     = c.getString(11);
                    aux_peso2     = c.getString(12);
                    aux_alcance2  = c.getString(13);
                    aux_notas2    = c.getString(14);
                    aux_municion2 = c.getString(15);
                    aux_arma3     = c.getString(16);
                    aux_danio3    = c.getString(17);
                    aux_critico3  = c.getString(18);
                    aux_tipo3     = c.getString(19);
                    aux_peso3     = c.getString(20);
                    aux_alcance3  = c.getString(21);
                    aux_notas3    = c.getString(22);
                    aux_municion3 = c.getString(23);
                    aux_arma4     = c.getString(24);
                    aux_danio4    = c.getString(25);
                    aux_critico4  = c.getString(26);
                    aux_tipo4     = c.getString(27);
                    aux_peso4     = c.getString(28);
                    aux_alcance4  = c.getString(29);
                    aux_notas4    = c.getString(30);
                    aux_municion4 = c.getString(31);
                    aux_arma5     = c.getString(32);
                    aux_danio5    = c.getString(33);
                    aux_critico5  = c.getString(34);
                    aux_tipo5     = c.getString(35);
                    aux_peso5     = c.getString(36);
                    aux_alcance5  = c.getString(37);
                    aux_notas5    = c.getString(38);
                    aux_municion5 = c.getString(39);
                    aux_armadura  = c.getString(40);
                    aux_ca        = c.getString(41);
                    aux_desMax    = c.getString(42);
                    aux_tipo      = c.getString(43);
                    aux_pen       = c.getString(44);
                    aux_velocidad = c.getString(45);
                    aux_peso      = c.getString(46);
                    aux_fallo     = c.getString(47);
                    aux_esp       = c.getString(48);

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

            }


        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        }finally {
            db.close();
        }


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


}
