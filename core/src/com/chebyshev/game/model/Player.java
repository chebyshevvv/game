package com.chebyshev.game.model;

import com.chebyshev.game.physics.DefaultBoost;
import com.chebyshev.game.physics.Direction;
import com.chebyshev.game.physics.Engine;

import java.util.Objects;

public class Player {
    DefaultBoost boost;
    Direction direction;
    Engine engine;
    int width = 32;
    int height = 16;
    private static final Player player = new Player();

    private Player() {
        boost = new DefaultBoost(100, 0, 0);
        engine = new Engine(600,300);
    }
    public static Player getInstance(){
        return player;
    }
    public void boost(){
        float f = 0L;
        if (Direction.UP.equals(direction) || Direction.DOWN.equals(direction)){
            f = engine.work(boost.v.y);
        }else if (Direction.LEFT.equals(direction) || Direction.RIGHT.equals(direction)){
            f = engine.work(boost.v.x);
        }
        boost.boost(direction,Math.abs(f));
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
