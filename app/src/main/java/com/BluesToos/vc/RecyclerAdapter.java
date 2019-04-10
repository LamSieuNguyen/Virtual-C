package com.BluesToos.vc;

import android.support.annotation.NonNull;
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

    private int[] images;
    private String[] names;

    public RecyclerAdapter(int[] images,String[] names) {
        this.images = images;
        this.names = names;
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