package by.bsu.lab9b.substance.clothes.hemlet;

import by.bsu.lab9b.substance.clothes.cloth.Color;
import by.bsu.lab9b.substance.clothes.cloth.RandomEnum;
import java.util.Random;

public class HemletCreator {

    public Hemlet fillRandomizedHemlet(Hemlet hemlet) {
        hemlet.setBrand(fillRandomizedBrand());
        hemlet.setTypeMotoHemlet(new RandomEnum<>(TypeMotoHemlet.class).random());
        int minSize = 50;
        int maxSize = 60;
        hemlet.setSize(hemlet.randomSize(minSize, maxSize));
        hemlet.setColor(new RandomEnum<>(Color.class).random());
        return hemlet;
    }

    private int index(String []t) {
        return new Random().nextInt(t.length);
    }

    private String fillRandomizedBrand() {
        String []brands = {"Arai", "Bieffe", "Fox", "HJC and Cirus", "Icon", "Shoei", "Suomy"};
        return brands[index(brands)];
    }
}
