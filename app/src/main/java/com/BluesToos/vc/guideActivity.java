package com.BluesToos.vc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class guideActivity extends Fragment {

    String TAG = "HELP US";

    public static View myView;

    Button loc;
    Button num;
    Button web;

    TextView address;
    TextView phoneNumber;
    TextView webUrl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);

        myView = inflater.inflate(R.layout.guideactivity, container, false);

        Bundle bundle = getArguments();
        Log.d(TAG,"BUNDLE: " + bundle);
        int pos = getArguments().getInt("pos");
        String[] names = getArguments().getStringArray("names");
        String[] locs = getArguments().getStringArray("locs");
        String[] webs = getArguments().getStringArray("webs");
        String[] nums = getArguments().getStringArray("nums");
        int[] images = getArguments().getIntArray("images");

        ImageView pic = myView.findViewById(R.id.menuPic);
        pic.setImageResource(images[pos]);

        loc = myView.findViewById(R.id.locButton);
        num = myView.findViewById(R.id.phoneButton);
        web = myView.findViewById(R.id.webButton);

        address = myView.findViewById(R.id.LocationTV);
        address.setText(locs[pos]);
        phoneNumber = myView.findViewById(R.id.NumberTV);
        phoneNumber.setText(nums[pos]);
        webUrl = myView.findViewById(R.id.UrlTV);
        webUrl.setText(webs[pos]);

        final String strLoc = locs[pos];
        final String strNum = nums[pos];
        final String strURL = webs[pos];

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

        return myView;

    }


}