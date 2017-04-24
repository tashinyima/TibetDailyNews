package com.potalainfotech.tibetdailynews.dashboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.potalainfotech.tibetdailynews.R;

import java.util.ArrayList;

/**
 * Created by tenzi on 4/24/2017.
 */

public class Adapter extends RecyclerView.Adapter<HomeViewHolder> {

    Context context;
    ArrayList<HomeData> homeDatas;

    public Adapter(Context context, ArrayList<HomeData> homeDatas) {
        this.context = context;
        this.homeDatas = homeDatas;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_body,parent,false);
        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

        HomeData data=homeDatas.get(position);
        holder.title.setText(data.getTitle());
        holder.category.setText(data.getCategory());
        holder.date.setText(data.getDate());
        Glide.with(context).load(data.featuredImageUrl).error(R.drawable.flower).into(holder.featuredImgUrl);


    }

    @Override
    public int getItemCount() {
        return homeDatas.size();

       // return (null != feedItemList ? feedItemList.size() : 0);

    }
}
