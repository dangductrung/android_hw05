package com.adida.hw05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements MainCallbacks {
    ArrayList<User> data = new ArrayList<User>();
    String[] name = {"Nguyen Van A", "Nguyen Van B", "Nguyen Van C", "Nguyen Van D"};
    String[] id = {"#01","#02","#03","#04"};
    String[] className = {"A1","A2","A3","A4"};
    Double[] gpa = {9.0,8.0,7.0,9.0};
    int currentPosition = -1;
    int[] image = {R.drawable.main_yellow_hair, R.drawable.man, R.drawable.man_face_round, R.drawable.woman_face_long};
    ListFragment listFragment;
    ContentFragment contentFragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i =0 ; i<name.length ; ++i) {
            data.add(new User(id[i], name[i], image[i], className[i], gpa[i]));
        }

        ft = getSupportFragmentManager().beginTransaction();
        listFragment = ListFragment.newInstance("abc", "abc",  data);
        contentFragment = ContentFragment.newInstance("abc", "abc",  data);
        ft.replace(R.id.nameFrag, listFragment);
        ft.replace(R.id.contentFrag, contentFragment);
        ft.commit();
    }

    @Override
    public void onMsgFromFragToMain(String sender, int position) {
        switch (sender) {
            case StringKeys.LIST_FRAGMENT:
                currentPosition = position;
                contentFragment.onMsgFromMainToFragment(position);
                break;
            case StringKeys.CONTENT_FRAGMENT:
                switch (position){
                    case PositionButton.first:
                        currentPosition = 0;
                        break;
                    case PositionButton.last:
                        currentPosition = data.size() - 1;
                        break;
                    case PositionButton.previous:
                        if (currentPosition > 0) {
                            currentPosition -= 1;
                        }
                        break;
                    case PositionButton.next:
                        if (currentPosition < (data.size() - 1)) {
                            currentPosition += 1;
                        }
                        break;
                }
                contentFragment.onMsgFromMainToFragment(currentPosition);
                listFragment.onMsgFromMainToFragment(currentPosition);
                break;
        }
    }
}
