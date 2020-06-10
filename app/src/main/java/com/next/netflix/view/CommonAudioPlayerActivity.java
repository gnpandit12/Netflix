package com.next.netflix.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.next.netflix.R;
import com.next.netflix.databinding.ActivityRecyclerViewOneBinding;

public class CommonAudioPlayerActivity extends AppCompatActivity {

    ActivityRecyclerViewOneBinding mRecyclerViewOneBinding;
    private ImageView mMovieImageView;
    private final static String TAG = "recycler_one";
    private MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerViewOneBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_one);
        mMovieImageView = mRecyclerViewOneBinding.lionKingImageView;

        Intent intent = getIntent();
        String number = intent.getStringExtra("recycler_view_number");
        if ("1".equals(number)){
            mMovieImageView.setImageDrawable(this.getResources().getDrawable(R.drawable.harray_potter_image));
            ring = MediaPlayer.create(CommonAudioPlayerActivity.this,R.raw.harry_potter_hedwigs);
        }else {
            ring = MediaPlayer.create(CommonAudioPlayerActivity.this,R.raw.lion_king_this_land);
        }

        playMusic();

        mMovieImageView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(CommonAudioPlayerActivity.this, MainActivity.class);
                startActivity(intent);
                ring.stop();
                overridePendingTransition(R.anim.enter, R.anim.exit);
                return true;
            }
        });

    }

    private void playMusic() {
        try{
            ring.start();
        }catch(Exception e) {
            e.printStackTrace();
            Log.d(TAG, "playMusicException: " + e);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            overridePendingTransition(R.anim.enter, R.anim.exit);
            ring.stop();
        }catch (Exception e){
            Log.d(TAG, "onPauseException: "+e);
        }

    }
}
