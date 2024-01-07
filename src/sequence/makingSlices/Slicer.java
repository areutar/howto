package sequence.makingSlices;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Slicer {

	public static final String LIST_IS_NULL = "List is null!";

	public static void main(String[] args) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Slicer slicer = new Slicer();
		System.out.println(slicer.slice(alphabet, 2, 3, null));
		System.out.println(slicer.slice(alphabet, -2, -2, null));
		System.out.println(slicer.slice(alphabet, null, 5, null));
		System.out.println(slicer.slice(alphabet, null, -2, null));
		System.out.println(slicer.slice(alphabet, null, null, 2));
		System.out.println(slicer.slice(alphabet, 1, null, 2));
		System.out.println(slicer.slice(alphabet, null, null, -1));
		System.out.println(slicer.slice(alphabet, null, null, -2));
	}

	public String slice(String input, Integer start,
			Integer end, Integer step) {
		List<String> chars = input.chars()
				.mapToObj(i -> String.valueOf((char) i))
				.collect(Collectors.toList());
		return String.join(
				"", slice(
						chars, start, end, step));
	}

	public <T> List<T> slice(List<T> list, Integer start,
			Integer end, Integer step) {

		if (list == null) {
			throw new IllegalArgumentException(LIST_IS_NULL);
		}

		if (list.isEmpty()) {
			return list;
		}

		RangeConfigurator configurator = new RangeConfigurator(start, end, step, list.size());

		int cStart = configurator.getStart();
		int cEnd = configurator.getEnd();
		int cStep = configurator.getStep();
		return IntStream.iterate(cStart,
				i -> (cStart <= cEnd && i <= cEnd - 1)
						|| (cStart >= cEnd && i >= cEnd + 1),
				i -> i + cStep)
				.mapToObj(list::get)
				.collect(Collectors.toList());
	}
}