package numerical.RamanujanNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RamanujanNumbers {
    public static List<List<Long>> getRamanujanNumbers2(int threshold) {
        Map<Long, List<Long>> mapSumPairs = new HashMap<>();
        List<List<Long>> result = new ArrayList<>();
        long[] cubes = new long[threshold];
        for (long i = 0; i < threshold; i++) {
            cubes[(int) (i)] = i * i * i;
        }

        for (int i = 0; i < threshold; i++) {
            for (int j = 0; j < threshold; j++) {
                if (i < j) {
                    Long sum = cubes[i] + cubes[j];
                    List<Long> currents = new ArrayList<Long>(
                            Arrays.asList((long) i, (long) j));

                    mapSumPairs.merge(sum, currents, (t, u) -> {
                        t.addAll(u);
                        return t;
                    });
                }
            }
        }

        for (Map.Entry<Long, List<Long>> pair : mapSumPairs.entrySet()) {
            if (pair.getValue().size() > 2) {
                List<Long> current = new ArrayList<>(pair.getValue());
                current.add(0, pair.getKey());
                result.add(current);
            }
        }

        result.sort((o1, o2) -> (int) (o1.get(0) - o2.get(0)));
        return result;
    }
}