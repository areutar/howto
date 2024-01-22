package numerical.RamanujanNumbers;

import static numerical.RamanujanNumbers.RamanujanNumbers.getRamanujanNumbers2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestRamanujanNumbers {
    public static void main(String[] args) throws IOException {
        int threshold = 1000;
        StringBuilder builder = new StringBuilder();

        long start = System.currentTimeMillis();
        List<List<Long>> sums = getRamanujanNumbers2(threshold);
        long end = System.currentTimeMillis();
        builder.append(String.format(
                "Для чисел меньших %d найдено %d чисел Рамануджана%n",
                threshold, sums.size()));
        builder.append(String.format(
                "Время выполнения - %dms%n%n",
                end - start));

        FileWriter writer = new FileWriter(
                "./src/numerical/RamanujanNumbers/java_test.txt",
                StandardCharsets.UTF_8);
        writer.write(builder.toString());
        for (List<Long> list : sums) {
            writer.write(list.toString() + System.lineSeparator());
        }
        writer.close();
    }
}