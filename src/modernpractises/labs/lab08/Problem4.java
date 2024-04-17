package modernpractises.labs.lab08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Problem4 {

    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen", "Kristy","alexa"};
        Consumer<String[]> sort = x -> Arrays.sort(x,String::compareToIgnoreCase);
        sort.accept(names);
        System.out.println(Arrays.toString(names));

        List<String> namesList = Arrays.asList(names);
        Consumer<List<String>> print = System.out::println;
        print.accept(namesList);
    }
}
