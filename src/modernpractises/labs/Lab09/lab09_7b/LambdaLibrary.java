package modernpractises.labs.Lab09.lab09_7b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {

    public static final TriFunction<List<Employee>, Integer , String , String> FILTERED_NAMES_IN_LIST = (lists, salary, lastNameGreaterThan)->lists.stream()
            .filter(x->x.getSalary() > salary)
            .filter(x-> (int) x.getLastName().charAt(0) > (int) lastNameGreaterThan.charAt(0))
            .map(x-> x.getFirstName() + " " + x.getLastName())
            .sorted()
            .collect(Collectors.joining(", "));
}
