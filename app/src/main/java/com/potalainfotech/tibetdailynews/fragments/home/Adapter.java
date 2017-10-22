package com.potalainfotech.tibetdailynews.fragments.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.potalainfotech.tibetdailynews.R;

import java.util.ArrayList;

/**
 * Created by tenzi on 4/24/2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<HomeData> homeDatas;
    private static final int TYPE_HEADER =0;
    private static final int TYPE_ITEM =1;
    private static final int TYPE_FOOTER=2;



    public static class ItemTypeViewHolder extends RecyclerView.ViewHolder{
        TextView title,description,date,category,author;
        ImageView featuredImgUrl;


        public ItemTypeViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titleTextView);
            featuredImgUrl = (ImageView) itemView.findViewById(R.id.featuredImage);
            date= (TextView) itemView.findViewById(R.id.dateTextView);
            category = (TextView) itemView.findViewById(R.id.catTextView);

        }
    }


    // add view holders

    // HeaderView

    public static class HeaderViewHolder extends RecyclerView.ViewHolder{

        ImageView headerImageView;
        TextView headerTitleTextView,headerTimeTextView,headerCategoryTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerImageView = (ImageView) itemView.findViewById(R.id.headerImageView);
            headerTitleTextView = (TextView) itemView.findViewById(R.id.headerTitleTextView);
            headerTimeTextView = (TextView) itemView.findViewById(R.id.headerTimeTextView);
            headerCategoryTextView = (TextView) itemView.findViewById(R.id.headerCatTextView);



        }
    }


    public Adapter(Context context, ArrayList<HomeData> homeDatas) {
        this.context = context;
        this.homeDatas = homeDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) throws RuntimeException {
        if(viewType==TYPE_HEADER){
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,parent,false);
            return new HeaderViewHolder(view);
        }else {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_body,parent,false);
            return new ItemTypeViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof HeaderViewHolder){
            HomeData hm =homeDatas.get(position);
            ((HeaderViewHolder) holder).headerTitleTextView.setText(hm.getTitle());
            ((HeaderViewHolder) holder).headerCategoryTextView.setText(hm.getCategory());
            ((HeaderViewHolder) holder).headerTimeTextView.setText(hm.getDate());
            Glide.with(context).load(hm.getFeaturedImageUrl()).error(R.drawable.flower).into(((HeaderViewHolder) holder)
                    .headerImageView);
        }else if( holder instanceof ItemTypeViewHolder)
        {
            HomeData data=homeDatas.get(position);
            ((ItemTypeViewHolder) holder).title.setText(data.getTitle());
            ((ItemTypeViewHolder) holder).category.setText(data.getCategory());
            ((ItemTypeViewHolder) holder).date.setText(data.getDate());
            Glide.with(context).load(data.getFeaturedImageUrl()).error(R.drawable.flower)
                    .into(((ItemTypeViewHolder) holder).featuredImgUrl);

        }


    }


    @Override
    public int getItemCount() {
        return homeDatas.size();

       // return (null != feedItemList ? feedItemList.size() : 0);

    }

    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position))
        {
            return TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    private boolean isPositionHeader(int position) {
        return position==0;
    }



}
