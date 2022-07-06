package com.chebyshev.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chebyshev.game.stage.CameraStage;
import com.chebyshev.game.stage.WorldStage;

public class MyGdxGame implements ApplicationListener {
	SpriteBatch batch;
	WorldStage worldStage;
	CameraStage cameraStage;

	@Override
	public void create () {
		batch = new SpriteBatch();
		worldStage = new WorldStage(batch);
		cameraStage = new CameraStage(batch);
		Gdx.input.setInputProcessor(worldStage);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		cameraStage.draw();
		worldStage.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		cameraStage.resize(width,height);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
