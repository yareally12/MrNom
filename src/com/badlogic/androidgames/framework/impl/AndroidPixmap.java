package com.badlogic.androidgames.framework.impl;

import android.graphics.Bitmap;
import com.badlogic.androidgames.framework.Graphics.PixmapFormat;
import com.badlogic.androidgames.framework.Pixmap;

public class AndroidPixmap implements Pixmap
{
    Bitmap       bitmap;
    PixmapFormat format;

    public AndroidPixmap(Bitmap bitmap, PixmapFormat format)
    {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth()
    {
        return this.bitmap.getWidth();
    }

    @Override
    public int getHeight()
    {
        return this.bitmap.getHeight();
    }

    @Override
    public PixmapFormat getFormat()
    {
        return this.format;
    }

    @Override
    public void dispose()
    {
        this.bitmap.recycle();
    }
}