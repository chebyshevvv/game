package com.chebyshev.game.physics;

public class Velocity {
    public float x;
    public float y;

    public Velocity(){
        x = 0;
        y = 0;
    }

    public Velocity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void accelerateX(float a){
        x += a;
    }

    public void accelerateY(float a){
        y += a;
    }

    public void stoppingX(float a){
        x = stopping(x, a);
    }
    public void stoppingY(float a){
        y = stopping(y, a);
    }
    private float stopping(float xOrY,float a){
        float result;
        if (xOrY == 0){
            result = xOrY;
        }else {
            if (Math.abs(xOrY) > a){
                if (xOrY > 0){
                    result = xOrY - a;
                }else {
                    result = xOrY + a;
                }
            }else {
                result = 0;
            }
        }
        return result;
    }
}
