package main;

public class Science implements Subject{
	String name = "science";
	double score;
	
	public Science(double score) {
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
		return "Science = " + score;
	}

}