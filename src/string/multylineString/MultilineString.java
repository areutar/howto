package string.multylineString;

public class MultilineString {
    static String text = "line1\nline2\nline3";

    static String textWithConcatenation = "line1\n"
            .concat("line2\n")
            .concat("line3");

    static String textWithStringJoin = String.join("\n",
            "line1",
            "line2",
            "line3");

}
