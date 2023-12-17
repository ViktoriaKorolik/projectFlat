package FlatProject.models.createRoomFabricMethod;

import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.FinishBuildInterfaceRoom;
import FlatProject.interfaces.InterfaceAbstractRoom;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.interfaces.Printable;

public abstract class RoomsCreaterClass<R, S> implements FinishBuildInterfaceRoom, Printable {

    public MyFlatInterface buildRoom(R roomType, S specOption, InterfaceAbstractRoom interfaceRoom) throws FlatException {
        MyFlatInterface myFlatInterface = createRoom(roomType, specOption, interfaceRoom);
       // System.out.printf("Room was created");
        return myFlatInterface;
    }

    protected abstract MyFlatInterface createRoom(R roomType, S specOption, InterfaceAbstractRoom interfaceRoom) throws FlatException;

    @Override
    public void print() throws FlatException {
        this.print();
    }
}
