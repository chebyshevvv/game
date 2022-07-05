package com.chebyshev.game.physics;


public class DefaultBoost implements Boost{
    public int x;
    public int y;
    Velocity v;
    float m;
    Engine engine;
    float friction;

    public DefaultBoost(float m, int x, int y, Engine engine) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.engine = engine;
        friction = 50;
        v = new Velocity();
    }

    @Override
    public void boost(Direction direction) {
        if (Direction.UP.equals(direction)){
            v.stoppingX(friction / m);
            workUp();
        }else if (Direction.DOWN.equals(direction)){
            v.stoppingX(friction / m);
            workDown();
        }else if (Direction.LEFT.equals(direction)){
            v.stoppingY(friction / m);
            workLeft();
        }else if (Direction.RIGHT.equals(direction)){
            v.stoppingY(friction / m);
            workRight();
        }else {
            v.stoppingX(friction / m);
            v.stoppingY(friction / m);
        }
        x += v.x;
        y += v.y;
    }

    private void workUp(){
        float f = work(v.y,v.y > 0);
        v.accelerateY(Math.abs(f / m));
    }
    private void workDown(){
        float f = work(v.y,v.y < 0);
        v.accelerateY(-(f / m));
    }
    private void workRight(){
        float f = work(v.x,v.x > 0);
        v.accelerateX(Math.abs(f / m));
    }
    private void workLeft(){
        float f = work(v.x,v.x < 0);
        v.accelerateX(-(f / m));
    }
    private float work(float value,boolean isSameDirection){
        float force = engine.work(Math.abs(value));
        if (isSameDirection){
            force -= friction;
        }else {
            force += friction;
        }
        return force;
    }
}
