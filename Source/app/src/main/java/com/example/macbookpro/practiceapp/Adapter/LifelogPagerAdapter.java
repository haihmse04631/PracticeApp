package com.example.macbookpro.practiceapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.macbookpro.practiceapp.Fragment.ChatFragment;
import com.example.macbookpro.practiceapp.Fragment.MapFragment;
import com.example.macbookpro.practiceapp.Fragment.MusicFragment;
import com.example.macbookpro.practiceapp.Fragment.ProfileFragment;
import com.example.macbookpro.practiceapp.Fragment.SettingFragment;
import com.example.macbookpro.practiceapp.Model.User;

/**
 * Created by MacbookPro on 3/25/18.
 */

public class LifelogPagerAdapter extends FragmentPagerAdapter {

    public LifelogPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public User receivedUser;

    public LifelogPagerAdapter(FragmentManager fm, User receivedUser) {
        super(fm);
        this.receivedUser = receivedUser;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MusicFragment.newInstance();
            case 1:
                return MapFragment.newInstance();
            case 2:
                return ChatFragment.newInstance();
            case 3:
                return ProfileFragment.newInstance(receivedUser);
            case 4:
                return SettingFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
