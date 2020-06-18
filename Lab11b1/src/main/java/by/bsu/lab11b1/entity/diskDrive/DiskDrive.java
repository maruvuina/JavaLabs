package by.bsu.lab11b1.entity.diskDrive;


public class DiskDrive {
    private double capacity;
    private int speed;
    private TypeDiskDrive typeDiskDrive;

    public DiskDrive() {}

    public DiskDrive(double capacity, int speed, TypeDiskDrive typeDiskDrive) {
        this.capacity = capacity;
        this.speed = speed;
        this.typeDiskDrive = typeDiskDrive;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTypeDiskDrive(TypeDiskDrive typeDiskDrive) {
        this.typeDiskDrive = typeDiskDrive;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public TypeDiskDrive getTypeDiskDrive() {
        return typeDiskDrive;
    }

    @Override
    public String toString() {
        return "\nDiskDrive" +
                "\ncapacity: " + capacity +
                "\nspeed: " + speed +
                "\ntypeDiskDrive: " + typeDiskDrive + "\n\n";
    }
}
