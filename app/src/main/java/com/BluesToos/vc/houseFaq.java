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
    ,"How do I confirm my room on the first day I’d like to stay?","Why can’t I have food in my room?","When does the shuttle come?","When I am ready to check out, what do I have to do?",
            "How can I request a room if I need to come back? "};
    private String[] As = {"Wi-Fi is “Wayport”.  There is no password required","There are trash cans at the end of each hallway." +
            "  Please take dirty diapers and other smelly/wet garbage outside." +
            "  There is a trash can outside the front door, and a dumpster at the edge of the parking lot."
            ,"Out front to the left of the driveway beyond the bushes.","Donations are always welcome and can be made out to RMHC-CP." +
            "  Other ways to donate can be found on our website at www.rmhc-centralpa.org","All of this information can be found here:" +
            "  https://www.rmhc-centralpa.org/get-involved/meal-providers/","Please call the House at 717-533-4001, extension “0” after 10am on the day you would like to arrive.",
    "We have a small housekeeping staff and are not able to keep up with the mess that food creates in our bedrooms.  We need to keep the rooms neat and clean in order to turn the rooms around quickly and help as many families as possible." +
            "  Please keep all food and drinks, with the exception of water, in the kitchen/dining room areas.",
            "*The Hershey Medical Center’s Patient Shuttle comes to the Ronald McDonald House House automatically, Monday through Friday at 5:10am, 6:10am, 7:10am, 8:10am, 9:10am, 10:10am, 11:10am, 12:10pm, 1:10pm, 2:10pm and 3:10pm.\n" +
                    "\n" +
                    "*Service is also available at 4:10pm, 5:10pm, 6:10pm, 7:10pm and 8:10pm from the House, but these times require a phone call to the shuttle.  If you need the shuttle at 4:10pm, 5:10pm, 6:10pm, 7:10pm or 8:10pm, please let our front desk volunteers know so that they can call.\n" +
                    "\n" +
                    "*The shuttle service is available on the weekends for emergencies only at the following times: 8:00am, 10:00am and 12:00pm.  If you need emergency service on the weekends at any of these times, please let the front desk know.\n" +
                    "*Other emergency shuttle service may be available – please have your doctor, nurse or social worker set up emergency shuttle service for you if you need it at times other than listed above. \n",
            "Follow the check-out checklist that you received when you checked in.  If you don’t have one, please come to the office for a replacement.",
            "You can put in a room request with a volunteer before you leave, or you can call the House any day between 9:00am and 9:00pm to make a request.  You can also make room requests online at https://www.rmhc-centralpa.org/request-a-room/"
    };

    private int[] images = {R.drawable.questionmark};

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView2 = inflater.inflate(R.layout.house_faq,container,false);
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
