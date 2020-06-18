package by.bsu.lab9b.print;

import by.bsu.lab9b.logic.Logic;
import by.bsu.lab9b.substance.clothes.cloth.Cloth;
import by.bsu.lab9b.substance.motorcyclist.Motorcyclist;

import java.util.ArrayList;

public class PrintResults {
    public void printMotorcyclist(Motorcyclist motorcyclist) {
        System.out.println("Motorcyclist nickname: " + motorcyclist.getNickName());
        System.out.println("Name: " + motorcyclist.getName());
        System.out.println("Surname: " + motorcyclist.getSurname());
        System.out.println("Age: " + motorcyclist.getAge());
    }

    public void printBuyPrice(Motorcyclist motorcyclist) {
        System.out.println(new Logic().getPrice(motorcyclist));
    }

    public void printMotorcyclistsCloth(Motorcyclist motorcyclist){
        ArrayList<Cloth> clothes = motorcyclist.getClothList();
        for (Cloth cloth : clothes) {
            System.out.println(cloth);
        }
    }

    public void printMotorcyclistsCloth(ArrayList<Cloth> clothes ){
        for (Cloth cloth : clothes) {
            System.out.println(cloth);
        }
    }
}
