package com.badlogic.androidgames.framework;

public abstract class Screen {
    protected final Game game;

    /**
     *
     * @param game
     */
    public Screen(Game game) {
        this.game = game;
    }

    /**
     *
     * @param deltaTime
     */
    public abstract void update(float deltaTime);

    /**
     *
     * @param deltaTime
     */
    public abstract void present(float deltaTime);

    /**
     *
     */
    public abstract void pause();

    /**
     *
     */
    public abstract void resume();

    /**
     *
     */
    public abstract void dispose();
}
