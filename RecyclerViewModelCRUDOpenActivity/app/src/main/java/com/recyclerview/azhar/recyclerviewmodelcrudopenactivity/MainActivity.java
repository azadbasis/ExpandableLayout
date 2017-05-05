package com.recyclerview.azhar.recyclerviewmodelcrudopenactivity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.adapter.CustomAdapter;
import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data.CRUD;
import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data.SpaceCraft;
import com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data.SpaceCraftCoollection;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SpaceCraft spaceCraft;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    EditText etName, etDescription;
    CRUD crud;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();
            }
        });


    }

    private void findViewById() {
        crud = new CRUD(SpaceCraftCoollection.getSpaceCrafts());
        //spaceCraftArrayList = new ArrayList<>();
        //spaceCraftArrayList = crud.getSpaceCraftArrayList();

        recyclerView = (RecyclerView) findViewById(R.id.recycerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter(this, crud.getSpaceCraftArrayList());
        // recyclerView.setAdapter(customAdapter);
    }

    private void displayDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("ADD DATA");
        d.setContentView(R.layout.add_dilogue);

        etName = (EditText) d.findViewById(R.id.etName);
        etDescription = (EditText) d.findViewById(R.id.etDescription);
        btnSave = (Button) d.findViewById(R.id.btnAdd);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spaceCraft = new SpaceCraft();
                spaceCraft.setName(etName.getText().toString());
                spaceCraft.setDescription(etDescription.getText().toString());

                if (crud.addData(spaceCraft)) {
                    etName.setText("");
                    etDescription.setText("");

                    recyclerView.setAdapter(customAdapter);

                } else {
                    Toast.makeText(MainActivity.this, "data does not insert", Toast.LENGTH_SHORT).show();
                }
            }
        });

        d.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(customAdapter);
    }
}
