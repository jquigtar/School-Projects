import java.awt.Color;
import java.awt.Graphics;
/**
 * 
 */

/**
 * Shape
 * 
 * this is a class that describes a shape using its 
 * x, y coordinates as well as its color
 * @author jquigtar
 */
public class Shape {
	//invariants
	//1)x can not be a negative value
	//2)y can not be a negative value
	//3)the area can not be negative
	//4)color can only be in color class
	private int x;
	private int y;
	private Color color;
	
	public Shape() {
		this.setX(0);
		this.setY(0);
		this.color = new Color(255,0,0);
	}
	
	public Shape(int x, int y, Color color) {
		//remember imports for class Color
		this.setX(x);
		this.setY(y);
		this.setColor(color);
	}
	
	/**
	 * Shape
	 * 
	 * this is a copy constructor that creates a new 
	 * Shape which is a copy of the shape
	 * @param other
	 */
	public Shape(Shape other) {
		//copy constructor
		this.setColor(other.getColor());
		this.setX(other.getX());
		this.setY(other.getY());
	}
	
	/**
	 * toString
	 * 
	 * this is a function that returns a string describing 
	 * the shape using its coordinates and color
	 * @return it returns a string in the form
	 * 			(x,y) - color is (Color class color)
	 */
	public String toString() {
		//describe your shape’s x,y, color, etc.
		return "(" + this.x + ", " + this.y + ") - color is " + this.color; 
	}
	
	public double getArea() {
		//to be replaced by subclasses, so just return -1 here
		return -1;
	}
	
	public void draw(Graphics g) {
		//to be used by the paint program, so this can be empty for now
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x >= 0) {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y >= 0) {
			this.y = y;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
