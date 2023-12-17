package FlatProject.models;

import FlatProject.interfaces.InterfaceFlatCommon;
import FlatProject.interfaces.MyFlatInterface;

import java.util.ArrayList;
import java.util.Collection;

public class Flat implements InterfaceFlatCommon {
    private int countOfRoom;
    Collection<MyFlatInterface> collectionRooms = new ArrayList<>();

    public Flat(int countOfRoom, Collection<MyFlatInterface> collectionRooms) {
        this.countOfRoom = countOfRoom;
        this.collectionRooms = collectionRooms;
    }

    public int getCountOfRoom() {
        return countOfRoom;
    }

    public void setCountOfRoom(int countOfRoom) {
        this.countOfRoom = countOfRoom;
    }

    public Collection<MyFlatInterface> getCollectionRooms() {
        return collectionRooms;
    }

    public void setCollectionRooms(Collection<MyFlatInterface> collectionRooms) {
        this.collectionRooms = collectionRooms;
    }
}
