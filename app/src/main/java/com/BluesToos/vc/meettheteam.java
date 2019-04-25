package com.BluesToos.vc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class meettheteam extends Fragment {

    View myView;
    View mynewView;
//Initialize the names and job titles to a list then send them to a recycler view
    private RecyclerView meetteamrecyclerView;
    private int[] images = {R.drawable.alyssa, R.drawable.amy,
            R.drawable.bonnie,R.drawable.brenda, R.drawable.whitebackground, R.drawable.colin,
            R.drawable.whitebackground,R.drawable.debs,R.drawable.heidi,R.drawable.iona,R.drawable.jen,
            R.drawable.karla,R.drawable.leeann,R.drawable.loretta,R.drawable.lori,R.drawable.michelle,
            R.drawable.patrice,R.drawable.rachel,R.drawable.teresa};

    private String[] name = {"Alyssa", "Amy", "Bonnie", "Brenda", "Christine", "Colin", "Deb J.", "Deb S.", " Heidi", "Iona"
    ,"Jen", "Karla", "Leeann", "Loretta", " Lori", "Michelle", "Patrice", "Rachel", "Teresa"};

    private String[] titles = {"Volunteer and Operations Manager", "Development Director", "Ronald McDonald Family Room Assistant Manager",
    "Relief Manager", "Relief Manager", "Resident and Facilities Manager", "Housekeeper","Office Manager","Ronald McDonald Family Room Manager",
    "Housekeeper", "Relief Manager", "Executive Director", "Relief Manager", "Relief Manager", "Administrative Assistant for Development",
            "Relief Manager", "Operations Director", "Marketing and Communications Manager", "Relief Manager"};

    private String[] nametitles = new String[19];


    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        for(int i =0; i<name.length;i++){
            nametitles[i] = name[i] + ": " + titles[i];
        }

        mynewView = inflater.inflate(R.layout.meet_the_team,container,false);
        meetteamrecyclerView = mynewView.findViewById(R.id.meettheteamrecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        meetteamrecyclerView.setHasFixedSize(true);
        meetteamrecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,nametitles, titles, titles,titles,this.getContext());
        meetteamrecyclerView.setAdapter(adapter);
        return mynewView;

    }
}
