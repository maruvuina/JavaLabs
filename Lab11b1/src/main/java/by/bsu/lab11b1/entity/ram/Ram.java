package by.bsu.lab11b1.entity.ram;

import java.util.Objects;

public class Ram {
    private int size;

    public Ram() {}

    public Ram(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ram)) return false;
        Ram ram = (Ram) o;
        return size == ram.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "Ram size = " + size;
    }
}
