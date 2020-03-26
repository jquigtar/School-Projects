import java.awt.Graphics;

/**
 * 
 */

/**
 * Cylinder
 * 
 * this is a class that extends the Shape class and has 
 * ints height, and radius to determine the area as well as how to draw 
 * the shape 
 * @author jquigtar
 * @version 2/14/19
 *
 */
public class Cylinder extends Shape{

	private int radius;
	private int height;
	
	/**
	 * Cylinder
	 * 
	 * this is a constructor that sets the (x,y) coordinates for the 
	 * Cylinder as well as the radius and height
	 * @param x
	 * @param y
	 * @param radius
	 * @param height
	 */
	public Cylinder(int x, int y, int radius, int height) {
		super(x,y);
		this.radius = radius;
		this.height = -height;
	}
	
	/**
	 * getArea
	 * 
	 * this method overrides the parent class so when called on
	 * a Cylinder object this method will run and will find the 
	 * area of the given Cylinder by the formula 2*(PI*r^2) + (2*PI*r*h)
	 * and returns that number as double
	 * @return a double which is the area of the Cylinder
	 */
	@Override
	public double getArea() {
		double areaOfCircles = 2 * (Math.PI * this.radius * this.radius);
		double areaOfSides = 2 * Math.PI *this.radius * this.height;
		return areaOfCircles + areaOfSides;
	}
	
	/**
	 * draw
	 * 
	 * this is a method that takes a parameter of Graphics g
	 * and uses this to draw the Cylinder with the given 
	 * radius, height, and (x,y) coordinates in a JFrame
	 * it also overrides the parent class when called on a Cylinder object
	 * @param Graphics g
	 */
	@Override
	public void draw(Graphics g) {
		int diameter = radius * 2;
		g.drawOval(super.getX(),super.getY(),diameter,diameter);     // upper ellipse
		g.drawLine(super.getX(),super.getY() + this.radius,super.getX(),super.getY() + this.radius + height);     // left vertical line
		g.drawLine(super.getX() + diameter,super.getY() + this.radius,super.getX() + diameter,super.getY() + this.radius + height);   // right horizontal line
		g.drawOval(super.getX(),super.getY() + this.height,diameter,diameter);    // lower ellipse
	}
}
