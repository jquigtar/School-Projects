 import java.io.Serializable;
 
/**
 * @author jquigtar
 *
 */
public class Student implements Comparable<Student>, Cloneable, Serializable, Runnable {
	
	private String name;
	private double GPA;
	
	public Student(String name, double gpa) {
		this.name = name;
		this.GPA = gpa;
	}
	
	public Student(Student other) {
		this.GPA = other.getGPA();
		this.name = other.getName();
	}
	
	public String getName() {
		String copy = this.name;
		return copy;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getGPA() {
		double copy = this.GPA;
		return copy;
	}
	
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Student)) {
			return false;
		}
		
		Student that = (Student) other;
		
		if(this.getGPA() == that.getGPA() && this.getName().equals(that.getName())) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString(){
		return this.name + ":" + this.GPA; 
	}

	@Override
	public int compareTo(Student o) {
		if(o.getGPA() == this.getGPA()) {
			return 0;
		}else if(o.getGPA() < this.getGPA()) {
			return 1;
		}else {
			return -1;
		}
	}
	
	@Override
	public Student clone() {
		return new Student(this);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < this.name.length(); i++) {
			System.out.println(this.name.charAt(i));
		}
	}
}
