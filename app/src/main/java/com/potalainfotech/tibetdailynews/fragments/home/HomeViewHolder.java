package com.potalainfotech.tibetdailynews.fragments.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.potalainfotech.tibetdailynews.R;

/**
 * Created by tenzi on 4/24/2017.
 */

public class HomeViewHolder extends RecyclerView.ViewHolder {

    TextView title,description,date,category,author;
    ImageView featuredImgUrl;


    public HomeViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.titleTextView);
        featuredImgUrl = (ImageView) itemView.findViewById(R.id.featuredImage);
        date= (TextView) itemView.findViewById(R.id.dateTextView);
        category = (TextView) itemView.findViewById(R.id.catTextView);



    }
}
