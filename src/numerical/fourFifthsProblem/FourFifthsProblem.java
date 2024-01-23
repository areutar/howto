package numerical.fourFifthsProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import static java.lang.Math.*;

public class FourFifthsProblem {
    public static List<List<Long>> fourFifthsProblem(int threshold) {
        List<Long> degrees5 = LongStream.range(0, threshold)
                .map(i -> i * i * i * i * i)
                .boxed()
                .collect(Collectors.toList());
        List<List<Long>> result = new ArrayList<>();

        for (int i = 1; i < threshold; i++) {
            for (int j = i; j < threshold; j++) {
                for (int k = j; k < threshold; k++) {
                    for (int l = k; l < threshold; l++) {
                        double root = pow(
                                degrees5.get(i) + degrees5.get(j)
                                        + degrees5.get(k) + degrees5.get(l),
                                0.2);

                        if ((root - (long) root) < 0.0000000000001) {
                            result.add(Arrays.asList(
                                    (long) i, (long) j, (long) k,
                                    (long) l, (long) root));
                        }
                    }
                }
            }
        }
        return result;
    }
}