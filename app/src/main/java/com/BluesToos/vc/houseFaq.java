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
import android.widget.TextView;

public class houseFaq extends Fragment {

    View myView;
    TextView textView1,textView2,textView3,textView4,textView5,textView6;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.house_faq,container,false);
        TextView textView1 = (TextView)getView().findViewById(R.id.);
        return myView;
    }
}
