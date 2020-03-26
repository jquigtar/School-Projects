import java.awt.Color;
import java.awt.Graphics;

/**
 * Circle
 * 
 * this is a class that extends the Shape class and has 
 * an int radius to determine the area as well as how to draw 
 * the shape 
 * @author jquigtar
 * @version 2/14/19
 *
 */
public class Circle extends Shape {

	private double radius;
	private Color myColor;
	
	/**
	 * Circle
	 * 
	 * this is a constructor that sets the (x,y) coordinates for the 
	 * Circle as well as the radius
	 * @param x
	 * @param y
	 * @param radius
	 * @param height
	 */
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	/**
	 * getArea
	 * 
	 * this method overrides the parent class so when called on
	 * a Circle object this method will run and will find the 
	 * area of the given Circle by the formula PI*r^2
	 * and returns that number as double
	 * @return a double which is the area of the Circle
	 */
	@Override
	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}
	
	/**
	 * draw
	 * 
	 * this is a method that takes a parameter of Graphics g
	 * and uses this to draw the Cirlce with the given 
	 * radius, and (x,y) coordinates in a JFrame
	 * it also overrides the parent class when called on a Circle object
	 * @param Graphics g
	 */
	@Override
	public void draw(Graphics g) {
		
	    int diameter = (int) radius*2;

	    g.drawOval(this.getX(),this.getY(), diameter, diameter);
	}
	
	public Color getMyColor() {
		return myColor;
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}

	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
