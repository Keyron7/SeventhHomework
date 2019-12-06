package com.example.seventhhomework.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    public ViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position){
        if (0 == position){
            return "呼入电话";
        }else if (1 == position){
            return "呼出电话";
        }else if (2 == position){
            return "未接电话";
        }
        return null;
    }
    public Fragment getItem(int position) {
        if (0 == position){
            return new Firstfragment();}
        else if (1 == position){
            return new Secondfragment();
        }
        else if (2 == position){
            return new Thirdfragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
