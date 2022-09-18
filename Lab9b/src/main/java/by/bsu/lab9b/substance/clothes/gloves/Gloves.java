package by.bsu.lab9b.substance.clothes.gloves;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;

public class Gloves extends Cloth {

    private static final long serialVersionUID = 3970225975400053434L;

    private String brand;

    private int size;

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nbrand: " + brand +
                "\nsize: " + size +
                "\nweight: " + getWeight() +
                "\nprice: " + getPrice() + "\n";
    }
}
