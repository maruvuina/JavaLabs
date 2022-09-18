package by.bsu.lab9b.shop;

import by.bsu.lab9b.substance.clothes.boots.Boots;
import by.bsu.lab9b.substance.clothes.boots.BootsCreator;
import by.bsu.lab9b.substance.clothes.cloth.Cloth;
import by.bsu.lab9b.substance.clothes.gloves.Gloves;
import by.bsu.lab9b.substance.clothes.gloves.GlovesCreator;
import by.bsu.lab9b.substance.clothes.hemlet.Hemlet;
import by.bsu.lab9b.substance.clothes.hemlet.HemletCreator;
import by.bsu.lab9b.substance.clothes.jacket.Jacket;
import by.bsu.lab9b.substance.clothes.jacket.JacketCreator;
import by.bsu.lab9b.substance.clothes.pants.Pants;
import by.bsu.lab9b.substance.clothes.pants.PantsCreator;
import by.bsu.lab9b.substance.clothes.protection.ProtectionCloth;
import by.bsu.lab9b.substance.clothes.protection.ProtectitonClothCreator;

import java.util.List;

public class ClothesShop {

    public void buy(List<Cloth> cloths, String ... clothsType) {
        for (String s : clothsType) {
            Cloth cloth = defineCloth(s);
            if (cloth != null) {
                cloths.add(cloth);
            }
        }
    }

    private Cloth defineCloth(String type) {
        switch (type) {
            case "Boots":
                return new BootsCreator().fillRandomizedBoots(new Boots());
            case "Gloves":
                return new GlovesCreator().fillRandomizedGloves(new Gloves());
            case "Hemlet":
                return new HemletCreator().fillRandomizedHemlet(new Hemlet());
            case "Jacket":
                return new JacketCreator().fillRandomizedJacket(new Jacket());
            case "Pants":
                return new PantsCreator().fillRandomizedPants(new Pants());
            case "ProtectionCloth":
                return new ProtectitonClothCreator()
                        .fillRandomizedProtectionCloth(new ProtectionCloth());
            default:
                System.out.println("Sir, I haven`t " + type + ".");
                return null;
        }
    }
}
