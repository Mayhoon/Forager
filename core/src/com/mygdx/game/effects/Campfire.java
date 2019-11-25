package com.mygdx.game.effects;

import java.io.Serializable;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Campfire implements Serializable{

	float x,y;
	private transient ParticleEffect effect;
	private transient TextureAtlas atlas;
	private transient Texture img;
	private int id;
	
	public Campfire() {	
		atlas = new TextureAtlas();
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal("fire2.p"), Gdx.files.internal(""));
		effect.scaleEffect(0.1f);
		effect.start();
		
		this.x = Gdx.graphics.getWidth()/2;
		this.y = Gdx.graphics.getHeight()/2;
		effect.setPosition(x, y);
		
		img = new Texture("campfire.png");
	}
	
	public void render(SpriteBatch batch) {
		/*effect.draw(batch,Gdx.graphics.getDeltaTime());
		if(effect.isComplete()) {
			System.out.println("Reset");
			effect.reset();
			effect.scaleEffect(0.1f);
		}*/
		batch.draw(img, 200,200, 2000,2000);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
