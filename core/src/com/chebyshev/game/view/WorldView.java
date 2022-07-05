package com.chebyshev.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class WorldView implements View{
    Texture texture;

    public WorldView() {
        texture = new Texture("w.jpg");
    }
    @Override
    public void draw(Batch batch){
        batch.draw(texture,0,0);
    }
}
