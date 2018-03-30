package com.example.haifa.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plyBtn;
    SeekBar positionBar;
    SeekBar volumeBar;
    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;
    MediaPlayer MP;
    int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plyBtn = ( Button) findViewById(R.id.playBtn);
        elapsedTimeLabel= (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);

        //Media Player
        MP = MediaPlayer.create(this, R.raw.fireflies);
        MP.setLooping(true);
        MP.seekTo(0);
        MP.setVolume(0.5f,0.5f);
        totalTime = MP.getDuration();

        //Postion Bar
        positionBar = (SeekBar) findViewById(R.id.volumeBar);
        positionBar.setMax(totalTime);

        //volume Bar
        volumeBar = (SeekBar) findViewById(R.id.volumeBar);


    }

    public void playBtnClick (View view){

        if (!MP.isPlaying()){
            //stopping
            MP.start();
            plyBtn.setBackgroundResource(R.drawable.stop);
        } else {
            //playing
            MP.pause();
            plyBtn.setBackgroundResource(R.drawable.play);
        }
    }
}
















