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

import com.github.barteksc.pdfviewer.PDFView;

public class houseFaq extends Fragment {

    View myView;

    PDFView pdfview1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.house_faq,container,false);

       // pdfview1 = (PDFView) getView().findViewById(R.id.pdfviewer1);
       // pdfview1.fromAsset("faqs.pdf").load();

        return myView;

    }
}
