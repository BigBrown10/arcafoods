package com.example.arcafood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdaptor extends BaseAdapter {
private Context mContext;



    public ImageAdaptor( Context c) {
        mContext= c;

    }
    @Override
    public int getCount()
    {
        return mImages.length;

    }

    @Override
    public Object getItem(int i)
    {
        return mImages[i];
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {


       if(convertView==null){
       convertView =LayoutInflater.from(parent.getContext()).inflate(
                   R.layout.layout_images, parent,false);

        }
        ImageView myView = convertView.findViewById(R.id.rice);
        TextView theText = convertView.findViewById(R.id.ourText);
        myView.setImageResource((int)getItem(position));
        theText.setText(names[position]);

        return convertView;
    }
    int[] mImages = {
            R.drawable.rice,
            R.drawable.swallow,
            R.drawable.citrus,
            R.drawable.drinks,
            R.drawable.protein_sources,
            R.drawable.snacks
    };
    String[] names={
            "Rice",
            "Swallow",
            "Fruits",
            "Drinks",
            "Proteins",
            "Snacks",
    };

}


