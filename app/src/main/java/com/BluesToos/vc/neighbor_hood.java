package com.BluesToos.vc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class neighbor_hood extends Fragment {

    View myView;

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.members1,R.drawable.metro, R.drawable.wellsfargo};
    private String[] names = {"Members 1st","Metro First","Wells Fargo"};

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.neighborhood_guide,container,false);
        //getActivity().setContentView(R.layout.activity_main);
        recyclerView = myView.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,names);
        recyclerView.setAdapter(adapter);
        return myView;
    }
}
