package com.example.arcafood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ImageAdaptor extends ArrayAdapter<Image> {


    public ImageAdaptor(Context c, ArrayList<Image> pictures) {
        super(c, 0, pictures);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout_images, parent, false);
        }
        Image theMain = getItem(position);


        TextView myText = listView.findViewById(R.id.ourText);
        myText.setText(theMain.getText());

        ImageView myImage = listView.findViewById(R.id.image);
        myImage.setImageResource(theMain.getImage());

        return listView;
    }

}








