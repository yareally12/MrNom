package com.badlogic.androidgames.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: admin Date: 9/18/11 Time: 5:53 AM To change
 * this template use File | Settings | File Templates.
 */
public class Pool<T>
{
    /**
     *
     * @param <T>
     */
    public interface PoolObjectFactory<T>
    {
        public T createObject();
    }

    private final List<T>              freeObjects;
    private final PoolObjectFactory<T> factory;
    private final int                  maxSize;

    /**
     *
     * @param factory
     * @param maxSize
     */
    public Pool(PoolObjectFactory<T> factory, int maxSize)
    {
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }

    /**
     *
     * @return
     */
    public T newObject()
    {
        T object = null;

        if (this.freeObjects.size() == 0) {
            object = this.factory.createObject();
        }
        else {
            object = this.freeObjects.remove(this.freeObjects.size() - 1);
        }

        return object;
    }

    /**
     *
     * @param object
     */
    public void free(T object)
    {
        if (this.freeObjects.size() < this.maxSize) {
            this.freeObjects.add(object);
        }
    }
}
