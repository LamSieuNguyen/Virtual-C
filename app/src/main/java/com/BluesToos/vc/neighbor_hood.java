package com.BluesToos.vc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class neighbor_hood extends Fragment {

    View myView;

    private RecyclerView recyclerView;
    private int[] images = {R.drawable.members1,R.drawable.metro, R.drawable.wellsfargo};
    private String[] names = {"Members 1st","Metro Bank","WellsFargo"};
    private String[] phones = {"8002377288","7175664400","7175334550"};
    private String[] locs = {"381 W Governor Rd, Hershey, PA 17033","600 Walton Ave, Hummelstown, PA 17036","27 Ridge Rd, Hershey, PA 17033"};
    private String[] webs = {"members1st.org","metrobankonline.co.uk","wellsfargo.com"};

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
        adapter = new RecyclerAdapter(images, names, locs, webs, phones, this.getContext());
        recyclerView.setAdapter(adapter);
        return myView;
    }
}
