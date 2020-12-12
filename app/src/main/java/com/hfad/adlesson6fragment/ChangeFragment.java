package com.hfad.adlesson6fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChangeFragment extends Fragment {
    private Button btnFirst;
    private Button btnSecond;
    private TextView txtView;


    private IFragments listener;



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IFragments) context; // explore
    }

    public ChangeFragment() {
        // Required empty public constructor
    }

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change, container, false);
        btnFirst = view.findViewById(R.id.btnFirst);
        btnSecond = view.findViewById(R.id.btnSecond);
        txtView = view.findViewById(R.id.txtFirstFragment);

        if(mParam1 != null){
            txtView.setText(mParam1);
        }

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TextView text = getActivity().findViewById(R.id.textMain);
                text.setText("Hello Main Activity");
                listener.onFirstFragment();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSecondFragment();
            }
        });
        return view;

    }
}