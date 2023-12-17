package FlatProject.models.rooms;

import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceAbstractRoom;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.interfaces.Printable;

import java.io.Serializable;

public class Kitchen<R, S> extends AbstractEntity<R, S> implements Printable, MyFlatInterface, Serializable {
    InterfaceAbstractRoom interfaceRoom;
        // private boolean coffeeMachine;


    public Kitchen(R roomType, S coffeeMachine, InterfaceAbstractRoom interfaceRoom) throws FlatException{
        super(roomType, coffeeMachine);
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
        System.out.println("\nType of room:" + "\t" + super.getParameter() + "\nCoffee machine in the kitchen: \t" + super.getSpecOption());
        System.out.println("Room parameters:\n" + interfaceRoom.toString());
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "interfaceRoom=" + interfaceRoom +
                '}';
    }
}
