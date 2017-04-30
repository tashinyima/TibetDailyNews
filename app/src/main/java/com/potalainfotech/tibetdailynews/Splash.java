package com.potalainfotech.tibetdailynews;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.potalainfotech.tibetdailynews.dashboard.DashboardActivity;

public class Splash extends AppCompatActivity {
    ImageView splashImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImage = (ImageView) findViewById(R.id.splashImage);

        Glide.with(this).fromResource()
                .asBitmap()
                .encoder(new BitmapEncoder(Bitmap.CompressFormat.PNG, 100)).load(R.drawable.flower).into(splashImage);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(Splash.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);


    }
}
