package com.dhcc.smvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dhcc.smvp.R;
import com.dhcc.smvp.view.adapter.BeautyBigAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 全屏幕大图，透明状态栏
 * 传入图片集合，及当前位置
 */
public class BeautyActivity extends AppCompatActivity {


    @BindView(R.id.vpg_beauty)
    ViewPager mVpgBeauty;

    private List<Integer> mList;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mList = intent.getIntegerArrayListExtra("BeautyList");
        position = intent.getIntExtra("position", -1);
        if (mList == null) {
            mList = new ArrayList<>();
        }
        BeautyBigAdapter adapter = new BeautyBigAdapter(getSupportFragmentManager(), mList);
        mVpgBeauty.setAdapter(adapter);
        if (-1 != position) {
            mVpgBeauty.setCurrentItem(position, false);
        }
    }

}
