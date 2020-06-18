package by.bsu.lab9b.substance.clothes.jacket;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;
import by.bsu.lab9b.substance.clothes.cloth.Color;

public class Jacket extends Cloth {
    private static final long serialVersionUID = 6782513476127749246L;
    private String brand;
    private int size;
    private transient String madeOf;
    private Color color;

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }

    public String getMadeOf() {
        return madeOf;
    }

    public Color getColor() {
        return color;
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

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nbrand: " + brand +
                "\nsize: " + size +
                "\nmadeOf: " + madeOf +
                "\ncolor: " + color +
                "\nweight: " + getWeight() +
                "\nprice: " + getPrice() + "\n";
    }
}
