package com.example.arcafood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {

    public static final String EXTRA_TEXT= "com.example.arcafood";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        TextView textView = findViewById(R.id.username);
        textView.setText(text);
    }
//    for the go to food order button
    public void newButton (View v) {
        Button click = findViewById(R.id.myButton);
         openimageButtons();
    }
    public void openimageButtons(){
        TextView theText = findViewById(R.id.username);
        String go = theText.getText().toString();
        Intent goIntent = new Intent(this,imageButtons.class);
        goIntent.putExtra(EXTRA_TEXT,go);
        startActivity(goIntent);
    }
}


