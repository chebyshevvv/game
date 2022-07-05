package com.chebyshev.game.physics;

public class Engine {

    final float p;
    final float f;

    public Engine(float p, float f) {
        this.p = p;
        this.f = f;
    }

    public float work(float v){
        float result;
        if (v == 0){
            result = f;
        }else {
            result = p / v;
            if (result > f){
                result = f;
            }
        }
        return result;
    }
}
