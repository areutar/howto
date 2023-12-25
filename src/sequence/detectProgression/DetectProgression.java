package sequence.detectProgression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class DetectProgression {
    public static void detectProgression(List<Integer> numbers) {
        List<Integer> copyList = new ArrayList<>(numbers);
        Collections.sort(copyList);
        boolean result = IntStream.range(0, copyList.size() - 1)
                .map(i -> copyList.get(i + 1) - copyList.get(i))
                .distinct()
                .count() == 1L;
        System.out.println(result);
    }
}