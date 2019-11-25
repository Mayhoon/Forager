package com.mygdx.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.mygdx.config.CFG;

public class GameData {
	FileHandle file;
	private Json json;
	private String data;
	private animationsList animations;
	
	public GameData() {
		animations = new animationsList();
		
		json = new Json();
		file = Gdx.files.local(CFG.PATH_ANIMATIONS + CFG.PATH_ANIMATIONS_WATER);
	}
	
	public void save() {
		data = json.toJson(animations);
		if(!file.exists()){
			Gdx.files.local(CFG.PATH_ANIMATIONS).file().mkdirs();
			file.writeString(data, false);
		}else {
			file.writeString(data, false);
		}
	}

	public void load() {
		data = json.toJson(animations);
		if(file.exists()){
			data = file.readString();
			
			animations = json.fromJson(animationsList.class, data);
			animations.create();
		}else {
			Gdx.files.local(CFG.PATH_ANIMATIONS).file().mkdirs();
		}
	}
	
	//Renders every reintroduced item in the list
	public void render(SpriteBatch batch){	
		animations.render(batch);
	}
	
	public void createAnimation(int x, int y){
			animations.addAnimation(x,y);
	}
}
