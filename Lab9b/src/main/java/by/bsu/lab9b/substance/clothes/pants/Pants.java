package by.bsu.lab9b.substance.clothes.pants;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;

public class Pants extends Cloth {
    private static final long serialVersionUID = -2620819426661633670L;
    private String brand;
    private int size;
    private String madeOf;

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }

    public String getMadeOf() {
        return madeOf;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMadeOf(String madeOf) {
        this.madeOf = madeOf;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nbrand: " + brand +
                "\nsize: " + size +
                "\nmadeOf: " + madeOf +
                "\nweight: " + getWeight() +
                "\nprice: " + getPrice() + "\n";
    }
}
