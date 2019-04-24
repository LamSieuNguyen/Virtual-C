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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class meet_team extends Fragment {

    View myView;
    ListView myListView;
    View mynewView;

    private int[] images = {R.drawable.alyssa, R.drawable.amy,
            R.drawable.bonnie,R.drawable.brenda, R.drawable.whitebackground, R.drawable.colin,
            R.drawable.whitebackground,R.drawable.debs,R.drawable.heidi,R.drawable.iona,R.drawable.jen,
            R.drawable.karla,R.drawable.leeann,R.drawable.loretta,R.drawable.lori,R.drawable.michelle,
            R.drawable.patrice,R.drawable.rachel,R.drawable.teresa};

    private String[] name = {"Alyssa", "Amy", "Bonnie", "Brenda", "Christine", "Colin", "Deb J.", "Deb S.", " Heidi", "Iona"
            ,"Jen", "Karla", "Leeann", "Loretta", " Lori", "Michelle", "Patrice", "Rachel", "Teresa"};

    private String[] titles = {"Volunteer and Operations Manager", "Development Director", "Ronald McDonald Family Room Assistant Manager",
            "Relief Manager", "Relief Manager", "Resident and Facilities Manager", "Housekeeper","Office Manager","Ronald McDonald Family Room Manager",
            "Housekeeper", "Relief Manager", "Executive Director", "Relief Manager", "Relief Manager", "Administrative Assistant for Development",
            "Relief Manager", "Operations Director", "Marketing and Communications Manager", "Relief Manager"};




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        myView = inflater.inflate(R.layout.meet_team, container, false);

        CustomAdapter customAdapter = new CustomAdapter();
        myListView =  myView.findViewById(R.id.Teamlist);
        myListView.setAdapter(customAdapter);
        return myView;

    }
    class CustomAdapter extends BaseAdapter{
        @Override

        public int getCount()
        {
            return images.length;
        }
        @Override
        public Object getItem(int position)
        {
            return null;
        }
        @Override
        public long getItemId(int position)
        {
            return 0;
        }
        public View getView(int position, View concertView, ViewGroup parent)
        {
            View view = getLayoutInflater().inflate(R.layout.list_image,null);
            ImageView myImageView = (ImageView) view.findViewById(R.id.TeamPic);
            TextView myTextView = (TextView) view.findViewById(R.id.Teamnames);
            TextView myTextView2 = (TextView) view.findViewById(R.id.Disc);

            myImageView.setImageResource(images[position]);
            myTextView.setText(name[position]);
            myTextView2.setText(titles[position]);

            return view;
        }

    }

}
