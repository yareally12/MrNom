package com.badlogic.androidgames.framework.impl;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import com.badlogic.androidgames.framework.Audio;
import com.badlogic.androidgames.framework.Music;
import com.badlogic.androidgames.framework.Sound;

import java.io.IOException;

public class AndroidAudio implements Audio
{
    AssetManager assets;
    SoundPool    soundPool;

    /**
     *
     * @param activity
     */
    public AndroidAudio(Activity activity)
    {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    /**
     *
     * @param filename
     * @return
     */
    @Override
    public Music newMusic(String filename)
    {
        try {
            AssetFileDescriptor assetDescriptor = this.assets.openFd(filename);
            return new AndroidMusic(assetDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load music '" + filename +
                    "'");
        }
    }

    /**
     *
     * @param filename
     * @return
     */
    @Override
    public Sound newSound(String filename)
    {
        try {
            AssetFileDescriptor assetDescriptor = this.assets.openFd(filename);
            int soundId = this.soundPool.load(assetDescriptor, 0);
            return new AndroidSound(this.soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }
}