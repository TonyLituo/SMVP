package com.dhcc.smvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.dhcc.smvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeautyActivity extends AppCompatActivity {

    @BindView(R.id.img_beauty)
    ImageView mImgBeauty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);
        ButterKnife.bind(this);
        int imageRes = getIntent().getIntExtra("imageRes", -1);
        if (-1 != imageRes) {
            mImgBeauty.setImageResource(imageRes);
        }
    }

}
