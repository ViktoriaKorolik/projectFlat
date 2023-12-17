package FlatProject.menu;

import FlatProject.actions.Printer;
import FlatProject.actions.ReaderFile;
import FlatProject.actions.ReaderFromConsole;
import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceFlatCommon;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.interfaces.Printable;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public class Application {

    public static String doubleFormat = "#0.00";
    public static DecimalFormat doubleFormatter;

    //String formattedDouble = new DecimalFormat("#0.00").format(0.1321231);
    static {
        doubleFormatter = new DecimalFormat(doubleFormat);

        //DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern(doubleFormat)).toFormatter();
    }

    public Application() {
        AtomicReference<Collection<MyFlatInterface>> rooms = new AtomicReference<>();
        AtomicReference<Collection<InterfaceFlatCommon>> flats = new AtomicReference<>();

        try {

            Menu mainMenu = new Menu("Main Menu", "My flat-constructor");
            Menu subMenuLoad = new Menu("Load saved data", "get data from file");
            Menu subMenuPrint = new Menu("Print data", "print data");
            Menu subMenuCreate = new Menu("Create data", "print data from memory");
            Menu subMenuActions = new Menu("Manipulate data", "data manipulations");

            //sub menu activate


            mainMenu.putAction("load data", () -> subMenuLoad.activateMenu());
            mainMenu.putAction("print data", () -> subMenuPrint.activateMenu());
            mainMenu.putAction("create data", () -> subMenuCreate.activateMenu());
            mainMenu.putAction("print flats", () -> subMenuPrint.activateMenu());
            mainMenu.putAction("data manipulations", () -> subMenuActions.activateMenu());

            //submenu load
            subMenuLoad.putAction("load saved rooms", () -> {
                try {
                    Collection<MyFlatInterface> collectionRooms = ReaderFile.parseFileRoom("room.txt");
                    rooms.set(collectionRooms);
                    System.out.println("Data loaded");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            subMenuLoad.putAction("load saved flats", () -> {
            });
            subMenuLoad.putAction("main menu", () -> mainMenu.activateMenu());

            //submenu print
            subMenuPrint.putAction("print collection of room", () -> {
              /*  try {
                   // print(rooms);
                    //SortedSet<MyFlatInterface> ss = new TreeSet<>((Comparator) rooms);
                   // Printer.PrintSet(ss);

                } catch (FlatException e) {
                    throw new RuntimeException(e);
                }*/
            });
            subMenuPrint.putAction("print collection of flat", () -> {
            });
            subMenuPrint.putAction("back to main menu", () -> mainMenu.activateMenu());

            //submenu create
            subMenuCreate.putAction("create room", () -> {
                try {
                    MyFlatInterface r = ReaderFromConsole.readAndCreateRoom();
                    r.print();
                } catch (FlatException e) {
                    throw new RuntimeException(e);
                }
            });
            subMenuCreate.putAction("create flat", () -> {
            });
            subMenuCreate.putAction("main menu", () -> mainMenu.activateMenu());

            //submenu actions
            subMenuActions.putAction("sort room", () -> {
            });
            subMenuActions.putAction("find room", () -> {
            });
            subMenuActions.putAction("back to main menu", () -> mainMenu.activateMenu());

            mainMenu.putAction("quit", () -> System.exit(0));
            mainMenu.activateMenu();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static void print( Collection<MyFlatInterface> rooms) throws FlatException {
        for (MyFlatInterface m : rooms) {
            m.print();
        }
    }
}
