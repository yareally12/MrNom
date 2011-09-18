package com.badlogic.androidgames.framework;

/**
 * Created by IntelliJ IDEA. User: admin Date: 9/18/11 Time: 5:02 AM To change
 * this template use File | Settings | File Templates.
 */
public interface Game {

    /**
     *
     * @return
     */
    public Input getInput();

    /**
     * @return
     */
    public FileIO getFileIO();

    /**
     * @return
     */
    public Graphics getGraphics();

    /**
     * @return
     */
    public Audio getAudio();

    /**
     * @param screen
     */
    public void setScreen(Screen screen);

    /**
     *
     * @return
     */
    public Screen getCurrentScreen();

    /**
     *
     * @return
     */
    public Screen getStartScreen();
}
