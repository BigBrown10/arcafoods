package com.example.arcafood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class imageButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_buttons);

        Intent intent =getIntent();
//        String ourText= intent.getStringExtra(home.EXTRA_TEXT);
//        TextView view = findViewById(R.id.ourText);
//        view.setText(ourText);

        GridView theGrid = (GridView) findViewById(R.id.gridView);
        theGrid.setAdapter(new ImageAdaptor(this));

        }



}





