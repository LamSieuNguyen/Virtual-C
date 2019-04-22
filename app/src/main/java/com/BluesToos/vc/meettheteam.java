package com.BluesToos.vc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class meettheteam extends Fragment {

    View myView;
    View mynewView;

    private RecyclerView meetteamrecyclerView;
    private int[] images = {R.drawable.alyssanoel, R.drawable.amyleonard,
            R.drawable.bonnieluz,R.drawable.whitebackground, R.drawable.whitebackground, R.drawable.colinpowell,
            R.drawable.whitebackground,R.drawable.debstegall,R.drawable.heidimurray,R.drawable.whitebackground,R.drawable.whitebackground,
            R.drawable.karlamitchell,R.drawable.whitebackground,R.drawable.whitebackground,R.drawable.whitebackground,R.drawable.whitebackground,
            R.drawable.whitebackground,R.drawable.rachelclippinger,R.drawable.whitebackground};

    private String[] name = {"Alyssa", "Amy", "Bonnie", "Brenda", "Christine", "Colin", "Deb J.", "Deb S.", " Heidi", "Iona"
    ,"Jen", "Karla", "Leeann", "Loretta", " Lori", "Michelle", "Patrice", "Rachel", "Teresa"};

    private String[] titles = {"Volunteer and Operations Manager", "Development Director", "Ronald McDonald Family Room Assistant Manager",
    "Relief Manager", "Relief Manager", "Resident and Facilities Manager", "Housekeeper","Office Manager","Ronald McDonald Family Room Manager",
    "Housekeeper", "Relief Manager", "Executive Director", "Relief Manager", "Relief Manager", "Administrative Assistant for Development",
            "Relief Manager", "Operations Director", "Marketing and Communications Manager", "Relief Manager"};

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mynewView = inflater.inflate(R.layout.meet_the_team,container,false);
        meetteamrecyclerView = mynewView.findViewById(R.id.meettheteamrecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        meetteamrecyclerView.setHasFixedSize(true);
        meetteamrecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,name);
        meetteamrecyclerView.setAdapter(adapter);
        return mynewView;

    }
}
