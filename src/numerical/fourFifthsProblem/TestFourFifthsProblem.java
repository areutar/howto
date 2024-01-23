package numerical.fourFifthsProblem;

import static numerical.fourFifthsProblem.FourFifthsProblem.fourFifthsProblem;

public class TestFourFifthsProblem {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fourFifthsProblem(150));
        long end = System.currentTimeMillis();
        System.out.printf("Время выполнения - %dms", end - start);
    }   
}

