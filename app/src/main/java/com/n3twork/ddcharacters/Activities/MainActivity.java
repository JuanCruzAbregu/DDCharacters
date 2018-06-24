package com.n3twork.ddcharacters.Activities;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.Fragments.PJFragment;
import com.n3twork.ddcharacters.Fragments.SkillsFragment;
import com.n3twork.ddcharacters.Fragments.StatsFragment;
import com.n3twork.ddcharacters.R;
import com.n3twork.ddcharacters.Adapters.ViewPagerAdapter;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private SkillsFragment skillsFragment = new SkillsFragment();

    public static final int PJ_FRAGMENT     = 0;
    public static final int STATS_FRAGMENT  = 1;
    public static final int SKILLS_FRAGMENT = 2;
    public static final int EQUIP_FRAGMENT  = 3;
    public static final int SPELLS_FRAGMENT = 4;
    public static final int OTHERS_FRAGMENT = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setToolbar();
        setTabLayout();
        setViewPager();
        setListenerTabLayout(viewPager);

        skillsFragment.recuperarTodosSkills();

    }

    /**
     * Método que llama al toolbar al iniciar la app
     *
     */

    private void setToolbar() {
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Método que setea los tabs con sus nombres
     *
     */

    private void setTabLayout() {
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("List"));
        tabLayout.addTab(tabLayout.newTab().setText("Pj"));
        tabLayout.addTab(tabLayout.newTab().setText("Hab"));
        tabLayout.addTab(tabLayout.newTab().setText("Inv"));
        tabLayout.addTab(tabLayout.newTab().setText("Mag"));
        tabLayout.addTab(tabLayout.newTab().setText("+"));

    }

    /**
     * Método que refresca la pantalla para llamar a los fragments
     *
     */

    private void setViewPager() {
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    /**
     * Método que llama al fragment al realizar clic en los tabs
     *
     * @param viewPager
     */

    private void setListenerTabLayout(final ViewPager viewPager) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    /*public void modificarModHabilidad(View v){

        TextView textViewRecuperar;
        String valorControl;

        switch (v.getId()){

            case R.id.textViewValorCerradura:

                textViewRecuperar = findViewById(R.id.textViewValorCerradura);
                valorControl = textViewRecuperar.getText().toString();

                Cursor c = db
                        .rawQuery("SELECT _id, ptsHab, cerradura, cerraduraCarac, cerraduraRango, cerraduraVarios FROM personaje WHERE controlAct='1'",null);

                if(c.moveToFirst()){
                    do {

                        aux_id          = c.getString(0);
                        aux_pts_hab     = c.getString(1);
                        aux_total       = c.getString(2);
                        aux_modificador = c.getString(3);
                        aux_rango       = c.getString(4);
                        aux_varios      = c.getString(5);

                    }while (c.moveToNext());
                }

                dialogModificarHabilidades(" Modificar puntos habilidad", valorControl, aux_modificador, aux_rango, aux_varios);


                break;

            case R.id.textViewValorArte:

                textViewRecuperar = findViewById(R.id.textViewValorArte);
                valorControl = textViewRecuperar.getText().toString();

                break;




            default:
                Toast.makeText(getApplicationContext(),"No funciona", Toast.LENGTH_SHORT).show();
        }

    }


    private void dialogModificarHabilidades(String title, final String valorControl, String modificador, String rangos, String valor_varios){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        View viewInflated = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_modificadores_habilidades, null);
        builder.setView(viewInflated);

        final TextView textViewTitle   = findViewById(R.id.tvTitleHabilidades);
        final EditText editTextModCar  = findViewById(R.id.editTextModCaracHab);
        final EditText editTextRangos  = findViewById(R.id.editTextRangos);
        final EditText editTextVarios  = findViewById(R.id.editTextModVariosHab);

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
                if (controlDeValorTotal(valorControl, total)){

                    //Agregar valores a la base de datos
                    //Restar total al valor de control
                    //Agregar valor a la base de datos





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

            Toast.makeText(getApplicationContext(),"No tienes puntos suficientes para asignar",Toast.LENGTH_SHORT).show();
            return false;

        }else {
            return true;
        }
    }*/


}
