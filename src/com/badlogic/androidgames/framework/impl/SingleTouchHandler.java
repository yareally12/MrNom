package com.badlogic.androidgames.framework.impl;

import android.view.MotionEvent;
import android.view.View;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Pool;
import com.badlogic.androidgames.framework.Pool.PoolObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class SingleTouchHandler implements TouchHandler
{
    boolean          isTouched;
    int              touchX;
    int              touchY;
    Pool<TouchEvent> touchEventPool;
    List<TouchEvent> touchEvents       = new ArrayList<TouchEvent>();
    List<TouchEvent> touchEventsBuffer = new ArrayList<TouchEvent>();
    float scaleX;
    float scaleY;

    /**
     *
     * @param view
     * @param scaleX
     * @param scaleY
     */
    public SingleTouchHandler(View view, float scaleX, float scaleY)
    {
        PoolObjectFactory<TouchEvent> factory = new PoolObjectFactory<TouchEvent>()
        {
            @Override
            public TouchEvent createObject()
            {
                return new TouchEvent();
            }
        };
        
        this.touchEventPool = new Pool<TouchEvent>(factory, 100);
        view.setOnTouchListener(this);

        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    /**
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        synchronized (this) {
            TouchEvent touchEvent = this.touchEventPool.newObject();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchEvent.type = TouchEvent.TOUCH_DOWN;
                    this.isTouched = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    touchEvent.type = TouchEvent.TOUCH_DRAGGED;
                    this.isTouched = true;
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    touchEvent.type = TouchEvent.TOUCH_UP;
                    this.isTouched = false;
                    break;
            }

            touchEvent.x = this.touchX = (int) (event.getX() * this.scaleX);
            touchEvent.y = this.touchY = (int) (event.getY() * this.scaleY);
            this.touchEventsBuffer.add(touchEvent);

            return true;
        }
    }

    /**
     *
     * @param pointer
     * @return
     */
    @Override
    public boolean isTouchDown(int pointer)
    {
        synchronized (this) {
            if (pointer == 0) {
                return this.isTouched;
            }
            else {
                return false;
            }
        }
    }

    /**
     *
     * @param pointer
     * @return
     */
    @Override
    public int getTouchX(int pointer)
    {
        synchronized (this) {
            return this.touchX;
        }
    }

    /**
     *
     * @param pointer
     * @return
     */
    @Override
    public int getTouchY(int pointer)
    {
        synchronized (this) {
            return this.touchY;
        }
    }

    /**
     * 
     * @return
     */
    @Override
    public List<TouchEvent> getTouchEvents()
    {
        synchronized (this) {
            int len = this.touchEvents.size();
            for (int i = 0; i < len; i++) {
                this.touchEventPool.free(this.touchEvents.get(i));
            }
            this.touchEvents.clear();
            this.touchEvents.addAll(this.touchEventsBuffer);
            this.touchEventsBuffer.clear();
            return this.touchEvents;
        }
    }
}