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
            R.drawable.hersheypark,R.drawable.newhersheystadium, R.drawable.newzooamerica, R.drawable.hersheyschocolateworld, R.drawable.thehersheystory, R.drawable.hersheygardens, R.drawable.hersheytheatre, R.drawable.giantcenter, R.drawable.adventuresports, R.drawable.hersheybearshockey, R.drawable.hersheytrolley, R.drawable.hersheysweetlights, R.drawable.aacamuseum, R.drawable.indianechocave, R.drawable.challengefamilyfun, R.drawable.challengefamilyfun, R.drawable.cocoacastle, R.drawable.eshenourmemorialtrail, R.drawable.generalinfo};

    private String[] name = {"Butterfly Garden", "Hershey Candy Lane", "Hershey Park", "Hershey Stadium", "ZooAmerica", "Hershey's Chocolate World", "The Hershey Story", "Hershey Gardens", "Hershey Theatre", "Giant Center", "Adventure Sports", "Hershey Bears Hockey", "Hershey Trolley Works", "Hershey Sweet Lights", "AACA Museum", "Indian Echo Caverns", "Challenge Family Fun Center", "Chocolate Town Square", "Cocoa Castle Playground", "Jonathan Eshenour Memorial Trail", "General Info"};
    private String[] phones = {"7175343492","7175343900","8004377439","7175343911","7175343900", "7175344900", "7172309160", "7175343492", "7175343405", "7175343911", "7175337479", "7175082327", "7175333000", "7175343900", "7175667100", "7175668131", "7175666322", "7175348939", "7175337138", "7175332057", "8777278573"};
    private String[] locs = {"170 Hotel Road, Hershey, PA 17033","Boat House Rd, Hershey, PA 17033","100 Hersheypark Dr, Hershey, PA 17033", "201 Park Avenue, Hershey, PA 17033", "101 Chocolate World Way, Hershey, PA 17033", "63 W Chocolate Ave, Hershey, PA 17033", "170 Hotel Rd, Hershey, PA 17033", "15 E Caracas Ave, Hershey, PA 17033", "550 Hersheypark Dr, Hershey, PA 17033", "3010 Elizabethtown Rd, Hershey, PA 17033", "550 West Hersheypark Drive\n" +
            "Hershey, PA 17033", "251 Park Blvd, Hershey, PA 17033", "Boat House Rd, Hershey, PA 17033", "161 Museum Dr, Hershey, PA 17033", "368 Middletown Rd, Hummelstown, PA 17036", "366 Middletown Rd, Hummelstown, PA 17036", "48 W Chocolate Ave, Hershey, PA 17033", "Hershey, PA 17033", "Jonathan Eshenour Memorial Trail, Hummelstown, PA 17036", "3211 North Front Street, Suite 301-A, Harrisburg, PA 17110"};
    private String[] webs = {"https://www.hersheygardens.org/attractions/butterfly-house","http://www.hersheypark.com/explore-the-park/christmas.php","http://www.hersheypark.com/","http://www.hersheyentertainment.com/hersheypark-stadium/","http://www.zooamerica.com/", "https://www.hersheys.com/chocolateworld/en_us/home.html", "https://hersheystory.org/", "https://www.hersheygardens.org/", "http://www.hersheyentertainment.com/hershey-theatre/", "http://www.hersheyentertainment.com/giant-center/", "https://www.adventurehershey.com/", "http://www.hersheybears.com/", "https://www.hersheytrolleyworks.com/", "http://www.hersheypark.com/info/hours/sweet-lights.php", "https://www.aacamuseum.org/", "http://indianechocaverns.com/", "http://www.challengefamilyfun.com/", "https://www.mshersheyfoundation.org/about/chocolatetown-square.asp", "http://www.derrytownship.org/departments/parks-and-recreation", "http://www.derrytownship.org/resident-services/jonathan-eshenour-memorial-trail", "https://www.visithersheyharrisburg.org/"};

    private String[] nametitles = new String[19];


    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //for(int i =0; i<name.length;i++){
        //    nametitles[i] = name[i] + ": " + url[i];
        //}

        mynewView = inflater.inflate(R.layout.things_to_do,container,false);
        thingstodorecyclerView = mynewView.findViewById(R.id.thingstodorecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        thingstodorecyclerView.setHasFixedSize(true);
        thingstodorecyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(images,name, locs, webs, phones, this.getContext());

        thingstodorecyclerView.setAdapter(adapter);

        return mynewView;



    }
}
