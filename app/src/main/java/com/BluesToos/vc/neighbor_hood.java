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
    private int[] images = {R.drawable.members1,R.drawable.metro, R.drawable.wellsfargo,R.drawable.hersheypharmacy,
            R.drawable.newweis,R.drawable.newgiant,R.drawable.mcdonalds,R.drawable.piazzasorrento,R.drawable.subbway,R.drawable.friendlys,
            R.drawable.newfenniccis,R.drawable.newwalmart,R.drawable.tarrget,R.drawable.newgiant,R.drawable.newweis,R.drawable.newkarns,
            R.drawable.newpostoffice,
            R.drawable.hummelstownpostoffice,R.drawable.cocoaplex,R.drawable.newtanger,R.drawable.harrisburgmall,R.drawable.newcolonial,
            R.drawable.haiairport,R.drawable.hmcfitness,R.drawable.newsupercuts,R.drawable.holidayhair,R.drawable.newsportclips};

    private String[] names = {"Members 1st","Metro Bank","WellsFargo", "Hershey Pharmacy", "Weis Pharmacy", "Giant Pharmacy"
    ,"McDonald’s","Piazza Sorrento", "Subway","Friendly’s", "Fenicci’s","Walmart", "Target", "Giant", "Weis", "Karns", "Hershey Post Office",
    "Hummelstown Post Office","CocoaPlex", "Tanger Outlets", "Harrisburg Mall", "Colonial Park Mall", "HIA Airport", "HMC Fitness Center",
    "Supercuts", "Holiday Hair", "SportClips"};
    private String[] phones = {"8002377288","7175664400","7175334550", "7175341300","7175332963"," 7173120729","7175666041","7178351919",
            "8145717143","7175334190","7175337159","7175618402","7175584150","7173120725","7175332447","7175336445" };
    private String[] locs = {"381 W Governor Rd, Hershey, PA 17033","600 Walton Ave, Hummelstown, PA 17036","27 Ridge Rd, Hershey, PA 17033","731 Cherry Dr Ste 2, Hershey, PA 17033"
    ,"1130 Mae St, Hummelstown, PA 17036","1250 Cocoa Ave, Hershey, PA 17033","611 E Main St, Hummelstown, PA 17036","16 Briarcrest Square, Hershey, PA 17033",
    "Park, 100 West Hersheypark Drive Founders Way, Hershey, PA 17033","1000 Reese Ave, Hershey, PA 17033","102 W Chocolate Ave, Hershey, PA 17033",
            "6535 Grayson Rd, Harrisburg, PA 17111","4600 High Pointe Blvd, Harrisburg, PA 17111","1250 Cocoa Ave, Hershey, PA 17033", "1130 Mae St, Hummelstown, PA 17036",
            "731 Cherry Dr, Hershey, PA 17033"};
    private String[] webs = {"members1st.org","metrobankonline.co.uk","wellsfargo.com", "https://hersheypharmacy.com/", "https://www.weismarkets.com/pharmacy-services?q-pharmacy%2F=",
    "https://stores.giantfoodstores.com/pa/hershey/1250-cocoa-ave","https://www.mcdonalds.com/us/en-us/location/pa/hummelstown/rt-39-at-rt-322/2837.html?cid=RF:YXT:GMB::Clicks",
            "http://www.piazzasorrento.com/","https://order.subway.com/?r=1432328590","https://www.friendlysrestaurants.com/restaurants/friendlys-hershey-17033/?id=756",
            "http://feniccis.com/","https://www.walmart.com/store/1591/harrisburg-pa/details","https://www.target.com/sl/harrisburg-east/2186",
            "https://stores.giantfoodstores.com/pa/hershey/1250-cocoa-ave", "https://www.weismarkets.com/stores#/4406","https://www.karnsfoods.com/?utm_source=googlemybusiness&utm_medium=organic&utm_campaign=hershey",
    ""};

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
