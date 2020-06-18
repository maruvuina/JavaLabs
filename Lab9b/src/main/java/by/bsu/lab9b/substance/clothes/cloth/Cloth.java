package by.bsu.lab9b.substance.clothes.cloth;

import by.bsu.lab9b.substance.clothes.exception.NegativeNumberException;

import java.io.Serializable;
import java.util.Random;

public abstract class Cloth implements Serializable {
    private static final long serialVersionUID = -5550976760351939566L;
    private final int ID;
    private double price;
    private double weight;

    {
        ID = new Random().nextInt();
    }

    public Cloth() {
        price = Math.random()*1000;
        weight = Math.random()*10;
    }

    public int getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public void setPrice(double price) {
        if (price < 0) {
            try {
                throw new NegativeNumberException("Значение цены не может быть отрицательным.");
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }
        } else {
            this.price = price;
        }

    }

    public void setWeight(double weight) {
        if (weight < 0) {
            try {
                throw new NegativeNumberException("Вес не может быть отрицательным.");
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }
        }
        this.weight = weight;
    }

    public int randomSize(int min, int max){
        int difference = max - min;
        Random random = new Random();
        int i = random.nextInt(difference + 1);
        i += min;
        return i;
    }

    public static <T extends Enum<?>> T getRandomEnumType(Class<T> tClass) {
        Random random = new Random();
        int x = random.nextInt(tClass.getEnumConstants().length);
        return tClass.getEnumConstants()[x];
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\nID: " + ID +
                "\nPrice: " + price +
                "\nWeight: " + weight;
    }

    @Override
    public int hashCode() {
        int result = 1;
        return (int) (weight * 10 * result + ID);
    }
}
