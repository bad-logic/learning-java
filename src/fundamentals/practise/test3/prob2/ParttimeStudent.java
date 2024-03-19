package fundamentals.practise.test3.prob2;
import java.util.*;
public class ParttimeStudent extends Student {
	private ParttimeTranscriptRecord record;
	public ParttimeStudent(String name, ParttimeTranscriptRecord record) {
		super(name);
		this.record = record;
	}
	
	public double computeGpa() {
		List<Double> grades = record.getRecord();
		if(grades.isEmpty()) return 0.0;
		double sum = 0.0;
		for(Double d : grades) {
			sum += d.doubleValue();
		}
		return sum / grades.size();
	}

	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof ParttimeStudent)) return false;
		ParttimeStudent pts = (ParttimeStudent)ob;
		return this.getName().equals(pts.getName());
	}
	public String toString() {
		return this.getName();
	}
}
