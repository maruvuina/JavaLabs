package by.bsu.lab11b1.entity.processor;

import java.util.Objects;

public class Processor {
    private String brand;
    private int numberOfCore;
    private double clockFrequency;

    public Processor() {}

    public Processor(String brand, int numberOfCore, double clockFrequency) {
        this.brand = brand;
        this.numberOfCore = numberOfCore;
        this.clockFrequency = clockFrequency;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumberOfCore() {
        return numberOfCore;
    }

    public double getClockFrequency() {
        return clockFrequency;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumberOfCore(int numberOfCore) {
        this.numberOfCore = numberOfCore;
    }

    public void setClockFrequency(double clockFrequency) {
        this.clockFrequency = clockFrequency;
    }

    @Override
    public String toString() {
        return "\nProcessor:\n" +
                "brand: " + brand + "\n" +
                "numberOfCore: " + numberOfCore + "\n" +
                "clockFrequency: " + clockFrequency + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processor)) return false;
        Processor processor = (Processor) o;
        return numberOfCore == processor.numberOfCore &&
                Double.compare(processor.clockFrequency, clockFrequency) == 0 &&
                brand.equals(processor.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, numberOfCore, clockFrequency);
    }
}
