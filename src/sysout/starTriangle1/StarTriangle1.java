package sysout.starTriangle1;

public class StarTriangle1 {
    public static void starTriangle1(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(" ".repeat(number - i - 1));
            System.out.println("*".repeat(2 * i + 1));
        }
    }
}