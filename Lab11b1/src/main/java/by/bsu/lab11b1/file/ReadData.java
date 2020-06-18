package by.bsu.lab11b1.file;

import by.bsu.lab11b1.entity.computer.Computer;
import by.bsu.lab11b1.entity.diskDrive.DiskDrive;
import by.bsu.lab11b1.entity.diskDrive.TypeDiskDrive;
import by.bsu.lab11b1.entity.processor.Processor;
import by.bsu.lab11b1.entity.ram.Ram;
import by.bsu.lab11b1.entity.winchester.Winchester;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadData {
  private Workbook getWorkbook() {
    String fileName = "data\\Computer.xls";
    try (FileInputStream fis = new FileInputStream(fileName)) {
      return new HSSFWorkbook(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private ArrayList<Sheet> getSheets() {
    ArrayList<Sheet> sheetNames = new ArrayList<>();
    for (int i = 0; i < Objects.requireNonNull(getWorkbook()).getNumberOfSheets(); i++) {
      sheetNames.add(getWorkbook().getSheetAt(i));
    }
    return sheetNames;
  }

  private Processor readFromProcessor(Sheet processorSheet) {
    Processor processor = new Processor();
    for (Row row : processorSheet) {
      for (Cell cell : row) {
        if (cell.getCellType() == CellType.STRING) {
          processor.setBrand(cell.getStringCellValue());
        } else if (cell.getCellType() == CellType.NUMERIC) {
          if (cell.getColumnIndex() == 1) {
            processor.setNumberOfCore((int) cell.getNumericCellValue());
          } else if (cell.getColumnIndex() == 2) {
            processor.setClockFrequency(cell.getNumericCellValue());
          }
        }
      }
    }
    return processor;
  }

  private DiskDrive readFromDiskDrive(Sheet diskDriveSheet) {
    DiskDrive diskDrive = new DiskDrive();
    for (Row row : diskDriveSheet) {
      for (Cell cell : row) {
        if (cell.getCellType() == CellType.STRING && cell.getColumnIndex() == 2) {
          diskDrive.setTypeDiskDrive(TypeDiskDrive
            .valueOf(cell.getRichStringCellValue().getString()));
        } else if (cell.getCellType() == CellType.NUMERIC) {
          if (cell.getColumnIndex() == 0) {
            diskDrive.setCapacity(cell.getNumericCellValue());
          }
          if (cell.getColumnIndex() == 1) {
            diskDrive.setSpeed((int)cell.getNumericCellValue());
          }
        }
      }
    }
    return diskDrive;
  }

  private Ram readFromRam(Sheet ramSheet) {
    Ram ram = new Ram();
    Row row = ramSheet.getRow(0);
    Cell cell = row.getCell(0);
    ram.setSize((int)cell.getNumericCellValue());
    return ram;
  }

  private Winchester readFromWinchester(Sheet winchesterSheet) {
    Winchester winchester = new Winchester();
    for (Row row : winchesterSheet) {
      for (Cell cell : row) {
        if (cell.getCellType() == CellType.STRING) {
          if (cell.getColumnIndex() == 0) {
            winchester.setBrand(cell.getStringCellValue());
          }
          if (cell.getColumnIndex() == 1) {
            winchester.setModelNumber(cell.getStringCellValue());
          }
        }
      }
    }
    return winchester;
  }

  public void choosePartOfComputer(Computer computer) {
    for (Sheet sheet : getSheets()) {
      switch (sheet.getSheetName()) {
        case "Processor":
          computer.setProcessor(readFromProcessor(sheet));
          break;
        case "DiskDrive":
          computer.setDiskDrive(readFromDiskDrive(sheet));
          break;
        case "Ram":
          List<Ram> ramList = new ArrayList<>();
          ramList.add(readFromRam(sheet));
          computer.setRamList(ramList);
          break;
        case "Winchester":
          List<Winchester> winList = new ArrayList<>();
          winList.add(readFromWinchester(sheet));
          computer.setWinchesterList(winList);
          break;
      }
    }
  }
}
