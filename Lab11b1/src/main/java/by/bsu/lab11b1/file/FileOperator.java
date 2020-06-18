package by.bsu.lab11b1.file;

import java.io.*;

public class FileOperator {
    private File file;
    private BufferedWriter bw;
    private BufferedReader br;
    private boolean isWriteComplete;

    public FileOperator() {
        this.isWriteComplete = false;
        file = new File(getRelativePathToFile());
        try {
            bw = new BufferedWriter(new FileWriter(file));
            br = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isWriteComplete() {
        return isWriteComplete;
    }

    public void setWriteComplete(boolean writeComplete) {
        isWriteComplete = writeComplete;
    }

    private String getRelativePathToFile() {
        String FILE_EXTENSION = ".txt";
        String DIR_NAME = "data";
        String FILE_NAME = "File";
        return DIR_NAME + File.separator + FILE_NAME + FILE_EXTENSION;
    }

    public void writeInFile(String str) {
        try {
            bw.write(str);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile() throws IOException{
        return br.readLine();
    }
}
