
// Seeker is the node for representing Harry
public class Seeker {
	private int x;
	private int y;
	// seeker don't need to remember current 'direction' because it can change its direction at any time
	private int speed;        // define the moving speed
	private char name;
	
	public Seeker(char name, int x, int y, int speed) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public Seeker(char name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public char getName() {
		return name;
	}
	
	public void setName(char n) {
		name = n;
	}

	public int getSpeed() {
		return speed;
	}

}
