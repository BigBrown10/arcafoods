package com.example.arcafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class imageButtons extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_buttons);

        Intent intent = getIntent();
//        String ourText= intent.getStringExtra(home.EXTRA_TEXT);
//        TextView view = findViewById(R.id.ourText);
//        view.setText(ourText);

        final ArrayList<Image> pictures = new ArrayList<Image>();
        {
            pictures.add(new Image(R.string.white_rice, R.drawable.rice));
            pictures.add(new Image(R.string.joll_rice, R.drawable.joll));
            pictures.add(new Image(R.string.fried_rice, R.drawable.fried_rice));
            pictures.add(new Image(R.string.beans, R.drawable.beans));
            pictures.add(new Image(R.string.pro, R.drawable.protein_sources));
            pictures.add(new Image(R.string.fufu, R.drawable.fufu));
            pictures.add(new Image(R.string.pound, R.drawable.swallow));
            pictures.add(new Image(R.string.eba, R.drawable.eba));


            ImageAdaptor adapter = new ImageAdaptor(this, pictures);

            final ListView theList = (ListView) findViewById(R.id.listView);
            theList.setAdapter(adapter);

            theList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String currentImage = getString(((Image) adapterView.getItemAtPosition(i)).getText());
                    Intent newIntent = new Intent(imageButtons.this, ConfirmRiceActivity.class);
                    newIntent.putExtra("pictures", currentImage);
                    startActivity(newIntent);

                }
            });


        }


    }
}





