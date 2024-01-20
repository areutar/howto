package numerical.RamanujanNumbers;

import java.util.ArrayList;
import java.util.List;

public class RamanujanNumbers {
    public static List<List<Integer>> getSumOfCubes(int threshold) {
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = 0; i < threshold; i++) {
            for (int j = 0; j < threshold; j++) {
                if (i >= j) {
                    continue;
                } else {
                    sums.add(List.of(i, j, i * i * i + j * j * j));
                }
            }
        }
        return sums;

    }

    public static List<List<Integer>> getRamanujanNumbers(int threshold) {
        List<List<Integer>> sums = getSumOfCubes(threshold);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> sum1 : sums) {
            for (List<Integer> sum2 : sums) {
                if (sum1.get(2).equals(sum2.get(2))
                        && !sum1.get(0).equals(sum2.get(0))) {
                    result.add(sum1);
                }
            }
        }
        result.sort((o1, o2) -> o1.get(2) - o2.get(2));
        return result;
    }

}