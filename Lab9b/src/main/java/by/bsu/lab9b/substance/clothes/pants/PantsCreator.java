package by.bsu.lab9b.substance.clothes.pants;

import com.github.javafaker.Faker;
import java.util.Random;

public class PantsCreator {
    private int index(String []t) {
        return new Random().nextInt(t.length);
    }

    private String fillRandomizedMadeOf() {
        String []madeOf = {"Jeans", "Leather"};
        return madeOf[index(madeOf)];
    }

    public Pants fillRandomizedPants(Pants pants) {
        Faker faker = new Faker();
        pants.setBrand(faker.company().name());
        int minSize = 24;
        int maxSize = 36;
        pants.setSize(pants.randomSize(minSize, maxSize));
        pants.setMadeOf(fillRandomizedMadeOf());
        return pants;
    }
}
