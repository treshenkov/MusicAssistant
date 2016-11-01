package com.koalostudio.treshenkov.ru.musicassistant;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
    }

    public void Start(View view) throws IOException {
        Switch rainSwitch = (Switch) findViewById(R.id.rainSwitch);
        if (rainSwitch != null){
            if (rainSwitch.isChecked()){
                mediaPlayer = MediaPlayer.create(this,R.raw.rain);
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.start();
            } else {
                if (mediaPlayer != null)
                    mediaPlayer.stop();
            }
        }
    }
}
