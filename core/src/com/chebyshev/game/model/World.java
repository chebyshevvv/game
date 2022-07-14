package com.chebyshev.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.chebyshev.game.physics.Direction;

public class World {
    float width;
    float height;
    Player player;
    Character character;

    public World(float width, float height) {
        this.width = width;
        this.height = height;
        this.player = Player.getInstance();
        character = Character.instance;
    }
    public void checkCollision(){
        Rectangle playerRectangle = player.getRectangle();
        Rectangle characterRectangle = character.getRectangle();
        boolean isCollision = playerRectangle.contains(characterRectangle.x,characterRectangle.y);
        System.out.println(isCollision);
        if (isCollision){
            character.setDirection(player.direction);
            character.boost.v = player.boost.v;
            character.collide(0);
        }
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
