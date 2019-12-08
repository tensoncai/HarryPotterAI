
public class Goal {
	private char name;
	private int x;
	private int y;
	
	public Goal(char name, int x, int y) {
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
}
