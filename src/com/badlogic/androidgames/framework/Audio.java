package com.badlogic.androidgames.framework;

/**
 * Created by IntelliJ IDEA. User: admin Date: 9/18/11 Time: 5:08 AM To change
 * this template use File | Settings | File Templates.
 */
public interface Audio {
    /**
     *
     * @param filename
     * @return
     */
    public Music newMusic(String filename);

    /**
     *
     * @param filename
     * @return
     */
    public Sound newSound(String filename);
}
