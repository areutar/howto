package numerical.RamanujanNumbers;

import static numerical.RamanujanNumbers.RamanujanNumbers.getRamanujanNumbers;

import java.util.Arrays;
import java.util.List;

public class TestRamanujanNumbers {
    public static void main(String[] args) {
        List<Integer> thresholds = Arrays.asList(50, 100, 150, 200);
        StringBuilder builder = new StringBuilder();
        for (Integer threshold : thresholds) {
            long start = System.currentTimeMillis();
            List<List<Integer>> sums = getRamanujanNumbers(threshold);
            long end = System.currentTimeMillis();
            builder.append(String.format(
                    "Для чисел меньших %d найдено %d чисел Рамануджана%n",
                    threshold, sums.size()));
            builder.append(String.format(
                    "Время выполнения - %dms%n%n",
                    end - start));
        }
        System.out.println(builder.toString());
    }

}