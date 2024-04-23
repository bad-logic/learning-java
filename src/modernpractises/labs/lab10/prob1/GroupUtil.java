package modernpractises.labs.lab10.prob1;

import java.util.*;

public class GroupUtil {

	// unbounded wild card approach
	// wildcard capturing
	public static Group<?> copyHelper(Group<?> group) {
		return GroupUtil.copy(group);
	}
	//Fix this code
	public static <T> Group<T> copy(Group<T> group) {
		List<T> elements = group.getElements();
		return new Group<T>(group.getSpecialElement(), elements);
	}
	
	//Test using this main method
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4);
		Group<Integer> group = new Group<Integer>(0, list);
		System.out.println(group);
		System.out.println(GroupUtil.copyHelper(group));
	}
}
