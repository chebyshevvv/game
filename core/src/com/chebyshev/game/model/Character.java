package com.chebyshev.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.chebyshev.game.physics.Boost;
import com.chebyshev.game.physics.DefaultBoost;
import com.chebyshev.game.physics.Direction;

public class Character {
    Boost boost;
    Direction direction;
    Rectangle rectangle;

    public Character() {
        rectangle = new Rectangle(100,100,16,32);
        boost = new DefaultBoost(1000, rectangle.x, rectangle.y);
    }
    public void collide(float force){
        boost.boost(direction,force);
    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public Rectangle getRectangle() {
        return rectangle;
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
}
