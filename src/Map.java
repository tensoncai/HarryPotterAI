import java.util.ArrayList;
import java.util.List;

public class Map {
	// current board configuration
	// 0: wall
	// 1: road
	// 2: Harry
	// 3: Peter (the goal)
	// 4: Dumbledore
	// 5: Snape

	private final int ROWS = 8;
	private final int COLS = 8;

	private int [][] map;
	private int [][] distFromStart;
	private int [][] distFromGoal;
	private int [][] heuristicMap;

	private Seeker harry;
	private List<Catcher> catchers;
	private Goal peter;



	public Map() {
		map = initMap();
		distFromStart = new int[ROWS][COLS];
		distFromGoal = new int[ROWS][COLS];
		initDistMatrix();
    }



	public Map(Seeker s, List<Catcher> catchers, Goal g) {
		map = new int[ROWS][COLS];
		harry = s;
		this.catchers = catchers;
		peter = g;
		initMap1();
		distFromStart = new int[ROWS][COLS];
		distFromGoal = new int[ROWS][COLS];
		initDistMatrix();
	}


	public int[][] initMap() {
		int[][] map = {
		{0, 0, 0, 0, 0, 0, 0, 0},
 		{0, 1, 1, 1, 3, 0, 5, 0},
 		{0, 2, 0, 1, 0, 0, 1, 0},
 		{0, 1, 1, 1, 1, 0, 1, 0},
 		{0, 1, 0, 0, 1, 0, 1, 0},
 		{0, 1, 1, 4, 1, 0, 1, 0},
 		{0, 1, 0, 1, 1, 1, 1, 0},
 		{0, 0, 0, 0, 0, 0, 0, 0}
		};
		return map;
	}


	public void initDistMatrix() {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				distFromStart[r][c] = -1;
				distFromGoal[r][c] = -1;
			}
		}
	}

	public int getROWS() {
		return ROWS;
	}

	public int getCOLS() {
		return COLS;
	}

	public Seeker getSeeker() {
		return harry;
	}

	public int [][] getDistFromStart(){
		return distFromStart;
	}

	public int [][] getDistFromGoal(){
		return distFromGoal;
	}

	/* using BFS to compute distanceFromStart/Goal
	 * @param x: start point x coordinate
	 * @param y: start point y coordinate
	 * @param layer: store the current layer
	 * @param distMatrix: the matrix contains all the distances from start point
	 */
	public void updateDistFromStart(int x, int y) {
		distFromStart[x][y] = 0;
		Location s = new Location(x, y);
		ArrayList<Location> queue = new ArrayList<Location>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Location tmpLoc = queue.remove(0);
			int tmpX = tmpLoc.getX();
			int tmpY = tmpLoc.getY();
			for (int i = -1; i < 2; i = i+2) {
				if(isRoad(tmpX+i, tmpY) && distFromStart[tmpX+i][tmpY] == -1) {
					distFromStart[tmpX+i][tmpY] = distFromStart[tmpX][tmpY] + 1;
					queue.add(new Location(tmpX+i, tmpY));
				}
			}
			for (int j = -1; j < 2; j = j+2) {
				if(isRoad(tmpX, tmpY+j) && distFromStart[tmpX][tmpY+j] == -1) {
					distFromStart[tmpX][tmpY+j] = distFromStart[tmpX][tmpY] + 1;
					queue.add(new Location(tmpX, tmpY+j));
				}
			}

//			System.out.println();
		}
	}

	public void updateDistFromGoal(int x, int y) {
		distFromGoal[x][y] = 0;
		Location s = new Location(x, y);
		ArrayList<Location> queue = new ArrayList<Location>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Location tmpLoc = queue.remove(0);
			int tmpX = tmpLoc.getX();
			int tmpY = tmpLoc.getY();
			for (int i = -1; i < 2; i = i+2) {
				if(isRoad(tmpX+i, tmpY) && distFromGoal[tmpX+i][tmpY] == -1) {
					distFromGoal[tmpX+i][tmpY] = distFromGoal[tmpX][tmpY] + 1;
					queue.add(new Location(tmpX+i, tmpY));
				}
			}
			for (int j = -1; j < 2; j = j+2) {
				if(isRoad(tmpX, tmpY+j) && distFromGoal[tmpX][tmpY+j] == -1) {
					distFromGoal[tmpX][tmpY+j] = distFromGoal[tmpX][tmpY] + 1;
					queue.add(new Location(tmpX, tmpY+j));
				}
			}

//			System.out.println();
		}
	}


	public int[][] calculateMapHeuristics() {
		heuristicMap = new int[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < ROWS; j++) {
				heuristicMap[i][j] = distFromStart[i][j] + distFromGoal[i][j];
			}
		}

		for (int i = 0; i < catchers.size(); i++) {
			Catcher catcher = catchers.get(i);
			int catcherY = catcher.getY();
			int catcherX = catcher.getX();
			
			for (int y = catcherY - 2; y < catcherY + 2; y++) {
				for (int x = catcherX - 2; x < catcherX + 2; x++) {
					if (isRoad(y, x)) {
						int distance = Math.abs(x - catcherX) + Math.abs(y - catcherY);
						heuristicMap[y][x] = heuristicMap[y][x] + (1000 / (distance + 1));
					}
				}
			}
		}

		return heuristicMap;
	}

	public void printHeuristicMap() {
		for (int y = 0; y < ROWS; y++) {
			for (int x = 0; x < COLS; x++) {
				System.out.print("     " + heuristicMap[y][x]);
			}

			System.out.println();
		}
	}

	public void initMap1() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1) {
					map[i][j] = 0;
				}
				else {
					map[i][j] = 1;
				}
			}
		}
		
		map[peter.getY()][peter.getX()] = 3;
		map[harry.getY()][harry.getX()] = 2;
		for (int i = 0; i < catchers.size(); i++) {
			map[catchers.get(i).getY()][catchers.get(i).getX()] = 4;
		}
	}

	// justify a location is road or not
	public boolean isRoad(int x, int y) {
		if(x > -1 && x < ROWS && y > -1 && y < COLS) {
			if(map[x][y] != 0) {
				return true;
			}
		}
		return false;
	}
	
	public void printDistFromStart() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(" " + distFromStart[j][i]);
			}
			
			System.out.println();
		}
	}
	
	public void printDistFromGoal() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(" " + distFromGoal[j][i]);
			}
			
			System.out.println();
		}
	}

	public void printMap() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0)
					System.out.print("$");
				else if (map[i][j] == 1)
					System.out.print(" ");
				else if (map[i][j] == 2)
					System.out.print("H");
				else if (map[i][j] == 3)
					System.out.print("P");
				else if (map[i][j] == 4)
					System.out.print("D");
				else if (map[i][j] == 5)
					System.out.print("S");
			}
			System.out.println();
		}
	}

	
	public void moveHarry() {
		int r = harry.getY();
		int c = harry.getX();
		int lowestHeuristicValue = Integer.MAX_VALUE;
		
		map[r][c] = 1;
		
		if (isValidMove(r - 1, c) && heuristicMap[r - 1][c] < lowestHeuristicValue) {
			lowestHeuristicValue = heuristicMap[r - 1][c];
			harry.setX(c);
			harry.setY(r - 1);
		}
		if (isValidMove(r + 1, c) && heuristicMap[r + 1][c] < lowestHeuristicValue) {
			lowestHeuristicValue = heuristicMap[r + 1][c];
			harry.setX(c);
			harry.setY(r + 1);
		}
		if (isValidMove(r, c - 1) && heuristicMap[r][c - 1] < lowestHeuristicValue) {
			lowestHeuristicValue = heuristicMap[r][c - 1];
			harry.setX(c - 1);
			harry.setY(r);
		}
		if (isValidMove(r, c + 1) && heuristicMap[r][c + 1] < lowestHeuristicValue) {
			lowestHeuristicValue = heuristicMap[r][c + 1];
			harry.setX(c + 1);
			harry.setY(r);
		}
		
		map[harry.getY()][harry.getX()] = 2;
	}
	

	
	// justify a location is road or not
	public boolean isValidMove(int x, int y) {
		if(x > -1 && x < ROWS && y > -1 && y < COLS) {
			if(map[x][y] == 1) {
				return true;
			}
		}
		return false;
	}
	
}
