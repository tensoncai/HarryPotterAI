import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// Melody's code
		int steps = 30;
		Map m = new Map();

		while(steps > 0) {
			Catcher tmpCatcher = m.getCatchers().remove(0);
			// empty its current location
			m.updateMap(tmpCatcher.getY(), tmpCatcher.getX(), 1);
			tmpCatcher = m.randomWalk(tmpCatcher);
			m.updateMap(tmpCatcher.getY(), tmpCatcher.getX(), 4);
			List<Catcher> tmpCatchers = new ArrayList<Catcher>();
			tmpCatchers.add(tmpCatcher);
			m.setCatchers(tmpCatchers);
			m.printMap();
			steps--;
			System.out.println();
		}

//        // Tenson's code
//		Goal g = new Goal('P', 5, 3);
//		Seeker s = new Seeker('H', 1, 1);
//		Catcher c = new Catcher('D', 5, 5, 1);
//		List<Catcher> catchers = new ArrayList<Catcher>();
//
//		//catchers.add(c);
//		Map m1 = new Map(s, catchers, g);
//
//		m1.printMap();
//		m1.updateDistFromStart(1, 1);
//		m1.printDistFromStart();
//
//		System.out.println("*************************************");
//
//		m1.updateDistFromGoal(3, 5);
//		m1.printDistFromGoal();

	}

}
