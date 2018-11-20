package com.example.android.recyclerimageexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder>{

    private int[] images;
    private Context context;


    public RecyclerAdapter(int[] images,Context context)
    {
        this.images= images;
        this.context = context;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout,parent,false);

        ImageViewHolder imageViewHolder = new ImageViewHolder(view,context,images);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

    int image_id = images[position];
    holder.Album.setImageResource(image_id);
    holder.AlbumTitle.setText("Image :" +position);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView Album;
        TextView AlbumTitle;
        Context context;
        int[] images;


        public ImageViewHolder(View itemView, Context context, int[] images) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
            itemView.setOnClickListener(this);
            this.context=context;
            this.images=images;

        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context,DisplayActivity.class);
            intent.putExtra("image id",images[getAdapterPosition()]);

            context.startActivity(intent);

        }
    }


}
