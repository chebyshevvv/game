package com.chebyshev.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.chebyshev.game.physics.DefaultBoost;
import com.chebyshev.game.physics.Direction;
import com.chebyshev.game.physics.Engine;

public class Player {
    DefaultBoost boost;
    Direction direction;
    Engine engine;
    Rectangle rectangle;
    private static final Player player = new Player();

    private Player() {
        rectangle = new Rectangle(0,0,16,32);
        boost = new DefaultBoost(100, rectangle.x, rectangle.y);
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
        boost.boost(direction,f);
        rectangle.x = boost.x;
        rectangle.y = boost.y;
    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public float getX(){
        return rectangle.x;
    }
    public float getY(){
        return rectangle.y;
    }
    public float getWidth(){
        return rectangle.width;
    }
    public float getHeight(){
        return rectangle.height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
