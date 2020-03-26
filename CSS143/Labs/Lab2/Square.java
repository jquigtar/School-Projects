/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class Square {
	private Point2D location;
	private int sideLength;
	private String shape = "[]";
	
	public Square() {
		this.location = new Point2D(0,0);
		this.sideLength = 1;
	}
	
	public Square(int x, int y, int sideLength) {
		this.location = new Point2D(x,y);
		this.sideLength = sideLength;
	}
	
	public Square(Point2D location) {
		this.location = location;
		this.sideLength = 1;
	}
	
	/**
	 * draw
	 * 
	 * this is a function that shows the shape of the object square
	 */
	public void draw() {
		System.out.println(this.shape);
	}
	
	/**
	 * toString
	 * 
	 * this is a function that returns a string in the form
	 * {[] location: x: , y: , side length:  }
	 */
	public String toString() {
		return "{" + shape + " location: " + location.toString() 
				+ ". Side Length: " + sideLength + "}";
	}
	
	/**
	 * equals
	 * 
	 * this is a function that compares two squares and sees
	 * if they are the same
	 * @param otherSquare
	 * @return returns true if the object being compared has the 
	 * 			same sideLength and location as the object in the parameter
	 */
	public boolean eqauls(Square otherSquare) {
		if(otherSquare.location.equals(this.location) && 
				this.getSideLength() == otherSquare.getSideLength()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getX() {
		return location.getX();
	}
	
	public void setX(int newX) {
		this.location.setX(newX);
	}
	
	public int getY() {
		return location.getY();
	}
	
	public void setY(int newY) {
		this.location.setY(newY);
	}
	
	public double getArea() {
		return this.sideLength * this.sideLength;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	
	
}
