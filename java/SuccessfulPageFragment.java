package com.example.mad_assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class SuccessfulPageFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String username;

    public SuccessfulPageFragment(String username)
    {
        this.username = username;
    }

    public static SuccessfulPageFragment newInstance(String param1, String param2) {
        SuccessfulPageFragment fragment = new SuccessfulPageFragment(username);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Button order_History_Btn;

        View view = inflater.inflate(R.layout.fragment_successful_page, container, false);
        order_History_Btn = view.findViewById(R.id.view_history_btn);

        order_History_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                OrderHistoryFragment order_history_fragment = new OrderHistoryFragment(username);
                fr.replace(R.id.frag_container_two, order_history_fragment);
                fr.commit();
            }
        });
        return view;
    }
}