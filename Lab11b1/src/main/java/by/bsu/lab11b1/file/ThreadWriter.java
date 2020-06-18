package by.bsu.lab11b1.file;

public class ThreadWriter implements Runnable {
    private final FileOperator fo;
    private String computerData;

    public ThreadWriter(FileOperator fo, String computerData) {
        super();
        this.fo = fo;
        this.computerData = computerData;
    }

    @Override
    public void run() {
        synchronized (fo) {
            System.out.println("Going to write...");
            fo.writeInFile(computerData);
            fo.setWriteComplete(true);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fo.notify();
        }
    }
}
