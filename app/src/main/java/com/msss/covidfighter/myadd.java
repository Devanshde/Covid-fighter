package com.msss.covidfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myadd extends RecyclerView.Adapter <myadd.myviewholder>{
    @NonNull
    private Context context;
    private List<Countries> list;
    public  myadd(Context context, List <Countries> list)
    {
        this.context=context;
        this.list=list;
    }
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.singledata,parent,false);
        myviewholder holder =new myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
Countries countries =list.get(position);
holder.stextView1.setText(countries.getCountry());
        holder.stextView3.setText("Total Confirmed : "+countries.getTotalConfirmed());
        holder.stextView4.setText("New Recovered : "+countries.getNewRecovered());
        holder.stextView5.setText("Total Recovered : "+countries.getTotalRecovered());
        holder.stextView2.setText("New Confirmed : "+countries.getNewConfirmed());
        holder.stextView6.setText("Total Deaths :"+countries.getTotalDeaths());


    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView stextView1,stextView2,stextView3,stextView4,stextView5,stextView6;
        public myviewholder(@NonNull View itemView) {

            super(itemView);
            stextView1=itemView.findViewById(R.id.stextview1);
            stextView2=itemView.findViewById(R.id.stextView2);
            stextView3=itemView.findViewById(R.id.stextView3);
           stextView4=itemView.findViewById(R.id.stextView4);
            stextView5=itemView.findViewById(R.id.stextView5);
            stextView6=itemView.findViewById(R.id.stextView6);


        }
    }
}
