package com.dhcc.smvp.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.dhcc.library.util.RxToast;
import com.dhcc.smvp.R;
import com.dhcc.smvp.model.TestModel;
import com.dhcc.smvp.model.bean.Info;
import com.dhcc.smvp.view.adapter.LeftAdapter;
import com.dhcc.smvp.view.adapter.MenubBean;
import com.dhcc.smvp.view.intent.Lancher;
import com.dhcc.smvp.view.test.LiveFragment;
import com.dhcc.smvp.view.test.SurfaceActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.toolbar_app)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.lst_menu)
    ListView mListView;

    @BindView(R.id.img_bar_left)
    ImageView mImgBarLeft;
    @BindView(R.id.float_btn)
    FloatingActionButton mFloatBtn;

    @BindView(R.id.menu_left)
    LinearLayout mMenuLeft;
    List<MenubBean> mList;

    //推荐 图片集
    ArrayList<Integer> imagesList;
    //banner图集
    ArrayList<Integer> bannerList;

    private FragmentAdapter fmAapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        TestModel testModel = new TestModel();
        testModel.getArea(new Observer<Info>() {
            @Override
            public void onSubscribe(Disposable d) {
                String thread = Thread.currentThread().getName();
                Log.e("onSubscribe", thread + "========");
            }

            @Override
            public void onNext(Info info) {
                String thread = Thread.currentThread().getName();
                Log.e("onNext", thread + "========");
            }

            @Override
            public void onError(Throwable e) {
                String thread = Thread.currentThread().getName();
                Log.e("onError", thread + "========" + e.getMessage() + "==" + e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                String thread = Thread.currentThread().getName();
                Log.e("onComplete", thread + "========");
            }
        });
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

        imagesList = new ArrayList<>();
        imagesList.add(R.mipmap.beauty5);
        imagesList.add(R.mipmap.beauty6);
        imagesList.add(R.mipmap.beauty1);
        imagesList.add(R.mipmap.beauty2);
        imagesList.add(R.mipmap.beauty3);
        imagesList.add(R.mipmap.beauty4);


        bannerList = new ArrayList<>();
        bannerList.add(R.mipmap.qiong);
        bannerList.add(R.mipmap.banner1);
        bannerList.add(R.mipmap.qiong);
        bannerList.add(R.mipmap.banner1);

//        mToolbar.setTitle("title");
//        setSupportActionBar(mToolbar);
        List<Fragment> fmList = new ArrayList();

        LiveFragment fragment = LiveFragment.newInstance(bannerList, imagesList);
        LiveFragment fragment1 = LiveFragment.newInstance(bannerList, imagesList);
        LiveFragment fragment2 = LiveFragment.newInstance(bannerList, imagesList);
        LiveFragment fragment3 = LiveFragment.newInstance(bannerList, imagesList);
        LiveFragment fragment4 = LiveFragment.newInstance(bannerList, imagesList);
        LiveFragment fragment5 = LiveFragment.newInstance(bannerList, imagesList);

        fmList.add(fragment);
        fmList.add(fragment1);
        fmList.add(fragment2);
        fmList.add(fragment3);
        fmList.add(fragment4);
        fmList.add(fragment5);

        fmAapter = new FragmentAdapter(getSupportFragmentManager(), fmList);
        mViewPager.setAdapter(fmAapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("直播");
        mTabLayout.getTabAt(1).setText("推荐");
        mTabLayout.getTabAt(2).setText("追番");
        mTabLayout.getTabAt(3).setText("分区");
        mTabLayout.getTabAt(4).setText("动态");
        mTabLayout.getTabAt(5).setText("发现");
    }


    @OnItemClick({R.id.lst_menu})
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, "Position==" + position, Toast.LENGTH_SHORT).show();
        mDrawerLayout.closeDrawers();

        switch (position) {
            case 0:
                Lancher.newIntance(this, MainActivity.class).start();
                RxToast.success("一个非常长的Toast：位置" + position);
                break;
            case 1:
                Lancher.newIntance(this, LoginActivity.class).start();
                RxToast.info("一个非常长的Toast，就问你怕不怕：位置" + position);
                break;
            case 2:
                Lancher.newIntance(this, SurfaceActivity.class).start();
                RxToast.error("一个非常长的Toast，就问你怕不怕：啥 你不怕？？？？位置" + position);
                break;
            case 3:
                Lancher.newIntance(this, SurfaceActivity.class).start();
                RxToast.normal("位置" + position);
                break;
            case 4:
                Lancher.newIntance(this, SurfaceActivity.class).start();
                RxToast.success("位置" + position);
                break;
            case 11:
                Lancher.newIntance(this, HomeActivity.class).start();
                break;
            default:
                break;
        }

    }


    @OnClick({R.id.img_bar_left, R.id.float_btn})
    public void Clicked(View view) {
        switch (view.getId()) {
            case R.id.img_bar_left:
                mDrawerLayout.openDrawer(mMenuLeft);
                break;
            case R.id.float_btn:
                Snackbar.make(view, "想点我底下这个小姐姐吗", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "并不想，哼都没有王福荣小哥哥", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                break;
        }
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

    /**
     * 返回键
     */
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mDrawerLayout.findViewById(R.id.menu_left))) {
            mDrawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }

    }
}
