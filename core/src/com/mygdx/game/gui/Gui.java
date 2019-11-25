package com.mygdx.game.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Gui {
		Skin skin;
		Stage stage;
		GameScreenGUI gamescreen;
		
		public Gui() {
			gamescreen = new GameScreenGUI();
		}
		
		public void create() {
			
			
			/*
			skin = new Skin(Gdx.files.internal("uiskin.json"));
			//stage = new Stage(new ScreenViewport());
			*/
			
		}
		
		public void render(SpriteBatch batch, float deltaTime) {
			gamescreen.render(batch, deltaTime);
			
			/*
			System.out.println("TEST");
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			stage.act(deltaTime);
			stage.draw();*/
		}
		
		public GameScreenGUI getGameScreen (){
			return gamescreen;
		}
} 
