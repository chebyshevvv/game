package com.chebyshev.game.graphic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Sight {
    public final Batch batch;
    int x;
    int y;
    int width;
    int height;

    public Sight(Batch batch) {
        this.batch = batch;
        x = y = 0;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
