package sequence.mergeOrderedLists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MergeOrderedLists {
    public static List<Integer> mergeOrderedLists(
            List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue1 = new ArrayDeque<>(list1);
        Queue<Integer> queue2 = new ArrayDeque<>(list2);
        Integer elem1 = queue1.poll();
        Integer elem2 = queue2.poll();
        while (elem1 != null || elem2 != null) {
            if (elem1 == null || (elem2 != null && elem2 <= elem1)) {
                result.add(elem2);
                elem2 = queue2.poll();
                continue;
            }
            if (elem2 == null || (elem1 != null && elem2 >= elem1)) {
                result.add(elem1);
                elem1 = queue1.poll();
            }
        }
        return result;
    }

}