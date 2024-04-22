package modernpractises.labs.lab10.lab10_02;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static <T> T getSecondSmallestElement(List<T> list) {
        if(list.size() <= 1 || list == null) {
            return null;
        }   


        var sortedList =  list.stream()
            .sorted()
            .distinct()
            .collect(Collectors.toList());

        if(sortedList.size() == 1) {
            return null;
        }

        return sortedList.get(0);

        
    }    

    public static void main(String[] args) {

    }
}
