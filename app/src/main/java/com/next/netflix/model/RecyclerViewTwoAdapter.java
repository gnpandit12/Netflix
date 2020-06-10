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

public class RecyclerViewTwoAdapter extends RecyclerView.Adapter<RecyclerViewTwoAdapter.TwoViewHolder> {

    private Context mContext;
    private ArrayList<MovieTwoDataClass> mMovieTwoDataClassArrayList;
    private static String TAG = "two_adapter";

    public RecyclerViewTwoAdapter(Context context, ArrayList<MovieTwoDataClass> movieTwoDataClassArrayList){
        this.mContext = context;
        this.mMovieTwoDataClassArrayList = movieTwoDataClassArrayList;
        Log.d(TAG, "RecyclerViewTwoAdapter: ");
    }

    @NonNull
    @Override
    public TwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_two_item, parent, false);
        return new TwoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TwoViewHolder holder, int position) {

        Glide.with(mContext)
                .load(mMovieTwoDataClassArrayList.get(position).getmMovieTwoImage())
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.d(TAG, "onLoadFailed: "+e);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d(TAG, "onResourceReady: ");
                        return false;
                    }
                }).into(holder.mMovieImageView);

        holder.mMovieTitleTextView.setText(
                mMovieTwoDataClassArrayList.get(position).getmMovieTitle()
        );

        holder.mMovieImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CommonAudioPlayerActivity.class);
                intent.putExtra("recycler_view_number", "1");
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovieTwoDataClassArrayList.size();
    }

    public static class TwoViewHolder extends RecyclerView.ViewHolder {

        public ImageView mMovieImageView;
        public TextView mMovieTitleTextView;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);

            mMovieImageView = itemView.findViewById(R.id.movie_image_view_two);
            mMovieTitleTextView = itemView.findViewById(R.id.movie_title_two);

        }
    }

}
