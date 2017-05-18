package com.dhcc.smvp.view.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhcc.smvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinx on 2017/5/18.
 */

public class FirstFragment extends Fragment{

    private static final String ARG_NAME = "namelist";
    private List<String> nameList;
    private RecyclerView recyclerView;
    private LayoutInflater inflater;
    private MyAdapter adapter;

    public FirstFragment() {
        // Required empty public constructor
    }


    public static FirstFragment newInstance(ArrayList<String> nameList) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_NAME,nameList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.nameList = getArguments().getStringArrayList(ARG_NAME);
        }
        inflater=LayoutInflater.from(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //adapter
        adapter=new MyAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=inflater.inflate(R.layout.item_list,parent,false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //set item's value
            holder.nameText.setText(nameList.get(position));
        }

        @Override
        public int getItemCount() {
            return nameList.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder{
            public TextView nameText;
            public MyViewHolder(View itemView) {
                super(itemView);
                //get到相关控件的引用
                nameText= (TextView) itemView.findViewById(R.id.name_text);
            }
        }
    }

}
