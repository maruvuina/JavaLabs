package by.bsu.lab9b.substance.clothes.hemlet;

import java.util.Random;

public enum TypeMotoHemlet {
    FullFace,
    Motocross,
    Modular,
    OpenFace,
    Shorty,
    Beanie;

    public static TypeMotoHemlet getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
