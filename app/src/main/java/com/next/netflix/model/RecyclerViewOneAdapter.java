package com.next.netflix.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.next.netflix.R;
import com.next.netflix.view.CommonAudioPlayerActivity;

import java.util.ArrayList;

public class RecyclerViewOneAdapter extends RecyclerView.Adapter<RecyclerViewOneAdapter.OneViewHolder> {

    private Context mContext;
    private ArrayList<MoviesOneDataClass> mMoviesOneArrayList;
    private String TAG = "recycler_view_one";

    public RecyclerViewOneAdapter(Context context, ArrayList<MoviesOneDataClass> moviesOneArrayList){
        this.mContext = context;
        this.mMoviesOneArrayList = moviesOneArrayList;
        Log.d(TAG, "RecyclerViewOneAdapter: ");
    }


    @NonNull
    @Override
    public OneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_one_item, parent, false);
        return new OneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneViewHolder holder, int position) {

        holder.movieOneTitleTextView.setText(mMoviesOneArrayList.get(position).getMovieOneTitle());
        Glide.with(mContext)
                .load(mMoviesOneArrayList.get(position).getMovieImageDrawable())
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        assert e != null;
                        Log.d(TAG, "onLoadFailed: "+e.toString());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d(TAG, "onResourceReady: ");
                        return false;
                    }
                }).into(holder.movieOneImageView);

        holder.movieOneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CommonAudioPlayerActivity.class);
                intent.putExtra("recycler_view_number", "0");
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMoviesOneArrayList.size();
    }

    public static class OneViewHolder extends RecyclerView.ViewHolder {

        public ImageView movieOneImageView;
        public TextView movieOneTitleTextView;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);

            movieOneImageView = itemView.findViewById(R.id.movie_image_view_one);
            movieOneTitleTextView = itemView.findViewById(R.id.movie_title_one);

        }


    }


}
