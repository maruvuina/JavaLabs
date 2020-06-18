package by.bsu.lab9b.substance.clothes.hemlet;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;
import by.bsu.lab9b.substance.clothes.cloth.Color;

public class Hemlet extends Cloth {
    private static final long serialVersionUID = -8550039880375418934L;
    private String brand;
    private transient TypeMotoHemlet typeMotoHemlet;
    private int size;
    private Color color;

    public String getBrand() {
        return brand;
    }

    public TypeMotoHemlet getTypeMotoHemlet() {
        return typeMotoHemlet;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTypeMotoHemlet(TypeMotoHemlet typeMotoHemlet) {
        this.typeMotoHemlet = typeMotoHemlet;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nbrand: " + brand +
                "\ntypeMotoHemlet: " + typeMotoHemlet +
                "\nsize: " + size +
                "\ncolor: " + color +
                "\nweight: " + getWeight() +
                "\nprice: " + getPrice() + "\n";
    }
}
