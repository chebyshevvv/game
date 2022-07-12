package com.chebyshev.game.model;

public class World {
    float width;
    float height;
    Player player;
    Character character;

    public World(float width, float height) {
        this.width = width;
        this.height = height;
        this.player = Player.getInstance();
        character = new Character();
    }
    public void checkCollision(){

    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }
}
