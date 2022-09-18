package by.bsu.lab9b.substance.clothes.protection;

import java.util.Random;

public class ProtectitonClothCreator {

    public ProtectionCloth fillRandomizedProtectionCloth(ProtectionCloth pCloth) {
        pCloth.setMotoTurtle(getRandomBoolean());
        pCloth.setBackProtector(getRandomBoolean());
        pCloth.setElbowPads(getRandomBoolean());
        pCloth.setKneePads(getRandomBoolean());
        return pCloth;
    }

    private static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
