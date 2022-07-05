package com.chebyshev.game.stage;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.chebyshev.game.controller.PlayerController;

import java.util.Stack;

public class CameraStage extends InputAdapter {
    OrthographicCamera camera;
    PlayerController playerController;
    Batch batch;
    Stack<Integer> keyCodesStack = new Stack<>();

    public CameraStage(Batch batch) {
        camera = new OrthographicCamera();
        this.batch = batch;
        this.playerController = new PlayerController();
        camera.position.x = playerController.getX();
        camera.position.y = playerController.getY();
        camera.zoom = 1;
        camera.update();
    }

    public void draw(){
        camera.position.x = playerController.getX();
        camera.position.y = playerController.getY();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }
    public void resize(int width, int height){
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }
}
