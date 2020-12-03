package main;

public class Math implements Subject{
	String name = "math";
	double score;
	
	public Math(double score) {
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
		return "Math = " + score;
	}
	

}