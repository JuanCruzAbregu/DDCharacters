package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.ImageButton;
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

    private Button buttonPH;

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
    private String aux_ptsHab = "";
    private String aux_rangos = "";
    private String aux_modInt = "";
    private String[] opc_ptsHab = new String[]{"Actualizar", "Borrar"};

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
    private CheckBox checkEngañar;
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

    private TextView textViewPH;

    private ImageButton imgBtnRefreshSkills;

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
            checkCerradura       = view.findViewById(R.id.checkCerradura);
            checkArte            = view.findViewById(R.id.checkArte);
            checkIntenciones     = view.findViewById(R.id.checkIntenciones);
            checkAvistar         = view.findViewById(R.id.checkAvistar);
            checkBuscar          = view.findViewById(R.id.checkBuscar);
            checkConcentracion   = view.findViewById(R.id.checkConcentracion);
            checkConjuros        = view.findViewById(R.id.checkConjuros);
            checkDesfEscritura   = view.findViewById(R.id.checkDesfEscritura);
            checkDiplomacia      = view.findViewById(R.id.checkDiplomacia);
            checkDisfraz         = view.findViewById(R.id.checkDisfraz);
            checkEngañar         = view.findViewById(R.id.checkEngañar);
            checkEquilibrio      = view.findViewById(R.id.checkEquilibrio);
            checkEscapismo       = view.findViewById(R.id.checkEscapismo);
            checkEsconderse      = view.findViewById(R.id.checkEsconderse);
            checkEscuchar        = view.findViewById(R.id.checkEscuchar);
            checkFalsificar      = view.findViewById(R.id.checkFalsificar);
            checkInterpretar1    = view.findViewById(R.id.checkInterpretar1);
            checkInterpretar2    = view.findViewById(R.id.checkInterpretar2);
            checkInterpretar3    = view.findViewById(R.id.checkInterpretar3);
            checkIntimidar       = view.findViewById(R.id.checkIntimidar);
            checkInutilizarMeq   = view.findViewById(R.id.checkInutilizarMeq);
            checkJuegoManos      = view.findViewById(R.id.checkJuegoManos);
            checkMontar          = view.findViewById(R.id.checkMontar);
            checkSigilo          = view.findViewById(R.id.checkSigilo);
            checkNadar           = view.findViewById(R.id.checkNadar);
            checkOficio          = view.findViewById(R.id.checkOficio);
            checkPiruetas        = view.findViewById(R.id.checkPiruetas);
            checkReunirInfo      = view.findViewById(R.id.checkReunirInfo);
            checkSaberArcano     = view.findViewById(R.id.checkSaberArcano);
            checkSaberIng        = view.findViewById(R.id.checkSaberIng);
            checkSaberDung       = view.findViewById(R.id.checkSaberDung);
            checkSaberGeo        = view.findViewById(R.id.checkSaberGeo);
            checkSaberHistoria   = view.findViewById(R.id.checkSaberHistoria);
            checkSaberLocal      = view.findViewById(R.id.checkSaberLocal);
            checkSaberPlanos     = view.findViewById(R.id.checkSaberPlanos);
            checkSaberNat        = view.findViewById(R.id.checkSaberNat);
            checkSaberNobleza    = view.findViewById(R.id.checkSaberNobleza);
            checkSaberReligion   = view.findViewById(R.id.checkSaberReligion);
            checkSaltar          = view.findViewById(R.id.checkSaltar);
            checkSanar           = view.findViewById(R.id.checkSanar);
            checkSuperv          = view.findViewById(R.id.checkSuperv);
            checkTasacion        = view.findViewById(R.id.checkTasacion);
            checkAnimales        = view.findViewById(R.id.checkAnimales);
            checkTrepar          = view.findViewById(R.id.checkTrepar);
            checkObjMagico       = view.findViewById(R.id.checkObjMagico);
            checkCuerdas         = view.findViewById(R.id.checkCuerdas);
            imgBtnRefreshSkills  = view.findViewById(R.id.imgBtnRefreshSkills);
            buttonPH             = view.findViewById(R.id.buttonPH);
            textViewPH           = view.findViewById(R.id.textViewPH);

            //Acá hago el refresco inicial de la pantalla.
            recuperarTodosSkills();

            //Este es el método del imgBtn.
            imgBtnRefreshSkills.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = getContext().getPackageManager()
                            .getLaunchIntentForPackage( getContext().getPackageName() );
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            });

            //Este el método del boton de ph

            buttonPH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    opcionesPuntosHabilidad(opc_ptsHab);

                }
            });

        }

        return view;
    }

    private void opcionesPuntosHabilidad(String[] opc_ptsHab){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setItems(opc_ptsHab, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){

                    opcionModificarPuntosRestantes("Actualizar puntos de habilidad");


                }

                if(position == 1){

                    opcionBorrarPuntosRestantes("Borrar puntos", "¿Desea reiniciar los puntos de habilidad?");

                }

            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void opcionModificarPuntosRestantes(String title){

        aux_ptsHab = textViewPH.getText().toString();

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_botones_sueltos_skill, null);
        builder.setView(viewInflated);

        final TextView textViewTitleDialogHab = viewInflated.findViewById(R.id.tvTitleBotonesSueltosSkill);
        final EditText editTextPuntosSkill    = viewInflated.findViewById(R.id.editTextPuntosSkill);

        textViewTitleDialogHab.setText(title);
        editTextPuntosSkill.setText(aux_ptsHab);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                aux_ptsHab = editTextPuntosSkill.getText().toString();

                try {

                    dbHelper = new DBHelper(getActivity());
                    db       = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()) {

                        do {

                            aux_id = c.getString(0);

                        } while (c.moveToNext());
                    }

                    ContentValues values = new ContentValues();
                    values.put("ptsHab", aux_ptsHab);
                    db.update("personaje",values,"_id='" + aux_id + "'",null);
                    recuperarTodosSkills();

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

    private void opcionBorrarPuntosRestantes(String title, String message){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {

                    dbHelper = new DBHelper(getActivity());
                    db       = dbHelper.getReadableDatabase();

                    Cursor c = db
                            .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'",null);

                    if(c.moveToFirst()) {

                        do {

                            aux_id = c.getString(0);

                        } while (c.moveToNext());
                    }

                    ContentValues values = new ContentValues();
                    values.put("ptsHab", "0");
                    db.update("personaje",values,"_id='" + aux_id + "'",null);
                    recuperarTodosSkills();

                }catch (Exception e){
                    Log.e("Error","Error: "+e.getMessage());
                }finally {
                    db.close();
                }

            }
        });

        builder.setNegativeButton("Cancelaar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();

    }

//    private String calcularPuntosSegunClase(String aux_clase, int modInt) {
//
//        String puntos = "";
//        int resultado = 0;
//
//        switch (aux_clase) {
//
//            case "Bárbaro":
//
//                resultado = (4 + modInt) * 4;
//                break;
//
//            case "Bardo":
//
//                resultado = (6 + modInt) * 4;
//                break;
//
//            case "Clérigo":
//
//                resultado = (2 + modInt) * 4;
//                break;
//
//            case "Druida":
//
//                resultado = (4 + modInt) * 4;
//                break;
//
//            case "Explorador":
//
//                resultado = (6 + modInt) * 4;
//                break;
//
//            case "Guerrero":
//
//                resultado = (2 + modInt) * 4;
//
//                break;
//
//            case "Hechicero":
//
//                resultado = (2 + modInt) * 4;
//                break;
//
//            case "Mago":
//
//                resultado = (2 + modInt) * 4;
//                break;
//
//            case "Monje":
//
//                resultado = (4 + modInt) * 4;
//                break;
//
//            case "Paladín":
//
//                resultado = (2 + modInt) * 4;
//                break;
//
//            case "Pícaro":
//
//                resultado = (8 + modInt) * 4;
//                break;
//
//        }
//
//        puntos = String.valueOf(resultado);
//
//        return puntos;
//
//    }

    public void recuperarTodosSkills(){

        try {
            dbHelper = new DBHelper(getActivity());
            db = dbHelper.getReadableDatabase();

            Cursor c = db
                    .rawQuery("SELECT _id, clasePj, ptsHab FROM personaje WHERE controlAct='1'", null);

            if (c.moveToFirst()) {
                do {
                    aux_id = c.getString(0);
                    aux_clase = c.getString(1);
                    aux_ptsHab = c.getString(2);

                } while (c.moveToNext());

                habilidadesPorClase(aux_clase);

                textViewPH.setText(aux_ptsHab);

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
            checkEngañar.setChecked(false);
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
            checkEngañar.setClickable(false);
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
            checkEngañar.setChecked(false);
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

            checkArte.setClickable(false);
            checkAvistar.setClickable(false);
            checkBuscar.setClickable(false);
            checkConcentracion.setClickable(false);
            checkEsconderse.setClickable(false);
            checkEscuchar.setClickable(false);
            checkMontar.setClickable(false);
            checkSigilo.setClickable(false);
            checkNadar.setClickable(false);
            checkOficio.setClickable(false);
            checkSaberDung.setClickable(false);
            checkSaberGeo.setClickable(false);
            checkSaberNat.setClickable(false);
            checkSaltar.setClickable(false);
            checkSanar.setClickable(false);
            checkSuperv.setClickable(false);
            checkAnimales.setClickable(false);
            checkTrepar.setClickable(false);
            checkCuerdas.setClickable(false);
            checkIntimidar.setClickable(false);
            checkCerradura.setClickable(false);
            checkIntenciones.setClickable(false);
            checkConjuros.setClickable(false);
            checkDesfEscritura.setClickable(false);
            checkDiplomacia.setClickable(false);
            checkDisfraz.setClickable(false);
            checkEngañar.setClickable(false);
            checkEquilibrio.setClickable(false);
            checkEscapismo.setClickable(false);
            checkFalsificar.setClickable(false);
            checkInterpretar1.setClickable(false);
            checkInterpretar2.setClickable(false);
            checkInterpretar3.setClickable(false);
            checkInutilizarMeq.setClickable(false);
            checkJuegoManos.setClickable(false);
            checkPiruetas.setClickable(false);
            checkReunirInfo.setClickable(false);
            checkSaberArcano.setClickable(false);
            checkSaberIng.setClickable(false);
            checkSaberHistoria.setClickable(false);
            checkSaberLocal.setClickable(false);
            checkSaberPlanos.setClickable(false);
            checkSaberNobleza.setClickable(false);
            checkSaberReligion.setClickable(false);
            checkTasacion.setClickable(false);
            checkObjMagico.setClickable(false);

        } else {
            Toast.makeText(getContext(),"En mantenimiento",Toast.LENGTH_SHORT).show();
        }
    }



}
