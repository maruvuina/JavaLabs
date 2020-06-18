package by.bsu.lab12b1.logic;

import by.bsu.lab12b1.entities.diskDrive.DiskDrive;
import by.bsu.lab12b1.entities.diskDrive.DiskDriveCreator;
import by.bsu.lab12b1.entities.processor.Processor;
import by.bsu.lab12b1.entities.processor.ProcessorCreator;
import by.bsu.lab12b1.entities.ram.Ram;
import by.bsu.lab12b1.entities.winchester.Winchester;
import by.bsu.lab12b1.entities.winchester.WinchesterCreator;

import java.util.ArrayList;
import java.util.List;

public class InsertData {
    private List<Ram> ramListGetter() {
        List<Ram> ramList = new ArrayList<>();
        ramList.add(new Ram(2));
        ramList.add(new Ram(3));
        ramList.add(new Ram(4));
        ramList.add(new Ram(1));
        ramList.add(new Ram(5));
        ramList.add(new Ram(6));
        return ramList;
    }

    private List<Winchester> winchestersListGetter(int n) {
        List<Winchester> list = new ArrayList<>();
        WinchesterCreator wc = new WinchesterCreator();
        for (int i = 0; i < n; i++) {
            list.add(wc.fillRandomizedWinchester(new Winchester()));
        }
        return list;
    }

    private List<Processor> processorsListGetter(int n) {
        List<Processor> list = new ArrayList<>();
        ProcessorCreator pc = new ProcessorCreator();
        for (int i = 0; i < n; i++) {
            list.add(pc.fillRandomazed(new Processor()));
        }
        return list;
    }

    private List<DiskDrive> diskDrivesListGetter(int n) {
        List<DiskDrive> list = new ArrayList<>();
        DiskDriveCreator ddC = new DiskDriveCreator();
        for (int i = 0; i < n; i++) {
            list.add(ddC.fillRandomazed(new DiskDrive()));
        }
        return list;
    }

    private List<List<?>> listOfListDataGetter
            (List<Ram>ramList, List<Winchester> winchesterList,
             List<Processor> processorList, List<DiskDrive> diskDriveList) {
        List<List<?>> listOfListData = new ArrayList<>();
        listOfListData.add(ramList);
        listOfListData.add(winchesterList);
        listOfListData.add(processorList);
        listOfListData.add(diskDriveList);

        return listOfListData;
    }

    private List<String> tableNamesListGetter() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("Ram");
        tableNames.add("Winchester");
        tableNames.add("DiskDrive");
        tableNames.add("Processor");
        return tableNames;
    }

    public void insertIntoTables() {
        List<Ram> ramList = ramListGetter();
        Logic logic = new Logic();
        int n = 12;
        List<Winchester> winchesterList = winchestersListGetter(n);
        n = 10;
        List<Processor> processorList = processorsListGetter(n);
        n = 11;
        List<DiskDrive> diskDriveList = diskDrivesListGetter(n);
        List<List<?>> listOfListData =
                listOfListDataGetter(ramList, winchesterList, processorList, diskDriveList);
        List<String> tableNames = tableNamesListGetter();
        logic.insertDataIntoTables(tableNames, listOfListData);
    }
}
