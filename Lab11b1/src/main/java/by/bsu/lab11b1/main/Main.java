package by.bsu.lab11b1.main;

import by.bsu.lab11b1.entity.computer.Computer;
import by.bsu.lab11b1.entity.diskDrive.DiskDrive;
import by.bsu.lab11b1.entity.diskDrive.DiskDriveCreator;
import by.bsu.lab11b1.file.FileOperator;
import by.bsu.lab11b1.file.ThreadReader;
import by.bsu.lab11b1.file.ThreadWriter;
import by.bsu.lab11b1.entity.processor.Processor;
import by.bsu.lab11b1.entity.processor.ProcessorCreator;
import by.bsu.lab11b1.entity.ram.Ram;
import by.bsu.lab11b1.entity.winchester.Winchester;
import by.bsu.lab11b1.entity.winchester.WinchesterCreator;
import by.bsu.lab11b1.logic.Logic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ram> ramList = new ArrayList<>();
        ramList.add(new Ram(2));
        ramList.add(new Ram(3));
        List<Winchester> winchesterList = new ArrayList<>();
        WinchesterCreator wc = new WinchesterCreator();
        winchesterList.add(wc.fillRandomizedWinchester(new Winchester()));
        winchesterList.add(wc.fillRandomizedWinchester(new Winchester()));
        ProcessorCreator pc = new ProcessorCreator();
        DiskDriveCreator dcC = new DiskDriveCreator();
        Computer computer1 = new Computer(pc.fillRandomazed(new Processor()), dcC.fillRandomazed(new DiskDrive()), ramList, winchesterList);
        System.out.println(computer1.toString());
        ramList.add(new Ram(5));
        winchesterList.add(wc.fillRandomizedWinchester(new Winchester()));
        Logic logic = new Logic();
        String computerData1 = logic.writeDataToFileAsString(computer1);
        FileOperator fileOperator = new FileOperator();
        Thread thread1 = new Thread(new ThreadWriter(fileOperator, computerData1));
        thread1.start();
        Thread thread2 = new Thread(new ThreadReader(fileOperator));
        thread2.start();
    }
}
