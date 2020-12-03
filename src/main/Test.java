package main;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentSet students = new StudentSet();
		SubjectSet mathset = new SubjectSet();
		SubjectSet sciset = new SubjectSet();
		SubjectSet langset = new SubjectSet();
		Methods.readExcel(students, mathset, sciset, langset);
		students.students = (ArrayList<Student>)Methods.getPercentiles(students);
		System.out.println(students + "\n");
		System.out.println("Highest Math Score = " + Methods.getMax(mathset.returnArray()) + "\n" + (Methods.getMaxStudents(students,"math",mathset)).toStringName() );
		System.out.println("Highest Science Score = " + Methods.getMax(sciset.returnArray()) + "\n" + (Methods.getMaxStudents(students,"science",sciset)).toStringName() );
		System.out.println("Highest Language Score = " + Methods.getMax(langset.returnArray()) + "\n" + (Methods.getMaxStudents(students,"language",langset)).toStringName() );

		System.out.println("Lowest Math Score = " + Methods.getMin(mathset.returnArray()) + "\n" + (Methods.getMinStudents(students,"math",mathset)).toStringName() );
		System.out.println("Lowest Science Score = " + Methods.getMin(sciset.returnArray()) + "\n" + (Methods.getMinStudents(students,"science",sciset)).toStringName() );
		System.out.println("Lowest Language Score = " + Methods.getMin(langset.returnArray()) + "\n" + (Methods.getMinStudents(students,"language",langset)).toStringName() );
	}

}
