/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class Circle {
		private Point2D location;
		private int radius;
		private String shape = "O";
		
		public Circle() {
			this.location = new Point2D(0,0);
			this.radius = 1;
		}
		
		public Circle(int x, int y, int sideLength) {
			this.location = new Point2D(x,y);
			this.radius = sideLength;
		}
		
		public Circle(Point2D location) {
			this.location = location;
			this.radius = 1;
		}
		
		public void draw() {
			System.out.println(this.shape);
		}
		
		public String toString() {
			return "{" + shape + " location: " + location.toString() 
					+ ". Radius: " + radius + "}";
		}
		
		public boolean eqauls(Circle otherCircle) {
			if(otherCircle.location.equals(this.location) && 
					this.getRadius() == otherCircle.getRadius()) {
				return true;
			}else {
				return false;
			}
		}
		
		public int getX() {
			return location.getX();
		}
		
		public void setX(int newX) {
			this.location.setX(newX);
		}
		
		public int getY() {
			return location.getY();
		}
		
		public void setY(int newY) {
			this.location.setY(newY);
		}
		
		public double getArea() {
			return this.radius * this.radius * Math.PI;
		}

		public int getRadius() {
			return radius;
		}

		public void setRadius(int radius) {
			this.radius = radius;
		}

		public String getShape() {
			return shape;
		}

		public void setShape(String shape) {
			this.shape = shape;
		}
		
	}
