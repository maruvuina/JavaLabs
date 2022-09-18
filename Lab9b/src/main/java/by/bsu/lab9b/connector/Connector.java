package by.bsu.lab9b.connector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import by.bsu.lab9b.substance.motorcyclist.Motorcyclist;
import by.bsu.lab9b.substance.motorcyclist.Person;

public class Connector {

    private final String DIR_NAME = "dir";
    private final String FILE_NAME = "motorcyclist";
    private final String FILE_EXTENSION = ".ser";
    private final String RELATIVE_PATH_TO_FILE = DIR_NAME + File.separator + FILE_NAME + FILE_EXTENSION;

    public void serializedObject(Motorcyclist motorcyclist) {
        File file = new File(RELATIVE_PATH_TO_FILE);
        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Person.serializeStatic(oos);
            oos.writeObject(motorcyclist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeStaticDataObject(Motorcyclist motorcyclist) {
        motorcyclist.setNickName("default Nickname");
        int age = 19;
        motorcyclist.setAge(age);
    }

    public Motorcyclist deSerializedObject() {
        Motorcyclist moto = null;
        try(FileInputStream fis = new FileInputStream(RELATIVE_PATH_TO_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Person.deserializeStatic(ois);
            moto = (Motorcyclist)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return moto;
    }
}
