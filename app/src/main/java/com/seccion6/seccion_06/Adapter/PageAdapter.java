package com.seccion6.seccion_06.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.seccion6.seccion_06.Fragments.FirstFragment;
import com.seccion6.seccion_06.Fragments.SecondFragment;
import com.seccion6.seccion_06.Fragments.ThirdFragment;

/**
 * Created by quevon24 on 29/11/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PageAdapter(FragmentManager fm, int numberOfTabstabs) {
        super(fm);
        this.numberOfTabs = numberOfTabstabs;
    }

    @Override
    public Fragment getItem(int position) {
        // En base a la posicion se renderiza el fragment
        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
