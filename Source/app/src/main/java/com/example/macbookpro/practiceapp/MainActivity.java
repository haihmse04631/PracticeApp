package com.example.macbookpro.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private RelativeLayout containerLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDot;
    private LinearLayout mDotLayout;
    private TextView tvSkip, tvNext;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TutorialPagerAdapter tutorialPagerAdapter = new TutorialPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.container);
        containerLayout = findViewById(R.id.rl_container);
        mDotLayout = findViewById(R.id.ll_dot);
        tvSkip = findViewById(R.id.tv_skip);
        tvNext = findViewById(R.id.tv_next);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDot(0);

        viewPager.addOnPageChangeListener(viewListener);

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("currentPage", currentPage + "");
                if (currentPage == 2) {
                    Intent intent = new Intent(MainActivity.this, LifelogActivity.class);
                    startActivity(intent);
                } else {
                    viewPager.setCurrentItem(currentPage + 1);
                }

            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LifelogActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addDot(int position) {
        mDot = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < 3; i++) {
            mDot[i] = new TextView(this);
            mDot[i].setText(Html.fromHtml("&#8226"));
            mDot[i].setTextSize(35);
            mDot[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDot[i]);

        }

        if (mDot.length > 0) {
            mDot[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDot(position);
            currentPage = position;

            if (position == 2) {
                tvNext.setText("Finish");
            } else {
                tvNext.setText("Next");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class TutorialPagerAdapter extends FragmentPagerAdapter {

        public TutorialPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.e("position", position + "");
            switch (position) {
                case 0:
                    return TutorialScreen1.newInstance();
                case 1:
                    return TutorialScreen2.newInstance();
                case 2:
                    return TutorialScreen3.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
