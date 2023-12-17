package FlatProject.actions;

import FlatProject.interfaces.MyFlatInterface;
import FlatProject.models.Flat;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class ObjectSerialization {
    public static void writeToFileFlat(String fileName, Collection<? extends Flat> array){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(array);
            System.out.println("Object saved");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Flat> readFromFileFlat(String fileName){
        ArrayList<Flat> readArray = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            readArray = (ArrayList<Flat>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return readArray;
    }


    public static void writeToFileRoom(String fileName, Collection<? extends MyFlatInterface> array){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(array);
            System.out.println("Object saved");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<MyFlatInterface> readFromFileRoom(String fileName){
        ArrayList<MyFlatInterface> readArray = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            readArray = (ArrayList<MyFlatInterface>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return readArray;
    }
}
