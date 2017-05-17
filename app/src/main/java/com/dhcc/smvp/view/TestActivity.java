package com.dhcc.smvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dhcc.smvp.R;
import com.dhcc.smvp.view.adapter.ThemeCardAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {
    public String TAG = "TestActivity";
    @BindView(R.id.btn)
    Button mButton;

    private int themeApp = -1;

    int code = -2;

    private String THEME = "themeApp";

    List<ThemeCardAdapter.CardBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (null != savedInstanceState) {
            setTheme(savedInstanceState.getInt(THEME));
            Log.e(TAG, "onCreate====" + savedInstanceState.getInt(THEME));
        }
        setContentView(R.layout.activity_test);

        Log.e(TAG, "========onCreate");
        super.onCreate(savedInstanceState);


        mList = new ArrayList<>();
        mList.add(new ThemeCardAdapter.CardBean("夜间模式", R.color.darkApp, R.style.DarkTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("少女粉", R.color.pinkApp, R.style.PinkTheme, true));
        mList.add(new ThemeCardAdapter.CardBean("姨妈红", R.color.redApp, R.style.RedTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("咸蛋黄", R.color.yellowApp, R.style.YellowTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("草苗绿", R.color.greenApp, R.style.GreenTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("胖次蓝", R.color.blueApp, R.style.BlueTheme, false));
        mList.add(new ThemeCardAdapter.CardBean("基佬紫", R.color.popApp, R.style.PopTheme, false));

    }

    @OnClick({R.id.btn, R.id.select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
//                Intent intent = new Intent(this, SecActivity.class);
//                startActivityForResult(intent, 34);
                this.recreate();
                break;
            case R.id.select:
                selectTheme();
                break;
            default:
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "========onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "========onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "========onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "========onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "========onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "========onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "========onSaveInstanceState");
        outState.putInt(THEME, themeApp);
        outState.putInt("CODE", code);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "========onRestoreInstanceState");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "========onActivityResult" + "=" + requestCode);
        switch (requestCode) {
            case 34:
                if (null != data) {
                    code = data.getIntExtra("code", -1);
                    Log.e(TAG, "========data" + "=" + code);
//                    this.recreate();
                }
                break;
            default:
                break;
        }

    }

    private void selectTheme() {
        int num = (int) (Math.random() * 7);
        ThemeCardAdapter.CardBean bean = mList.get(num);
        themeApp = bean.getThemeApp();

        Log.e(TAG, "Select====" + themeApp);
    }
}
