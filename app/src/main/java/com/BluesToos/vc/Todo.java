package com.BluesToos.vc;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Todo extends Fragment {

    View myView;
    View mynewView;

    private RecyclerView thingstodorecyclerView;
    private int[] images = {R.drawable.butterfly, R.drawable.newhersheycandylane,
            R.drawable.hersheypark,R.drawable.newhersheystadium, R.drawable.newzooamerica};

    private String[] name = {"Butterfly Garden", "Hershey Candy Lane", "Hershey Park", "Hershey Stadium", "ZooAmerica"};


    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mynewView = inflater.inflate(R.layout.things_to_do,container,false);
        thingstodorecyclerView = mynewView.findViewById(R.id.thingstodorecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        thingstodorecyclerView.setHasFixedSize(true);
        thingstodorecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,name, this.getContext());
        thingstodorecyclerView.setAdapter(adapter);

        return mynewView;



    }
}
