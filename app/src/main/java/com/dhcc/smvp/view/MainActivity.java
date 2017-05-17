package com.dhcc.smvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.dhcc.smvp.R;
import com.dhcc.smvp.view.widget.BottomWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BottomWindow.OnClickListener {
    BottomWindow mBottomWindow;
    List<BottomWindow.CardBean> mList;
    @BindView(R.id.tv_test)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.RedTheme);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();
        mList.add(new BottomWindow.CardBean("交通银行储蓄卡", "6123345611113421567", "path", true));
        mList.add(new BottomWindow.CardBean("建设银行储蓄卡", "6123345611113421123", "path", false));
        mList.add(new BottomWindow.CardBean("民生银行储蓄卡", "6123345611113421865", "path", false));
        setCard(0);
    }

    private void setCard(int position) {
        BottomWindow.CardBean bean = mList.get(position);
        String accoutNo = bean.getAccoutNo();
        accoutNo = accoutNo.substring(15, 19);
        mTextView.setText(bean.getBankName() + "(" + accoutNo + ")");
    }

    @OnClick({R.id.tv_test, R.id.button,R.id.btn_sec})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                if (mBottomWindow == null) {
                    mBottomWindow = new BottomWindow(this, this, mList);
                    mBottomWindow.setTitle("选择付款方式");
                }
                //如果已经显示，则关闭
                if (mBottomWindow.isShowing()) {
                    mBottomWindow.dismiss();
                    return;
                }
                mBottomWindow.show();//显示来源选择框
                break;
            case R.id.button:
                Intent intent = new Intent(this, ThemeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sec:
                Intent intent1 = new Intent(this, TestActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "position===" + position, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < mList.size(); i++) {
            if (position == i) {
                mList.get(position).setChecked(true);
                setCard(position);
            } else {
                mList.get(i).setChecked(false);
            }
        }
        mBottomWindow.dismiss();
    }
}
