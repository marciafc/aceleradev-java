package challenge;

import java.util.Random;

public class RandomUtil {

    public static int generateRandomValue(int value) {
        return new Random().nextInt(value);
    }
}
