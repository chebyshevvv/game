package com.chebyshev.game.physics;


public class DefaultBoost implements Boost{
    public int x;
    public int y;
    public Velocity v;
    float m;
    float friction;

    public DefaultBoost(float m, int x, int y) {
        this.x = x;
        this.y = y;
        this.m = m;
        friction = 50;
        v = new Velocity();
    }

    @Override
    public void boost(Direction direction,float force) {
        if (Direction.UP.equals(direction)){
            v.stoppingX(friction / m);
            workUp(force);
        }else if (Direction.DOWN.equals(direction)){
            v.stoppingX(friction / m);
            workDown(force);
        }else if (Direction.LEFT.equals(direction)){
            v.stoppingY(friction / m);
            workLeft(force);
        }else if (Direction.RIGHT.equals(direction)){
            v.stoppingY(friction / m);
            workRight(force);
        }else {
            v.stoppingX(friction / m);
            v.stoppingY(friction / m);
        }
        x += v.x;
        y += v.y;
    }

    private void workUp(float force){
        float f = work(force,v.y > 0);
        v.accelerateY(Math.abs(f / m));
    }
    private void workDown(float force){
        float f = work(force,v.y < 0);
        v.accelerateY(-(f / m));
    }
    private void workRight(float force){
        float f = work(force,v.x > 0);
        v.accelerateX(Math.abs(f / m));
    }
    private void workLeft(float force){
        float f = work(force,v.x < 0);
        v.accelerateX(-(f / m));
    }
    private float work(float force,boolean isSameDirection){
        return isSameDirection ? force - friction : force + friction;
    }
}
