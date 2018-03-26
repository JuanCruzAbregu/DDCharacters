package com.n3twork.ddcharacters.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.n3twork.ddcharacters.Fragments.PJFragment;
import com.n3twork.ddcharacters.Fragments.SkillsFragment;
import com.n3twork.ddcharacters.Fragments.StatsFragment;
import com.n3twork.ddcharacters.R;
import com.n3twork.ddcharacters.Adapters.ViewPagerAdapter;

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
}
