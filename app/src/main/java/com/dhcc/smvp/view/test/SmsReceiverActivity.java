package com.dhcc.smvp.view.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dhcc.smvp.R;
import com.dhcc.smvp.eventbus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmsReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_send, R.id.btn_send1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                EventBus.getDefault().post(new MessageEvent("托托是大帅哥！"));
                finish();
                break;
            case R.id.btn_send1://粘性事件可以先发送给再注册
                EventBus.getDefault().postSticky(new MessageEvent("托托一直都是大帅哥！"));
                finish();
                break;
        }
    }
}
