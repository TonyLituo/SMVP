package com.dhcc.smvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.smvp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jinx on 2017/5/12.
 */

public class ThemeCardAdapter extends BaseAdapter {

    List<CardBean> mList;

    public ThemeCardAdapter(List<CardBean> list) {
        this.mList = list;
    }

    public void update(List<CardBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CardBean getItem(int position) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theme_card, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convertView.setBackgroundColor(parent.getContext().getResources().getColor(getItem(position).getColorCard()));
        viewHolder.mImageView.setVisibility(getItem(position).isCurTheme() ? View.VISIBLE : View.INVISIBLE);
        viewHolder.mTextView.setText(getItem(position).getName());
        return convertView;
    }

    public static class ViewHolder {
        @BindView(R.id.tv_theme)
        TextView mTextView;
        @BindView(R.id.img_check)
        ImageView mImageView;

        public ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }


    public static class CardBean {
        private String name;
        private int colorCard;
        private int themeApp;
        private boolean isCurTheme;

        public CardBean(String name, int colorCard, int themeApp, boolean isCurTheme) {
            this.name = name;
            this.colorCard = colorCard;
            this.themeApp = themeApp;
            this.isCurTheme = isCurTheme;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getColorCard() {
            return colorCard;
        }

        public void setColorCard(int colorCard) {
            this.colorCard = colorCard;
        }

        public int getThemeApp() {
            return themeApp;
        }

        public void setThemeApp(int themeApp) {
            this.themeApp = themeApp;
        }

        public boolean isCurTheme() {
            return isCurTheme;
        }

        public void setCurTheme(boolean curTheme) {
            isCurTheme = curTheme;
        }
    }
}
