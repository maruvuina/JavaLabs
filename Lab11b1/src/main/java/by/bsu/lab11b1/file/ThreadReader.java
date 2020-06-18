package by.bsu.lab11b1.file;

public class ThreadReader implements Runnable {
    private final FileOperator fo;

    public ThreadReader(FileOperator fo) {
        super();
        this.fo = fo;
    }

    @Override
    public void run() {
        synchronized (fo) {
            if (!fo.isWriteComplete()) {
                try {
                    fo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("========Computer details are wtitten=========");
            fo.notify();
        }
    }
}
