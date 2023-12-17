package FlatProject.actions;

import FlatProject.enums.ApartmentRoomTypes;
import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceAbstractRoom;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.models.createRoomFabricMethod.ApartmentRoomCreator;
import FlatProject.models.createRoomFabricMethod.RoomsCreaterClass;
import FlatProject.models.rooms.*;

import java.util.Locale;
import java.util.Scanner;

import static FlatProject.enums.ApartmentRoomTypes.isValid;

public class ReaderFromConsole {
    public static MyFlatInterface readAndCreateRoom() throws FlatException {
        boolean coffeeMachine = false;
        boolean urinal = false;
        boolean showerCabin = false;
        boolean hasWindow = false;
        double carpetLength = 0.0;
        int bed = 0;
        int toys = 0;
        String roomNumber = "";
        Double width = 0.0;
        Double length = 0.0;
        ApartmentRoomTypes roomType = null;
        RoomsCreaterClass apart = new ApartmentRoomCreator();
        MyFlatInterface myFlatInterface = null;
        System.out.println("");//прочитаем поля из консоли
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ApartmentRoomTypes (KITCHEN)");
        while (!isValid(String.valueOf(roomType)) || roomType == null) {
            roomType = ApartmentRoomTypes.valueOf(sc.nextLine().toUpperCase(Locale.ROOT));
            if (!isValid(String.valueOf(roomType)) || roomType == null) {
                System.out.println("Invalid input, try again");
                System.out.println("Enter ApartmentRoomTypes (KITCHEN)");
            }
        }
        switch (roomType) {
            case BALCONY -> {
                System.out.println("Is it has Window?) - (true/false)");
                while (!sc.hasNextBoolean()) {
                    hasWindow = sc.nextBoolean();
                    if (!sc.hasNextBoolean()) {
                        System.out.println("Invalid input, try again");
                        System.out.println("Is it has Window?) - (true/false)");
                    }
                }

                break;
            }
            case BATHROOM -> {
                System.out.println("Is it has shower cabin?) - (true/false)");
                showerCabin = sc.nextBoolean();
                break;
            }
            case BEDROOM -> {
                System.out.println("How many bed in bedroom?) - (1)");
                bed = sc.nextInt();
                break;
            }
            case CORRIDOR -> {
                System.out.println("How long carpet in corridor?) - (1.5)");
                carpetLength = sc.nextDouble();
                break;
            }
            case KIDSROOM -> {
                System.out.println("How many toys in kidsroom?) - (100500)");
                bed = sc.nextInt();
                break;
            }
            case KITCHEN -> {
                System.out.println("Is it has shower coffeeMachine?) - (true/false)");
                coffeeMachine = sc.nextBoolean();
                break;
            }
            case TOILET -> {
                System.out.println("Is it has urinal?) - (true/false)");
                coffeeMachine = sc.nextBoolean();
                break;
            }
            default -> System.out.println("No Valid data, try again");

        }


        System.out.println("Enter room number(1-100)");
        while (!sc.hasNextLine() ||  (roomNumber = sc.nextLine()) == "") {
           // roomNumber = sc.nextLine();
            if (!sc.hasNextLine() ||  (roomNumber = sc.nextLine()) == "") {
                System.out.println("Invalid input, try again");
                System.out.println("Enter room number(1-100)");
            }
        }


        System.out.println("Enter width(2.5)");
        while (!sc.hasNextDouble() || (width = sc.nextDouble()) < 0.5) {
            //width = sc.nextDouble();
            if (!sc.hasNextDouble() || (width = sc.nextDouble()) < 0.5) {
                System.out.println("Invalid input, try again");
                System.out.println("Enter width(2.5)");
            }
        }


        System.out.println("Enter length(2.5)");
        while (!sc.hasNextDouble()) {
            length = sc.nextDouble();
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid input, try again");
                System.out.println("Enter length(2.5)");
            }

        }

        double square = length * width;
        InterfaceAbstractRoom interfaceAbstractRoom = new Room(roomNumber, width, length, square);
        switch (roomType) {
            case BALCONY -> {
                myFlatInterface = new Balcony<>(roomType, hasWindow, interfaceAbstractRoom);
                break;
            }
            case BATHROOM -> {
                myFlatInterface = new Bathroom<>(roomType, showerCabin, interfaceAbstractRoom);
                break;
            }
            case BEDROOM -> {
                myFlatInterface = new Bedroom<>(roomType, bed, interfaceAbstractRoom);
                break;
            }
            case CORRIDOR -> {
                myFlatInterface = new Corridor<>(roomType, carpetLength, interfaceAbstractRoom);
                break;
            }
            case KIDSROOM -> {
                myFlatInterface = new Kidsroom<>(roomType, toys, interfaceAbstractRoom);
                break;
            }
            case KITCHEN -> {
                myFlatInterface = new Kitchen<>(roomType, coffeeMachine, interfaceAbstractRoom);
                break;
            }
            case TOILET -> {
                myFlatInterface = new Toilet<>(roomType, urinal, interfaceAbstractRoom);
                break;
            }
        }
        myFlatInterface.print();
        return myFlatInterface;
    }

}
