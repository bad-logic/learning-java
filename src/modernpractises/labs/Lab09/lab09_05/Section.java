package modernpractises.labs.Lab09.lab09_05;

import java.util.Arrays;
import java.util.stream.Stream;

public class Section {

    private static Stream<String> nextStream() {
        return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh","iii").stream();
    }

    public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
        if(m <  0 || n < 0 || m > n) return Stream.ofNullable(null);
        return stream.skip(m).limit(n - m + 1);
    }

    public static void main(String[] args) {
        // Make three calls for the streamSection() method with different inputs
        // use nextStream() method to supply the Stream input as a first argument in
        // streamSection method

        Section.streamSection(Section.nextStream(),-2,4).forEach(System.out::println);
        Section.streamSection(Section.nextStream(),2,5).forEach(System.out::println);
        Section.streamSection(Section.nextStream(),5,8).forEach(System.out::println);

    }


}
