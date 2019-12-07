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

	private Seeker harry;
	private List<Catcher> catchers;
	


	public Map() {
		map = initMap();
		distFromStart = new int[ROWS][COLS];
		distFromGoal = new int[ROWS][COLS];
		initDistMatrix();
    }
	
	
	
	/*public Map(Seeker s, List<Catcher> catchers) {
		map = initMap();
		distanceFromStart = new int[ROWS][COLS];
		distanceFromGoal = new int[ROWS][COLS];
		initDistMatrix();
		harry = s;
		this.catchers = catchers;
	}*/
	
	
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
		}
	}

	// justify a location is road or not
	public boolean isRoad(int x, int y) {
		if(x < ROWS && y < COLS) {
			if(map[x][y] != 0) {
				return true;
			}
		}
		return false;
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

}
