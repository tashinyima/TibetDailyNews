package com.potalainfotech.tibetdailynews.fragments.home;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.potalainfotech.tibetdailynews.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Context context;
    RecyclerView recycler;
    ArrayList<HomeData> homeDatas = new ArrayList<>();
    LinearLayoutManager mLinearlayout;
    Adapter myAdapter;
    ProgressBar progressBar;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        initView(view);
        PrepareData(view);
        return view;
    }

    private void initView(View view) {

        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        mLinearlayout = new LinearLayoutManager(context);
        myAdapter = new Adapter(context, homeDatas);
        recycler.setLayoutManager(mLinearlayout);
        recycler.setAdapter(myAdapter);

    }


    private void PrepareData(final View view) {

        String BaseUrl = getResources().getString(R.string.baseUrl) + "photos";
        Log.d("Base", BaseUrl);
        Ion.with(context)
                .load(BaseUrl)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {

                        if (result != null) {
                            for (int i = 0; i < result.size(); i++) {
                                JsonObject jsonObject = (JsonObject) result.get(i);
                                String title = jsonObject.get("title").getAsString();
                                String imageUrl = jsonObject.get("thumbnailUrl").getAsString();
                                String id = jsonObject.get("id").getAsString();

                                HomeData data = new HomeData(imageUrl, title, id, "business");
                                homeDatas.add(data);
                                myAdapter.notifyDataSetChanged();
                            }


                        } else {
                            showMessage("no data");
                        }


                    }
                });


    }

    private void showMessage(String msg) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


}
