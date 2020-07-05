package com.msss.covidfighter;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private myadd add;
    private Covid covido =new Covid();
    private List<Countries> list;
    private RecyclerView recyclerView;
    TextView textView1,textView2,textView3,textView4,textView5,textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        init();
        loaddata();
    }

    private void init() {
        textView1 =findViewById(R.id.textView1);
        textView2 =findViewById(R.id.textView2);
        textView3 =findViewById(R.id.textView3);
        textView4 =findViewById(R.id.textView4);
        textView5 =findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        recyclerView=findViewById(R.id.rv);
        add=new myadd(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(add);
    }

    private void loaddata() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.covid19api.com/summary";

// Request a string response from the provided URL.
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson son=new Gson();

                        covido=son.fromJson(response.toString(),Covid.class);
                        String a=covido.getCountries().toString();
                        Log.e("Risponce",response.toString());
                        textView2.setText("NewConfirmed : "+covido.getGlobal().getNewConfirmed());
                        textView3.setText("TotalConfirmed : "+covido.getGlobal().getTotalConfirmed());
                        textView4.setText("NewDeaths : "+covido.getGlobal().getNewDeaths());
                        textView5.setText("TotalDeaths : "+covido.getGlobal().getTotalDeaths());
                        textView6.setText("NewRecovered : "+covido.getGlobal().getNewRecovered());
                        for(Countries c:covido.getCountries())

                        {
                            list.add(c);

                        }add.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("x",null);
            }

        });
//NewConfirmed":146555,"TotalConfirmed":9201340,"NewDeaths":3852,"TotalDeaths":480648,"NewRecovered":91705,"TotalRecovered
////// Add the request to the RequestQueue.
        queue.add(objectRequest);


    }








}