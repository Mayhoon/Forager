package com.mygdx.game.data;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.buildings.AnimatedWater;

public class animationsList {
	public ArrayList<AnimatedWater> waterAnimations;
	
	public animationsList() {
		waterAnimations = new ArrayList<AnimatedWater>();
	}
	
	public void create() {
		for(int i = 0; i < waterAnimations.size(); i++) {
			waterAnimations.get(i).create();
		}
	}
	
	//Dynamische Erstellung von Aniamtionen 
	public void addAnimation(int x, int y) {
		waterAnimations.add(new AnimatedWater());
		waterAnimations.get(waterAnimations.size()-1).create(x,y);
	}
	
	public void render(SpriteBatch batch) {
		for(int i = 0; i < waterAnimations.size(); i++) {
			waterAnimations.get(i).render(batch);
		}
	}
}
