package by.bsu.lab9b.substance.clothes.jacket;

import by.bsu.lab9b.substance.clothes.cloth.Color;
import by.bsu.lab9b.substance.clothes.cloth.RandomEnum;
import com.github.javafaker.Faker;

import java.util.Random;

public class JacketCreator {

    public Jacket fillRandomizedJacket(Jacket jacket) {
        Faker faker = new Faker();
        jacket.setBrand(faker.company().name());
        int minSize = 38;
        int maxSize = 64;
        jacket.setSize(jacket.randomSize(minSize, maxSize));
        jacket.setMadeOf(fillRandomizedMadeOf());
        jacket.setColor(new RandomEnum<>(Color.class).random());
        return jacket;
    }

    private int index(String []t) {
        return new Random().nextInt(t.length);
    }

    private String fillRandomizedMadeOf() {
        String []madeOf = {"Suede", "Natural leather", "Faux leather", "Textile", "Polyurethane"};
        return madeOf[index(madeOf)];
    }
}
