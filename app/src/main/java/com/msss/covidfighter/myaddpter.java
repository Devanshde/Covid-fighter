package com.msss.covidfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myaddpter extends RecyclerView.Adapter<myaddpter.holder> {
    private Context context;
    private List<State> list;
    public myaddpter(Context context,List<State> list)
    {
this.list=list;
this.context =context;


    };
    @NonNull

    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.singledata,parent,false);
        holder holder =new holder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        State state =list.get(position);
        holder.stextView1.setText(state.getName());
        holder.stextView2.setText(state.getActive());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView stextView1,stextView2,stextView3,stextView4,stextView5,stextView6;
        public holder(@NonNull View itemView) {

            super(itemView);
            stextView1=itemView.findViewById(R.id.stextview1);
            stextView2=itemView.findViewById(R.id.stextView2);
        }
    }
}
