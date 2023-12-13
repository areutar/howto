package utility;

import java.util.stream.Collectors;
import static utility.ClipboardInOut.*;

public class CsvStringsBuilder {
    public static final int MAX_SIZE_LINE = 44;

    public static void main(String[] args) {
        String input = getTextFromClipboard();
        String output = prepareCsv(input);
        System.out.println(output);
        setTextToClipboard(output);
    }

    // подготавливает из табличных данных строки csv
    // все данные должны быть не пусты
    public static String prepareCsv(String input) {
        return input.lines()
                .map(str -> {
                    String[] lineTokens = str.split("\\s+");
                    return "\"" + lineTokens[0] + ", "
                            + lineTokens[1] + "\",";
                })
                .collect(Collectors.joining("\n"));
    }

}
