package string.findAllOccurrences;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllOccurrences {
    public static List<Integer> findAllOccurrences(
        String target, char ch) {
   return IntStream.range(0, target.length())
   .filter(i -> target.charAt(i) == ch)
   .boxed()
   .collect(Collectors.toList());    
  }
}
