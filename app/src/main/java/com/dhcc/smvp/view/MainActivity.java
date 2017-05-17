package com.dhcc.smvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dhcc.smvp.R;
import com.dhcc.smvp.common.widgetutil.GridSpacingItemDecoration;
import com.dhcc.smvp.view.adapter.BeautyAdapter;
import com.dhcc.smvp.view.adapter.LeftAdapter;
import com.dhcc.smvp.view.adapter.MenubBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lst_menu)
    ListView mListView;
    @BindView(R.id.rcv_beauty)
    RecyclerView mRecyclerView;
    List<MenubBean> mList;

    List<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mList = new ArrayList<>();
        mList.add(new MenubBean("首页", R.mipmap.ic_launcher));
        mList.add(new MenubBean("我的大会员", R.mipmap.ic_launcher));
        mList.add(new MenubBean("会员积分", R.mipmap.ic_launcher));
        mList.add(new MenubBean("免流量服务", R.mipmap.ic_launcher));
        mList.add(new MenubBean("离线缓存", R.mipmap.ic_launcher));
        mList.add(new MenubBean("稍后再看", R.mipmap.ic_launcher));
        mList.add(new MenubBean("我的收藏", R.mipmap.ic_launcher));
        mList.add(new MenubBean("历史记录", R.mipmap.ic_launcher));
        mList.add(new MenubBean("我的关注", R.mipmap.ic_launcher));
        mList.add(new MenubBean("B币钱包", R.mipmap.ic_launcher));
        mList.add(new MenubBean("主题选择", R.mipmap.ic_launcher));
        mList.add(new MenubBean("设置与帮助", R.mipmap.ic_launcher));

        mListView.setAdapter(new LeftAdapter(mList));

        images = new ArrayList<>();
        images.add(R.mipmap.beauty1);
        images.add(R.mipmap.beauty2);
        images.add(R.mipmap.beauty3);
        images.add(R.mipmap.beauty4);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        int spanCount = 2; // 3 columns
        int spacing = 20; // 50px
        boolean includeEdge = true;
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mRecyclerView.setAdapter(new BeautyAdapter(images));
    }

    @OnItemClick({R.id.lst_menu})
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position==" + position, Toast.LENGTH_SHORT).show();
    }
}
