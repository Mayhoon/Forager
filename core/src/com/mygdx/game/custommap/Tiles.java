package com.mygdx.game.custommap;

import com.mygdx.config.CFG;

import java.util.HashMap;

public enum Tiles {
	
	GRASS(1, true, "Grass"),
	WATER(2, true, "Water"),
	LEFT(3, false, "Grass_Left"),
	BOTTOM(4, true, "Grass_Bottom"),
	TOP(5, true, "Grass_Top"),
	RIGHT(6, true, "Grass_Right"),
	FULL(7, true, "Grass_Framed"),
	OPEN_TOP(8, true, "Grass_Top"),
	OPEN_BOTTOM(9, true, "Grass_Open_Bottom"),
	OPEN_RIGHT(10, true, "Grass_Right"),
	TOP_LEFT(11, true, "Grass_Top_Left"),
	TOP_RIGHT(12, true, "Grass_Top_Right"),
	BOTTOM_LEFT(13, true, "Grass_Bottom_Left"),
	BOTTOM_RIGHT(14, true, "Grass_Open_Rigth"),
	OPEN_LEFT(15, true, "Grass_Open_Left"),
	EMPTY(16, true, "Empty"),
	OPEN_TOP_BOTTOM(17, true, "Open_Top_Bottom"),
	OPEN_LEFT_RIGHT(18, true, "Open_Left_Right"),
	CLOSED(19, true, "Closed"),
	WATER_SOLO(20, true, "WaterAnimation_Solo"),
	L(21, true, "WaterAnimation_Left"),
	M(22, true, "WaterAnimation_Middle"),
	R(23, true, "WaterAnimation_Right"),
	CAMPFIRE(24, true, "Campfire");


	private int id;
	private boolean collidable;
	private String name;	
	
	private Tiles (int id, boolean collidable, String name) {
		this.id = id;
		this.collidable = collidable;
		this.name= name;
	}

	public int getId() {
		return id;
	}
	
	public boolean isCollidable() {
		return collidable;
	}

	public String getName() {
		return name;
	}

	//Stores all TileTypes in a Hashmap
	private static HashMap<Integer, Tiles> tileMap;
	static {
		tileMap = new HashMap<Integer, Tiles>();
		for (Tiles tileType : Tiles.values()) {
			tileMap.put(tileType.getId(), tileType);
		}
	}
	
	public static Tiles getTileTypeById (int id) {
		return tileMap.get(id);
	}
}