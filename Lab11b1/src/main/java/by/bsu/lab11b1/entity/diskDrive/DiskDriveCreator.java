package by.bsu.lab11b1.entity.diskDrive;

import by.bsu.lab11b1.logic.RandomEnum;

public class DiskDriveCreator {
    public DiskDrive fillRandomazed(DiskDrive diskDrive) {
        RandomEnum randomEnum = new RandomEnum<>(TypeDiskDrive.class);
        diskDrive.setCapacity((int)(Math.random()*10));
        diskDrive.setSpeed((int)(Math.random()*100));
        diskDrive.setTypeDiskDrive((TypeDiskDrive)randomEnum.random());
        return diskDrive;
    }
}
