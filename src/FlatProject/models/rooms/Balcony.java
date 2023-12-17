package FlatProject.models.rooms;

import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceAbstractRoom;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.interfaces.Printable;

import java.io.Serializable;

public class Balcony<R, S> extends AbstractEntity<R, S> implements Printable, MyFlatInterface, Serializable {
    InterfaceAbstractRoom interfaceRoom;
    private InterfaceAbstractRoom interfaceAbstractRoom;
    //private boolean hasWindow;

    public Balcony(R roomType, S hasWindow, InterfaceAbstractRoom interfaceRoom) throws FlatException {
        super(roomType, hasWindow);
        this.interfaceRoom = interfaceRoom;
    }

    public InterfaceAbstractRoom getInterfaceRoom() {
        return interfaceRoom;
    }

    public void setInterfaceRoom(InterfaceAbstractRoom interfaceRoom) {
        this.interfaceRoom = interfaceRoom;
    }

    @Override
    public void print() throws FlatException {
        System.out.println("Type of room:" + "\t" + super.getParameter() + "\tThere are Window:\t" + super.getSpecOption());
        System.out.println("Room parameters:\t" + interfaceRoom.toString());
    }

    @Override
    public String toString() {
        return "Balcony{" +
                "interfaceRoom=" + interfaceRoom +
                '}';
    }
}
