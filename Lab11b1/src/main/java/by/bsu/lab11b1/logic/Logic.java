package by.bsu.lab11b1.logic;

import by.bsu.lab11b1.entity.computer.Computer;

public class Logic {
    public String writeDataToFileAsString(Computer computer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(computer.getProcessor().getBrand()).append("| ");
        stringBuilder.append(computer.getProcessor().getNumberOfCore()).append("| ");
        stringBuilder.append(computer.getProcessor().getClockFrequency()).append("\n");
        stringBuilder.append(computer.getDiskDrive().getCapacity()).append("| ");
        stringBuilder.append(computer.getDiskDrive().getSpeed()).append("| ");
        stringBuilder.append(computer.getDiskDrive().getTypeDiskDrive()).append("\n");
        for (int i = 0; i < computer.getRamList().size(); i++) {
            stringBuilder.append(computer.getRamList().get(i).getSize()).append("| ");
        }
        stringBuilder.append("\n");
        for (int i = 0; i < computer.getWinchesterList().size(); i++) {
            stringBuilder.append(computer.getWinchesterList().get(i).getBrand()).append("| ");
            stringBuilder.append(computer.getWinchesterList().get(i).getModelNumber()).append("| ");
            stringBuilder.append(computer.getWinchesterList().get(i).getSize());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
