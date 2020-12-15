package com.hfad.adlesson6fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android1lesson71.Destination;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.ArrayList;

public class ChangeFragment extends Fragment implements IFragments {




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Destination> list;


    private String mParam1;
    private String mParam2;


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

        recyclerView = view.findViewById(R.id.recyclerView);
        setUpRecyclerView();

        return view;

    }

    private void setUpRecyclerView() {

        list = new ArrayList<>();
        list.add(new Destination("Latte","A couple of shots with steamed milk",R.drawable.latte));
        list.add(new Destination("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.cappuccino));
        list.add(new Destination("Filter", "Highest quality beans roasted and brewed fresh", R.drawable.filter));


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list, getContext());

        adapter.setOnClickListener(this); // this is method which we created in  RecyclerAdapter

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetails(String title, String subtitle, int imageResourceId) {
        MainActivity activity = (MainActivity) getActivity();
        activity.displayDetails(title, subtitle, imageResourceId);

    }

}