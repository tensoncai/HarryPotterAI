import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {

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
		m1.updateDistFromGoal(g.getY(), g.getX());
		
		m1.calculateMapHeuristics();
		m1.printHeuristicMap();
		
		int steps1 = 300;
		
		while(steps1 > 0) {
			
			List<Catcher> tmpCatchers = new ArrayList<Catcher>();
			
			for (int i = 0; i < m1.getCatchers().size(); i++) {
				Catcher tmpCatcher = m1.getCatchers().get(i);
				m1.updateMap(tmpCatcher.getY(), tmpCatcher.getX(), 1);
				tmpCatcher = m1.randomWalk(tmpCatcher);
				m1.updateMap(tmpCatcher.getY(), tmpCatcher.getX(), i+4);
				tmpCatchers.add(tmpCatcher);
			}
			
			m1.setCatchers(tmpCatchers);
			
			m1.calculateMapHeuristics();
			m1.moveHarry();
			m1.printMap();

//			m1.printHeuristicMap();

			System.out.println("*************************");
			steps1--;
			
			if (m1.isTerminal() == 1) {
				System.out.println(ConsoleColors.GREEN_BOLD + "Congratulations! Harry found Peter (the goal)." +
						ConsoleColors.RESET);
				break;
			}
			else if (m1.isTerminal() == 2) {
				System.out.println(ConsoleColors.RED_BOLD + "Sorry. Harry got caught." +
						ConsoleColors.RESET);
				break;
			}
		}
	}
	
}


