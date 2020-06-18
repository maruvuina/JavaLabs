package by.bsu.lab9b.substance.motorcyclist;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1726810535302265421L;
    private String name;
    private String surname;
    private static int age;

    public Person() {}

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void serializeStatic(ObjectOutputStream oos) throws IOException {
        oos.writeInt(age);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException{
        age = ois.readInt();
    }

    @Override
    public String toString() {
        return
                "\nname: " + name +
                "\nsurname: " + surname +
                "\nage: " + age;
    }
}
