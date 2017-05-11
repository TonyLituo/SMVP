package com.dhcc.smvp.view.widget;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dhcc.smvp.R;

import java.util.List;

/**
 * Created by Jinx on 2017/5/11.
 */

public class BottomWindow extends PopupWindow implements View.OnClickListener, AdapterView.OnItemClickListener, View.OnTouchListener {

    private OnClickListener onClickListener;

    private ListView mListView;

    private TextView mTitle;//标题

    private ImageView mImgCancel;

    private List<CardBean> mList;

    private CardAdapter mAdapter;

    private Activity mActivity;

    public BottomWindow(Activity activity, OnClickListener onClickListener, List<CardBean> list) {
        super(activity.getLayoutInflater().inflate(R.layout.popup_select_card, null),
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        this.mActivity = activity;
        this.onClickListener = onClickListener;
        this.mList = list;
        mListView = (ListView) getContentView().findViewById(R.id.lst_card);
        mImgCancel = (ImageView) getContentView().findViewById(R.id.img_cancel);
        mTitle = (TextView) getContentView().findViewById(R.id.title);
        mListView.setOnItemClickListener(this);
        mImgCancel.setOnClickListener(this);
        mAdapter = new CardAdapter(mList);
        mListView.setAdapter(mAdapter);

        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        getContentView().setOnTouchListener(this);

        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(Color.WHITE);
        setBackgroundDrawable(dw);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void show() {
        showAtLocation(mActivity.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_cancel:
                Log.e("BottomWindow", "点击了X");
                this.dismiss();
                break;

            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onClickListener.onItemClick(parent, view, position, id);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int height = getContentView().findViewById(R.id.popup_card).getTop();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (y < height) {
                dismiss();
            }
        }
        return true;
    }


    public interface OnClickListener {
        /**
         * List子条目点击事件
         */
        void onItemClick(AdapterView<?> parent, View view, int position, long id);

    }

    public void update(List<CardBean> list) {
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    class CardAdapter extends BaseAdapter {
        List<CardBean> mList;

        public CardAdapter(List<CardBean> list) {
            this.mList = list;
        }


        @Override
        public int getCount() {
            return null == mList ? 0 : mList.size();
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
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_card, parent, false);
            ViewHoder viewHoder = new ViewHoder(view);
            CardBean bean = getItem(position);
            viewHoder.check.setVisibility(bean.isChecked() ? View.VISIBLE : View.INVISIBLE);
            String accoutNo = bean.getAccoutNo();
            accoutNo = accoutNo.substring(15, 19);
            viewHoder.bankAndAcc.setText(bean.getBankName() + "(" + accoutNo + ")");
            return view;
        }

        class ViewHoder {
            ImageView bankLogo;
            TextView bankAndAcc;
            ImageView check;

            public ViewHoder(View view) {
                bankLogo = (ImageView) view.findViewById(R.id.img_bank);
                bankAndAcc = (TextView) view.findViewById(R.id.tv_bank);
                check = (ImageView) view.findViewById(R.id.img_select);
            }
        }
    }


    /**
     * listView 子条目实体
     */
    public static class CardBean {
        private String bankName;
        private String accoutNo;
        private String bankImage;
        private boolean isChecked;

        public CardBean(String bankName, String accoutNo, String bankImage, boolean isChecked) {
            this.bankName = bankName;
            this.accoutNo = accoutNo;
            this.bankImage = bankImage;
            this.isChecked = isChecked;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getAccoutNo() {
            return accoutNo;
        }

        public void setAccoutNo(String accoutNo) {
            this.accoutNo = accoutNo;
        }

        public String getBankImage() {
            return bankImage;
        }

        public void setBankImage(String bankImage) {
            this.bankImage = bankImage;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        @Override
        public String toString() {
            return "CardBean{" +
                    "bankName='" + bankName + '\'' +
                    ", accoutNo='" + accoutNo + '\'' +
                    ", bankImage='" + bankImage + '\'' +
                    ", isChecked=" + isChecked +
                    '}';
        }
    }
}
