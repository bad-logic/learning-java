package fundamentals.practise.test3.prob2;

import java.util.List;

public class FulltimeStudent extends Student {
	private FulltimeTranscriptRecord record;
	public FulltimeStudent(String name, FulltimeTranscriptRecord record) {
		super(name);
		this.record = record;
	}
	
	public double computeGpa() {
		List<Double> fallGrades = record.getFallTranscript().getRecord();
		List<Double> springGrades = record.getSpringTranscript().getRecord();
		if(fallGrades.isEmpty() && springGrades.isEmpty()) return 0.0;
		double sum = 0.0;
		for(Double d : fallGrades) {
			sum += d.doubleValue();
		}
		for(Double d : springGrades) {
			sum += d.doubleValue();
		}
		return sum / (fallGrades.size() + springGrades.size());
	}
	
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof FulltimeStudent)) return false;
		FulltimeStudent fts = (FulltimeStudent)ob;
		return this.getName().equals(fts.getName());
	}
	
	public String toString() {
		return this.getName();
	}
}
