package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.videoView)
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
        , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()
        + "/" + R.raw.video));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
    }
}
