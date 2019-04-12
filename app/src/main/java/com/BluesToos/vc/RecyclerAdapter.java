package com.BluesToos.vc;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.Toast;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private int[] images;
    private String[] names;
    private String[] locs;
    private String[] webs;
    private String[] nums;
    public View myView;
    public Context mContext;

    public RecyclerAdapter(int[] images, String[] names, String[] locs, String[] webs, String[] nums, Context context) {
        this.images = images;
        this.names = names;
        this.locs = locs;
        this.webs = webs;
        this.nums = nums;
        mContext =context;

    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
        int image_id = images[position];
        holder.Album.setImageResource(image_id);
        holder.AlbumTitle.setText(names[position]);
        holder.ll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("TAG?", "THIS WORKED YAYYYYYYYYYYYYYYYYYY");
                //start new activity
                //Intent mapIntent = new Intent(this, guideActivity.class);
                Log.d("run", "crashed");
                Bundle bundle = new Bundle();
                bundle.putIntArray("images",images);
                bundle.putStringArray("names",names);
                bundle.putStringArray("locs",locs);
                bundle.putStringArray("webs",webs);
                bundle.putStringArray("nums",nums);
                bundle.putInt("pos",position);

                Log.d(TAG, "Bundle: " + bundle);


                guideActivity sendto = new guideActivity();
                sendto.setArguments(bundle);


                Log.d(TAG, "ST: " + sendto.toString());

                FragmentManager manager = ((MainActivity)mContext).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame,sendto).commit();




            }

        });


    }



    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView Album;
        TextView AlbumTitle;
        public LinearLayout ll;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
            ll = itemView.findViewById(R.id.neighborhoodLayout);

        }
    }




}

