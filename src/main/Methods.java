package main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Methods {

	public static double getMax(ArrayList<Subject> arrayList) {
		double max = 0;
		if(arrayList.size() != 0) {
			for(Subject x : arrayList) {
				if(x.getScore() > max) {
					max = x.getScore();
				}
			}
		}
		return max;
	}
	
	public static double getMin(ArrayList<Subject> arrayList) {
		double min = 100;
		if(arrayList.size() != 0) {
			for(Subject x : arrayList) {
				if(x.getScore() < min) {
					min = x.getScore();
				}
			}
		}
		return min;
	}
	
	public static StudentSet getMaxStudents(StudentSet array,String subject, SubjectSet set) {
		double num = getMax(set.returnArray());
		StudentSet students = new StudentSet();
		for(Student s : array.returnArray()) {
			if(s.getScore(subject) == num) {
				students.add(s);
			}
		}
		return students;
	}
	
	public static StudentSet getMinStudents(StudentSet array,String subject, SubjectSet set) {
		double num = getMin(set.returnArray());
		StudentSet students = new StudentSet();
		for(Student s : array.returnArray()) {
			if(s.getScore(subject) == num) {
				students.add(s);
			}
		}
		return students;
	}
	
	public static List<Student> getPercentiles(StudentSet array) {
		List<Student> sortList = (array.returnArray());
		Collections.sort(sortList,Collections.reverseOrder());
		
		for(Student s: sortList) {
			double index = sortList.lastIndexOf(s)+1;
			double percent = (index/sortList.size()*100);
			s.percentile = percent;
		}
		return sortList;
	}
	
	public static void readExcel(StudentSet students, SubjectSet mathSet, SubjectSet sciSet, SubjectSet langSet) {
		try {
			File file = new File("C:\\Users\\nguye\\Documents\\Work\\Students.xlsx");
			FileInputStream fs = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> it = sheet.iterator();
			
			//iterate past first row
			it.next();
			int id = 1;
			while(it.hasNext()) {
				Row row = it.next();
				Iterator<Cell> itcell = row.cellIterator();
				
				String name = itcell.next().getStringCellValue();
				double math = itcell.next().getNumericCellValue();
				double science = itcell.next().getNumericCellValue();
				double language = itcell.next().getNumericCellValue();
				
				mathSet.add(new Math(math));
				sciSet.add(new Science(science));
				langSet.add(new Language(language));
				
				Student student = new Student(id,name,math,science,language);
				students.add(student);
				id = id + 1;
			}
			workbook.close();
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
}
	
}
