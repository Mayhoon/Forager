package com.mygdx.game.custommap;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.mygdx.config.CFG;
import com.mygdx.game.data.GameData;

public class MapLoader {
	private static Json json = new Json();
	private static final int ISLAND_SIZE = 25; 
	private static final int ISLAND_MARGIN = 2;
	static MapData mapData;
	
	public static MapData loadMap (String id, GameData animations) {
		Gdx.files.local(CFG.PATH_MAPS).file().mkdirs();
		FileHandle file = Gdx.files.local(CFG.PATH_MAPS + id + ".map");
		
		if (file.exists()) {
			MapData data = json.fromJson(MapData.class, file.readString());
			return data;
		} else {
			MapData data = generateRandomMap(id, animations);
			saveMap(data.id, data.map);
			return data;
		}
	}
	
	public static void saveMap (String id, int[][][] map) {
		MapData data = new MapData();
		data.id = id;
		data.map = map;
		
		Gdx.files.local(CFG.PATH_MAPS).file().mkdirs();
		FileHandle file = Gdx.files.local(CFG.PATH_MAPS + id + ".map");
		file.writeString(json.prettyPrint(data), false);
	}
	
	public static MapData generateRandomMap (String id, GameData animations) {
		mapData = new MapData();
		mapData.id = id;
		mapData.name = id;
		mapData.map = new int[2][ISLAND_SIZE][ISLAND_SIZE];
		
		Random random = new Random();
		
		//Pre-Layouts the map
		for (int row = 0; row < ISLAND_SIZE; row++) {
			for (int col = 0; col < ISLAND_SIZE; col++) {
				
				//Borders, no tile should be rendered here except the empty ones
				if(row < ISLAND_MARGIN || col < ISLAND_MARGIN || row >= ISLAND_SIZE - ISLAND_MARGIN|| col >= ISLAND_SIZE - ISLAND_MARGIN) {
					mapData.map[0][row][col] = Tiles.EMPTY.getId();
				}else if(row > 0 || col > 0 |row < ISLAND_SIZE - ISLAND_MARGIN || col < ISLAND_SIZE - ISLAND_MARGIN){
					if(random.nextInt(5) == 1) {
						mapData.map[0][row][col] = Tiles.EMPTY.getId();
					}else {
						mapData.map[0][row][col] = Tiles.GRASS.getId();
					}
				}else {
					mapData.map[0][row][col] = Tiles.GRASS.getId();
				}				
			}
		}
		
		//Populates the map with the according tiles based on the GRASS and EMPTY tiles that were defined previously
		for (int row = ISLAND_MARGIN; row <= ISLAND_SIZE - ISLAND_MARGIN; row++) {
			for (int col = ISLAND_MARGIN; col <= ISLAND_SIZE - ISLAND_MARGIN; col++) {
				
				if(mapData.map[0][row][col] == Tiles.GRASS.getId()) {	
					Land.generate(mapData, row, col);
							
				}else if(mapData.map[0][row][col] == Tiles.EMPTY.getId()){
					Water.generate(mapData, row, col, ISLAND_SIZE, animations);
				}
			}
		}
		return mapData;
	}
}



	
