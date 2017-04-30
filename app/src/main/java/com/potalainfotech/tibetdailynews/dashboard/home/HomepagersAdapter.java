package com.potalainfotech.tibetdailynews.dashboard.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by tenzi on 4/24/2017.
 */

public class HomepagersAdapter extends FragmentPagerAdapter {

    // Create list of fragment and fragement title.

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabtitles = new ArrayList<>();

    public void addFragments(Fragment fragments,String titles){

        this.fragments.add(fragments);
        this.tabtitles.add(titles);
    }

    public HomepagersAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }
}
