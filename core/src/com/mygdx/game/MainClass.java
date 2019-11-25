package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.custommap.Map;
import com.mygdx.game.data.GameData;
import com.mygdx.game.gui.Gui;

public class MainClass extends ApplicationAdapter{
	public static SpriteBatch batch;	
	InputMultiplexer inputMultiplexer;
	private Camera camera;
	private float dt;
	
	private Map customMap;
	private GameData gameData;
	private Gui gui;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new Camera();	
		
		gui = new Gui();
		gameData = new GameData();	
		gameData.load();	
		customMap = new Map(gameData);

		//Input defined in different classes
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(new UserInput(camera, customMap, gameData));
		inputMultiplexer.addProcessor(gui.getGameScreen().getStage());
		Gdx.input.setInputProcessor(inputMultiplexer);
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(50f / 255f, 160f / 255f, 238f / 255f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		dt = Gdx.graphics.getDeltaTime();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			customMap.render(batch);
			gameData.render(batch);
			//gui.render(batch, dt);
		batch.end();
		
		camera.updateMovement(dt);
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
