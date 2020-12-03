package main;

public class Language implements Subject{
	String name = "language";
	double score;
	
	public Language(double score) {
		this.score = score;
	}
	@Override
	public void printSubject() {
		System.out.println(name);
	}
	
	public double getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "Language = " + score;
	}

}