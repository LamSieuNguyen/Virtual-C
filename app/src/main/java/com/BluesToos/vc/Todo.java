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

public class Todo extends Fragment {

    View myView;
    View mynewView;

    private RecyclerView thingstodorecyclerView;
    private int[] images = {R.drawable.butterfly, R.drawable.newhersheycandylane,
            R.drawable.hersheypark,R.drawable.newhersheystadium, R.drawable.newzooamerica};

    private String[] name = {"Butterfly Garden", "Hershey Candy Lane", "Hershey Park", "Hershey Stadium", "ZooAmerica"};

    private String[] url = {"http://www.hersheypark.com/ ", "http://www.zooamerica.com/", "https://www.hersheys.com/chocolateworld/en_us/home.html",
    "https://hersheystory.org/", "https://www.hersheygardens.org/"," http://www.hersheyentertainment.com/hershey-theatre/","http://www.hersheyentertainment.com/giant-center/"
    , " http://www.hersheyentertainment.com/hersheypark-stadium/", " https://www.adventurehershey.com/","http://www.hersheybears.com/",
    " https://www.hersheytrolleyworks.com/", "http://www.hersheypark.com/info/hours/sweet-lights.php"," https://www.aacamuseum.org/",
    ""};

    private String[] nametitles = new String[19];


    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        for(int i =0; i<name.length;i++){
            nametitles[i] = name[i] + ": " + url[i];
        }


        mynewView = inflater.inflate(R.layout.things_to_do,container,false);
        thingstodorecyclerView = mynewView.findViewById(R.id.thingstodorecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        thingstodorecyclerView.setHasFixedSize(true);
        thingstodorecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,nametitles);
        thingstodorecyclerView.setAdapter(adapter);

        return mynewView;



    }
}
