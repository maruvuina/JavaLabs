package by.bsu.lab12b1.entities.computer;

import by.bsu.lab12b1.entities.diskDrive.DiskDrive;
import by.bsu.lab12b1.entities.processor.Processor;
import by.bsu.lab12b1.entities.processor.ProcessorCreator;
import by.bsu.lab12b1.entities.ram.Ram;
import by.bsu.lab12b1.entities.winchester.Winchester;
import by.bsu.lab12b1.entities.winchester.WinchesterCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerCreator {

    public int randomRange(int min, int max) {
        int difference = max - min;
        Random random = new Random();
        int i = random.nextInt(difference + 1);
        i += min;
        return i;
    }

    public void createComputer(Computer computer) {
        ProcessorCreator pc = new ProcessorCreator();
        computer.setProcessor(pc.fillRandomazed(new Processor()));
        computer.setDiskDrive(new DiskDrive());
        computer.setRamList(createRamList());
        computer.setWinchesterList(createWinchesterList());
    }

    private List<Ram> createRamList(){
        List<Ram> ramList = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(10); i++) {
            ramList.add(new Ram(i));
        }
        return ramList;
    }

    private List<Winchester> createWinchesterList() {
        List<Winchester> winList = new ArrayList<>();
        WinchesterCreator wc = new WinchesterCreator();
        int minRange = 1;
        int maxRange = 3;
        for (int i = 0; i < randomRange(minRange, maxRange); i++) {
            winList.add(wc.fillRandomizedWinchester(new Winchester()));
        }
        return winList;
    }
}
