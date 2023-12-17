package FlatProject.models.rooms;

import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceAbstractRoom;

import java.io.Serializable;

public class Room extends AbstractRoom implements InterfaceAbstractRoom, Serializable {
    public Room(String numberRoom, double width, double length, double square) {
        super(numberRoom, width, length, square);
    }


    @Override
    public void print() throws FlatException {
        System.out.println("Number room:\t");
    }
}
