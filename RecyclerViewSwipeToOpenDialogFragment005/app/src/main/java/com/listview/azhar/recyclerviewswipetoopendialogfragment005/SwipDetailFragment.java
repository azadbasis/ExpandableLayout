package com.listview.azhar.recyclerviewswipetoopendialogfragment005;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Azhar on 5/1/2017.
 */

public class SwipDetailFragment extends DialogFragment {


    TextView nameTextView;
    ImageView images;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spacecraftdetail,container,false);

        nameTextView = (TextView)view.findViewById(R.id.nameTextDetail);
        images = (ImageView)view.findViewById(R.id.spaceCraftImageDetail);

        String name = this.getArguments().getString("NAME");
        int image = this.getArguments().getInt("IMAGE");

        nameTextView.setText(name);
        images.setImageResource(image);

        return view;
    }
}
