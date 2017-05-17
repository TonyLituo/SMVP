package com.dhcc.smvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dhcc.smvp.R;
import com.dhcc.smvp.view.adapter.ThemeCardAdapter;
import com.stylingandroid.prism.Prism;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;

public class ThemeActivity extends AppCompatActivity {
    @BindView(R.id.lst_theme)
    ListView mListView;
    @BindView(R.id.base_toobar)
    Toolbar mToolbar;
    List<ThemeCardAdapter.CardBean> mList;

    private int themeApp = -1;

    private int currentColour = -1;

    private ThemeCardAdapter mAdapter;

    private Prism prism;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_theme);
        super.onCreate(savedInstanceState);
        init();
    }


    private void init() {
        mList = new ArrayList<>();
        mList.add(new ThemeCardAdapter.CardBean("夜间模式", R.color.darkApp, R.style.DarkTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("少女粉", R.color.pinkApp, R.style.PinkTheme, true));
        mList.add(new ThemeCardAdapter.CardBean("姨妈红", R.color.redApp, R.style.RedTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("咸蛋黄", R.color.yellowApp, R.style.YellowTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("草苗绿", R.color.greenApp, R.style.GreenTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("胖次蓝", R.color.blueApp, R.style.BlueTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("基佬紫", R.color.popApp, R.style.PopTheme, false));
        mAdapter = new ThemeCardAdapter(mList);
        mListView.setAdapter(mAdapter);
        prism = Prism.Builder.newInstance()
                .background(getWindow())
                .background(mToolbar)
                .build();
    }

    @OnItemClick({R.id.lst_theme})
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ThemeCardAdapter.CardBean bean = mList.get(position);
        //themeApp = bean.getThemeApp();
        currentColour = getResources().getColor(bean.getColorCard());
        prism.setColor(currentColour);
        Log.e("Position", "==" + position);
        for (int i = 0; i < mList.size(); i++) {
            if (position == i) {
                mList.get(i).setCurTheme(true);
            } else {
                mList.get(i).setCurTheme(false);
            }
        }
        mAdapter.update(mList);
    }


}
