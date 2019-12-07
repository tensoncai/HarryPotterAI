
// Catcher is the node for representing the teachers
public class Catcher {
	private int x;
	private int y;
	private int direction;    // current moving direction, 1-->up, 2-->down, 3-->left, 4-->right
	                  		 // catcher is designed can only change its direction at a junction
	private int speed;        // define the moving speed
	private char name;
	
	public Catcher(char name, int x, int y, int direction) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Catcher(char name, int x, int y, int direction, int speed) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.speed = speed;
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

	public int getDirection() {
		return direction;
	}

	public int getSpeed() {
		return speed;
	}
	
	public char getName() {
		return name;
	}
	
	public void setName(char n) {
		name = n;
	}
}
