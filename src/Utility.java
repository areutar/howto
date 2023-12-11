import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Utility {
    public static final int MAX_SIZE_LINE = 44;

    public static void main(String[] args) {
        String input = "Shakespeare’s most famous plays include Romeo and Juliet, Macbeth, Hamlet, King Lear, Othello, and Julius Caesar. Usually, Shakespeare did not invent the stories that he told in his plays. Instead, he wrote his plays using stories that already existed. However, Shakespeare’s plays told these stories in a more interesting way than ever before. Some of the stories were tragedies, some were comedies, and some described historical events.";
        setClipboardContents(splitStringInTextBlock(input));
    }

    public static String splitString(String input) {
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

    public static String splitStringInTextBlock(String input) {
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

    public static void setClipboardContents(String srcData) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(srcData), null);

    }
}

// Добавление страницы
// создаю страницу документа, например, в разделе Strings
// в этом же разделе записываю на неё ссылку в _sidebar.md
// там же на странице раздела strings, размещаю короткую аннотацию
