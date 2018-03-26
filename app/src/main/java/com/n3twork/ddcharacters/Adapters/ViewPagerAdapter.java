package com.n3twork.ddcharacters.Adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.n3twork.ddcharacters.Fragments.EquipFragment;
import com.n3twork.ddcharacters.Fragments.OthersFragment;
import com.n3twork.ddcharacters.Fragments.PJFragment;
import com.n3twork.ddcharacters.Fragments.SkillsFragment;
import com.n3twork.ddcharacters.Fragments.SpellsFragment;
import com.n3twork.ddcharacters.Fragments.StatsFragment;

import static com.n3twork.ddcharacters.Activities.MainActivity.PJ_FRAGMENT;
import static com.n3twork.ddcharacters.Activities.MainActivity.SKILLS_FRAGMENT;
import static com.n3twork.ddcharacters.Activities.MainActivity.SPELLS_FRAGMENT;
import static com.n3twork.ddcharacters.Activities.MainActivity.STATS_FRAGMENT;
import static com.n3twork.ddcharacters.Activities.MainActivity.EQUIP_FRAGMENT;
import static com.n3twork.ddcharacters.Activities.MainActivity.OTHERS_FRAGMENT;

/**
 * Created by N3TWORK on 6/2/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int tabsNum;

    public ViewPagerAdapter(FragmentManager fm, Context context, int tabsNum){
        super(fm);
        this.tabsNum = tabsNum;
    }

    @Override
    public Fragment getItem(int position){

        switch (position){
            case PJ_FRAGMENT:
                return new PJFragment();
            case STATS_FRAGMENT:
                return new StatsFragment();
            case SKILLS_FRAGMENT:
                return new SkillsFragment();
            case EQUIP_FRAGMENT:
                return new EquipFragment();
            case SPELLS_FRAGMENT:
                return new SpellsFragment();
            case OTHERS_FRAGMENT:
                return new OthersFragment();
            default:
                return null;
        }

    }
    @Override
    public int getCount() {
        return tabsNum;
    }

}
