package com.example.macbookpro.practiceapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.macbookpro.practiceapp.Adapter.SliderAdapter;
import com.example.macbookpro.practiceapp.R;

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
        viewPager = findViewById(R.id.container);
        containerLayout = findViewById(R.id.rl_container);
        mDotLayout = findViewById(R.id.ll_dot);
        tvSkip = findViewById(R.id.tv_skip);
        tvNext = findViewById(R.id.tv_next);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDot(0);
        Log.e("status", "oncreate");
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




}
