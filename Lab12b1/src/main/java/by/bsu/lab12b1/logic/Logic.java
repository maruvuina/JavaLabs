package by.bsu.lab12b1.logic;

import by.bsu.lab12b1.db.DataBaseHelper;
import by.bsu.lab12b1.entities.computer.Computer;
import by.bsu.lab12b1.entities.diskDrive.DiskDrive;
import by.bsu.lab12b1.entities.diskDrive.DiskDriveCreator;
import by.bsu.lab12b1.entities.processor.Processor;
import by.bsu.lab12b1.entities.processor.ProcessorCreator;
import by.bsu.lab12b1.entities.ram.Ram;
import by.bsu.lab12b1.entities.winchester.Winchester;
import by.bsu.lab12b1.entities.winchester.WinchesterCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Logic {
    private DataBaseHelper helper;
    private PreparedStatement statement;

    public <T> List<T> magicalListGetter(T t, int n) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(t);
        }
        return list;
    }

    public void insertDataIntoTables(List<String> tablesNames, List<List<?>> listOfListData) {
        List<Ram> ramList = new ArrayList<>();
        List<Winchester> winchesterList = new ArrayList<>();
        List<DiskDrive> diskDriveList = new ArrayList<>();
        List<Processor> processorList = new ArrayList<>();
        for (List<?> objects : listOfListData) {
            for (Object object : objects) {
                switch (object.getClass().getSimpleName()) {
                    case "Ram":
                        ramList.add((Ram) object);
                        break;
                    case "Winchester":
                        winchesterList.add((Winchester) object);
                        break;
                    case "DiskDrive":
                        diskDriveList.add((DiskDrive) object);
                        break;
                    case "Processor":
                        processorList.add((Processor) object);
                        break;
                }
            }
        }
        for (String tableName: tablesNames) {
            switch (tableName.toUpperCase()){
                case "RAM":
                    insertDataIntoRamTable(ramList);
                    break;
                case "DISKDRIVE":
                    insertDataIntoDiskDriveTable(diskDriveList);
                    break;
                case "WINCHESTER":
                    insertDataIntoWinchesterTable(winchesterList);
                    break;
                case "PROCESSOR":
                    insertDataIntoProcessorTable(processorList);
                    break;
            }
        }
    }

    public void insertDataIntoRamTable(List<Ram> ramList) {
        String insertIntoRam = "INSERT INTO Ram(size) VALUES(?)";
        try {
            helper = new DataBaseHelper();
            statement = helper.getPreparedStatement(insertIntoRam);
            for (Ram ram: ramList) {
                helper.insertRam(statement, ram);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(helper).closeStatement(statement);
        }
    }

    public void insertDataIntoDiskDriveTable(List<DiskDrive> diskDriveList) {
        String insertIntoDiskDrive =
                "INSERT INTO DiskDrive(capacity, speed, type) VALUES (?, ?, ?)";
        try {
            helper = new DataBaseHelper();
            statement = helper.getPreparedStatement(insertIntoDiskDrive);
            for (DiskDrive diskDrive: diskDriveList) {
                helper.insertDiskDrive(statement, diskDrive);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(helper).closeStatement(statement);
        }
    }

    public void insertDataIntoProcessorTable(List<Processor> processorList) {
        String insertIntoProcessor =
                "INSERT INTO Processor(brand, numberOfCore, clockFrequency) VALUES (?, ?, ?)";
        try {
            helper = new DataBaseHelper();
            statement = helper.getPreparedStatement(insertIntoProcessor);
            for (Processor processor: processorList) {
                helper.insertProcessor(statement, processor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(helper).closeStatement(statement);
        }
    }

    public void insertDataIntoWinchesterTable(List<Winchester> winchesterList) {
        String insertIntoWinchester =
                "INSERT INTO Winchester(brand, modelNumber, size) VALUES (?, ?, ?)";
        try {
            helper = new DataBaseHelper();
            statement = helper.getPreparedStatement(insertIntoWinchester);
            for (Winchester winchester: winchesterList) {
                helper.insertWinchester(statement, winchester);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(helper).closeStatement(statement);
        }
    }

    public void insertDataIntoComputerTable() {
        String selectFromTables =
                "INSERT INTO Computer(winchesterId, ramId, diskDriveId, processorId)\n" +
                        "VALUES (\n" +
                        "        (SELECT winchesterId FROM Winchester WHERE Winchester.winchesterId = ?),\n" +
                        "        (SELECT ramId FROM Ram WHERE Ram.ramId = ?),\n" +
                        "        (SELECT diskDriveId FROM DiskDrive WHERE DiskDrive.diskDriveId = ?),\n" +
                        "        (SELECT processorId FROM Processor WHERE Processor.processorId = ?)\n" +
                        "       )";
        try {
            helper = new DataBaseHelper();
            statement = helper.getPreparedStatement(selectFromTables);
            int n = 6;
            for(int i = 1; i <= n; i++) {
                statement.setInt(1, i);
                statement.setInt(2, i);
                statement.setInt(3, i);
                statement.setInt(4, i);
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(helper).closeStatement(statement);
        }
    }

    public List<Ram> getDataFromRamTable(String selectTableSQL) {
        List<Ram> ramList = new ArrayList<>();
        try {
            helper = new DataBaseHelper();
            ramList = helper.getRam(selectTableSQL);
            return ramList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ramList;
    }

    public List<Winchester> getDataFromWinchesterTable(String selectTableSQL) {
        List<Winchester> winchesterList = new ArrayList<>();
        try {
            helper = new DataBaseHelper();
            winchesterList = helper.getWinchester(selectTableSQL);
            return winchesterList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return winchesterList;
    }

    public List<Processor> getDataFromProcessorTable(String selectTableSQL) {
        List<Processor> processorList = new ArrayList<>();
        try {
            helper = new DataBaseHelper();
            processorList = helper.getProcessor(selectTableSQL);
            return processorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processorList;
    }

    public List<DiskDrive> getDataFromDiskDriveTable(String selectTableSQL) {
        List<DiskDrive> diskDriveList = new ArrayList<>();
        try {
            helper = new DataBaseHelper();
            diskDriveList = helper.getDiskDrive(selectTableSQL);
            return diskDriveList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diskDriveList;
    }

    public List<Computer> getDataFromComputerTable(String selectTableSQL) {
        List<Computer> computerList = new ArrayList<>();
        try {
            helper = new DataBaseHelper();
            computerList = helper.getComputer(selectTableSQL);
            return computerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computerList;
    }

    public List<Integer> getSizeWinchesterFromComterTable(String selectTableSQL) {
        List<Integer> sizeList = new ArrayList<>();
        try {
            helper = new DataBaseHelper();
            sizeList = helper.getWinchesterSizeFromComputer(selectTableSQL);
            return sizeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizeList;
    }
}
