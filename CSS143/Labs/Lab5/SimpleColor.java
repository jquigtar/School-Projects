//TODO: document the code with comments
//and fix the setters so they don't invalidate the [0-255] rule
public class SimpleColor {
	private int r;
	private int g;
	private int b;
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		if(r < 0 || r > 255) {
			throw new ColorException("Out of bounds: [0,255]");
		}
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		if(g < 0 || g > 255) {
			throw new ColorException("Out of bounds: [0,255]");
		}
		this.g = g;
	}

	public int getB(){
		return b;
	}

	public void setB(int b) {
		if(b < 0 || b > 255) {
			throw new ColorException("Out of bounds: [0,255]");
		}
		this.b = b;
	}

	public void setColor(int a, int b, int c) {
		setR(a);
		setG(b);
		setB(c);
	}
	public SimpleColor() {}
	
	public SimpleColor(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}
	public SimpleColor(SimpleColor b) {
		this(b.r,b.g,b.b);
	}
	
	/**
	 * toString
	 * 
	 * this is a method that takes each part of the color
	 * the red green and blue and displays it as a string
	 * @return a string in the form "r: ###, g: ###, b: ###
	 */
	public String toString() {
		return "r: " + this.getR() + ", g: " + this.getG() + ", b; " + this.getB();
	}
	
	/**
	 * equals
	 * 
	 * this is a method that checks that the object passed in is not null
	 * and an instance of simpleColor if it is not it will return false
	 * otherwise it will check to seet that the R, G, and B are all the same
	 * for both colors
	 * @param object o
	 * @return true for two SimpleColors with same r,g and b
	 * 			false if not and if null, or not a simpleColor
	 */
	public boolean equals(Object o) {
		if(o == null || !(o instanceof SimpleColor)) {
			return false;
		}
		
		SimpleColor that = (SimpleColor) o;
		
		if(this.getR() == that.getR() && this.getG() == that.getG() && this.getB() == that.getB()){
			return true;
		}else {
			return false;
		}
	}
}
