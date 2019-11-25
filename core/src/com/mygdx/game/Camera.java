package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera extends OrthographicCamera{
	private boolean moveUp,moveDown,moveLeft,moveRigth;
	private int speed = 20;
	
	public Camera() {
		this.setToOrtho(false, Gdx.graphics.getWidth()*2, Gdx.graphics.getHeight()*2);
		this.update();
		
		this.position.x  = 128;
		this.position.y = 128;
	}
	
	public void updateMovement(float dt) {
		if(moveUp) {
			this.translate(0f,(1f*speed));
		}else if(moveDown) {
			this.translate(0f,(-1f*speed));
		}else if(moveLeft) {
			this.translate((-1f*speed),0f);
		}else if(moveRigth) {
			this.translate((1f*speed),0f);
		}
		this.update();	
	}
	
	public void moveUp (boolean move){moveUp = move;}
	public void moveDown (boolean move){moveDown = move;}
	public void moveLeft (boolean move){moveLeft = move;}
	public void moveRight (boolean move){moveRigth = move;}	
}
