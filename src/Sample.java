import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        String input = "Cdef 1B1sfs";
        System.out.println(isTitle(input));
    }

    public static boolean isTitle(String input) {
        return Arrays.stream(input.split("\\s+"))
                .allMatch(s -> {
                    return s.substring(1).chars()
                            .mapToObj(i -> (char) i)
                            .allMatch(Character::isLowerCase)
                            && Character.isUpperCase(s.charAt(0));
                });

    }
}