package com.msss.covidfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void india(View view) {
startActivity(new Intent(MainActivity2.this,india.class));
    }
    public void country(View view) {startActivity(new Intent(MainActivity2.this,MainActivity3.class)); }
    public void safty(View view) { startActivity(new Intent(MainActivity2.this,safty.class));   }
    public void city(View view) {    startActivity(new Intent(MainActivity2.this,city.class));}
    public void state(View view) {startActivity(new Intent(MainActivity2.this,city.class));    }

    public void rateuss(View view) {
        Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=in.yourquote.app&hl=en_IN"));
startActivity(intent);
    }

    public void share(View view) {
        Intent o=new Intent((Intent.ACTION_SEND));
        o.setType("text/plain");
        String body ="hey i found best app for covid satisics you can download it by this link "+"https://play.google.com/store/apps/details?id=in.yourquote.app&hl=en_IN"+" I really like it hope you also like and main thing THIS IS MADE IN INDIA BY A COLLEGE BOY";
        String Trxt="Hey i found best app for us";
        o.putExtra(Intent.EXTRA_TEXT,body);
        o.putExtra(Intent.EXTRA_SUBJECT,Trxt);
        startActivity(Intent.createChooser(o,"select app"));
    }

    public void saftyy(View view) {
        startActivity(new Intent(MainActivity2.this,safty.class));
    }
}