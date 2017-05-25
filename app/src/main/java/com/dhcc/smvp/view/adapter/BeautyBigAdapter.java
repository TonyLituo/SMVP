package com.dhcc.smvp.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dhcc.smvp.view.test.BeautyFragment;

import java.util.List;

/**
 * Created by Jinx on 2017/5/19.
 * <p>
 * 美女大图Viewpager
 */

public class BeautyBigAdapter extends FragmentPagerAdapter {
    private List<Integer> mList;


    public BeautyBigAdapter(FragmentManager fm, List<Integer> list) {
        super(fm);
        this.mList = list;

    }

    @Override
    public Fragment getItem(int position) {
        BeautyFragment fragment = BeautyFragment.newInstance(mList.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return null == mList ? 0 : mList.size();
    }

}
