package by.bsu.lab12b1.main;

import by.bsu.lab12b1.logic.GetData;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GetData getData = new GetData();
        List<String> sqlSelectQueries = new ArrayList<>();
        String selectFromRam = "SELECT size FROM Ram";
        String selectFromWinchester = "SELECT brand, modelNumber, size FROM Winchester";
        String selectFromProcessor = "SELECT brand, numberOfCore, clockFrequency FROM Processor";
        String selectFromDiskDrive = "SELECT capacity, speed, type FROM DiskDrive";
        sqlSelectQueries.add(selectFromRam);
        sqlSelectQueries.add(selectFromWinchester);
        sqlSelectQueries.add(selectFromProcessor);
        sqlSelectQueries.add(selectFromDiskDrive);
        String sqlSelectFromComputerTable =
                "SELECT DISTINCT Ram.size,\n" +
                        "       Winchester.brand, Winchester.modelNumber, Winchester.size,\n" +
                        "       Processor.brand, Processor.numberOfCore, Processor.clockFrequency,\n" +
                        "       DiskDrive.capacity, DiskDrive.speed, DiskDrive.type\n" +
                        "FROM (Ram, Winchester, Processor, DiskDrive)\n" +
                        "        RIGHT JOIN Computer C ON Ram.ramId = C.ramId\n" +
                        "               AND Winchester.winchesterId = C.winchesterId\n" +
                        "               AND Processor.processorId = C.processorId\n" +
                        "               AND DiskDrive.diskDriveId = C.diskDriveId";
        String sqlSelectWinchestersSizesFromCpmterTable =
                "SELECT Winchester.size\n" +
                        "FROM Winchester\n" +
                        "RIGHT JOIN Computer C on Winchester.winchesterId = C.winchesterId";
        List<Integer> winchestersSizes = getData.getFromCompterWinchesterSize(sqlSelectWinchestersSizesFromCpmterTable);
        winchestersSizes.forEach(System.out::println);
    }
}
