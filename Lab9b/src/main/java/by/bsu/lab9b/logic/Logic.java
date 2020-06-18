package by.bsu.lab9b.logic;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;
import by.bsu.lab9b.substance.motorcyclist.Motorcyclist;
import java.util.ArrayList;
import java.util.Comparator;

public class Logic {
    public double getPrice(Motorcyclist motorcyclist) {
        double price = 0;
        for (Cloth cloth : motorcyclist.getClothList()) {
            price += cloth.getPrice();
        }
        return price;
    }

    public Motorcyclist sortByWeight(Motorcyclist moto) {
        Comparator<Cloth> comparator = Comparator.comparingDouble(Cloth::getWeight);
        moto.getClothList().sort(comparator);
        return moto;
    }

    public ArrayList<Cloth> getClothesByPriceGap(Motorcyclist biker,
                                                        double minPrice, double maxPrice) {
        ArrayList<Cloth> clothes = new ArrayList<>();
        for (Cloth cloth : biker.getClothList()) {
            if (cloth.getPrice() <= maxPrice && cloth.getPrice() >= minPrice) {
                clothes.add(cloth);
            }
        }
        return clothes;
    }
}
