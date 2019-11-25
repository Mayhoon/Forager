package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.config.CFG;
import com.mygdx.game.custommap.MapLoader;
import com.mygdx.game.custommap.Map;
import com.mygdx.game.data.GameData;

public class UserInput implements InputProcessor{
	Camera camera;
	Map map;
	GameData gameData;
		
	public UserInput(Camera camera, Map map, GameData gameData) {
		this.gameData = gameData;
		this.camera = camera;
		this.map = map;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.W: camera.moveUp(true);break;
		case Keys.S: camera.moveDown(true);break;
		case Keys.A: camera.moveLeft(true);break;
		case Keys.D: camera.moveRight(true);break;
		case Keys.ESCAPE: 
			MapLoader.saveMap(CFG.NAME_MAP, map.map);
			System.out.println("SHOULD NOW SAVE: " + CFG.NAME_MAP);
			gameData.save();
			Gdx.app.exit();
		}
		return false;	
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
			case Keys.W: camera.moveUp(false);break;
			case Keys.S: camera.moveDown(false);break;
			case Keys.A: camera.moveLeft(false);break;
			case Keys.D: camera.moveRight(false);break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector3 worldCoordinates = camera.unproject(new Vector3(screenX, screenY, 0));
		System.out.println("TILE YOU CLOICKED ON: "+map.getTileTypeByLocation(0, (int)worldCoordinates.x, (int)worldCoordinates.y));
		map.placeTile(0, (int)worldCoordinates.x, (int)worldCoordinates.y);
		return false;   
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}	
}
