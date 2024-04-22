package modernpractises.labs.lab10.lab10_01;

import java.util.Arrays;
import java.util.List;

public class GroupUtil {
    //Fix this code
    public static Group<?> copy(Group<?> group) {
        return copyHelper(group);
    }

    public static <T> Group<T> copyHelper(Group<T> group) {
        List<T> elements = group.getElements();
        Group<T> grp = new Group<>(group.getSpecialElement(), elements);
        return grp;
    } 
	
	//Test using this main method
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4);
		Group<Integer> group = new Group<>(0, list);
		System.out.println(group);
		System.out.println(GroupUtil.copy(group));
	}
}
