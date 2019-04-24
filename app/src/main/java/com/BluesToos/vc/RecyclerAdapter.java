package com.BluesToos.vc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private int[] images;
    private String[] names;
    private String[] locs;
    private String[] webs;
    private String[] nums;
    private String[] as;
    public View myView;
    public Context mContext;

    private static int type;





    public RecyclerAdapter(int[] images, String[] names, String[] locs, String[] webs, String[] nums, Context context) {
        type = 1;
        this.images = images;
        this.names = names;
        this.locs = locs;
        this.webs = webs;
        this.nums = nums;
        mContext =context;
    }

    public RecyclerAdapter(int[] images, String[] names, Context context) {
        type = 2;
        this.images = images;
        this.names = names;
        mContext =context;
    }

    public RecyclerAdapter(int[] images, String[] names, String[] as, Context context){
        type = 3;
        this.images = images;
        this.names = names;
        this.as = as;
        mContext = context;
    }

    public int getItemViewType(int type){
        return type;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (type == 1) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ImageViewHolder(view);

        }
        if(type == 2) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
            return new ImageViewHolder(view);
        }
        else{

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3, parent, false);
            return new ImageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
        switch(type) {
            case 1:
            int image_id = images[position];

            holder.Album.setImageResource(image_id);
            holder.AlbumTitle.setText(names[position]);
            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //start new activity
                    //Intent mapIntent = new Intent(this, guideActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putIntArray("images", images);
                    bundle.putStringArray("names", names);
                    bundle.putStringArray("locs", locs);
                    bundle.putStringArray("webs", webs);
                    bundle.putStringArray("nums", nums);
                    bundle.putInt("pos", position);




                    guideActivity sendto = new guideActivity();
                    sendto.setArguments(bundle);




                    FragmentManager manager = ((MainActivity) mContext).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_frame, sendto).commit();


                }

            });
            break;
            case 2:

                int image_id2 = images[position];
                holder.Album.setImageResource(image_id2);
                holder.AlbumTitle.setText(names[position]);
                break;
            case 3:

                int image_id3 = images[0];
                holder.Album.setImageResource(image_id3);
                holder.AlbumTitle.setText(names[position]);
                holder.Ans.setText(as[position]);
                break;
        }


    }



    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView Album;
        TextView AlbumTitle;
        TextView Ans;
        public LinearLayout ll;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
            Ans = itemView.findViewById(R.id.ans);
            ll = itemView.findViewById(R.id.neighborhoodLayout);

        }
    }





}

