package by.bsu.lab9b.substance.clothes.boots;

import com.github.javafaker.Faker;

import java.util.Random;

public class BootsCreator {
    private int index(String []t) {
        return new Random().nextInt(t.length);
    }

    private String randomFasteners() {
        String []fasteners = {"zipper", "bootlace"};
        return fasteners[index(fasteners)];
    }

    public Boots fillRandomizedBoots(Boots boots) {
        Faker faker =  new Faker();
        boots.setBrand(faker.company().name());
        boots.setFasteners(randomFasteners());
        return boots;
    }
}
