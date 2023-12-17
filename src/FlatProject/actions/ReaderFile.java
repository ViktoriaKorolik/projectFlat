package FlatProject.actions;

import FlatProject.enums.ApartmentRoomTypes;
import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceAbstractRoom;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.models.createRoomFabricMethod.ApartmentRoomCreator;
import FlatProject.models.createRoomFabricMethod.RoomsCreaterClass;
import FlatProject.models.rooms.Room;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ReaderFile {

    public static Collection<MyFlatInterface> parseFileRoom(String filePath) {
        Collection<MyFlatInterface> myFlatInterfacesCollection = new ArrayList<>();
        boolean coffeeMachine = false;
        boolean urinal = false;
        boolean showerCabin = false;
        boolean hasWindow = false;
        double carpetLength = 0.0;
        int bed = 0;
        int toys = 0;
        RoomsCreaterClass apart = new ApartmentRoomCreator();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();//для пропуска 1-й строки
            while ((line = br.readLine()) != null) {

                // Split the line into String creditName, double amount, double rate, int creditTerm, boolean earlyClosePossibility, boolean increaseCreditLimit, boolean salaryCertificate
                String[] parts = line.split(", ");

                // Extract data from parts and create a new room object
                ApartmentRoomTypes type = ApartmentRoomTypes.valueOf(parts[0]);
                switch (type.name()) {
                    case "KITCHEN" -> {
                        coffeeMachine = Boolean.parseBoolean((parts[1].split(", ")[0]));
                        String roomNumber = String.valueOf(parts[2].split(", ")[0]);
                        double width = Double.parseDouble(parts[3].split(", ")[0]);
                        double length = Double.parseDouble(parts[4].split(", ")[0]);
                        double square = Double.parseDouble(parts[5].split(", ")[0]);
                        MyFlatInterface my =
                                apart.buildRoom(type,
                                        coffeeMachine,
                                        new Room(roomNumber,
                                                width,
                                                length,
                                                width * length));
                        myFlatInterfacesCollection.add(my);
                        break;
                    }
                    case "CORRIDOR" -> {
                        carpetLength = Double.parseDouble((parts[1].split(", ")[0]));
                        String roomNumber = String.valueOf(parts[2].split(", ")[0]);
                        double width = Double.parseDouble(parts[3].split(", ")[0]);
                        double length = Double.parseDouble(parts[4].split(", ")[0]);
                        double square = Double.parseDouble(parts[5].split(", ")[0]);
                        MyFlatInterface my =
                                apart.buildRoom(type,
                                        carpetLength,
                                        new Room(roomNumber,
                                                width,
                                                length,
                                                width * length));
                        myFlatInterfacesCollection.add(my);
                        break;
                    }
                    case "TOILET" -> {
                        urinal = Boolean.parseBoolean((parts[1].split(", ")[0]));
                        String roomNumber = String.valueOf(parts[2].split(", ")[0]);
                        double width = Double.parseDouble(parts[3].split(", ")[0]);
                        double length = Double.parseDouble(parts[4].split(", ")[0]);
                        double square = Double.parseDouble(parts[5].split(", ")[0]);
                        MyFlatInterface my =
                                apart.buildRoom(type,
                                        urinal,
                                        new Room(roomNumber,
                                                width,
                                                length,
                                                width * length));
                        myFlatInterfacesCollection.add(my);
                        break;
                    }
                    case "BATHROOM" -> {
                        showerCabin = Boolean.parseBoolean((parts[1].split(", ")[0]));
                        String roomNumber = String.valueOf(parts[2].split(", ")[0]);
                        double width = Double.parseDouble(parts[3].split(", ")[0]);
                        double length = Double.parseDouble(parts[4].split(", ")[0]);
                        double square = Double.parseDouble(parts[5].split(", ")[0]);
                        MyFlatInterface my =
                                apart.buildRoom(type,
                                        showerCabin,
                                        new Room(roomNumber,
                                                width,
                                                length,
                                                width * length));
                        myFlatInterfacesCollection.add(my);
                        break;
                    }
                    case "BEDROOM" -> {
                        bed = Integer.parseInt((parts[1].split(", ")[0]));
                        String roomNumber = String.valueOf(parts[2].split(", ")[0]);
                        double width = Double.parseDouble(parts[3].split(", ")[0]);
                        double length = Double.parseDouble(parts[4].split(", ")[0]);
                        double square = Double.parseDouble(parts[5].split(", ")[0]);
                        MyFlatInterface my =
                                apart.buildRoom(type,
                                        roomNumber,
                                        new Room(roomNumber,
                                                width,
                                                length,
                                                width * length));
                        myFlatInterfacesCollection.add(my);
                        break;
                    }
                    case "BALCONY" -> {
                        hasWindow = Boolean.parseBoolean((parts[1].split(", ")[0]));
                        String roomNumber = String.valueOf(parts[2].split(", ")[0]);
                        double width = Double.parseDouble(parts[3].split(", ")[0]);
                        double length = Double.parseDouble(parts[4].split(", ")[0]);
                        double square = Double.parseDouble(parts[5].split(", ")[0]);
                        MyFlatInterface my =
                                apart.buildRoom(type,
                                        hasWindow,
                                        new Room(roomNumber,
                                                width,
                                                length,
                                                width * length));
                        myFlatInterfacesCollection.add(my);
                        break;
                    }
                    case "KIDSROOM" -> {
                        toys = Integer.parseInt((parts[1].split(", ")[0]));
                        String roomNumber = String.valueOf(parts[2].split(", ")[0]);
                        double width = Double.parseDouble(parts[3].split(", ")[0]);
                        double length = Double.parseDouble(parts[4].split(", ")[0]);
                        double square = Double.parseDouble(parts[5].split(", ")[0]);
                        MyFlatInterface my =
                                apart.buildRoom(type,
                                        toys,
                                        new Room(roomNumber,
                                                width,
                                                length,
                                                width * length));
                        myFlatInterfacesCollection.add(my);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FlatException e) {
            throw new RuntimeException(e);
        }
        return myFlatInterfacesCollection;
    }


}

