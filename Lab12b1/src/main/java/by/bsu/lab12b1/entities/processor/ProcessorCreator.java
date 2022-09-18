package by.bsu.lab12b1.entities.processor;

import java.util.Random;

public class ProcessorCreator {

    public Processor fillRandomazed(Processor processor) {
        processor.setBrand(randomBrand());
        processor.setNumberOfCore(randomNumberOfCore());
        processor.setClockFrequency(new Random().nextDouble());
        return processor;
    }

    private <T> int index(T []t) {
        return new Random().nextInt(t.length);
    }

    private String randomBrand() {
        String []brands = {"Intel", "AMD"};
        return brands[index(brands)];
    }

    private int randomNumberOfCore() {
        Integer []numberOfCore = {1, 2, 3, 4, 6, 8};
        return numberOfCore[index(numberOfCore)];
    }
}
