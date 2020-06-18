package by.bsu.lab12b1.entities.winchester;

import java.util.Objects;

public class Winchester {
    private String brand;
    private String modelNumber;
    private int size;

    public Winchester() {}

    public Winchester(String brand, String modelNumber, int size) {
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public int getSize() {
        return size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public String toString() {
        return "\nWinchester" +
                "\nbrand: " + brand +
                "\nmodelNumber: " + modelNumber +
                "\nSIZE: " + size + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Winchester)) return false;
        Winchester that = (Winchester) o;
        return getSize() == that.getSize() &&
                brand.equals(that.brand) &&
                modelNumber.equals(that.modelNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, modelNumber, getSize());
    }
}