package by.bsu.lab9b.substance.motorcyclist;

import by.bsu.lab9b.substance.clothes.cloth.Cloth;
import java.util.ArrayList;

public class Motorcyclist extends Person {

    private static final long serialVersionUID = -6127457105150299548L;

    private static String nickName;

    private ArrayList<Cloth> cloths;

    public Motorcyclist(String name, String surname, String nickName, int age, ArrayList<Cloth> cloths) {
        super(name, surname, age);
        this.nickName = nickName;
        this.cloths = cloths;
    }

    public Motorcyclist(String name, String surname, int age, ArrayList<Cloth> cloths) {
        super(name, surname, age);
        this.cloths = cloths;
    }

    public void addCloth(Cloth cloth) {
        cloths.add(cloth);
    }

    public void setCloths(ArrayList<Cloth> cloths) {
        this.cloths = cloths;
    }

    public Cloth getCloth(int n) {
        return cloths.get(n);
    }

    public ArrayList<Cloth> getClothList() {
        return cloths;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("===========================");
                str.append("\nnickName: ")
                .append(nickName)
                .append("\n");
        for (Cloth cloth : cloths) {
            str.append(cloth).append("\n");
        }
        str.append("===========================");
        return str.toString();
    }
}
