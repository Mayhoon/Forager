package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.config.CFG;

public class GameScreenGUI {
	Skin skin;
	Stage stage;
	TextButton button;
	
	public GameScreenGUI() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin = new Skin(Gdx.files.internal(CFG.FILE_SKIN_GUI));
		
		button = new TextButton("Dis a Button", skin, "default");
		button.setPosition(0,0);
		button.addListener(new ClickListener() {
			@Override 
			public void touchUp(InputEvent e, float x, float y, int pointer, int btn) {
					button.setText("YAY");
			}
		});
		
		Slider slider = new Slider(0, 30, 2, false, skin);
		slider.setPosition(50, 50);
		
		Dialog dialog = new Dialog("Dialog", skin);
		dialog.setPosition(50, 200);
		
		Window window = new Window("Window", skin);
		
		ProgressBar progressBar = new ProgressBar(0, 100, 2, false, skin);
		progressBar.setPosition(50, 300);
		
		stage.addActor(progressBar);
		stage.addActor(window);
		stage.addActor(dialog);
		stage.addActor(slider);
		stage.addActor(button);
	}
	
	public void create() {
		
	}
	
	public void render(SpriteBatch batch, float deltaTime) {
		stage.act(deltaTime);
		stage.draw();	
	}
	
	public Stage getStage() {
		return stage;
	}
}
