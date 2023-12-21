package com.projekt.foszk.starwarsoffline;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

    ///////////////////////////////////////////////////////////////////////////////
    // Service for operating background music.
    // So the music is continuous and the program doesn't drop out.

public class MpService extends Service {

    MediaPlayer myPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        myPlayer = MediaPlayer.create(this,R.raw.theme_song_low);
        myPlayer.setLooping(true);
        myPlayer.setVolume(0.2f, 0.2f);
    }
    @Override
    public void onStart(Intent intent, int startid) {
        myPlayer.start();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped and Music Stopped", Toast.LENGTH_LONG).show();
        myPlayer.stop();
    }
}
