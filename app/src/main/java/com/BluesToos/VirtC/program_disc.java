package com.BluesToos.VirtC;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.BluesToos.vc.R;

public class program_disc extends Fragment {

    View myView2;
//Initialize the titles and information then send them to a recycler view

    private RecyclerView recyclerView;


    private String[] Qs = {"PET THERAPY","GUEST CHEF PROGRAM", " CAITLIN’S SMILES CRAFTING NIGHT"};
    private String[] As = {"Pet therapy is a guided interaction between a person and a trained animal. It also\n" +
            "involves the animal’s handler. The purpose of pet therapy is to help both children\n" +
            "and adults with a variety of physical and mental issues. It can reduce stress, anxiety\n" +
            "and depression, and increase positivity and socialization.\n" +
            "RMHC-CP receives regular evening visits from pet therapy teams. Our furry friends\n" +
            "can usually be found in the West Living Room from 6:30-7:30pm. Check out the\n" +
            "lobby TV screen to see who will be visiting each evening!!\n" +
            "Our Pet Therapy Teams are certified through:\n" +
            "1. Caring Hearts Pet Therapy http://www.caringheartspettherapy.org/ \n" +
            "2. Therapy Dogs International https://www.tdi-dog.org/default.aspx\n" +
            "3. KPETS https://kpets.org/”.  There is no password required","https://www.caitlins-smiles.org/\n" +
            "The mission is simple, the impact immense. Caitlin's Smiles is dedicated to sharing\n" +
            "smiles and laughter with children facing chronic or life threatening illnesses.\n" +
            "Founded in 2004 in memory of Caitlin Hornung, the non-profit organization\n" +
            "distributes arts and crafts kits to hospitals, giving kids an outlet for creativity and\n" +
            "the means to heightened feelings of self-worth. Caitlin&#39;s Smiles recognizes\n" +
            "children as unique individuals and strives to heighten their feelings of self-worth\n" +
            "and competency by providing them with opportunities to be creative and\n" +
            "successful with a variety of creative art experiences.\n" +
            "All family members are welcome to join Caitlin’s Smiles Volunteers in our West\n" +
            "Dining Room the first Tuesday and third Monday of every month for Crafts and\n" +
            "Conversation!.","Community Groups volunteer their time to provide dinner meals every evening and\n" +
            "breakfast meals every weekend morning for families staying at the Ronald\n" +
            "McDonald House. Breakfast is usually served around 9:00am on Saturday and\n" +
            "Sunday. Dinner is usually served around 6:00pm every evening",

    };

    private int[] images = {R.drawable.questionmark};

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView2 = inflater.inflate(R.layout.progam_disc,container,false);
        //getActivity().setContentView(R.layout.activity_main);
        recyclerView = myView2.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(images, Qs, As, this.getContext());

        recyclerView.setAdapter(adapter);
        return myView2;
    }
}
