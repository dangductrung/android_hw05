package com.adida.hw05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomRowCell extends ArrayAdapter<User> {
    public CustomRowCell(Context context, ArrayList<User> user) {
        super(context, 0, user);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.activity_custom_row_cell, parent, false);
        TextView name = (TextView) row.findViewById(R.id.userId);
        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        name.setText(user.userId);
        icon.setImageResource(user.imageId);
        icon.setScaleType(ImageView.ScaleType.FIT_XY);

        if(position == ListFragment.selectedId){
            row.setBackgroundColor(Color.YELLOW);
        }
        return (row);
    }

}
