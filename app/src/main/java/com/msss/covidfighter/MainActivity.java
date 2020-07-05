package com.msss.covidfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4;
  ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 =findViewById(R.id.totalcases);
        textView2=findViewById(R.id.active);
        textView3=findViewById(R.id.recovered);
        textView4=findViewById(R.id.deaths);
        getSupportActionBar().hide();
volly();
    }


    private void volly() {

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://disease.sh/v3/covid-19/all";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject jsonObject =new JSONObject(response.toString());
                            textView1.setText(jsonObject.getString("cases"));
                            textView2.setText(jsonObject.getString("active"));
                            textView3.setText(jsonObject.getString("recovered"));
                            textView4.setText(jsonObject.getString("deaths"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView2.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    public void more(View view) {



        startActivity(new Intent(MainActivity.this,MainActivity2.class));


    }


}