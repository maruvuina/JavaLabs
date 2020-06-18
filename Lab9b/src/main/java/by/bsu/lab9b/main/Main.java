package by.bsu.lab9b.main;

import by.bsu.lab9b.connector.Connector;
import by.bsu.lab9b.logic.Logic;
import by.bsu.lab9b.print.PrintResults;
import by.bsu.lab9b.shop.ClothesShop;
import by.bsu.lab9b.substance.clothes.cloth.Cloth;
import by.bsu.lab9b.substance.motorcyclist.Motorcyclist;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.print("Enter motorcycle age: ");
        Scanner ageScanner = new Scanner(System.in);
        int age;
        age = ageScanner.nextInt();
        Motorcyclist motorcyclist = new Motorcyclist(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().username(),
                age, new ArrayList<>());

        int key;
        do {
            System.out.println("\nEnter key number: ");
            System.out.println("Who?-------------------------------------------->1");
            System.out.println("Buy ammunition---------------------------------->2");
            System.out.println("What is a price of the ammunition?-------------->3");
            System.out.println("Sort ammunition by weight----------------------->4");
            System.out.println("Find purchased ammunition by price-------------->5");
            System.out.println("Serialize Object-------------------------------->6");
            System.out.println("Change static data after after serialization---->7");
            System.out.println("Deserialize Object------------------------------>8");
            System.out.println("Exit from program------------------------------->9");
            Scanner countScan = new Scanner(System.in);
            key = countScan.nextInt();
            PrintResults print = new PrintResults();
            Logic logic = new Logic();
            Connector connector = new Connector();
            switch (key) {
                case 1:
                    print.printMotorcyclist(motorcyclist);
                    break;
                case 2:
                    ClothesShop clothesShop = new ClothesShop();
                    String []buyClothes =
                            {"Boots", "Gloves", "Jacket", "Hemlet", "Pants", "ProtectionCloth"};
                    clothesShop.buy(motorcyclist.getClothList(), buyClothes);
                    System.out.println("You buy");
                    print.printMotorcyclistsCloth(motorcyclist.getClothList());
                    break;
                case 3:
                    System.out.print("Purchase amount: ");
                    print.printBuyPrice(motorcyclist);
                    break;
                case 4:
                    motorcyclist = logic.sortByWeight(motorcyclist);
                    print.printMotorcyclistsCloth(motorcyclist.getClothList());
                    break;
                case 5:
                    System.out.print("Enter minimum price: ");
                    Scanner minPriceScanner = new Scanner(System.in);
                    int minPrice = minPriceScanner.nextInt();
                    System.out.print("Enter maximum price: ");
                    Scanner maxPriceScanner = new Scanner(System.in);
                    int maxPrice = maxPriceScanner.nextInt();
                    ArrayList<Cloth> cl = logic.getClothesByPriceGap(motorcyclist, minPrice, maxPrice);
                    print.printMotorcyclistsCloth(cl);
                    break;
                case 6:
                    connector.serializedObject(motorcyclist);
                    System.out.println("Object has been serialized");
                    break;
                case 7:
                    System.out.println("Object has been chanched");
                    connector.changeStaticDataObject(motorcyclist);
                    break;
                case 8:
                    Motorcyclist moto = connector.deSerializedObject();
                    System.out.println("Object has been deserialized");
                    print.printMotorcyclist(moto);
                    print.printMotorcyclistsCloth(moto.getClothList());
                    break;
            }
        } while (key != 9);
    }
}
