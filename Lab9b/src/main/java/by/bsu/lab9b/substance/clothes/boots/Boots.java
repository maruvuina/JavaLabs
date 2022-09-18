package by.bsu.lab9b.substance.clothes.boots;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;

public class Boots extends Cloth {

    private static final long serialVersionUID = 8111816311499886741L;

    private String brand;

    private String fasteners;

    public String getBrand() {
        return brand;
    }

    public String getFasteners() {
        return fasteners;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFasteners(String fasteners) {
        this.fasteners = fasteners;
    }

    @Override
    public String toString() {
        return "\n" + this.getClass().getSimpleName() +
                "\nbrand: " + brand +
                "\nfasteners: " + fasteners +
                "\nweight: " + getWeight() +
                "\nprice: " + getPrice() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boots)) return false;
        Boots boots = (Boots) o;
        return getBrand().equals(boots.getBrand()) &&
                getFasteners().equals(boots.getFasteners());
    }
}
