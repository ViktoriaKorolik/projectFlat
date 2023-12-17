package FlatProject.models.createRoomFabricMethod;

import FlatProject.enums.CommunalRoomTypes;
import FlatProject.exceptions.FlatException;
import FlatProject.interfaces.InterfaceAbstractRoom;
import FlatProject.interfaces.MyFlatInterface;
import FlatProject.models.rooms.*;

public class CommunalRoomCreator<R, S> extends RoomsCreaterClass<R, S> {
    @Override
    protected MyFlatInterface createRoom(R roomType, S specOption, InterfaceAbstractRoom interfaceRoom) throws FlatException {
        MyFlatInterface myFlatInterface = null;
        CommunalRoomTypes communalRoomType = CommunalRoomTypes.valueOf(roomType.toString());
        switch (communalRoomType){
            case KITCHEN -> {
                myFlatInterface = new Kitchen<>((CommunalRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
                break;
            }
            case CORRIDOR -> {
                myFlatInterface = new Corridor<>((CommunalRoomTypes) roomType, (Double) specOption, interfaceRoom);
                break;
            }
            case TOILET -> {
                myFlatInterface = new Toilet<>((CommunalRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
                break;
            }
            case BEDROOM -> {
                myFlatInterface = new Bedroom<>((CommunalRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
                break;
            }
            case BALCONY -> {
                myFlatInterface = new Balcony<>((CommunalRoomTypes) roomType, (Boolean) specOption, interfaceRoom);
               /* Class<? extends  InterfaceAbstractRoom> irClass = interfaceRoom.getClass();
                Field fieldNumberRoom = irClass.getField("numberRoom");
                Field fieldWidth = irClass.getDeclaredField("width");
                Field fieldLength = irClass.getDeclaredField("length");
                Field fieldSquare = irClass.getDeclaredField("square");
                fieldNumberRoom.setAccessible(true);
                fieldLength.setAccessible(true);
                fieldWidth.setAccessible(true);
                fieldSquare.setAccessible(true);
                try {
                    String numberRoom = (String) fieldNumberRoom.get(interfaceRoom);
                    double width = fieldWidth.getDouble(interfaceRoom);
                    double length = fieldLength.getDouble(interfaceRoom);
                    double square = fieldSquare.getDouble(interfaceRoom);

                    System.out.println(numberRoom + "\t" + width + "\t" + length + "\t" + square);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }*/
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


