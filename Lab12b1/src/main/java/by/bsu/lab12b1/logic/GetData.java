package by.bsu.lab12b1.logic;

import by.bsu.lab12b1.entities.computer.Computer;
import by.bsu.lab12b1.entities.diskDrive.DiskDrive;
import by.bsu.lab12b1.entities.processor.Processor;
import by.bsu.lab12b1.entities.ram.Ram;
import by.bsu.lab12b1.entities.winchester.Winchester;

import java.util.ArrayList;
import java.util.List;

public class GetData {

    private Logic logic;

    public GetData() {
        logic = new Logic();
    }

    private List<Ram> ramListReceivedData(String selectFromRam) {
        return logic.getDataFromRamTable(selectFromRam);
    }

    private List<Winchester> winchesterListReceivedData(String selectFromWinchester) {
        return logic.getDataFromWinchesterTable(selectFromWinchester);
    }

    private List<Processor> processorListReceivedData(String selectFromProcessor) {
        return logic.getDataFromProcessorTable(selectFromProcessor);
    }

    private List<DiskDrive> diskDriveListReceivedData(String selectFromDiskDrive) {
        return logic.getDataFromDiskDriveTable(selectFromDiskDrive);
    }

    private List<List<?>> listsReceivedData(
            List<Ram> rams, List<Winchester> winchesters,
            List<Processor> processors, List<DiskDrive> diskDrives) {
        List<List<?>> listOfLists = new ArrayList<>();
        listOfLists.add(rams);
        listOfLists.add(winchesters);
        listOfLists.add(processors);
        listOfLists.add(diskDrives);
        return listOfLists;
    }

    public List<List<?>> getFromTables(List<String> sqlSelectQueries, String ... sqlSelectStatements) {
        List<Ram> rams = new ArrayList<>();
        List<Winchester> winchesters = new ArrayList<>();
        List<Processor> processors = new ArrayList<>();
        List<DiskDrive> diskDrives = new ArrayList<>();
        for (String sqlStatement : sqlSelectStatements) {
            switch (sqlStatement.toUpperCase()) {
                case "RAM":
                    rams = ramListReceivedData(sqlSelectQueries.get(0));
                    break;
                case "WINCHESTER":
                    winchesters = winchesterListReceivedData(sqlSelectQueries.get(1));
                    break;
                case "PROCESSOR":
                    processors = processorListReceivedData(sqlSelectQueries.get(2));
                    break;
                case "DISKDRIVE":
                    diskDrives = diskDriveListReceivedData(sqlSelectQueries.get(3));
                    break;
            }
        }
        return listsReceivedData(rams, winchesters, processors, diskDrives);
    }

    public List<Computer> getFromComputerData(String sqlSelectQuery) {
        return logic.getDataFromComputerTable(sqlSelectQuery);
    }

    public List<Integer> getFromCompterWinchesterSize(String sqlSelectQuery) {
        return logic.getSizeWinchesterFromComterTable(sqlSelectQuery);
    }
}
