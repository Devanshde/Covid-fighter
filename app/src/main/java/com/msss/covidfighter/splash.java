package com.msss.covidfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class splash extends AppCompatActivity {
ImageView  imageView;
TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        imageView=findViewById(R.id.image);
        Animation my = AnimationUtils.loadAnimation(this,R.anim.sp);
        t2.startAnimation(my);
        getSupportActionBar().hide();
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    startActivity(new Intent(splash.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                                    }
            }
        });thread.start();
    }
}