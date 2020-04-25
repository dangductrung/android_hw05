package com.adida.hw05;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class custom_row extends ArrayAdapter<User> {
    public custom_row(Context context, ArrayList<User>  user) {
        super(context, 0, user);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.activity_custom_row, parent, false);
        TextView name = (TextView) row.findViewById(R.id.name);
        TextView phone = (TextView) row.findViewById(R.id.phone);
        ImageView icon = (ImageView) row.findViewById(R.id.icon);
        name.setText(user.name);
        phone.setText(user.phone);
        icon.setImageResource(user.imgId);
        icon.setScaleType(ImageView.ScaleType.FIT_XY);

        if(position == MainActivity.selectedId){
            row.setBackgroundColor(Color.YELLOW);
        }
        return (row);
    }
}
