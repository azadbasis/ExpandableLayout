package com.recyclerview.azhar.recyclerviewmodelcrudopenactivity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data.CRUD;
import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data.SpaceCraft;
import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data.SpaceCraftCoollection;

public class DetailActivity extends AppCompatActivity {

    TextView nameTxtDetail, descLabelDetail;
    EditText nameEditDetailTxt, descEditTextDetail;
    Button updateBtn, deleteBtn;
    String name, description;
    int position;
    CRUD crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayUpdateDialog();
            }
        });
    }

    private void findViewById() {
        crud = new CRUD(SpaceCraftCoollection.getSpaceCrafts());
        descLabelDetail = (TextView) findViewById(R.id.descLabelDetail);
        nameTxtDetail = (TextView) findViewById(R.id.nameTxtDetail);
        name = this.getIntent().getExtras().getString("NAME");
        description = this.getIntent().getExtras().getString("DESCRIPTION");
        position = this.getIntent().getExtras().getInt("POSITION");
        descLabelDetail.setText(description);
        nameTxtDetail.setText(name);
    }


    private void displayUpdateDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("UPDATE/DELETE DATA");
        d.setContentView(R.layout.update_diloge);

        nameEditDetailTxt = (EditText) d.findViewById(R.id.nameEditTxt);
        descEditTextDetail = (EditText) d.findViewById(R.id.descEditTxt);
        updateBtn = (Button) d.findViewById(R.id.saveBtn);
        deleteBtn = (Button) d.findViewById(R.id.deleteBtn);

        nameEditDetailTxt.setText(name);
        descEditTextDetail.setText(description);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpaceCraft spaceCraft = new SpaceCraft();

                name = nameEditDetailTxt.getText().toString();
                description = descEditTextDetail.getText().toString();

                spaceCraft.setName(name);
                spaceCraft.setDescription(description);

                if (crud.updateData(position, spaceCraft)) {
                    nameEditDetailTxt.setText(name);
                    descEditTextDetail.setText(description);

                    nameTxtDetail.setText(name);
                    descLabelDetail.setText(description);
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crud.deleteData(position)) {
                    //KILL THIS ACTIVITY AND GO BACK TO MASTER
                    DetailActivity.this.finish();

                }
            }
        });

        d.show();

    }

}
