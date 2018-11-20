package com.example.android.recyclerexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder>{

    private List<String> list;

    public RecyclerAdapter(List<String> list)
    {
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(textView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.VersionName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView VersionName;

        public MyViewHolder(TextView itemView) {
            super(itemView);
            VersionName = itemView;
        }
    }
}
