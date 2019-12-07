import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*int[][] board = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
		 		{0, 1, 1, 1, 1, 1, 3, 0, 5, 0}, 
		 		{0, 2, 0, 1, 0, 0, 1, 1, 1, 0}, 
		 		{0, 1, 1, 1, 1, 0, 1, 0, 0, 0}, 
		 		{0, 1, 0, 0, 1, 0, 1, 0, 0, 0},
		 		{0, 1, 1, 4, 1, 0, 1, 0, 0, 0}, 
		 		{0, 1, 0, 1, 1, 1, 1, 1, 1, 0}, 
		 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
				}; */
		
		Map m = new Map();
		//m.printMap();
		m.updateDistFromStart(2, 1);
		
		int[][] tmpMatrix = m.getDistFromStart();
		for (int i = 0; i < m.getROWS(); i++) {
			for (int j = 0; j < m.getCOLS(); j++) {
				System.out.print(tmpMatrix[i][j] + " ");
			}
			System.out.println();
		}		
		
		
//		Seeker h = new Seeker(new Location(2, 1), 2);
//		Catcher d = new Catcher(new Location(2, 3), 1, 1);
//		Catcher s = new Catcher(new Location(1, 6), 3, 1);
//		State state = new State(board, h, d, s);
//		state.printBoard();
		
	}

}
