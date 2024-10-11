package test;

import com.osipov.oop.Companion;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println(Companion.add(1, 2));
    }

    public static Integer getRandomNumberOrNull(int min, int max) {
        if (!random.nextBoolean() || max < min) {
            return null;
        }

        return random.nextInt(min, max + 1);
    }
}
