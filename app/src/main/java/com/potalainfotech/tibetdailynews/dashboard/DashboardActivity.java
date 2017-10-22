package com.potalainfotech.tibetdailynews.dashboard;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.potalainfotech.tibetdailynews.R;
import com.potalainfotech.tibetdailynews.fragments.home.HomeFragment;
import com.potalainfotech.tibetdailynews.fragments.home.HomepagersAdapter;
import com.potalainfotech.tibetdailynews.fragments.opinion.OpinionFragment;
import com.potalainfotech.tibetdailynews.fragments.popular.PopularFragment;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomepagersAdapter pagersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initView();
        setupToolBar(getString(R.string.app_name));

    }

    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pagersAdapter = new HomepagersAdapter(getSupportFragmentManager());
        pagersAdapter.addFragments(new HomeFragment(),getResources().getString(R.string.tabHome));
        pagersAdapter.addFragments(new OpinionFragment(),getResources().getString(R.string.tabOpinion));
        pagersAdapter.addFragments(new PopularFragment(),getResources().getString(R.string.tabPopular));
        viewPager.setAdapter(pagersAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }


    private void setupToolBar(String title) {

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

    }
}
