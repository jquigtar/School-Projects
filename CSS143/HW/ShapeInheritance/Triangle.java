import java.awt.Graphics;

/**
 * 
 */

/**
 * Triangle
 * 
 * this is a class that extends the Shape class and has 
 * ints height, and base to determine the area as well as how to draw 
 * the shape
 * @author jquigtar
 * @version 2/14/19
 *
 */
public class Triangle extends Shape{

	private int base;
	private int height;
	
	/**
	 * Triangle
	 * 
	 * this is a constructor that sets the height, base, and 
	 * (x,y) coordinates for the Triangle object
	 * @param x
	 * @param y
	 * @param base
	 * @param height
	 */
	public Triangle(int x, int y, int base, int height) {
		super(x,y);
		//takes constructor from parent class and sets the (x,y) coordinate
		this.base = base;
		this.height = -height;
	}
	
	/**
	 * getArea
	 * 
	 * this method overrides the parent class so when called on
	 * a Triangle object this method will run and will find the 
	 * area of the gien triangle by the formula b*h/2
	 * and returns that number as double
	 * @return a double which is the area of the triangle
	 */
	@Override
	public double getArea() {
		return (this.base * this.height) / 2;
	}
	
	/**
	 * draw
	 * 
	 * this is a method that takes a parameter of Graphics g
	 * and uses this to draw the triangle with the given 
	 * base, height, and (x,y) coordinates in a JFrame
	 * it also overrides the parent class when called on a Trianlge object
	 * @param Graphics g
	 */
	@Override
	public void draw (Graphics g) {
		g.drawLine(super.getX(), super.getY(), super.getX() + (base / 2), super.getY() + height);
		g.drawLine(super.getX() + (base / 2), super.getY() + height, super.getX() + base, super.getY());
		g.drawLine(super.getX() + base, super.getY(), super.getX(), super.getY());
	}
}
