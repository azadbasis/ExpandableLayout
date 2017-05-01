package com.recyclerview.azhar.recyclerviewswipetoopenactivityandpassdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    TextView nameTextView;
    ImageView images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spacecraftdetail);

        nameTextView = (TextView)findViewById(R.id.nameTextDetail);
        images = (ImageView)findViewById(R.id.spaceCraftImageDetail);

        String name = this.getIntent().getExtras().getString("NAME");
        int image = this.getIntent().getExtras().getInt("IMAGE");

        nameTextView.setText(name);
        images.setImageResource(image);

    }
}
