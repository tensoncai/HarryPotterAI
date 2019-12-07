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
	private int [][] distanceFromStart;
	private int [][] distanceFromGoal;
	int[][] heuristicMap;

	private Seeker harry;
	private List<Catcher> catchers;
	
	/*int [][] board = {
			{0, 0, 0, 0, 0, 0, 0, 0}, 
	 		{0, 1, 1, 1, 3, 0, 5, 0}, 
	 		{0, 2, 0, 1, 0, 0, 1, 0}, 
	 		{0, 1, 1, 1, 1, 0, 1, 0}, 
	 		{0, 1, 0, 0, 1, 0, 1, 0},
	 		{0, 1, 1, 4, 1, 0, 1, 0}, 
	 		{0, 1, 0, 1, 1, 1, 1, 0}, 
	 		{0, 0, 0, 0, 0, 0, 0, 0}
	};*/

	
	public Map(Seeker s, List<Catcher> catchers) {
		map = new int[ROWS][COLS];
		distanceFromStart = new int[ROWS][COLS];
		distanceFromGoal = new int[ROWS][COLS];
		harry = s;
		this.catchers = catchers;
	}

	public Seeker getSeeker() {
		return harry;
	}
	
	public void printMap() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(map[i][j]);
			}
			
			System.out.println();
		}
	}

//	public void printMap() {
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < board[0].length; j++) {
//				if(board[i][j] == 0)
//					System.out.print("*");
//				else if (board[i][j] == 1)
//					System.out.print(" ");
//				else if (board[i][j] == 2)
//					System.out.print("H");
//				else if (board[i][j] == 3)
//					System.out.print("P");
//				else if (board[i][j] == 4)
//					System.out.print("D");
//				else if (board[i][j] == 5)
//					System.out.print("S");
//			}
//			System.out.println();
//		}
//	}
	
	public int[][] calculateMapHeuristics() {
		heuristicMap = new int[ROWS][COLS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < ROWS; j++) {
				heuristicMap[i][j] = distanceFromStart[i][j] + distanceFromGoal[i][j];
			}
		}
		
		for (int i = 0; i < catchers.size(); i++) {
			Catcher catcher = catchers.get(i);
			int catcherY = catcher.getY();
			int catcherX = catcher.getX();
			System.out.println("HERE");
			for (int y = catcherY - 2; y < catcherY + 2; y++) {
				for (int x = catcherX - 2; x < catcherX + 2; x++) {
					System.out.println("HI");
					if (isValidLocation(x, y)) {
						int distance = Math.abs(x - catcherX) + Math.abs(y - catcherY);
						System.out.println("distance = " + distance);
						heuristicMap[y][x] = heuristicMap[y][x] + (1000 / (distance + 1));
					}
				}
			}
			
		}
		
		return heuristicMap;
	}
	
	private boolean isValidLocation(int x, int y) {
		if (y < ROWS && x < COLS && map[y][x] == 1) {
			System.out.println("HEY");
			return true;
		}
		
		return false;
	}
	
	public void printHeuristicMap() {
		for (int y = 0; y < ROWS; y++) {
			for (int x = 0; x < COLS; x++) {
				System.out.print("     " + heuristicMap[y][x]);
			}
			
			System.out.println();
		}
	}
	
	public void initMap() {
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
	}

}
