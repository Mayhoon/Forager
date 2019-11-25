package com.mygdx.game.custommap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.config.CFG;
import com.mygdx.game.data.GameData;

public class Map {

	String id, name;
	public int [][][] map;
	private TextureRegion[][] tiles;
	
	public Map(GameData animations) {

		MapData data = MapLoader.loadMap(CFG.NAME_MAP, animations);
		this.id = data.id;
		this.name = data.name;
		this.map = data.map;

		tiles = TextureRegion.split(new Texture(Gdx.files.internal(CFG.PATH_TILESET_MAP)), CFG.TILE_SIZE, CFG.TILE_SIZE);	
	}

	//RENDER
	public void render(SpriteBatch batch) {	
		for (int layer = 0; layer < getLayers(); layer++) {
			for (int row = 0; row < getHeight(); row++) {
				for (int col = 0; col < getWidth(); col++) {
					Tiles type = this.getTileTypeByCoordinate(layer, col, row);
					if (type != null)
						batch.draw(tiles[0][type.getId() - 1], col * CFG.TILE_SIZE, row * CFG.TILE_SIZE);
				}
			}
		}
	}
	
	//(Re)places tile at given position
	public void placeTile(int layer, int x, int y) {
		int row = x/CFG.TILE_SIZE;
		int col = getHeight() - y/CFG.TILE_SIZE;
		try{
			map[layer][col-1][row] = Tiles.CLOSED.getId();
		}catch(IndexOutOfBoundsException e){
			System.out.println(e);
		}
	}
	
	public Tiles getTileTypeByLocation(int layer, int x, int y) {
		return this.getTileTypeByCoordinate(layer, x / CFG.TILE_SIZE , y / CFG.TILE_SIZE);
	}
	
	public Tiles getTileTypeByCoordinate(int layer, int col, int row) {
		if(col < 0 || col >= getWidth() || row < 0 || row >= getHeight()) {
			return null;	
		}else {
			return Tiles.getTileTypeById(map[layer][getHeight()- row - 1][col]);
		}
	} 

	public int getWidth() {
		return map[0][0].length;
	}
	
	public int getHeight() {
		return map[0].length;
	}
	
	public int getLayers() {
		return map.length;
	}
	
}
