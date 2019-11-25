package com.mygdx.game.custommap;

import com.mygdx.game.data.GameData;
import com.mygdx.config.CFG;

public class Water {
	public static void generate(MapData mapData, int row, int col, int ISLAND_SIZE, GameData animations) {
	
		int empty = Tiles.EMPTY.getId();
		int water_solo = Tiles.WATER_SOLO.getId();
		int grass = Tiles.GRASS.getId();
		int l = Tiles.L.getId();
		int m = Tiles.M.getId();
		int r = Tiles.R.getId();
		int top = Tiles.TOP.getId();
		int top_left = Tiles.TOP_LEFT.getId();
		int top_right = Tiles.TOP_RIGHT.getId();
		int open_left_right = Tiles.OPEN_LEFT_RIGHT.getId();
		int open_top_bottom = Tiles.OPEN_TOP_BOTTOM.getId();
		int open_top = Tiles.OPEN_TOP.getId();
		int open_bottom = Tiles.OPEN_BOTTOM.getId();
		int open_left = Tiles.OPEN_LEFT.getId();
		int open_right = Tiles.OPEN_RIGHT.getId();
		int left = Tiles.LEFT.getId();
		int right = Tiles.RIGHT.getId();
		int bottom = Tiles.BOTTOM.getId();
		int bottom_right = Tiles.BOTTOM_RIGHT.getId();
		int bottom_left = Tiles.BOTTOM_LEFT.getId();
		int closed = Tiles.CLOSED.getId();	
		
		int tileAbove = mapData.map[0][row-1][col];
		int tileUnder = mapData.map[0][row+1][col];
		int tileLeft = mapData.map[0][row][col-1];
		int tileRight = mapData.map[0][row][col+1];
		
		int tileRightTop = mapData.map[0][row-1][col+1];
				
		//LEFT WATER{
			if(tileLeft == empty && tileAbove == bottom_left 
				|| tileLeft == empty && tileAbove == open_right
				|| tileLeft == empty && tileAbove == closed && tileRight != empty
				|| tileLeft == empty && tileAbove == open_top && tileRight != empty){
				mapData.map[0][row][col] = Tiles.L.getId();
				animations.createAnimation(col * CFG.TILE_SIZE, ((ISLAND_SIZE-1)-row) * CFG.TILE_SIZE);		
			}
		
		//MIDDLE WATER
		//if(tileRight == empty || tile) {
				if(tileAbove == open_top_bottom 
					|| tileAbove == bottom 
					|| tileAbove == bottom_right
					|| tileAbove == bottom_left && tileLeft != empty
					|| tileAbove == open_left
					|| tileAbove == open_right && tileLeft != empty
					|| tileAbove == top
					|| tileAbove == open_top_bottom
					|| tileAbove == open_left_right
					|| tileAbove == bottom_right && tileRight == top_left) {				
					mapData.map[0][row][col] = Tiles.M.getId();
					animations.createAnimation(col * CFG.TILE_SIZE, ((ISLAND_SIZE-1)-row) * CFG.TILE_SIZE);
				}
		//}
		
		//RIGHT WATER
		//if(tileLeft == m || tileLeft == l) {
			if(tileRight == empty && tileAbove == bottom_right
				|| tileRight == empty && tileAbove == open_left
				|| tileRight == top_left && tileAbove == bottom_right
				|| tileRight == empty && tileAbove == open_top) {
				mapData.map[0][row][col] = Tiles.R.getId();
				animations.createAnimation(col * CFG.TILE_SIZE, ((ISLAND_SIZE-1)-row) * CFG.TILE_SIZE);					
			}
		//}
			
		//Water_solo
		if(tileAbove == closed && tileLeft == m && tileLeft == r
			|| tileAbove == closed 
			|| tileAbove == open_top
			|| tileAbove == open_top && tileLeft == m && tileLeft == r
			|| tileAbove == open_top && tileLeft == empty && tileRight == empty) {
			//if(tileRight == empty) {
				mapData.map[0][row][col] = Tiles.WATER_SOLO.getId();
				animations.createAnimation(col * CFG.TILE_SIZE, ((ISLAND_SIZE-1)-row) * CFG.TILE_SIZE);
			//}
			
		}

	}
}
