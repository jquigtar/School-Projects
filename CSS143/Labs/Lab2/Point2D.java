/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class Point2D {
	private int x;
	private int y;
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void translate(int addToX, int addToY) {
		this.x = this.x + addToX;
		this.y = this.x + addToY;
	}
	
	public String toString() {
		return "x: " + this.x + ", y: " + this.y;
	}
	
	public boolean equals(Point2D otherPoint) {
		if(otherPoint.getX() == this.getX() && otherPoint.getY() == this.getY()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int newX) {
		this.x = newX;
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		this.y = newY;
	}
	
}
