package com.dhcc.smvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.smvp.R;

import java.util.List;

/**
 * Created by Jinx on 2017/5/17.
 */

public class LeftAdapter extends BaseAdapter {

    List<MenubBean> mList;

    public LeftAdapter(List<MenubBean> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return null == mList ? 0 : mList.size();
    }

    @Override
    public MenubBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_left, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MenubBean bean = getItem(position);
        viewHolder.mTextView.setText(bean.getTitle());
        viewHolder.mImageView.setImageResource(bean.getLabel());
        return convertView;
    }

    public static class ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public ViewHolder(View view) {
            mImageView = (ImageView) view.findViewById(R.id.img_label);
            mTextView = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
