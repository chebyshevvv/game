package com.chebyshev.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerView implements View{
    Animation<TextureRegion> animation;
    Texture texture;
    float stateTime;
    int x;
    int y;

    public PlayerView() {
        texture = new Texture("NPC.png");
        TextureRegion[][] textureRegions = TextureRegion.split(texture,texture.getWidth() / 3, texture.getHeight() / 3);
        TextureRegion[] regions = new TextureRegion[9];
        int index = 0;
        for (int i = 0; i < textureRegions.length; i++) {
            for (int j = 0; j < textureRegions[i].length; j++) {
                regions[index++] = textureRegions[i][j];
            }
        }
        animation = new Animation<>(0.1f,regions);
        stateTime = 0f;
    }

    @Override
    public void draw(Batch batch) {
        TextureRegion frame = animation.getKeyFrame(stateTime, true);
        batch.draw(frame,x,y);
    }
    public void animate(){
        stateTime += Gdx.graphics.getDeltaTime();
    }
    public void setLocation(int x,int y){
        this.x = x;
        this.y = y;
    }
}
