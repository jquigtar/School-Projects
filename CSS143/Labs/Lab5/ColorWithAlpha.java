/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class ColorWithAlpha extends SimpleColor {

	private int alpha;

	public ColorWithAlpha(int alpha) {
		this.setAlpha(alpha);
		this.setColor(0, 0, 0);
	}
	
	public ColorWithAlpha(int r, int g, int b, int a) {
		super(r,g,b);
		this.setAlpha(a);
	}
	
	public ColorWithAlpha(ColorWithAlpha toCopy) {
		int r = toCopy.getR();
		int g = toCopy.getG();
		int b = toCopy.getB();
		int a = toCopy.getAlpha();
		this.setColor(r, g, b);
		this.setAlpha(a);
	}
	
	public int getAlpha() {
		int copy = this.alpha;
		return copy;
	}

	public void setAlpha(int alpha) {
		if(alpha < 0 || alpha > 255) {
			throw new ColorException("out of bounds; [0,255]");
		}
		this.alpha = alpha;
	}
	
	/**
	 * toString
	 * 
	 * this is a method that displays the colarWithAlpha as a string
	 * @return String in the form "r: ###, g: ###, b: ###, alpha: ###
	 */
	@Override
	public String toString() {
		 return super.toString() + ", alpha: "+ this.getAlpha();
	}
	
	/**
	 * equals
	 * 
	 * this is a method that checks that the object passed in is not null and 
	 * is an instanceof colorWithAlpha, if not it will return false, otherwise
	 * it will compare to the colorWithAlpha object it is called on and see if 
	 * r, g, b, a are all equal
	 * @param object o
	 * @return true if r, g, b,a all equal false if not and if null or 
	 * 			not an instanceof colorWithAlpha
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof ColorWithAlpha)) {
			return false;
		}
		
		
		ColorWithAlpha that = (ColorWithAlpha) o;
		//SimpleColor colorThat = (SimpleColor) o;
		//SimpleColor colorThis = (SimpleColor) this;
		
		if(this.getAlpha() == that.getAlpha() && this.getR() == that.getR() && 
				this.getG() == that.getG() && this.getB() == that.getB()){
			return true;
		}else {
			return false;
		}
	}
}
