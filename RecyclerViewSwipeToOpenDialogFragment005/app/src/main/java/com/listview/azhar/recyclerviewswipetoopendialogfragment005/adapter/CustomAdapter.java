package com.listview.azhar.recyclerviewswipetoopendialogfragment005.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.listview.azhar.recyclerviewswipetoopendialogfragment005.R;
import com.listview.azhar.recyclerviewswipetoopendialogfragment005.SwipDetailFragment;
import com.listview.azhar.recyclerviewswipetoopendialogfragment005.data.SpaceCraft;

import java.util.ArrayList;

/**
 * Created by Azhar on 5/1/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    ArrayList<SpaceCraft> spaceCraftArrayList;
    FragmentManager fragmentManager;
    Context context;
    SpaceCraft spaceCraft;
    public CustomAdapter(ArrayList<SpaceCraft> spaceCraftArrayList, FragmentManager fragmentManager, Context context) {
        this.spaceCraftArrayList = spaceCraftArrayList;
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       spaceCraft = spaceCraftArrayList.get(position);

        final String name = spaceCraft.getName();
        final  int image = spaceCraft.getImage();

        holder.nameTxt.setText(name);
        holder.imageView.setImageResource(image);

        holder.setOnItemTouchListener(new OnItemTouch() {
            @Override
            public void touchItem(int position) {
                spaceCraft = spaceCraftArrayList.get(position);
            }
        });

    }
    public void openDialoguFragment() {

        Bundle bundle = new Bundle();
        bundle.putString("NAME",spaceCraft.getName());
        bundle.putInt("IMAGE",spaceCraft.getImage());
        SwipDetailFragment swipDetailFragment = new SwipDetailFragment();
        swipDetailFragment.setArguments(bundle);
        swipDetailFragment.show(fragmentManager,"DATA");
        this.notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return spaceCraftArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener{

        TextView nameTxt;
        ImageView imageView;
        OnItemTouch onItemTouch;

        public MyViewHolder(View view) {
            super(view);

            nameTxt = (TextView)view.findViewById(R.id.nameTxt);
            imageView = (ImageView)view.findViewById(R.id.spacecraftImage);
            view.setOnTouchListener(this);
        }

        private void setOnItemTouchListener(OnItemTouch onItemTouch){
            this.onItemTouch = onItemTouch;
        }



        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.onItemTouch.touchItem(this.getLayoutPosition());
            return false;
        }
    }
}
