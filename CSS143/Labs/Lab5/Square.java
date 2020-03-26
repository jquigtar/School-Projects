import java.awt.Color;
import java.awt.Graphics;
/**
 * @author jquigtar
 *
 */
public class Square extends Shape {

	private int base;
	private int height;
	private Color myColor;
	
	public Square(int x, int y, int base, int height) {
		super(x, y);
		this.base = base;
		this.height = height;
	}
	
	@Override 
	public double getArea() {
		return this.base * this.height;
	}
	
	@Override 
	public void draw(Graphics g) {
		g.draw3DRect(super.getX(), super.getY(), this.base, this.height, true);

	}
}
