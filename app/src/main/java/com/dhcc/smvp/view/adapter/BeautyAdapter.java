package com.dhcc.smvp.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dhcc.smvp.R;
import com.dhcc.smvp.common.widgetutil.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jinx on 2017/5/17.
 * <p>
 * 首页美女recyclerView适配器
 */

public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.MyViewHolder> {

    private List<Integer> mList;

    private OnItemClickListener mOnItemClickListener;

    public BeautyAdapter(List<Integer> list) {
        mList = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beauty, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mImageView.setImageResource(mList.get(position));
        if (null != mOnItemClickListener) {
            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_beauty)
        CardView mCardView;
        @BindView(R.id.img_beauty)
        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
