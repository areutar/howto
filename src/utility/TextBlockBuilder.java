package utility;
import static utility.ClipboardInOut.getTextFromClipboard;
import static utility.ClipboardInOut.setTextToClipboard;

public class TextBlockBuilder {
    public static final int MAX_SIZE_LINE = 44;

    public static void main(String[] args) {
        String input = getTextFromClipboard();
        String output = convertStringInTextBlock(input);
        System.out.println(output);
        setTextToClipboard(output);
    }

    // преобразует длинную строку в текстовый блок из коротких строк
    // каждая размера примерно MAX_SIZE_LINE
    // текстовый блок подходит для python (java since 15)
    public static String convertStringInTextBlock(String input) {
        input = input.trim();
        String result = "";
        String[] words = input.split("\\s+");
        String line = "\"\"\"";

        for (int j = 0; j < words.length; j++) {
            line += words[j];
            if (j == words.length - 1) {
                return result + line + "\"\"\"";
            }

            line += " ";
            if (line.length() >= MAX_SIZE_LINE) {
                result += line + " \n";
                line = "";
            }
        }
        return result;
    }
    
}

// Добавление страницы
// создаю страницу документа, например, в разделе Strings
// в этом же разделе записываю на неё ссылку в _sidebar.md
// там же на странице раздела strings, размещаю короткую аннотацию
