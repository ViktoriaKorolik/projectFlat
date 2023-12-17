package FlatProject.models.createRoomFabricMethod;

import FlatProject.enums.ApartmentRoomTypes;
import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceAbstractRoom;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.interfaces.Printable;
import FlatProject.models.rooms.*;

public class ApartmentRoomCreator <R, S> extends RoomsCreaterClass<R, S> implements Printable {
    @Override
    protected MyFlatInterface createRoom(R roomType, S specOption, InterfaceAbstractRoom interfaceRoom) throws FlatException {
        MyFlatInterface myFlatInterface = null;
        ApartmentRoomTypes apartmentRoomType = ApartmentRoomTypes.valueOf(roomType.toString());
        switch (apartmentRoomType){
            case KITCHEN -> {
                myFlatInterface = new Kitchen<>((ApartmentRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
                break;
            }
            case CORRIDOR -> {
                myFlatInterface = new Corridor<>((ApartmentRoomTypes) roomType, (Double) specOption, interfaceRoom);
                break;
            }
            case TOILET -> {
                myFlatInterface = new Toilet<>((ApartmentRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
                break;
            }
            case BEDROOM -> {
                myFlatInterface = new Bedroom<>((ApartmentRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
                break;
            }
            case BALCONY -> {
                myFlatInterface = new Balcony<>((ApartmentRoomTypes) roomType, (Integer) specOption, interfaceRoom);
                break;
            }
            case BATHROOM -> {
                myFlatInterface = new Bathroom<>((ApartmentRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
                break;
            }
            case KIDSROOM -> {
                myFlatInterface = new Kidsroom<>((ApartmentRoomTypes) roomType, (Integer) specOption, interfaceRoom);
                break;
            }
        }
        return myFlatInterface;
    }

    @Override
    public void print() throws FlatException {
        this.print();
    }
}
