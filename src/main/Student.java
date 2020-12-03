package main;

import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Comparator<Student>, Comparable<Student>{
	int id;
	String name;
	ArrayList<Subject> scores = new ArrayList<Subject>();
	double scoreTotal;
	double percentile;
	
	public Student(int id, String name, double math, double science, double language) {
		this.id = id;
		this.name = name;
		scores.add(new Math(math));
		scores.add(new Science(science));
		scores.add(new Language(language));
		scoreTotal = math + science + language;
	}

	@Override
	public String toString() {
		return name + ": (" + scores + "), total score: " + scoreTotal + " percentile:" + String.format("%.2f", percentile) + "\n";
	}

	public double getScore(String name) {
		if(name == "math") {
			return scores.get(0).getScore();
		}
		else if(name == "science") {
			return scores.get(1).getScore();
		}
		else if(name == "language") {
			return scores.get(2).getScore();
		}
		else {
			return scoreTotal;
		}
	}
	
	public int compareTo(Student s) {
		return (int) (s.scoreTotal - this.scoreTotal);
	}
	
	public int compare(Student a, Student b) {
		return (int) (a.scoreTotal-b.scoreTotal);
	}
	
}
