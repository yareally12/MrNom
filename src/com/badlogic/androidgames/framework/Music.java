package com.badlogic.androidgames.framework;

/**
 * Created by IntelliJ IDEA. User: admin Date: 9/18/11 Time: 5:07 AM To change
 * this template use File | Settings | File Templates.
 */
public interface Music {

    /**
     *
     */
    public void play();

    /**
     *
     */
    public void stop();

    /**
     *
     */
    public void pause();

    /**
     *
     * @param looping
     */
    public void setLooping(boolean looping);

    /**
     *
     * @param volume
     */
    public void setVolume(float volume);

    /**
     *
     * @return
     */
    public boolean isPlaying();

    /**
     *
     * @return
     */
    public boolean isStopped();

    /**
     *
     * @return
     */
    public boolean isLooping();

    /**
     *
     */
    public void dispose();
}