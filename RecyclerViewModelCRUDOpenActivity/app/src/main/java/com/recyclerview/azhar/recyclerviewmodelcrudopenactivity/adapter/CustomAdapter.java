package com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.DetailActivity;
import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.R;
import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data.SpaceCraft;

import java.util.ArrayList;

/**
 * Created by Azhar on 5/5/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {
    Context context;
    ArrayList<SpaceCraft> spaceCrafts;

    public CustomAdapter(Context context, ArrayList<SpaceCraft> spaceCrafts) {
        this.context = context;
        this.spaceCrafts = spaceCrafts;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        SpaceCraft spaceCraft = spaceCrafts.get(position);
        final String name = spaceCraft.getName();
        final String description = spaceCraft.getDescription();

        holder.tvName.setText(name);
        holder.tvDescription.setText(description);
        holder.setItemListener(new ItemClickListener() {
            @Override
            public void itemClick(int position) {

                openDataNewActivity(name,description,position);
            }
        });

    }

    private void openDataNewActivity(String name, String description,int position) {

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("NAME",name);
        intent.putExtra("DESCRIPTION",description);
        intent.putExtra("POSITION",position);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return spaceCrafts.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvName,tvDescription;
        ItemClickListener itemClickListener;
        public MyHolder(View view) {
            super(view);
            tvName = (TextView)view.findViewById(R.id.tvName);
            tvDescription = (TextView)view.findViewById(R.id.tvDescription);
            view.setOnClickListener(this);
        }

        public void setItemListener(ItemClickListener itemListener){
            this.itemClickListener = itemListener;
        }

        @Override
        public void onClick(View view) {
      //      itemClickListener.itemClick(view.getLayoutParams());
            this.itemClickListener.itemClick(this.getLayoutPosition());
        }
    }
}
