package com.chebyshev.game.model;

import com.chebyshev.game.physics.DefaultBoost;
import com.chebyshev.game.physics.Direction;
import com.chebyshev.game.physics.Engine;

import java.util.Objects;

public class Player {
    DefaultBoost boost;
    Direction direction;
    int width = 32;
    int height = 16;
    private static Player player = new Player();

    private Player() {
        boost = new DefaultBoost(100, 0, 0,new Engine(600,300));
    }
    public static Player getInstance(){
        return player;
    }
    public void boost(){
        boost.boost(direction);
    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public int getX(){
        return boost.x;
    }
    public int getY(){
        return boost.y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
