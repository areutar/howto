package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestGenerator {
        private static final String sep = System.lineSeparator();
        private static final Map<String, String> numbers = Map.of(
                        "Null", "null",
                        "Zero", "0",
                        "One", "1",
                        "Two", "2",
                        "Four", "4",
                        "Fife", "5",
                        "MinusOne", "-1",
                        "MinusTwo", "-2");

        private static final List<String> starts = Arrays.asList(
                        "Null", "Zero", "One", "Four", "Fife");

        private static final List<String> ends = Arrays.asList(
                        "Null", "Zero", "One", "Four", "Fife");

        private static final List<String> steps = Arrays.asList(
                        "Null", "MinusTwo", "MinusOne", "Zero", "One", "Two");

        public static void main(String[] args) throws IOException {
                BufferedWriter writer = new BufferedWriter(
                                new FileWriter(
                                                "src\\utility\\tests.txt"));

                StringBuilder builder = new StringBuilder();

                for (String start : starts) {
                        for (String end : ends) {
                                for (String step : steps) {
                                        builder.append(
                                                        generate(start, end, step));
                                }
                        }
                }

                writer.write(builder.toString());
                writer.close();

        }

        public static String generate(String... args) {
                String[] lines = new String[8];
                lines[0] = "@Test";

                lines[1] = "public void "
                                + "whenStartIs" + args[0]
                                + "EndIs" + args[1]
                                + "StepIs" + args[2]
                                + "ThenReturnList(){";

                lines[2] = "    List<Integer> expected = "
                                + "Arrays.asList(0);";

                lines[3] = "    List<Integer> actual = "
                                + "new MakingSlices().makingSlices(";

                lines[4] = "            givenList, "
                                + numbers.get(args[0]) + ", "
                                + numbers.get(args[1]) + ", "
                                + numbers.get(args[2]) + ");";

                lines[5] = "    assertEquals(expected, actual);";

                lines[6] = "}";
                lines[7] = sep;

                return String.join(sep, lines);

        }
}
