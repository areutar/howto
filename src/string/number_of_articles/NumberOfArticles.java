package string.number_of_articles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfArticles {
    public static int getNumberOfArticles(String input) {
        List<String> articles = List.of("an", "a", "the");
        List<String> words = Arrays.stream(input.split("\\s"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        return articles.stream()
                .mapToInt(article -> Collections.frequency(words, article))
                .sum();
    }
}
