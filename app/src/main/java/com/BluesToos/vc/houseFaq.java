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

    private String[] Qs = {"The question is how the fuck does this work","How do you kill yourself?","Do I hate my life?"};
    private String[] As = {"The answer is it doesn't","Noose, gun, poisen or slitting your wrists","Absofuckinglutely!!"};

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

        adapter = new RecyclerAdapter(Qs, As, this.getContext());

        recyclerView.setAdapter(adapter);
        return myView2;
    }
}
