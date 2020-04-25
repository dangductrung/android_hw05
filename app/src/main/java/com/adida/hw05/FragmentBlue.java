package com.adida.hw05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentBlue<User> extends Fragment {
    TextView textView;
    String[] names = {"Nguyen Van A", "Bui Thi B", "Tran Van C", "Nguyen Thi D"};
    String[] phones = {"0123456789", "03353456789", "0987456349", "0999456711"};
    ArrayList<User> users = new ArrayList<User>();

    // public static
    public static int selectedId = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);


        for (int i = 0 ;i<names.length ; i++) {
            users.add(new User(names[i], phones[i], imgIds[i]));
        }

        textView = (TextView) findViewById(R.id.selectedMsg);
        final custom_row adapter = new custom_row(this, users);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("Your choose: "+ names[position]);

                adapter.notifyDataSetChanged();
                selectedId = position;
            }
        });

        return view;
    }
}
