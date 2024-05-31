package com.example.fragile_jalihara;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

public class aboutUsFragment extends Fragment {
    public static final String TITLE = "title";

    String[] names = {"Jalihara Sentul", "Jalihara Jakarta", "Jalihara Medan", "Jalihara Bali", "Jalihara Bandung" };
    String[] location = {"Sentul","Jakarta", "Medan", "Bali", "bandung"};
    Integer[] image = {R.drawable.building1, R.drawable.building2,R.drawable.building3, R.drawable.building4, R.drawable.building5};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_about_us, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.horizontalRvfourth);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new AboutAdapter(names,location,image));
        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ((TextView)view.findViewById(R.id.text_view)).setText(getArguments().getString(TITLE));
//
//    }
}