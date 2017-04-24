package com.potalainfotech.tibetdailynews.dashboard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.potalainfotech.tibetdailynews.R;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recycler;
    Context context;
    LinearLayoutManager mLinearlayout;
    ArrayList<HomeData> homeDatas= new ArrayList<>();
    Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setupToolBar(getString(R.string.app_name));
        initView();
        setRecycler();
        context=this;


    }

    private void setRecycler() {
        // steps:

        mLinearlayout = new LinearLayoutManager(this);
        myAdapter = new Adapter(this,homeDatas);
        recycler.setLayoutManager(mLinearlayout);      //we can also use like... recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(myAdapter);             //  recycler.setAdapter(new Adapter(this,homeDatas));
        PrepareData();
    }

    private void PrepareData() {
        String BaseUrl= getResources().getString(R.string.baseUrl)+"photos";
        Log.d("Base",BaseUrl);
        Ion.with(this)
                .load(BaseUrl)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {

                        if(result!=null){
                            for(int i=0;i<result.size();i++){
                                JsonObject jsonObject = (JsonObject) result.get(i);
                                String title=jsonObject.get("title").getAsString();
                                String imageUrl=jsonObject.get("thumbnailUrl").getAsString();
                                String id =jsonObject.get("id").getAsString();

                                HomeData data= new HomeData(imageUrl,title,id,"business");
                                homeDatas.add(data);
                                myAdapter.notifyDataSetChanged();
                            }



                        }else
                        {
                            showMessage("no data");
                        }
                    }
                });


    }

    private void showMessage(String msg) {

        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    private void initView() {

        recycler = (RecyclerView) findViewById(R.id.recycler);

    }


    private void setupToolBar(String title) {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textViewTitle = (TextView) toolbar.findViewById(R.id.textViewTitle);
        textViewTitle.setText(title);


    }
}
