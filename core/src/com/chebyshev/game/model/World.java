package com.chebyshev.game.model;

public class World {
    int width;
    int height;
    Player player;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = Player.getInstance();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }
}
