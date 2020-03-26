import java.awt.Color;
import java.awt.Graphics;
/**
 * Square
 * 
 * this is a class that extends the Shape class and has 
 * ints height, and base to determine the area as well as how to draw 
 * the shape 
 * @author jquigtar
 * @version 2/14/19
 *
 */
public class Square extends Shape {

	private int base;
	private int height;
	
	/**
	 * Square
	 * 
	 * this is a constructor that sets the (x,y) coordinates for the 
	 * Square as well as the base and height
	 * @param x
	 * @param y
	 * @param base
	 * @param height
	 */
	public Square(int x, int y, int base, int height) {
		super(x, y);
		this.base = base;
		this.height = height;
	}
	
	/**
	 * getArea
	 * 
	 * this method overrides the parent class so when called on
	 * a Square object this method will run and will find the 
	 * area of the given Square by the formula b*h
	 * and returns that number as double
	 * @return a double which is the area of the square
	 */
	@Override 
	public double getArea() {
		return this.base * this.height;
	}
	
	/**
	 * draw
	 * 
	 * this is a method that takes a parameter of Graphics g
	 * and uses this to draw the Square with the given 
	 * base, height, and (x,y) coordinates in a JFrame
	 * it also overrides the parent class when called on a Square object
	 * @param Graphics g
	 */
	@Override 
	public void draw(Graphics g) {
		g.draw3DRect(super.getX(), super.getY(), this.base, this.height, true);
	}
}
