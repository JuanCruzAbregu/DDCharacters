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

    private FloatingActionButton armaFab;
    private String[] opciones_armas = new String[]{"Arma 1", "Arma 2", "Arma 3", "Arma 4", "Arma 5"};

    private TextView textViewArma1, textViewDanio1, textViewCritico1, textViewTipo1, textViewPeso1, textViewAlcance1, textViewNotas1, textViewMunicion1;
    private ProgressBar progressBarMunicion1;

    private Button buttonMunicion;

    private String aux_id = "";
    private String aux_arma1 = "";
    private String aux_danio1 = "";
    private String aux_critico1 = "";
    private String aux_tipo1 = "";
    private String aux_peso1 = "";
    private String aux_alcance1 = "";
    private String aux_notas1 = "";
    private String aux_municion1 = "";

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

            recuperarTodosLosEquipos();

//            progressBarMunicion1.setProgress(Integer.parseInt(textViewMunicion1.getText().toString()));

            buttonMunicion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 1;
                    dialogButtonMunicion("  Modificar munición", control);
                }
            });

            armaFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFabArmas(opciones_armas);
                }
            });

        }

        return view;
    }

    private void recuperarTodosLosEquipos(){

        try{

            db = dbHelper.getReadableDatabase();
            Cursor c = db
                    .rawQuery("SELECT _id, arma1arma, arma1Danio, arma1Critico, arma1Tipo, arma1Peso, arma1Alcance, arma1Notas, arma1Municion " +
                            "FROM personaje WHERE controlAct='1'",null);

            if(c.moveToFirst()){

                do{
                    aux_id        = c.getString(0);
                    aux_arma1     = c.getString(1);
                    aux_danio1    = c.getString(2);
                    aux_critico1  = c.getString(3);
                    aux_tipo1     = c.getString(4);
                    aux_peso1     = c.getString(5);
                    aux_alcance1  = c.getString(6);
                    aux_notas1    = c.getString(7);
                    aux_municion1 = c.getString(8);

                }while (c.moveToNext());

                textViewArma1.setText(aux_arma1);
                textViewDanio1.setText(aux_danio1);
                textViewCritico1.setText(aux_critico1);
                textViewTipo1.setText(aux_tipo1);
                textViewPeso1.setText(aux_peso1);
                textViewAlcance1.setText(aux_alcance1);
                textViewNotas1.setText(aux_notas1);
                textViewMunicion1.setText(aux_municion1);

                progressBarMunicion1.post(new Runnable() {
                    @Override
                    public void run() {

                        progressBarMunicion1.setProgress(Integer.parseInt(textViewMunicion1.getText().toString()));

                    }
                });

            }


        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        }finally {
            db.close();
        }


    }

    private void dialogFabArmas(String[] opciones_armas){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones_armas, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                switch (position) {

                    case 0:
                        control = 1;
                        dialogFabModificarArma("  Modificar Arma 1", control);
                        break;

                    case 1:
                        control = 2;
                        dialogFabModificarArma("  Modificar Arma 2", control);
                        break;

                    case 2:
                        control = 3;
                        dialogFabModificarArma("  Modificar Arma 3", control);
                        break;

                    case 3:
                        control = 4;
                        dialogFabModificarArma("  Modificar Arma 4", control);
                        break;

                    case 4:
                        control = 5;
                        dialogFabModificarArma("  Modificar Arma 5", control);
                        break;
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void dialogFabModificarArma(String title, final int control){

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

                Cursor c = db
                        .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);
                if(c.moveToFirst()){
                    do {
                        aux_id = c.getString(0);
                    }while (c.moveToNext());
                }
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
                        db.update("personaje", values, "_id='" + aux_id + "'", null);

                        getActivity().recreate();
                        break;
                        default:
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();

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

    private void dialogButtonMunicion(String title, final int control){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_municion, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView textViewTitleMunicion  = viewInflated.findViewById(R.id.textViewTitleMunicion);
        final SeekBar  seekBarMunicionEditor  = viewInflated.findViewById(R.id.seekBarMunicionEditor);
        final TextView textViewMunicionEditor = viewInflated.findViewById(R.id.textViewMunicionEditor);

        textViewTitleMunicion.setText(title);

        switch (control){
            case 1:

                String municion = textViewMunicion1.getText().toString();
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

                Cursor c = db
                        .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);
                if(c.moveToFirst()){
                    do {
                        aux_id = c.getString(0);
                    }while (c.moveToNext());
                }


                switch (control) {
                    case 1:
                    municion = textViewMunicionEditor.getText().toString();

                    values.put("arma1Municion", municion);
                    db.update("personaje", values, "_id='" + aux_id + "'", null);
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

}
