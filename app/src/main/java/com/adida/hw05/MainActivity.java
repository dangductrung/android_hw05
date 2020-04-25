package com.adida.hw05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft;
    FragmentRed redFragment;
    FragmentBlue blueFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        // get a reference to each fragment attached to the GUI
        if (fragment.getClass() == FragmentRed.class ){
            redFragment = (FragmentRed) fragment;
        }
        if (fragment.getClass() == FragmentBlue.class ){
            blueFragment = (FragmentBlue) fragment;
        }
    }
}
