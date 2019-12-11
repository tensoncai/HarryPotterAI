import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		int wins = 0;
		int loss = 0;
		int gameIterations = 0;
		int numOfSteps = 0;
		
		while (gameIterations < 200) {
		
			Seeker s = new Seeker('H', 3, 1);
			
	//      // bigger/simpler map	
	//		Goal g = new Goal('P', 78, 19);
	//		Catcher d = new Catcher('D', 33, 9, 1);
	//		Catcher snape = new Catcher('S', 22, 15, 1);
	//		Catcher l = new Catcher('L', 69, 18, 1);
	//		Catcher f = new Catcher('F', 77, 19, 1);
	//		Catcher m = new Catcher('M', 48, 9, 1);
	//		Catcher b = new Catcher('B', 44, 15, 1);
	//		Catcher a = new Catcher('A', 80, 15, 1);
	//		Catcher c = new Catcher('C', 76, 17, 1);
	//		
	//		List<Catcher> catchers = new ArrayList<Catcher>();
	//		catchers.add(d);
	//		catchers.add(snape);
	//		catchers.add(l);
	//		catchers.add(f);
	//		catchers.add(m);
	//		catchers.add(b);
	//		catchers.add(a);
	//		catchers.add(c);
			
			
			// smaller/complicated map 
			Goal g = new Goal('P', 27, 17);
			Catcher d = new Catcher('D', 13, 5, 1);
			Catcher snape = new Catcher('S', 3, 9, 1);
			Catcher l = new Catcher('L', 15, 14, 1);
			Catcher f = new Catcher('F', 4, 17, 1);
			Catcher m = new Catcher('M', 25, 10, 1);
			Catcher b = new Catcher('B', 18, 18, 1);
			Catcher a = new Catcher('A', 21, 15, 1);
			Catcher c = new Catcher('C', 8, 6, 1);
			
			List<Catcher> catchers = new ArrayList<Catcher>();
			catchers.add(d);
			catchers.add(snape);
			catchers.add(l);
			catchers.add(f);
			catchers.add(m);
			catchers.add(b);
			catchers.add(a);
			catchers.add(c);
			
			Map m1 = new Map(s, catchers, g);
	
			m1.printMap();
			m1.updateDistFromGoal(g.getY(), g.getX());
			
			m1.calculateMapHeuristics();
	//		m1.printHeuristicMap();
			
			int steps1 = 2000;
			
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
				numOfSteps++;
				m1.printMap();
	
	//			m1.printHeuristicMap();
	
				System.out.println();
				steps1--;
				
				if (m1.isTerminal() == 1) {
					System.out.println(ConsoleColors.GREEN_BOLD + "Congratulations! Harry found Peter (the goal)." +
							ConsoleColors.RESET);
					wins++;
					break;
				}
				else if (m1.isTerminal() == 2) {
					System.out.println(ConsoleColors.RED_BOLD + "Sorry. Harry got caught." +
							ConsoleColors.RESET);
					loss++;
					break;
				}
			}
			
			gameIterations++;
		}
		
		System.out.println("WINS = " + wins);
		System.out.println("LOSSES = " + loss);
		int averageStepsTaken = numOfSteps / gameIterations;
		System.out.println("AVERAGE STEPS TAKEN = " + averageStepsTaken);
	}
	
}


