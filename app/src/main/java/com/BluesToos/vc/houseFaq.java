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
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class houseFaq extends Fragment {

    View myView2;

    private RecyclerView recyclerView;


    private String[] Qs = {"What is your Wi-Fi password?","Where can I put my trash? ","Where can I smoke?","How can I support RMHC-CP?","How can I sign up to volunteer for the guest chef, baking or lunch programs?"
    ,"How do I confirm my room on the first day I’d like to stay?","Why can’t I have food in my room?"};
    private String[] As = {"The answer is it doesn't","Noose, gun, poisen or slitting your wrists","Absofuckinglutely!!"};
    private int[] images = {R.drawable.questionmark};

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView2 = inflater.inflate(R.layout.neighborhood_guide,container,false);
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
