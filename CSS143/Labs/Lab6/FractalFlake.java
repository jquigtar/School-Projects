import java.awt.Graphics;

/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class FractalFlake extends Shape {

	private final int limit = 7;
	private final int numBranches = 12;
	private int size;
	
	public FractalFlake(int x, int y, int size) {
		super(x,y);
		this.size = size;
	}
	
	@Override
	public void draw(Graphics g) { //a redirect or facade

	     draw(g,getX(), getY(), this.limit);
	}
	
	private void draw(Graphics g, int startX, int startY, int limit) {

	     if(limit>= 3) { //base case is depth <3

	          for ( int i = 0; i < numBranches; i++ ) {

	               int x2 = startX + (int) (size * Math.cos( (2 * Math.PI / numBranches) * i ));

	               int y2 = startY - (int) (size * Math.sin( (2 * Math.PI / numBranches) * i ));

	               g.drawLine( startX, startY, x2, y2 ); //do a branch

	               draw(g, x2, y2, limit/3); //recursive call

	          }

	     }

	}
}
