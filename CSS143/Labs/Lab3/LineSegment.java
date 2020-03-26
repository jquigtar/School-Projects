/**
 * 
 */

/**
 * LineSegment
 * 
 * this is a class that uses two Point2D
 * objects as a start and enpoint for a LineSegment
 * @author jquigtar
 *
 */
public class LineSegment {
	//1)a privacy leak is when the original memory can be accessed
	//2)almost all getters and setters we used in past had privacy leaks
	//3)privacy leaks can also occur in point2d class 

	private Point2D startPoint;
	private Point2D endPoint;
	
	//default start and end point is both (0,0)
	public LineSegment() {
		this.startPoint = new Point2D(0,0);
		this.endPoint = new Point2D(0,0);
	}
	
	/**
	 * LineSegment (constructor)
	 * 
	 * this is a constructor that takes two point2D objects
	 * and sets them as a start and end points of the 
	 * LineSegment
	 * @param start
	 * @param end
	 */
	public LineSegment(Point2D start, Point2D end) {
		if(start != null && end != null) {
			Point2D copyStart = new Point2D(start.getX(), start.getY());
			Point2D copyEnd = new Point2D(end.getX(), end.getY());
			this.startPoint = copyStart;
			this.endPoint = copyEnd;
		}
	}
	
	//copy constructor
	public LineSegment(LineSegment other) {
		this.startPoint = other.startPoint;
		this.endPoint = other.endPoint;
	}
	
	
	/**
	 * distance
	 * 
	 * this is a function that returns the distance between 
	 * the start and ending points of a line segment
	 * @return returns the distance between the start and end points
	 * as a double
	 */
	public double distance() {
		double x = Math.abs((this.startPoint.getX() - this.endPoint.getX()));
		double y = (this.startPoint.getY() - this.endPoint.getY());
		double x2 = x * x;
		double y2 = y * y;
		double distance = Math.sqrt(x2 + y2);
				
		return distance;
	}

	/**
	 * toString
	 * 
	 * this is a function that returns a string for the 
	 * LineSegment
	 * @return returns a string of the LineSegment
	 * 			in the form "Line start (a,b) and end(c,d)
	 */
	public String toString () {
		return "Line start" + this.startPoint.toString() +
				" and end" + this.endPoint.toString();
	}
	
	/**
	 * equals
	 * 
	 * @return returns true if the two lineSegments are the same
	 * 			returns false if the object being passed in is
	 * 			null, not a LineSegment  or not equal to the 
	 * 			LineSegment it is called on
	 */
	public boolean equals(Object other) {
		if(other == null || !(other instanceof LineSegment)) {
			return false;
		}
		LineSegment that = (LineSegment) other;
		if(this.startPoint.equals(that.startPoint) && this.endPoint.equals(that.endPoint)) {
			return true;
		}else {
			return false;
		}
	}
	
	public Point2D getStartPoint() {
		Point2D copyStart = new Point2D(this.startPoint.getX(),this.startPoint.getY());
		return copyStart;
	}

	public void setStartPoint(Point2D start) {
		Point2D setStart = new Point2D(start.getX(), start.getY());
		this.startPoint = setStart;
	}

	public Point2D getEndPoint() {
		Point2D copyEnd = new Point2D(this.endPoint.getX(),this.endPoint.getY());
		return copyEnd;
	}

	public void setEndPoint(Point2D end) {
		Point2D setEnd = new Point2D(end.getX(), end.getY());
		this.endPoint = setEnd;
	}
	
	
}
