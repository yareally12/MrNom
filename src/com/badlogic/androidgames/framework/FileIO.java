package com.badlogic.androidgames.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileIO {

    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public InputStream readAsset(String fileName) throws IOException;

    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public InputStream readFile(String fileName) throws IOException;

    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public OutputStream writeFile(String fileName) throws IOException;
}
