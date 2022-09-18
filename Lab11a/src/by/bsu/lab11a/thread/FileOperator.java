package by.bsu.lab11a.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperator {

    File file = new File("data\\File.txt");

    BufferedWriter bw;

    BufferedReader br;

    boolean isWriteComplete = false;

    public FileOperator() throws IOException {
        bw = new BufferedWriter(new FileWriter(file));
        br = new BufferedReader(new FileReader(file));
    }

    public void writeInFile(String str) throws IOException{
        bw.write(str);
        bw.newLine();
        bw.flush();
    }

    public String readFromFile() throws IOException{
        return br.readLine();
    }
}
