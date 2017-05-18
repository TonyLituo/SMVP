package com.dhcc.smvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dhcc.smvp.HomeActivity;
import com.dhcc.smvp.R;
import com.dhcc.smvp.view.adapter.LeftAdapter;
import com.dhcc.smvp.view.adapter.MenubBean;
import com.dhcc.smvp.view.test.FirstFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar_app)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.lst_menu)
    ListView mListView;
    //    @BindView(R.id.rcv_beauty)
//    RecyclerView mRecyclerView;
    List<MenubBean> mList;


    List<Integer> images;

    private FragmentAdapter fmAapter;

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

//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        int spanCount = 2; // 3 columns
//        int spacing = 20; // 20px
//        boolean includeEdge = true;
//        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
//        BeautyAdapter adapter = new BeautyAdapter(images);
//        adapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, "这是第" + position + "个小姐姐", Toast.LENGTH_SHORT).show();
//                showBeauty(images.get(position));
//            }
//        });
//        mRecyclerView.setAdapter(adapter);

//        mToolbar.setTitle("title");
//        setSupportActionBar(mToolbar);
        List<Fragment> fmList = new ArrayList<Fragment>();
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nameList.add("Android" + i);
        }
        FirstFragment firstFragment = FirstFragment.newInstance(nameList);
        FirstFragment firstFragment1 = FirstFragment.newInstance(nameList);
        FirstFragment firstFragment2 = FirstFragment.newInstance(nameList);
        fmList.add(firstFragment);
        fmList.add(firstFragment1);
        fmList.add(firstFragment2);
        fmAapter = new FragmentAdapter(getSupportFragmentManager(), fmList);
        mViewPager.setAdapter(fmAapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("View0");
        mTabLayout.getTabAt(1).setText("View1");
        mTabLayout.getTabAt(2).setText("View2");
    }


    @OnItemClick({R.id.lst_menu})
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position==" + position, Toast.LENGTH_SHORT).show();

        switch (position) {
            case 0:
                toActivity(HomeActivity.class);
                break;
            case 1:
                break;
            default:
                break;
        }
    }

    private void toActivity(Class<?> cla) {
        Intent intent = new Intent(this, cla);
        startActivity(intent);
    }


    private void showBeauty(int imageRes) {
        Intent intent = new Intent(this, BeautyActivity.class);
        intent.putExtra("imageRes", imageRes);
        startActivity(intent);
    }

    //适配器
    class FragmentAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> fmList = new ArrayList();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fmList) {
            super(fm);
            this.fmList = fmList;
        }

        @Override
        public Fragment getItem(int position) {
            return fmList.get(position);
        }

        @Override
        public int getCount() {
            if (fmList == null) {
                return 0;
            } else {
                return fmList.size();
            }
        }
    }

}
