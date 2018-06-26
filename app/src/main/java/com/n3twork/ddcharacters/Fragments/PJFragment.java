package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.n3twork.ddcharacters.Adapters.PersonajeAdaptador;
import com.n3twork.ddcharacters.Clases.Personaje;
import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;


public class PJFragment extends ListFragment {

    private ListView listViewPersonajes;
    private FloatingActionButton fabAgregarPj;

    private PersonajeAdaptador personajeAdaptador;

    private DBHelper dbHelper = new DBHelper(getContext());
    private SQLiteDatabase db;

    private String[] opciones_pj = new String[]{"Seleccionar", "Editar", "Borrar"};

    private String aux_id = "";
    private String aux_nombre = "";
    private String aux_clase = "";
    private String aux_raza = "";
    private String aux_alineamiento = "";
    private String aux_nivel = "";
    private String aux_deidad = "";
    private String aux_sexo = "";
    private String aux_campania = "";
    private String aux_experiencia = "";
    private String aux_tamanio = "";
    private String aux_low = "0";
    private String aux_high = "";

    private String[] str_clase  = new String[]{"Bárbaro", "Bardo", "Clérigo", "Druida", "Explorador",
            "Guerrero", "Hechicero", "Mago", "Monje", "Paladín", "Pícaro"};
    private String[] str_raza   = new String[]{"Humano", "Elfo", "Enano", "Gnomo", "Mediano", "Semielfo", "Semiorco"};
    private String[] str_alin   = new String[]{"Legal bueno", "Neutral bueno","Caótico bueno",
            "Legal neutral", "Neutral", "Caótico neutral", "Legal maligno", "Neutral maligno", "Caótico maligno"};
    private String[] str_tamanio = new String[]{"Pequeño", "Mediano", "Grande"};
    private String[] str_deidad = new String[]{"Boccob","Corellon Larethian","Ehlonna","Erythnul","Fharlanghn","GAL",
            "Gruumsh","Heironeous","Hextor","Kord","Moradin","Nerull","Obad-Hai","Olidammara","Pelor","San Cuthbert",
            "Vecna","Wee Jas","Yondalla"};
    public PJFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pj, container, false);

        if(view != null) {
            dbHelper           = new DBHelper(getActivity());
            db                 = dbHelper.getWritableDatabase();
            fabAgregarPj       = view.findViewById(R.id.fabAddPJ);
            listViewPersonajes = view.findViewById(android.R.id.list);
            recuperarTodosLosPersonajes();

            fabAgregarPj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogAgregarPersonaje("  Agregar personaje");
                }
            });


        }
        return view;

    }

    /**
     * Método que muestra en la lista de la tab List, todos los personajes
     * que se encuentran en la base de datos.
     *
     */

    public void recuperarTodosLosPersonajes(){

        try{
            dbHelper = new DBHelper(getActivity());

            Cursor cursor = dbHelper.obtenerTodosPersonajes();

            String[] from = new String[]{
                    "_id",
                    "nombrePj",
                    "clasePj",
                    "nivelPj",
                    "razaPj",
                    "alineamientoPj",
                    "deidadPj",
                    "tamañoPj",
                    "sexoPj",
                    "expPj",
                    "expLow",
                    "expHigh",
                    "campañaPj",
                    "controlAct"
            };

            int[] to = new int[]{
                    R.id.identPj,
                    R.id.textViewNombre,
                    R.id.textViewClase,
                    R.id.textViewNivel,
                    R.id.textViewRaza2,
                    R.id.textViewAlineamiento2,
                    R.id.textViewDeidad2,
                    R.id.textViewTamaño2,
                    R.id.textViewSexo2,
                    R.id.textViewExp2,
                    R.id.textViewLow2,
                    R.id.textViewHigh2,
                    R.id.textViewCampaña2,
                    R.id.textViewControlAct
            };

            personajeAdaptador = new PersonajeAdaptador(getContext(), cursor, from, to, 0);
            listViewPersonajes.setAdapter(personajeAdaptador);

            listViewPersonajes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textViewNombrePJ      = view.findViewById(R.id.textViewNombre);
                    TextView textViewClasePJ       = view.findViewById(R.id.textViewClase);
                    TextView textViewNivelPJ       = view.findViewById(R.id.textViewNivel);
                    TextView textViewRaza2         = view.findViewById(R.id.textViewRaza2);
                    TextView textViewAlineamiento2 = view.findViewById(R.id.textViewAlineamiento2);
                    TextView textViewDeidad2       = view.findViewById(R.id.textViewDeidad2);
                    TextView textViewTamanio2      = view.findViewById(R.id.textViewTamaño2);
                    TextView textViewSexo2         = view.findViewById(R.id.textViewSexo2);
                    TextView textViewExp2          = view.findViewById(R.id.textViewExp2);
                    TextView textViewCampania2     = view.findViewById(R.id.textViewCampaña2);
                    TextView textViewIdPJ          = view.findViewById(R.id.identPj);

                    aux_nombre       = textViewNombrePJ.getText().toString();
                    aux_clase        = textViewClasePJ.getText().toString();
                    aux_nivel        = textViewNivelPJ.getText().toString();
                    aux_raza         = textViewRaza2.getText().toString();
                    aux_alineamiento = textViewAlineamiento2.getText().toString();
                    aux_deidad       = textViewDeidad2.getText().toString();
                    aux_tamanio      = textViewTamanio2.getText().toString();
                    aux_sexo         = textViewSexo2.getText().toString();
                    aux_experiencia  = textViewExp2.getText().toString();
                    aux_campania     = textViewCampania2.getText().toString();
                    aux_id           = textViewIdPJ.getText().toString();

                    dialogOpcionesPersonaje(opciones_pj, aux_id, aux_nombre, aux_clase, aux_raza, aux_alineamiento, aux_nivel,
                            aux_deidad, aux_sexo, aux_campania, aux_experiencia, aux_tamanio);

                    return true;
                }
            });

        }catch (Exception e){
            Log.e("Error", "Error: " +e.getMessage());
        }finally {
            dbHelper.cerrar();
        }
    }

    /**
     * Este método genera un cuadro de diálogo que permite agendar nuevos personajes
     * en la tabla Personaje de la base de datos.
     *
     * @param title
     */

    public void dialogAgregarPersonaje(final String title){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_agregar_personaje, null);
        builder.setView(viewInflated);

        final TextView textViewTitle                    = viewInflated.findViewById(R.id.textViewTitle);
        final AutoCompleteTextView editTextClase        = viewInflated.findViewById(R.id.editTextClasePJ);
        final AutoCompleteTextView editTextRaza         = viewInflated.findViewById(R.id.editTextRaza);
        final AutoCompleteTextView editTextAlineamiento = viewInflated.findViewById(R.id.editTextAlineamiento);
        final AutoCompleteTextView editTextDeidad       = viewInflated.findViewById(R.id.editTextDeidad);
        final AutoCompleteTextView editTextTamanio      = viewInflated.findViewById(R.id.editTextTamaño);
        final EditText editTextNombre                   = viewInflated.findViewById(R.id.editTextNombrePJ);
        final EditText editTextNivel                    = viewInflated.findViewById(R.id.editTextNivelPJ);
        final EditText editTextExp                      = viewInflated.findViewById(R.id.editTextExperiencia);
        final EditText editTextCampania                 = viewInflated.findViewById(R.id.editTextCampaña);
        final RadioButton rbMasculino                   = viewInflated.findViewById(R.id.rbMasculino);
        final RadioButton rbFemenino                    = viewInflated.findViewById(R.id.rbFemenino);

        ArrayAdapter<String> adapterClase = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_clase);

        ArrayAdapter<String> adapterRaza = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_raza);

        ArrayAdapter<String> adapterDeidad = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_deidad);

        ArrayAdapter<String> adapterAlin = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_alin);

        ArrayAdapter<String> adapterTamanio = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_tamanio);

        editTextClase.setThreshold(0);
        editTextRaza.setThreshold(0);
        editTextDeidad.setThreshold(0);
        editTextAlineamiento.setThreshold(0);
        editTextTamanio.setThreshold(0);

        editTextClase.setAdapter(adapterClase);
        editTextRaza.setAdapter(adapterRaza);
        editTextDeidad.setAdapter(adapterDeidad);
        editTextAlineamiento.setAdapter(adapterAlin);
        editTextTamanio.setAdapter(adapterTamanio);

        textViewTitle.setText(title);

        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre        = editTextNombre.getText().toString();
                String clase         = editTextClase.getText().toString();
                String nivel         = editTextNivel.getText().toString();
                String raza          = editTextRaza.getText().toString();
                String alineamiento  = editTextAlineamiento.getText().toString();
                String deidad        = editTextDeidad.getText().toString();
                String tamanio       = editTextTamanio.getText().toString();
                String sexo          = sexoMetodoRadioButtons(rbMasculino, rbFemenino);
                String exp           = editTextExp.getText().toString();
                String campania      = editTextCampania.getText().toString();

                if(nombre.length() > 0 && clase.length() > 0 && nivel.length() > 0 && raza.length() > 0 &&
                        alineamiento.length() > 0 && deidad.length() > 0 && tamanio.length() > 0 &&
                        sexo.length() > 0 && exp.length() > 0 && campania.length() > 0) {

                    if (verificarNivel(nivel)) {

                        aux_high  = cambiarHighSegunNivel(nivel);

                        if (verificarExpNivel(nivel, exp)) {

                            // Agregar los puntos de habilidad correspondientes al nivel.

                            agregarPersonaje(nombre, clase, nivel, raza, alineamiento, deidad, tamanio, sexo, exp, aux_low, aux_high, campania);
                            recuperarTodosLosPersonajes();
                        }
                    }
                } else {

                    Toast.makeText(getContext(), "Campos incompletos, intente de nuevo", Toast.LENGTH_SHORT).show();

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
     * Método que devuelve el sexo del PJ a través de los RadioButtons
     *
     * @return
     */

    public String sexoMetodoRadioButtons(RadioButton rbMasculino, RadioButton rbFemenino){

        String sexo = "";

        if(rbMasculino.isChecked()){
            sexo = "Masculino";
        }else if(rbFemenino.isChecked()){
            sexo = "Femenino";
        }

        return sexo;
    }

    /**
     *Método que llama al método de la db para agregar un personaje nuevo.
     *
     * @param nombre
     * @param clase
     * @param nivel
     */

    public void agregarPersonaje(String nombre, String clase, String nivel, String raza, String alineamiento,
                                 String deidad, String tamanio, String sexo, String exp, String low, String high, String campania) {

        //Agregar método que asigne puntos de habilidad según la clase del pj

        Personaje personaje = new Personaje(nombre, clase, nivel, raza, alineamiento, deidad, tamanio,
                sexo, exp, low, high, campania, "0", "0","0","0","0",
                "0","0","0","0","0","0", "0","0","0",
                "0", "0", "", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0", "0", "0", "0", "0", "0", "0","0","0",
                "0", "0","0","0","0", "0","0","0", "-", "0", "0",
                "-", "0", "0", "-", "0");

        dbHelper.addPersonaje(personaje);
    }

    /**
     * Método que muestra opciones para el pj al hacer longClick en la lista.
     *
     * @param opciones_pj
     */

    public void dialogOpcionesPersonaje(final String[] opciones_pj, final String aux_id, final String aux_nombre, final String aux_clase, final String aux_raza,
                                        final String aux_alineamiento, final String aux_nivel, final String aux_deidad, final String aux_sexo,
                                        final String aux_campaña, final String aux_experiencia, final String aux_tamaño){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones_pj, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){

                    dialogConfirmarSeleccion("Seleccionar PJ", "¿Desea seleccionar este personaje?", aux_nombre);

                }

                else if(position == 1){

                    dialogEditarPj(" Editar", aux_id, aux_nombre, aux_clase, aux_raza, aux_alineamiento, aux_nivel, aux_deidad,
                            aux_sexo, aux_campaña, aux_experiencia, aux_tamaño);

                } else if(position == 2){

                    dialogConfirmarBorrado("Borrar personaje", "¿Desea borrar a "+aux_nombre+" de su lista de personajes?", aux_nombre);

                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * Método que pide confimación para enviar todos los datos a los otros fragments.
     *
     * @param title
     * @param message
     */
    public void dialogConfirmarSeleccion(String title, String message, final String aux_nombre){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if(title !=null){
            builder.setTitle(title);
        }

        if(message !=null){
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    dbHelper = new DBHelper(getContext());
                    db = dbHelper.getReadableDatabase();
                    Cursor c = db
                            .rawQuery("SELECT nombrePj, controlAct FROM personaje", null);

                    if(c.moveToFirst()){

                        do{

                            ContentValues values = new ContentValues();

                            values.put("controlAct","1");

                            String[]args = new String[]{aux_nombre};

                            db.update("personaje",values,"nombrePj=?", args);

                            values.put("controlAct","0");
                            db.update("personaje",values,"nombrePj!=?",args);

                        }while (c.moveToNext());

                    }

                    recuperarTodosLosPersonajes();

                    Intent i = getContext().getPackageManager()
                            .getLaunchIntentForPackage( getContext().getPackageName() );
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                }catch (Exception e){

                    Log.e("Error", "Error: "+e.getMessage());

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

    public void dialogEditarPj(String title, final String aux_id, final String aux_nombre, final String aux_clase, final String aux_raza,
                               final String aux_alineamiento, final String aux_nivel, final String aux_deidad, final String aux_sexo,
                               final String aux_campaña, final String aux_experiencia, final String aux_tamaño){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_agregar_personaje, null);
        builder.setView(viewInflated);

        final TextView textViewTitle                    = viewInflated.findViewById(R.id.textViewTitle);
        final AutoCompleteTextView editTextClase        = viewInflated.findViewById(R.id.editTextClasePJ);
        final AutoCompleteTextView editTextRaza         = viewInflated.findViewById(R.id.editTextRaza);
        final AutoCompleteTextView editTextAlineamiento = viewInflated.findViewById(R.id.editTextAlineamiento);
        final AutoCompleteTextView editTextDeidad       = viewInflated.findViewById(R.id.editTextDeidad);
        final AutoCompleteTextView editTextTamaño       = viewInflated.findViewById(R.id.editTextTamaño);
        final EditText editTextNombre                   = viewInflated.findViewById(R.id.editTextNombrePJ);
        final EditText editTextNivel                    = viewInflated.findViewById(R.id.editTextNivelPJ);
        final EditText editTextExp                      = viewInflated.findViewById(R.id.editTextExperiencia);
        final EditText editTextCampaña                  = viewInflated.findViewById(R.id.editTextCampaña);
        final RadioButton rbMasculino                   = viewInflated.findViewById(R.id.rbMasculino);
        final RadioButton rbFemenino                    = viewInflated.findViewById(R.id.rbFemenino);

        ArrayAdapter<String> adapterClase = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_clase);

        ArrayAdapter<String> adapterRaza = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_raza);

        ArrayAdapter<String> adapterDeidad = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_deidad);

        ArrayAdapter<String> adapterAlin = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_alin);

        ArrayAdapter<String> adapterTamaño = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, str_tamanio);

        editTextClase.setThreshold(0);
        editTextRaza.setThreshold(0);
        editTextDeidad.setThreshold(0);
        editTextAlineamiento.setThreshold(0);
        editTextTamaño.setThreshold(0);

        editTextClase.setAdapter(adapterClase);
        editTextRaza.setAdapter(adapterRaza);
        editTextDeidad.setAdapter(adapterDeidad);
        editTextAlineamiento.setAdapter(adapterAlin);
        editTextTamaño.setAdapter(adapterTamaño);

        cambiarRbAlEditarPJ(rbMasculino, rbFemenino);

        textViewTitle.setText(title);
        editTextNombre.setText(aux_nombre);
        editTextClase.setText(aux_clase);
        editTextNivel.setText(aux_nivel);
        editTextRaza.setText(aux_raza);
        editTextAlineamiento.setText(aux_alineamiento);
        editTextDeidad.setText(aux_deidad);
        editTextTamaño.setText(aux_tamaño);
        editTextExp.setText(aux_experiencia);
        editTextCampaña.setText(aux_campaña);

        builder.setCancelable(true);

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre  = editTextNombre.getText().toString();
                String clase   = editTextClase.getText().toString();
                String nivel   = editTextNivel.getText().toString();
                String raza    = editTextRaza.getText().toString();
                String alinea  = editTextAlineamiento.getText().toString();
                String deidad  = editTextDeidad.getText().toString();
                String tamaño  = editTextTamaño.getText().toString();
                String sexo    = sexoMetodoRadioButtons(rbMasculino, rbFemenino);
                String exp     = editTextExp.getText().toString();
                String campaña = editTextCampaña.getText().toString();

                if(verificarNivel(aux_nivel)) {

                    aux_high  = cambiarHighSegunNivel(aux_nivel);

                    try {

                        db = dbHelper.getReadableDatabase();

                        Cursor c = db
                                .rawQuery("SELECT * FROM personaje WHERE _id='" + aux_id + "'", null);


                        if (c.moveToFirst()) {

                            do {

                                ContentValues values = new ContentValues();
                                values.put("nombrePj", nombre);
                                values.put("clasePj", clase);
                                values.put("nivelPj", nivel);
                                values.put("razaPj", raza);
                                values.put("alineamientoPj", alinea);
                                values.put("deidadPj", deidad);
                                values.put("tamañoPj", tamaño);
                                values.put("sexoPj", sexo);
                                values.put("expPj", exp);
                                values.put("expLow", aux_low);
                                values.put("expHigh", aux_high);
                                values.put("campañaPj", campaña);
                                db.update("personaje", values, "_id='" + aux_id + "'", null);

                            } while (c.moveToNext());

                            recuperarTodosLosPersonajes();
                            (getActivity()).recreate();
                        }
                    } catch (Exception e) {
                        Log.e("Error", "Error: " + e.getMessage());
                    } finally {
                        db.close();
                    }
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
     * Método que escoje el radioButton al editar el PJ
     *
     * @param rbMasculino
     * @param rbFemenino
     */

    public void cambiarRbAlEditarPJ(RadioButton rbMasculino, RadioButton rbFemenino){

        try{
            db = dbHelper.getReadableDatabase();

            Cursor c = db
                    .rawQuery("SELECT sexoPj FROM personaje WHERE controlAct='1'",null);
            if(c.moveToFirst());

            String sexo = c.getString(0);

            if(sexo.equals("Masculino")){
                rbMasculino.setChecked(true);
            }else if(sexo.equals("Femenino")){
                rbFemenino.setChecked(true);
            }

        }catch (Exception e){
            Log.e("Error","Error: "+e.getMessage());
        }finally {
            db.close();
        }
    }

    /**
     * Diálogo de confirmación para borrar personaje.
     *
     * @param title
     * @param message
     * @param aux_nombre
     */

    public void dialogConfirmarBorrado(String title, String message, final String aux_nombre){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if(title !=null){
            builder.setTitle(title);
        }

        if(message !=null){
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {

                    db = dbHelper.getWritableDatabase();
                    db.delete("personaje", "nombrePj='" +aux_nombre+"'", null);
                    recuperarTodosLosPersonajes();
                    (getActivity()).recreate();

                }catch (Exception e){

                    Log.e("Error", "Error: "+e.getMessage());

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


    public String cambiarHighSegunNivel(String aux_nivel){

        String high = "";

        switch (aux_nivel){

            case "1":
                high = "1000";
                break;
            case "2":
                high = "3000";
                break;
            case "3":
                high = "6000";
                break;
            case "4":
                high = "10000";
                break;
            case "5":
                high = "15000";
                break;
            case "6":
                high = "21000";
                break;
            case "7":
                high = "28000";
                break;
            case "8":
                high = "36000";
                break;
            case "9":
                high = "45000";
                break;
            case "10":
                high = "55000";
                break;
            case "11":
                high = "66000";
                break;
            case "12":
                high = "78000";
                break;
            case "13":
                high = "91000";
                break;
            case "14":
                high = "105000";
                break;
            case "15":
                high = "120000";
                break;
            case "16":
                high = "136000";
                break;
            case "17":
                high = "153000";
                break;
            case "18":
                high = "171000";
                break;
            case "19":
                high = "190000";
                break;
            case "20":
                high = "MAX";
                break;
        }

        return high;
    }


    /**
     * Método que verifica que los datos tengan lógica al ingresar el nivel/exp.
     *
     * @param aux_nivel
     */

    public Boolean verificarExpNivel(String aux_nivel, String aux_experiencia){


        String high = cambiarHighSegunNivel(aux_nivel);

        int exp      = Integer.parseInt(aux_experiencia);
        int exp_high = Integer.parseInt(high);

        if(exp < 0 || exp > exp_high || exp == exp_high){
            Toast.makeText(getContext(),"Para el nivel "+aux_nivel+ " tiene que tener exp entre 0 y "+exp_high+".", Toast.LENGTH_LONG).show();
            return false;

        } else {

            return true;

        }

    }

    private Boolean verificarNivel(String aux_nivel){

        int nivel = Integer.parseInt(aux_nivel);

        if(nivel < 1){

            Toast.makeText(getContext(),"El nivel tiene que ser mayor a 1", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(nivel > 20){

            Toast.makeText(getContext(),"El nivel tiene que ser menor a 20", Toast.LENGTH_SHORT).show();
            return false;
        }

        else{
            return true;
        }

    }

}
