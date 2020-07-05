package com.msss.covidfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class india extends AppCompatActivity {
TextView totalcases,active1,deaths1,recovered1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
        getSupportActionBar().hide();

        volly1();
    }

    private void volly1() {
        //https://api.rootnet.in/covid19-in/stats/latest
        totalcases=findViewById(R.id.totalcases1);
        active1=findViewById(R.id.active1);
        recovered1=findViewById(R.id.recovered1);
        deaths1=findViewById(R.id.Deaths1);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.covidindiatracker.com/total.json";

// Request a string response from the provided URL.
        //active":229652,"confirmed":628203,"recovered":380309,"deaths":18242
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject jsonObject =new JSONObject(response.toString());
                             totalcases.setText(jsonObject.getString("confirmed"));

                            active1.setText(jsonObject.getString("active"));
                            recovered1.setText(jsonObject.getString("recovered"));
                            deaths1.setText(jsonObject.getString("deaths"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                totalcases.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}