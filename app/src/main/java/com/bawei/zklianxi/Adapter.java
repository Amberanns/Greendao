package com.bawei.zklianxi;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;



public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
        List<MyBean.ResultsBean> list;
        Context context;

    public Adapter(List<MyBean.ResultsBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.itemImg.setImageURI(list.get(position).getUrl());
            holder.title.setText(list.get(position).getDesc());
            Uri imgUrl = Uri.parse("http://img.gank.io/fef497ed-83ba-46f6-8a94-0e7b724e1c10");
            holder.itemImg.setImageURI(imgUrl);
        }



        @Override
        public int getItemCount() {
            return list.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.item_img)
            SimpleDraweeView itemImg;
            @Bind(R.id.title)
            TextView title;



            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
}
