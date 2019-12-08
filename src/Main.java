import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

//		Map m = new Map();
//		m.updateDistFromStart(1, 1);
//		m.updateDistFromGoal(3, 5);

//		int[][] tmpMatrix = m.getDistFromStart();
//		for (int i = 0; i < m.getROWS(); i++) {
//			for (int j = 0; j < m.getCOLS(); j++) {
//				System.out.print(tmpMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		Goal g = new Goal('P', 5, 3);
		Seeker s = new Seeker('H', 1, 1);
		Catcher c = new Catcher('D', 5, 5, 1);
		List<Catcher> catchers = new ArrayList<Catcher>();
//		catchers.add(c);
		Map m1 = new Map(s, catchers, g);
		
		m1.printMap();
		m1.updateDistFromStart(1, 1);
		m1.printDistFromStart();
		
		System.out.println("*************************************");
		
		m1.updateDistFromGoal(3, 5);
		m1.printDistFromGoal();
		
//		m1.initMap1();
//		m1.printMap();
//		m1.calculateMapHeuristics();
//		m1.printHeuristicMap();
//		m1.moveHarry();
//		m1.printMap();
//		
//		int steps = 10;
//		
//		while (steps > 0) {
//			System.out.println("********************************************");
//			m1.calculateMapHeuristics();
//			m1.printHeuristicMap();
//			m1.moveHarry();
//			m1.printMap();
//			steps--;
//		}
	}

}
