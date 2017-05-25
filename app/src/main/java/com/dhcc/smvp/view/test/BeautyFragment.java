package com.dhcc.smvp.view.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dhcc.smvp.R;

/**
 * Created by Jinx on 2017/5/19.
 */

public class BeautyFragment extends Fragment {

    private int image;

    public BeautyFragment() {

    }

    public static BeautyFragment newInstance(int resId) {
        BeautyFragment fragment = new BeautyFragment();
        Bundle args = new Bundle();
        args.putInt("resId", resId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != this.getArguments()) {
            this.image = this.getArguments().getInt("resId");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beauty, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_beauty);
        imageView.setImageResource(image);
        return view;
    }
}
