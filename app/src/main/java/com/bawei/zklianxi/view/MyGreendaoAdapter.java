package com.bawei.zklianxi.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.zklianxi.R;
import com.bawei.zklianxi.User;

import java.util.List;

import butterknife.Bind;



public class MyGreendaoAdapter extends RecyclerView.Adapter {
    List<User> list;
    Context context;
    @Bind(R.id.title1)
    TextView title1;

    public MyGreendaoAdapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
        return new MViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MViewholder mViewholder= (MViewholder) holder;
        mViewholder.textView.setText(list.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MViewholder extends RecyclerView.ViewHolder {


        private final TextView textView;

        public MViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title1);


        }
    }


}
