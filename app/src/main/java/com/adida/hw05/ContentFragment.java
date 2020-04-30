package com.adida.hw05;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFragment extends Fragment implements FragmentCallbacks {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<User> data = new ArrayList<User>();

    MainActivity main;

    TextView userName;
    TextView userId;
    TextView className;
    TextView grade;
    Button btnFirst;
    Button btnLast;
    Button btnPrevious;
    Button btnNext;


    public ContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String param1, String param2, ArrayList<User> data) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.data = data;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_content, null);
        this.userName = (TextView) layout.findViewById(R.id.userName);
        this.userId = (TextView) layout.findViewById(R.id.userContentId);
        this.className = (TextView) layout.findViewById(R.id.className);
        this.grade = (TextView) layout.findViewById(R.id.grade);
        this.btnFirst = (Button) layout.findViewById(R.id.first);
        this.btnLast = (Button) layout.findViewById(R.id.last);
        this.btnNext = (Button) layout.findViewById(R.id.next);
        this.btnPrevious = (Button) layout.findViewById(R.id.previous);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain(StringKeys.CONTENT_FRAGMENT, PositionButton.first);
            }
        });
        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain(StringKeys.CONTENT_FRAGMENT, PositionButton.last);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain(StringKeys.CONTENT_FRAGMENT, PositionButton.next);
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain(StringKeys.CONTENT_FRAGMENT, PositionButton.previous);
            }
        });

        return layout;
    }

    @Override
    public void onMsgFromMainToFragment(int position) {
        User user = data.get(position);
        this.userName.setText("Ho ten: " + user.name);
        this.userId.setText(user.userId);
        this.className.setText("Lop: " + user.className);
        this.grade.setText("Diem trung binh: " + Double.toString(user.grade));

        if (position == (data.size() - 1)) {
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
        } else if (position == 0) {
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnFirst.setEnabled(false);
            btnPrevious.setEnabled(false);
        } else {
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
        }
    }
}
