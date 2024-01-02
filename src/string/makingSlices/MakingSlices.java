package string.makingSlices;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakingSlices {
    private final String text;

    public MakingSlices(String text) {
        this.text = text;
    }

    public void makingSlices() {
        Integer[][] slices = {
                { 2, 3, null },
                { -2, -1, null },
                { null, 5, null },
                { null, -2, null },
                { null, null, 2 },
                { null, null, 3 },
                { 1, null, 2 },
                { -1, null, -1 },
                { -1, null, -2 },
                { -1, null, -3 },
                { 3, 2, -1 },
                { 2, 3, 0 },
                { 0, 1, 1 },
                { 0, 2, null },
                {0, 7, null},
                {1, null, null},
                {1, null, -1},
                {1, 1, 1},
                {1, 1, 0},
                {0, 0, 0},
        };

        Arrays.stream(slices)
                .forEach(slice -> System.out.println(
                        range(slice[0], slice[1], slice[2])
                                .mapToObj(i -> text.charAt(i))
                                .map(String::valueOf)
                                .collect(Collectors.joining())));
    }

    private IntStream range(Integer a, Integer b, Integer c) {
        RangeConfigurator configurator = new RangeConfigurator(a, b, c, text.length());
        int start = configurator.getStart();
        int end = configurator.getEnd();
        int step = configurator.getStep();
        return IntStream.iterate(start,
                i -> (start <= end && i <= end - 1)
                        || (start >= end && i >= end + 1),
                i -> i + step);
    }

}