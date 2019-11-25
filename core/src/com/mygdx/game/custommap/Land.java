package com.mygdx.game.custommap;

public class Land {
	
	public static void generate(MapData mapData, int row, int col) {
		int empty = Tiles.EMPTY.getId();
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
		int water_solo = Tiles.WATER_SOLO.getId();
		
		int tileAbove = mapData.map[0][row-1][col];
		int tileUnder = mapData.map[0][row+1][col];
		int tileLeft = mapData.map[0][row][col-1];
		int tileRight = mapData.map[0][row][col+1];
		
		//OPEN_TOP_BOTTOM (Bridge)
		if(tileLeft == empty || tileLeft == m || tileLeft == l) {
			if(tileRight == empty) {
				if(tileUnder != empty) {
					if(tileAbove != empty
						&& tileAbove != l
						&& tileAbove != m
						&& tileAbove != r) {
						mapData.map[0][row][col] = open_top_bottom;
						//System.out.println("OPEN_TOP_BOTTOM");
					}
				}
			}
		}
		//OPEN_LEFT_RIGHT (Bridge)
		if(tileLeft != empty && tileLeft != m && tileLeft != water_solo) {
			if(tileRight != empty) {
				if(tileUnder == empty) {
					if(tileAbove == empty
						|| tileAbove == l
						|| tileAbove == m
						|| tileAbove == r
						|| tileAbove == water_solo) {
						mapData.map[0][row][col] = open_left_right;
						//System.out.println("OPEN_LEFT_RIGHT");
					}
				}
			}
		}
		//OPEN_TOP
		if(tileLeft == empty || tileLeft == m || tileLeft == l) {
			if(tileRight == empty) {
				if(tileUnder == empty) {
					if(tileAbove != empty
						&& tileAbove != l
						&& tileAbove != m
						&& tileAbove != r
						&& tileAbove != water_solo) {
						mapData.map[0][row][col] = open_top;
						//System.out.println("OPEN_TOP");
					}
				}
			}
		}
		//OPEN_BOTTOM
		if(tileLeft == empty || tileLeft == m || tileLeft == l || tileLeft == water_solo || tileLeft == l) {
			if(tileRight == empty || tileRight == water_solo || tileRight == r) {
				if(tileAbove == empty
						||tileAbove == l
						||tileAbove == m
						||tileAbove == r
						||tileAbove == water_solo) {
					if(tileUnder != empty) {
						mapData.map[0][row][col] = open_bottom;
					   //System.out.println("OPEN_BOTTOM");
					}
				}
			}
		}
		//OPEN_LEFT
		if(tileLeft != empty
				&& tileLeft != m
				&& tileLeft != l
				&& tileLeft != closed
				&& tileLeft != water_solo) {
			if(tileRight == empty) {
				if(tileUnder == empty) {
					if(tileAbove == empty
						|| tileAbove == l
						|| tileAbove == m
						|| tileAbove == r
						|| tileAbove == water_solo) {
						mapData.map[0][row][col] = open_left;
						//System.out.println("OPEN_LEFT");
					}
				}
			}
		}
		//OPEN_RIGHT
		if(tileLeft == empty || tileLeft == m || tileLeft == water_solo) {
			if(tileRight != empty) {
				if(tileUnder == empty) {
					if(tileAbove == empty
						|| tileAbove == l
						|| tileAbove == m
						|| tileAbove == r
						|| tileAbove == water_solo) {
						mapData.map[0][row][col] = open_right;
						//System.out.println("OPEN_RIGHT");
					}
				}
			}
		}
		//TOP_LEFT
		if(tileLeft == empty
			|| tileLeft == m
			|| tileLeft == l
			|| tileLeft == water_solo) {
			if(tileRight != empty) {
				if(tileAbove == empty
					|| tileAbove == l
					|| tileAbove == m
					|| tileAbove == r
					|| tileAbove == water_solo) {
					if(tileUnder != empty) {
						mapData.map[0][row][col] = top_left;
						//System.out.println("TOP_LEFT");
					}
				}
			}
		}
		//TOP_RIGHT
		if(tileLeft != empty
			&& tileLeft != l
			&& tileLeft != m
			&& tileLeft != r
			&& tileLeft != water_solo) {
			if(tileRight == empty) {
				if(tileAbove == empty
					|| tileAbove == l
					|| tileAbove == m
					|| tileAbove == r
					|| tileAbove == water_solo) {
					if(tileUnder != empty) {
						mapData.map[0][row][col] = top_right;
						//System.out.println("TOP_RIGHT");
					}
				}
			}
		}
		//BOTTOM_LEFT
		if(tileLeft == empty || tileLeft ==  m || tileLeft == l) {
			if(tileRight != empty) {
				if(tileAbove != empty
					&& tileAbove != l
					&& tileAbove != m
					&& tileAbove != r
					&& tileAbove != closed
					&& tileAbove != water_solo) {
					if(tileUnder == empty) {
						mapData.map[0][row][col] = bottom_left;
						//System.out.println("BOTTOM_LEFT");
					}
				}
			}
		}
		//BOTTOM_RIGHT
		if(tileLeft != empty && tileLeft != m && tileLeft != l) {
			if(tileRight == empty) {
				if(tileAbove != empty
					&& tileAbove != l
					&& tileAbove != m
					&& tileAbove != r
					&& tileAbove != closed
					&& tileAbove != water_solo) {
					if(tileUnder == empty) {
						mapData.map[0][row][col] = bottom_right;
						//System.out.println("BOTTOM_RIGHT");
					}
				}
			}
		}
		//LEFT
		if(tileLeft == empty
				|| tileLeft == m
				|| tileLeft == l
				|| tileLeft == water_solo) {
			if(tileRight != empty) {
				if(tileAbove != empty
					&& tileAbove != l
					&& tileAbove != m
					&& tileAbove != r
					&& tileAbove != closed
					&& tileAbove != water_solo) {
					if(tileUnder != empty) {
						mapData.map[0][row][col] = left;
						//System.out.println("LEFT");
					}
				}
			}
		}
		//RIGHT
		if(tileLeft != empty && tileLeft != l && tileLeft != m && tileLeft != r) {
			if(tileRight == empty) {
				if(tileAbove != empty
					&& tileAbove != l
					&& tileAbove != m
					&& tileAbove != r
					&& tileAbove != closed
					&& tileAbove != water_solo) {
					if(tileUnder != empty) {
						mapData.map[0][row][col] = right;
						//System.out.println("RIGHT");
					}
				}
			}
		}
		//TOP
		if(tileLeft != empty && tileLeft != m && tileLeft != l && tileLeft != water_solo) {
			if(tileRight != empty ) {
				if(tileAbove == empty
					|| tileAbove == l
					|| tileAbove == m
					|| tileAbove == r
					|| tileAbove == water_solo) {
					if(tileUnder != empty) {
						mapData.map[0][row][col] = top;
						//System.out.println("TOP");
					}
				}
			}
		}
		//BOTTOM
		if(tileLeft != empty && tileLeft != m && tileLeft != l && tileLeft != r) {
			if(tileRight != empty) {
				if(tileAbove != empty
					&& tileAbove != l
					&& tileAbove != m
					&& tileAbove != r
					&& tileAbove != water_solo) {
					if(tileUnder == empty) {
						mapData.map[0][row][col] = bottom;
						//System.out.println("BOTTOM");
					}
				}
			}
		}
		//CLOSED
		if(tileLeft == empty || tileLeft == m || tileLeft == water_solo) {
			if(tileRight == empty) {
				if(tileAbove == empty
					|| tileAbove == l
					|| tileAbove == m
					|| tileAbove == r
					|| tileAbove == water_solo) {
					if(tileUnder == empty) {
						mapData.map[0][row][col] = closed;
						//System.out.println("CLOSED");
					}
				}
			}
		}

//		if(tileLeft == Tiles.GRASS.getId()) {
//			mapData.map[0][row][col] = Tiles.CAMPFIRE.getId();
//		}
	}
}