package com.BluesToos.vc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class notifications extends Fragment {

    View myView;
    String TAG = "pweiser.notes";
    public TextView title,message;

    public static ArrayList<String> titles = new ArrayList<>();
    public static ArrayList<String> messages = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.notificatons,container,false);


        super.onCreate(savedInstanceState);
        LocalBroadcastManager.getInstance(myView.getContext()).registerReceiver(mHandler,new IntentFilter("edu.fandm.pweiser.notes_FCMMESSAGE"));
        title = myView.findViewById(R.id.title);
        message = myView.findViewById(R.id.message);
        Log.d(TAG,"ONCREATE");
        if(titles != null) {
            title.setText(titles.toString());
            message.setText(titles.toString());
        }

        if(getActivity().getIntent().getExtras()!=null){
            Log.d(TAG,"getIntent: " + getActivity().getIntent().getExtras().keySet());
            for(String key: getActivity().getIntent().getExtras().keySet()){
                if(key.equals("title")){
                    Log.d(TAG,"title");
                    titles.add(getActivity().getIntent().getExtras().getString(key));
                    title.setText(titles.toString());
                }
                else if(key.equals("message")){
                    Log.d(TAG,"message");
                    messages.add(getActivity().getIntent().getExtras().getString(key));
                    message.setText(titles.toString());
                }
            }
        }
    return myView;
    }

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

