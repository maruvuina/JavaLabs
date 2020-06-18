package by.bsu.lab11a.thread;

import java.io.*;

class ThreadReader implements Runnable {
    FileOperator fo;

    public ThreadReader(FileOperator fo) {
        super();
        this.fo = fo;
    }

    @Override
    public void run() {
        synchronized (fo) {
            if(!fo.isWriteComplete){
                try {
                    fo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("--------ORDER DETAILS------");
            try {
                System.out.println(fo.readFromFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            fo.notify();
        }
    }
}

class ThreadWriter implements Runnable{
    FileOperator fo;
    String demo;

    public ThreadWriter(FileOperator fo, String demo) {
        super();
        this.fo = fo;
        this.demo = demo;
    }

    @Override
    public void run() {
        synchronized (fo) {
            System.out.println("Going to write...");
            try {
                fo.writeInFile(demo);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fo.isWriteComplete = true;
            fo.notify();
        }
    }

}

public class FileReaderWriterDemo {
    public static void main(String[] args) {
        String str = "demo string info";
        FileOperator fop = null;
        try {
            fop = new FileOperator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread tr = new Thread(new ThreadWriter(fop, str));
        tr.start();
        Thread tw = new Thread(new ThreadReader(fop));
        tw.start();
    }
}