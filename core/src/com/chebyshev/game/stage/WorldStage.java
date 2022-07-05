package com.chebyshev.game.stage;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.chebyshev.game.controller.PlayerController;
import com.chebyshev.game.controller.WorldController;
import com.chebyshev.game.view.View;

import java.util.Stack;

public class WorldStage extends InputAdapter {
    WorldController worldController;
    PlayerController playerController;
    Batch batch;
    Stack<Integer> keyCodesStack = new Stack<>();

    public WorldStage(Batch batch) {
        this.batch = batch;
        worldController = new WorldController();
        playerController = new PlayerController();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (isInstruction(keycode)){
            keyCodesStack.push(keycode);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (isInstruction(keycode)){
            int index = keyCodesStack.indexOf(keycode);
            if (index != -1){
                keyCodesStack.remove(index);
            }
        }
        return true;
    }
    private void process(){
        if (keyCodesStack.empty()){
            playerController.waite();
        }else {
            switch (keyCodesStack.peek()){
                case Input.Keys.UP: playerController.up();break;
                case Input.Keys.DOWN: playerController.down();break;
                case Input.Keys.LEFT: playerController.left();break;
                case Input.Keys.RIGHT: playerController.right();break;
                default: break;
            }
        }
    }
    private boolean isInstruction(int keyCode){
        return keyCode == Input.Keys.UP ||
                keyCode == Input.Keys.DOWN ||
                keyCode == Input.Keys.LEFT ||
                keyCode == Input.Keys.RIGHT;
    }

    public void draw(){
        process();
        View view = worldController.refresh();
        view.draw(batch);
    }
}
