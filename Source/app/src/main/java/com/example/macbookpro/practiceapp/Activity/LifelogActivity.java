package com.example.macbookpro.practiceapp.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.macbookpro.practiceapp.Adapter.LifelogPagerAdapter;
import com.example.macbookpro.practiceapp.R;

public class LifelogActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private TextView tvHome,tvNews,tvInbox,tvProfile,tvSetting;
    private ImageView imgHome,imgNews,imgInbox,imgProfile,imgSetting;
    private TextView[] tabTextviews;
    private ImageView[] tabImageViews;
    private RelativeLayout rlMenuHome, rlMenuNews, rlMenuInbox, rlMenuProfile, rlMenuSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifelog);
        referenceComponent();
        setupUI();
    }


    private void referenceComponent() {
        viewPager = findViewById(R.id.vp_container);
        tvHome = findViewById(R.id.tv_home);
        tvNews = findViewById(R.id.tv_news);
        tvInbox = findViewById(R.id.tv_inbox);
        tvProfile = findViewById(R.id.tv_profile);
        tvSetting = findViewById(R.id.tv_setting);
        imgHome = findViewById(R.id.img_home);
        imgNews = findViewById(R.id.img_news);
        imgInbox = findViewById(R.id.img_inbox);
        imgProfile = findViewById(R.id.img_profile);
        imgSetting = findViewById(R.id.img_setting);
        rlMenuHome = findViewById(R.id.rl_menu1);
        rlMenuNews = findViewById(R.id.rl_menu2);
        rlMenuInbox = findViewById(R.id.rl_menu3);
        rlMenuProfile = findViewById(R.id.rl_menu4);
        rlMenuSetting = findViewById(R.id.rl_menu5);
        rlMenuProfile.setOnClickListener(this);
        rlMenuSetting.setOnClickListener(this);
        rlMenuInbox.setOnClickListener(this);
        rlMenuNews.setOnClickListener(this);
        rlMenuHome.setOnClickListener(this);
        tabTextviews = new TextView[]{tvHome, tvNews, tvInbox, tvProfile, tvSetting};
        tabImageViews = new ImageView[]{imgHome, imgNews, imgInbox, imgProfile, imgSetting};
    }

    private void setupUI() {
        setColorTabBar(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setColorTabBar(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        LifelogPagerAdapter adapter = new LifelogPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private void setColorTabBar(int currentPosition){
        for(int i=0; i<5; i++){
            if(i == currentPosition){
                tabTextviews[currentPosition].setTextColor(Color.RED);
                tabImageViews[currentPosition].setColorFilter(Color.RED);
            }else {
                tabImageViews[i].setColorFilter(Color.BLACK);
                tabTextviews[i].setTextColor(Color.BLACK);
            }
        }
    }


    @Override
    public void onClick(View view) {
        int v = view.getId();
        switch (v){
            case R.id.rl_menu1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rl_menu2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rl_menu3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rl_menu4:
                viewPager.setCurrentItem(3);
                break;
            case R.id.rl_menu5:
                viewPager.setCurrentItem(4);
                break;
        }
    }
}
