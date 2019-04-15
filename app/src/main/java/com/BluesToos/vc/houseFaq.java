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

public class houseFaq extends Fragment {

    View myView;
    View mynewView;

    private RecyclerView housefaqrecyclerView;
    private int[] images = {R.drawable.butterfly, R.drawable.newhersheycandylane,
            R.drawable.hersheypark,R.drawable.newhersheystadium, R.drawable.newzooamerica};

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
        mynewView = inflater.inflate(R.layout.house_faq,container,false);
        housefaqrecyclerView = mynewView.findViewById(R.id.housefaqrecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        housefaqrecyclerView.setHasFixedSize(true);
        housefaqrecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,name);
        housefaqrecyclerView.setAdapter(adapter);
        return mynewView;
    }
}
