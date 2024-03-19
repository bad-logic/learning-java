package fundamentals.practise.test3.prob2;

import java.util.Arrays;
import java.util.List;

public class Admin {
	public static List<Student> convertArray(Student[] studentArray) {
		return Arrays.asList(studentArray);
	}

	public static double computeAverageGpa(List<Student> studentList) {
		double avg = 0;
		for(Student st:studentList){
			avg += st.computeGpa();
		}
		return avg / studentList.size();
	}
}
