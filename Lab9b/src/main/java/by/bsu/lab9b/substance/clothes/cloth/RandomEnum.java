package by.bsu.lab9b.substance.clothes.cloth;

import java.util.Random;

public class RandomEnum<T extends Enum<T>> {

    private static final Random RND = new Random();

    private final T[] values;

    public RandomEnum(Class<T> tClass) {
        values = tClass.getEnumConstants();
    }

    public T random() {
        return values[RND.nextInt(values.length)];
    }
}
