package by.bsu.lab12b1.entities.computer;

import by.bsu.lab12b1.entities.processor.Processor;
import by.bsu.lab12b1.entities.diskDrive.DiskDrive;
import by.bsu.lab12b1.entities.ram.Ram;
import by.bsu.lab12b1.entities.winchester.Winchester;

import java.util.List;

public class Computer {
    private Processor processor;
    private DiskDrive diskDrive;
    private List<Ram> ramList;
    private List<Winchester> winchesterList;
    private boolean power;

    public Computer() {
        this.power = false;
    }

    public Computer(Processor processor, DiskDrive diskDrive, List<Ram> ramList, List<Winchester> winchesterList) {
        this.processor = processor;
        this.diskDrive = diskDrive;
        this.ramList = ramList;
        this.winchesterList = winchesterList;
        this.power = false;
    }

    public void switchOn() {
        power = true;
    }

    public void switchOff() {
        power = false;
    }

    public String checkViruses() {
        return "Cheched";
    }

    public boolean isPower() {
        return power;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setDiskDrive(DiskDrive diskDrive) {
        this.diskDrive = diskDrive;
    }

    public void setRamList(List<Ram> ramList) {
        this.ramList = ramList;
    }

    public void setWinchesterList(List<Winchester> winchesterList) {
        this.winchesterList = winchesterList;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public int getSizeWinchester() {
        int size = 0;
        for(Winchester winchester: winchesterList) {
            size += winchester.getSize();
        }
        return size;
    }

    @Override
    public String toString() {
        return "\nComputer\n" +
                "\nprocessor " + processor +
                "\ndiskDrive: " + diskDrive +
                "\nramList: " + ramList +
                "\nwinchesterList: " + winchesterList + "\n\n";
    }
}