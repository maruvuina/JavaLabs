package by.bsu.lab9b.substance.clothes.gloves;

import com.github.javafaker.Faker;

public class GlovesCreator {

    public Gloves fillRandomizedGloves(Gloves gloves) {
        Faker faker = new Faker();
        gloves.setBrand(faker.company().name());
        int minSize = 16;
        int maxSize = 27;
        gloves.setSize(gloves.randomSize(minSize, maxSize));
        return gloves;
    }
}
