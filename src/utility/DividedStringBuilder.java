package utility;
import static utility.ClipboardInOut.getTextFromClipboard;
import static utility.ClipboardInOut.setTextToClipboard;

public class DividedStringBuilder {
    public static final int MAX_SIZE_LINE = 44;

    public static void main(String[] args) {
        String input = getTextFromClipboard();
        String output = divideString(input);
        System.out.println(output);
        setTextToClipboard(output);
    }


    // преобразует длинную строку в сумму коротких,
    // каждая размера примерно MAX_SIZE_LINE
    public static String divideString(String input) {
        input = input.trim();
        String result = "";
        String[] words = input.split("\\s+");
        String line = "\"";
        boolean firstLine = true;

        for (int j = 0; j < words.length; j++) {
            line += words[j];
            if (j == words.length - 1) {
                return result + " + " + line + "\"";
            }

            if (line.length() < MAX_SIZE_LINE) {
                line += " ";
            } else {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += " + ";
                }
                result += line + " \"\n";
                line = "\"";
            }
        }
        return result.stripTrailing();
    }

}

// Добавление страницы
// создаю страницу документа, например, в разделе Strings
// в этом же разделе записываю на неё ссылку в _sidebar.md
// там же на странице раздела strings, размещаю короткую аннотацию
