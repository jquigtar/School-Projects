import java.util.ArrayList;

/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class StudentDB implements Cloneable{

	private ArrayList<Student> students = new ArrayList<Student>();
	
	public ArrayList<Student> getStudents() {
		ArrayList<Student> copy = new ArrayList<Student>(this.students.size());
		for(int i = 0; i< copy.size(); i++) {
			copy.set(i, this.students.get(i));
		}
		return copy;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	public StudentDB() {
		
	}

	public StudentDB(StudentDB other) {
		this.setStudents(other.getStudents());
	}
	
	public void add(Student s) {
		Student copy = s.clone();
		students.add(copy);
	}
	
	public boolean equals(Object other) {
		if(other == null || !(other instanceof StudentDB)) {
			return false;
		}
		
		StudentDB that = (StudentDB) other;
		
		
		if(this.students.size() == that.students.size()) {
			for(int i = 0; i < that.students.size(); i++) {
				if(!(this.students.get(i).equals(that.students.get(i))) || 
						this.students.get(i) == that.students.get(i)){
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public StudentDB clone() {
		return new StudentDB(this);
	}
}
