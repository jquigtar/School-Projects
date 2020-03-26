import java.awt.Color;
import java.awt.Graphics;

/**
 * @author jquigtar
 *
 */
public class Circle extends Shape {

	private double radius;
	private Color myColor;
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}
	
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
