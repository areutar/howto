package sysout.starTriangle2;

public class StarTriangle2 {

    public static void starTriangle2(int number) {
        if (number % 2 == 0 || number <= 0) {
            throw new IllegalArgumentException();
        }
        int height = number / 2 + 1;
        for (int i = -height + 1; i < height; i++) {
            System.out.println("*".repeat(height - Math.abs(i)));
        }
    }

}