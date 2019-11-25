package com.mygdx.game.buildings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.config.CFG;

public class AnimatedWater {
	private transient Texture img;
	private transient TextureRegion[] animationFrames;
	public transient Animation<TextureRegion> animation;
	transient float elapsedTime = 0;
	int x = 0, y = 0;
	
	public void create() {
		img = new Texture(CFG.FILE_ANIMATIONS_WATER);
		TextureRegion[][] tmpFrames = TextureRegion.split(img, 128, 128);
		
		animationFrames  = new TextureRegion[8];
		int index = 0;
		
		for(int i=0; i<8; i++) {
			for(int j = 0; j < 1; j++) {
				animationFrames[index++] = tmpFrames[j][i];
			}
		}
		animation = new Animation<TextureRegion>(1f/5f, animationFrames);
	}
	
	public void create(int x, int y) {
		this.x = x;
		this.y = y;
		img = new Texture(CFG.FILE_ANIMATIONS_WATER);
		TextureRegion[][] tmpFrames = TextureRegion.split(img, 128, 128);
		
		animationFrames  = new TextureRegion[8];
		int index = 0;
		
		for(int i=0; i<8; i++) {
			for(int j = 0; j < 1; j++) {
				animationFrames[index++] = tmpFrames[j][i];
			}
		}
		animation = new Animation<TextureRegion>(1f/5f, animationFrames);
	}
	
	public void render(SpriteBatch batch) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime,true),x,y);
	}
}
