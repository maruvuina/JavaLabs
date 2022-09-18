package by.bsu.lab12b1.db;

import by.bsu.lab12b1.entities.computer.Computer;
import by.bsu.lab12b1.entities.diskDrive.DiskDrive;
import by.bsu.lab12b1.entities.diskDrive.TypeDiskDrive;
import by.bsu.lab12b1.entities.processor.Processor;
import by.bsu.lab12b1.entities.ram.Ram;
import by.bsu.lab12b1.entities.winchester.Winchester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBaseHelper {

    private Connection connect;

    public DataBaseHelper() throws SQLException {
        connect = ConnectorDB.getConnection();
    }

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public boolean insertRam(PreparedStatement ps, Ram ram) {
        boolean flag = false;
        try {
            ps.setInt(1, ram.getSize());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertDiskDrive(PreparedStatement ps, DiskDrive diskDrive) {
        boolean flag = false;
        try {
            ps.setDouble(1, diskDrive.getCapacity());
            ps.setInt(2, diskDrive.getSpeed());
            ps.setString(3, String.valueOf(diskDrive.getTypeDiskDrive()));
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertProcessor(PreparedStatement ps, Processor processor) {
        boolean flag = false;
        try {
            ps.setString(1, processor.getBrand());
            ps.setInt(2, processor.getNumberOfCore());
            ps.setDouble(3, processor.getClockFrequency());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertWinchester(PreparedStatement ps, Winchester winchester) {
        boolean flag = false;
        try {
            ps.setString(1, winchester.getBrand());
            ps.setString(2, winchester.getModelNumber());
            ps.setInt(3, winchester.getSize());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void insertIntoTable(String sqlInsert) {
        try(Connection dbConnection = ConnectorDB.getConnection();
            Statement statement = dbConnection.createStatement()) {
            statement.executeUpdate(sqlInsert);
            System.out.println("Data is inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Ram> getRam(String selectTableSQL) {
        List<Ram> ramList = new ArrayList<>();
        try(Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectTableSQL);
            while (resultSet.next()) {
                int ramSize = resultSet.getInt("size");
                ramList.add(new Ram(ramSize));
            }
            return ramList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ramList;
    }

    public List<Winchester> getWinchester(String selectTableSQL) {
        List<Winchester> winchesterList = new ArrayList<>();
        try(Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectTableSQL);
            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String modelNumber = resultSet.getString("modelNumber");
                int winchesterSize = resultSet.getInt("size");
                winchesterList.add(new Winchester(brand, modelNumber, winchesterSize));
            }
            return winchesterList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return winchesterList;
    }

    public List<Processor> getProcessor(String selectTableSQL) {
        List<Processor> processorList = new ArrayList<>();
        try(Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectTableSQL);
            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                int numberOfCore = resultSet.getInt("numberOfCore");
                double clockFrequency = resultSet.getDouble("clockFrequency");
                processorList.add(new Processor(brand, numberOfCore, clockFrequency));
            }
            return processorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processorList;
    }

    public List<DiskDrive> getDiskDrive(String selectTableSQL) {
        List<DiskDrive> diskDriveList = new ArrayList<>();
        try(Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectTableSQL);
            while (resultSet.next()) {
                double capacity = resultSet.getDouble("capacity");
                int speed = resultSet.getInt("speed");
                String type = resultSet.getString("type");
                diskDriveList.add(new DiskDrive(capacity, speed, TypeDiskDrive.valueOf(type)));
            }
            return diskDriveList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diskDriveList;
    }

    public List<Computer> getComputer(String selectTableSQL) {
        List<Computer> computerList = new ArrayList<>();
        try(Statement statement = connect.createStatement()) {
            List<Ram> ramList = new ArrayList<>();
            List<Winchester> winchesterList = new ArrayList<>();
            List<Processor> processorList = new ArrayList<>();
            List<DiskDrive> diskDriveList = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(selectTableSQL);
            int i = 0;
            while (resultSet.next()) {
                int sizeRam = resultSet.getInt(1);
                ramList.add(new Ram(sizeRam));
                String brandWinchester = resultSet.getString(2);
                String modelNumberWinchester = resultSet.getString(3);
                int sizeWinchester = resultSet.getInt(4);
                winchesterList
                        .add(new Winchester(brandWinchester, modelNumberWinchester, sizeWinchester));
                String brandProcessor = resultSet.getString(5);
                int numberOfCoreProcessor = resultSet.getInt(6);
                double clockFrequencyProcessor = resultSet.getDouble(7);
                processorList
                        .add(new Processor(brandProcessor, numberOfCoreProcessor, clockFrequencyProcessor));
                int capacityDiskDrive = resultSet.getInt(8);
                int speedDiskDrive = resultSet.getInt(9);
                String typeDiskDrive = resultSet.getString(10);
                diskDriveList
                        .add(new DiskDrive(capacityDiskDrive, speedDiskDrive, TypeDiskDrive.valueOf(typeDiskDrive)));
                List<Ram> rams = ramList
                        .stream()
                        .filter(ram -> ram.getSize() <= (int)(Math.random()*10) + 1)
                        .collect(Collectors.toCollection(ArrayList::new));
                List<Winchester> winchesters = winchesterList
                        .stream()
                        .filter(winchester -> winchester.getSize() <= (int)(Math.random()*10) + 1)
                        .collect(Collectors.toCollection(ArrayList::new));
                computerList
                        .add(new Computer(processorList.get(i), diskDriveList.get(i), rams, winchesters));
                i++;
            }
            return computerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computerList;
    }

    public List<Integer> getWinchesterSizeFromComputer(String selectTableSQL) {
        List<Integer> listSizeOfWinchesteres = new ArrayList<>();
        try(Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectTableSQL);
            while (resultSet.next()) {
                int size = resultSet.getInt("size");
                listSizeOfWinchesteres.add(size);
            }
            return listSizeOfWinchesteres;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSizeOfWinchesteres;
    }
}
