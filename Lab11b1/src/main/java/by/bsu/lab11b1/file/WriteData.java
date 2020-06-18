package by.bsu.lab11b1.file;

import by.bsu.lab11b1.entity.computer.Computer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteData {
  private Workbook getUpdatedWorkbook(Computer computer) {
    Workbook workbook = new HSSFWorkbook();
    List<Sheet> sheets = getSheets(workbook);
    for (Sheet sheet : sheets) {
      Row row = sheet.createRow(0);
      switch (sheet.getSheetName()) {
        case "AboutComputerProcessor":
          setProcessorRow(computer, row);
          break;
        case "AboutComputerDiskDrive":
          setDiskDriveRow(computer, row);
          break;
        case "AboutComputerRam":
          setRamRow(computer, row);
          break;
        case "AboutComputerWinchester":
          setWinchesterRow(computer, row);
          break;
      }
    }
    return workbook;
  }

  private List<Sheet> getSheets(Workbook workbook){
    List<Sheet> sheets = new ArrayList<>();
    sheets.add(workbook.createSheet("AboutComputerProcessor"));
    sheets.add(workbook.createSheet("AboutComputerDiskDrive"));
    sheets.add(workbook.createSheet("AboutComputerRam"));
    sheets.add(workbook.createSheet("AboutComputerWinchester"));
    return sheets;
  }

  private void setProcessorRow(Computer computer, Row row) {
    row.createCell(0).setCellValue("Processor");
    row.createCell(1).setCellValue(computer.getProcessor().getBrand());
    row.createCell(2).setCellValue(computer.getProcessor().getNumberOfCore());
    row.createCell(3).setCellValue(computer.getProcessor().getClockFrequency());
  }

  private void setDiskDriveRow(Computer computer, Row row) {
    row.createCell(0).setCellValue("DiskDrive");
    row.createCell(1).setCellValue(computer.getDiskDrive().getCapacity());
    row.createCell(2).setCellValue(computer.getDiskDrive().getSpeed());
    row.createCell(3.setCellValue(String.valueOf(computer.getDiskDrive().getTypeDiskDrive())));
  }

  private void setRamRow(Computer computer, Row row) {
    row.createCell(0).setCellValue("Ram");
    row.createCell(1).setCellValue(computer.getRamList().get(0).getSize());
  }

  private void setWinchesterRow(Computer computer, Row row) {
    row.createCell(0).setCellValue("Winchester");
    row.createCell(1).setCellValue(computer.getWinchesterList().get(0).getBrand());
    row.createCell(2).setCellValue(computer.getWinchesterList().get(0).getModelNumber());
    row.createCell(3).setCellValue(computer.getWinchesterList().get(0).getSIZE());
  }

  public void writeToExcelFile(Computer computer) {
    Workbook workbook = getUpdatedWorkbook(computer);
    String fileName = "data\\ComputerWrite.xls";
    OutputStream fileOut;
    try {
      fileOut = new FileOutputStream(fileName);
      workbook.write(fileOut);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
