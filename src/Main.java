import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {

//		// Melody's code
//		int steps = 30;
//		Map m = new Map();
//
//		while(steps > 0) {
//			Catcher tmpCatcher = m.getCatchers().remove(0);
//			// empty its current location
//			m.updateMap(tmpCatcher.getY(), tmpCatcher.getX(), 1);
//			tmpCatcher = m.randomWalk(tmpCatcher);
//			m.updateMap(tmpCatcher.getY(), tmpCatcher.getX(), 4);
//			List<Catcher> tmpCatchers = new ArrayList<Catcher>();
//			tmpCatchers.add(tmpCatcher);
//			m.setCatchers(tmpCatchers);
//			m.printMap();
//			steps--;
//			System.out.println();
//		}

        // Tenson's code
		Goal g = new Goal('P', 78, 19);
//		Goal g = new Goal('P', 8, 8);
		Seeker s = new Seeker('H', 61, 16);
		Catcher c = new Catcher('D', 75, 17, 1);
		Catcher snape = new Catcher('S', 66, 15, 1);
		Catcher l = new Catcher('L', 69, 18, 1);
		Catcher f = new Catcher('F', 77, 18, 1);
		
		
		List<Catcher> catchers = new ArrayList<Catcher>();
		catchers.add(c);
		catchers.add(snape);
		catchers.add(l);
		catchers.add(f);
		
		Map m1 = new Map(s, catchers, g);

		m1.printMap();
//		m1.updateDistFromStart(s.getX(), s.getY());
		m1.updateDistFromGoal(g.getY(), g.getX());
		
		m1.calculateMapHeuristics();
		m1.printHeuristicMap();
		
		int steps1 = 300;
		
		while(steps1 > 0) {
			Catcher tmpCatcher1 = m1.getCatchers().remove(0);
			Catcher tmpCatcher2 = m1.getCatchers().remove(0);
			Catcher tmpCatcher3 = m1.getCatchers().remove(0);
			Catcher tmpCatcher4 = m1.getCatchers().remove(0);
			
			
			m1.updateMap(tmpCatcher1.getY(), tmpCatcher1.getX(), 1);
			tmpCatcher1 = m1.randomWalk(tmpCatcher1);
			m1.updateMap(tmpCatcher1.getY(), tmpCatcher1.getX(), 4);
			
			m1.updateMap(tmpCatcher2.getY(), tmpCatcher2.getX(), 1);
			tmpCatcher2 = m1.randomWalk(tmpCatcher2);
			m1.updateMap(tmpCatcher2.getY(), tmpCatcher2.getX(), 5);
			
			m1.updateMap(tmpCatcher3.getY(), tmpCatcher3.getX(), 1);
			tmpCatcher3 = m1.randomWalk(tmpCatcher3);
			m1.updateMap(tmpCatcher3.getY(), tmpCatcher3.getX(), 6);
			
			m1.updateMap(tmpCatcher4.getY(), tmpCatcher4.getX(), 1);
			tmpCatcher4 = m1.randomWalk(tmpCatcher4);
			m1.updateMap(tmpCatcher4.getY(), tmpCatcher4.getX(), 7);
			
			
			List<Catcher> tmpCatchers = new ArrayList<Catcher>();
			tmpCatchers.add(tmpCatcher1);
			tmpCatchers.add(tmpCatcher2);
			tmpCatchers.add(tmpCatcher3);
			tmpCatchers.add(tmpCatcher4);
			m1.setCatchers(tmpCatchers);
			
			m1.calculateMapHeuristics();
			m1.moveHarry();
			m1.printMap();

//			m1.printHeuristicMap();

			System.out.println("*************************");
			steps1--;
			
			if (m1.isTerminal() == 1) {
				System.out.println("Congratulations! Harry found Peter (the goal).");
				break;
			}
			else if (m1.isTerminal() == 2) {
				System.out.println("Sorry. Harry got caught.");
				break;
			}
		}
	}
}


