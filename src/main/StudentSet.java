package main;

import java.util.ArrayList;

public class StudentSet {
	ArrayList<Student> students;
	
	public StudentSet() {
		students = new ArrayList<Student>();
	}

	public void add(Student student) {
		// TODO Auto-generated method stub
		students.add(student);
	}

	@Override
	public String toString() {
		return "" + students + "";
	}
	
	public String toStringName() {
		String str = "";
		for(Student s : students) {
			str += s.name + "\n";
		}
		return str;
	}
	
	public ArrayList<Student> returnArray(){
		return students;
	}
}
