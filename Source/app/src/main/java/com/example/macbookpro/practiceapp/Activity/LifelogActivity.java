package com.example.macbookpro.practiceapp.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.macbookpro.practiceapp.Adapter.LifelogPagerAdapter;
import com.example.macbookpro.practiceapp.R;

public class LifelogActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifelog);
        tabLayout = findViewById(R.id.tl_header);
        viewPager = findViewById(R.id.vp_container);
        setupUI();
    }

    private void setupUI(){
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_music_tab));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_map_tab));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_chat_tab));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_profile_tab));

        tabLayout.getTabAt(0).getIcon().setAlpha(255);
        tabLayout.getTabAt(1).getIcon().setAlpha(100);
        tabLayout.getTabAt(2).getIcon().setAlpha(100);
        tabLayout.getTabAt(3).getIcon().setAlpha(100);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setAlpha(255);
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setAlpha(100);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        LifelogPagerAdapter adapter = new LifelogPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
