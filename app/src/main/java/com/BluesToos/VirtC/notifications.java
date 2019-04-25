package com.BluesToos.VirtC;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.BluesToos.vc.R;

import java.util.ArrayList;

public class notifications extends Fragment {

    View myView;
    String TAG = "pweiser.notes";
    public TextView title,message;

    public static ArrayList<String> titles = new ArrayList<>();
    public static ArrayList<String> messages = new ArrayList<>();

    private int[] images = {R.drawable.questionmark};

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;


    // This gets the data from notifications while the app was closed, and sets the recycler view

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.notificatons,container,false);


        super.onCreate(savedInstanceState);
        LocalBroadcastManager.getInstance(myView.getContext()).registerReceiver(mHandler,new IntentFilter("edu.fandm.pweiser.notes_FCMMESSAGE"));
        //title = myView.findViewById(R.id.title);
        //message = myView.findViewById(R.id.message);
        Log.d(TAG,"ONCREATE");
        //if(titles != null) {
          //  title.setText(titles.toString());
           // message.setText(titles.toString());
        //}

        if(getActivity().getIntent().getExtras()!=null){
            Log.d(TAG,"getIntent: " + getActivity().getIntent().getExtras().keySet());
            for(String key: getActivity().getIntent().getExtras().keySet()){
                if(key.equals("title")){
                    Log.d(TAG,"title");
                    titles.add(getActivity().getIntent().getExtras().getString(key));
                }
                else if(key.equals("message")){
                    Log.d(TAG,"message");
                    messages.add(getActivity().getIntent().getExtras().getString(key));
                }
            }
        }

        //sends info to recycle view so data is connected correctly
        myView = inflater.inflate(R.layout.house_faq,container,false);
        //getActivity().setContentView(R.layout.activity_main);
        recyclerView = myView.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(images, titles, messages, this.getContext());

        recyclerView.setAdapter(adapter);
        return myView;

    }

    // The following two are used to save the data from notifications
    private BroadcastReceiver mHandler = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG,"asdfklj");
            String titles = intent.getStringExtra("title");
            String messages = intent.getStringExtra("message");
            title.setText(titles);
            message.setText(messages);

        }
    };

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"ONPAuSSE");
        LocalBroadcastManager.getInstance(myView.getContext()).unregisterReceiver(mHandler);
    }


}

