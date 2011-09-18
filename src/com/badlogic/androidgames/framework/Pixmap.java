package com.badlogic.androidgames.framework;

/**
 * Created by IntelliJ IDEA. User: admin Date: 9/18/11 Time: 5:03 AM To change
 * this template use File | Settings | File Templates.
 */

import com.badlogic.androidgames.framework.Graphics.PixmapFormat;

public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dispose();
}