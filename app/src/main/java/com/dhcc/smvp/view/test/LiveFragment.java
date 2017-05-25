package com.dhcc.smvp.view.test;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhcc.smvp.R;
import com.dhcc.smvp.common.PicassoImageLoader;
import com.dhcc.smvp.common.widgetutil.GridSpacingItemDecoration;
import com.dhcc.smvp.common.widgetutil.OnItemClickListener;
import com.dhcc.smvp.view.BeautyActivity;
import com.dhcc.smvp.view.adapter.BeautyAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jinx on 2017/5/19.
 * <p>
 * 直播Fragment
 */

public class LiveFragment extends Fragment {
    /**
     * baner图集Bean
     */
    public static final String BANNER_LIST = "banner";
    /**
     * 推荐主播Bean
     */
    public static final String REFER_LIST = "refer";
    /**
     * bibi音乐Bean
     */
    public static final String MUSIC_LIST = "music";
    /**
     * 分类直播Bean
     */
    public static final String LIVE_LIST = "live";

    //推荐图片
    private ArrayList<Integer> referList;
    //banner图片
    private ArrayList<Integer> bannerList;

    @BindView(R.id.rcv_live)
    RecyclerView mRecyclerView;
    @BindView(R.id.banner_live)
    Banner mBanner;

    public LiveFragment() {

    }

    public static LiveFragment newInstance(ArrayList<Integer> bannerList, ArrayList<Integer> referList) {
        LiveFragment fragment = new LiveFragment();
        Bundle args = new Bundle();
        args.putIntegerArrayList(REFER_LIST, referList);
        args.putIntegerArrayList(BANNER_LIST, bannerList);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.referList = getArguments().getIntegerArrayList(REFER_LIST);
            this.bannerList = getArguments().getIntegerArrayList(BANNER_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        int spanCount = 2; // 3 columns
        int spacing = 20; // 20px
        boolean includeEdge = true;
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        BeautyAdapter adapter = new BeautyAdapter(referList);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showBeauty(position);
            }
        });
        mRecyclerView.setAdapter(adapter);

        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        mBanner.setImageLoader(new PicassoImageLoader());

        mBanner.setImages(bannerList);

        mBanner.setBannerAnimation(Transformer.DepthPage);

        mBanner.setIndicatorGravity(BannerConfig.CENTER);

        mBanner.start();
        return view;
    }

    /**
     * 设置TextView的DrawTop图片
     *
     * @param view
     * @param drawable
     * @param x        right
     * @param y        bottom
     */
    private void setDrawBound(TextView view, Drawable drawable, int x, int y) {
        drawable.setBounds(0, 0, x, y);
        view.setCompoundDrawables(null, drawable, null, null);
    }

    /**
     * 大图
     *
     * @param position
     */

    private void showBeauty(int position) {
        Intent intent = new Intent(getActivity(), BeautyActivity.class);
        intent.putExtra("position", position);
        intent.putIntegerArrayListExtra("BeautyList", referList);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }
}
