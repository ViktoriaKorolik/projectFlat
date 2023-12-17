package FlatProject.actions;

import java.util.Scanner;

public class EnterData {
    static Scanner sc = new Scanner(System.in);

    public static void createRoom() {
        String numberRoom = "";
        double width = 0.0;
        double length = 0.0;
        double square = 0.0;
        System.out.println("Enter number of room(For example \" + 123 + \")");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLine()) {
            sc.nextLine();
            System.out.println("Invalid input, try again");
            System.out.println("Enter number of room(For example \" + 123 + \")");
        }

        System.out.println("Enter width of room(For example \" + 123 or 123.5 + \")");
        while (!sc.hasNextDouble()) {
            sc.nextLine();
            System.out.println("Invalid input, try again");
            System.out.println("Enter width of room(For example \" + 123 or 123.5 + \")");
        }
        System.out.println("Enter length of room(For example \" + 123 or 123.5 + \")");
        while (!sc.hasNextDouble()) {
            sc.nextLine();
            System.out.println("Invalid input, try again");
            System.out.println("Enter length of room(For example \" + 123 or 123.5 + \")");
        }
        square = width * length;
        System.out.println("Square = " + square);


    }
}
