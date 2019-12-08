import java.util.ArrayList;
import java.util.List;

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
		
//		Seeker s = new Seeker('H', 1, 1);
//		Catcher c = new Catcher('D', 5, 5, 1);
//		List<Catcher> catchers = new ArrayList<Catcher>();
//		catchers.add(c);
//		Map m1 = new Map(s, catchers);
//		m1.initMap1();
//		m1.printMap();
//		m1.calculateMapHeuristics();
//		m1.printHeuristicMap();


//		Seeker h = new Seeker(new Location(2, 1), 2);
//		Catcher d = new Catcher(new Location(2, 3), 1, 1);
//		Catcher s = new Catcher(new Location(1, 6), 3, 1);
//		State state = new State(board, h, d, s);
//		state.printBoard();
		

	}

}
