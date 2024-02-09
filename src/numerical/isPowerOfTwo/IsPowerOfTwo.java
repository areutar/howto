package numerical.isPowerOfTwo;

public class IsPowerOfTwo {
    public static void isPowerOfTwo1(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = value != 0 &&
                Integer.highestOneBit(value) == value;
        System.out.println(result);
    }

    public static void isPowerOfTwo2(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = Integer.toBinaryString(value).chars()
                .map(c -> Character.digit(c, 2))
                .sum() == 1;
        System.out.println(result);
    }

    public static void isPowerOfTwo3(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = value != 0 && (value & (value - 1)) == 0;
        System.out.println(result);
    }

    public static void isPowerOfTwo4(int value) {
        if (value < 0) {
            value = -value;
        }
        boolean result = value != 0 && (value & -value) == value;
        System.out.println(result);
    }

}