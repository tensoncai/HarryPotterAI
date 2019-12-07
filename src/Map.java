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
	
	private final int ROWS = 100;
	private final int COLS = 100;
	
	private int [][] map;
	private int [][] distanceFromStart;
	private int [][] distanceFromGoal;

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

	
	public Map() {
		map = new int[ROWS][COLS];
		distanceFromStart = new int[ROWS][COLS];
		distanceFromGoal = new int[ROWS][COLS];
		catchers = new ArrayList<Catcher>();
	}

	public Seeker getSeeker() {
		return harry;
	}
	
	public void printMap() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				
			}
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

}
