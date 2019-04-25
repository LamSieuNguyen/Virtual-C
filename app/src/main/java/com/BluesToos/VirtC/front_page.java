package com.BluesToos.VirtC;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.BluesToos.vc.R;

public class front_page extends Fragment {

    public static View myView;

    Button loc;
    Button num;
    Button web;

    TextView address;
    TextView phoneNumber;
    TextView webUrl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.front_page, container, false);
//get the buttons for locations, phone numbers and website urls
        loc = myView.findViewById(R.id.locButton);
        num = myView.findViewById(R.id.phoneButton);
        web = myView.findViewById(R.id.webButton);

        address = myView.findViewById(R.id.LocationTV);
        phoneNumber = myView.findViewById(R.id.NumberTV);
        webUrl = myView.findViewById(R.id.UrlTV);
// get the text for the loc, num and urls
        final String strLoc = address.getText().toString();
        final String strNum = phoneNumber.getText().toString();
        final String strURL = webUrl.getText().toString();
//make buttons do corresponding action when clicked for numbers, URL and locations
        loc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + strLoc);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        num.setOnClickListener(new View.OnClickListener() { //Edit manifest to allow phone calls
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + strNum)); // Initiates the Intent
                startActivity(callIntent);
            }

        });

        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Uri uri = Uri.parse("" + strURL); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return myView;

    }

    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //myView.setContentView(R.layout.front_page);

        loc = myView.findViewById(R.id.locButton);
        num = myView.findViewById(R.id.phoneButton);
        web = myView.findViewById(R.id.webButton);

        address = myView.findViewById(R.id.LocationTV);
        phoneNumber = myView.findViewById(R.id.NumberTV);
        webUrl = myView.findViewById(R.id.UrlTV);


        final String strLoc = address.getText().toString();
        final String strNum = phoneNumber.getText().toString();
        final String strURL = webUrl.getText().toString();
        /*
        loc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + strLoc);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        num.setOnClickListener(new View.OnClickListener() { //Edit manifest to allow phone calls
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + strNum)); // Initiates the Intent
                startActivity(callIntent);
            }

        });

        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Uri uri = Uri.parse("http://www." + strURL); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    */
    //}

}