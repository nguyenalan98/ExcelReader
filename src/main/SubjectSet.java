package main;

import java.util.ArrayList;

public class SubjectSet {
	ArrayList<Subject> subjects;
	
	public SubjectSet() {
		subjects = new ArrayList<Subject>();
	}

	public void add(Subject sub) {
		// TODO Auto-generated method stub
		subjects.add(sub);
	}
	
	public ArrayList<Subject> returnArray(){
		return subjects;
	}
}
