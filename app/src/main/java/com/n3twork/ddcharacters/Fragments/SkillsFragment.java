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
    private String[] opc_ptsHab = new String[]{"Actualizar", "Borrar"};

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
    private Button btnInutilizarMeq;
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



    private TextView textViewPH;

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
            buttonPH            = view.findViewById(R.id.buttonPH);
            textViewPH          = view.findViewById(R.id.textViewPH);

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
            btnInutilizarMeq = view.findViewById(R.id.btnValorInutilizarMeq);
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

            buttonPH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    opcionesPuntosHabilidad(opc_ptsHab);

                }
            });

            btnCerradura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    control = 1;

                    modificarPuntosHabilidad(control);

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
                    .rawQuery("SELECT _id, clasePj, ptsHab, cerradura FROM personaje WHERE controlAct='1'", null);

            if (c.moveToFirst()) {
                do {
                    aux_id = c.getString(0);
                    aux_clase = c.getString(1);
                    aux_ptsHab = c.getString(2);
                    aux_cerradura = c.getString(3);
                } while (c.moveToNext());

                habilidadesPorClase(aux_clase);

                textViewPH.setText(aux_ptsHab);
                btnCerradura.setText(aux_cerradura);

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
            checkEnganiar.setClickable(false);
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

    private void modificarPuntosHabilidad(int control){

        db = dbHelper.getReadableDatabase();

        switch (control) {

            case 1: //Cerradura

            Cursor c1 = db
                    .rawQuery("SELECT _id, ptsHab, cerradura, cerraduraCarac, cerraduraRango, cerraduraVarios FROM personaje WHERE controlAct='1'", null);

            if (c1.moveToFirst()) {
                do {

                    aux_id = c1.getString(0);
                    aux_pts_hab = c1.getString(1);
                    aux_total = c1.getString(2);
                    aux_modificador = c1.getString(3);
                    aux_rango = c1.getString(4);
                    aux_varios = c1.getString(5);

                } while (c1.moveToNext());
            }

            dialogModificarHabilidades(" Modificar puntos habilidad", aux_modificador, aux_rango, aux_varios, control, aux_id);

            break;

            case 2: //Arte

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

        editTextModCar.setText(modificador);
        editTextRangos.setText(rangos);
        editTextVarios.setText(valor_varios);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                final String modif  = editTextModCar.getText().toString();
                final String rango  = editTextRangos.getText().toString();
                final String varios = editTextVarios.getText().toString();

                final String total = devolverSumaDePuntos(modif, rango, varios);

                switch (control){
                    case 1:

                        ContentValues values = new ContentValues();

                        values.put("cerradura", total);
                        values.put("cerraduraCarac", modif);
                        values.put("cerraduraRango", rango);
                        values.put("cerraduraVarios", varios);
                        db.update("personaje", values, "_id='" + aux_id + "'", null);
                        btnCerradura.setText(total);
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

    private Boolean controlDeValorTotal(String valorControl, String valorTotal){

        int control = Integer.parseInt(valorControl);
        int total   = Integer.parseInt(valorTotal);


        if(total > control){

            Toast.makeText(getContext(),"No tienes puntos suficientes para asignar",Toast.LENGTH_SHORT).show();
            return false;

        }else {
            return true;
        }
    }



}
