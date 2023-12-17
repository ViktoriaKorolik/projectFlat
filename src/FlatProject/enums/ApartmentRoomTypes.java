package FlatProject.enums;

public enum ApartmentRoomTypes {
    KITCHEN,
    CORRIDOR,
    TOILET,
    BATHROOM,
    BEDROOM,
    BALCONY,
    KIDSROOM;

    public static boolean isValid(String g){
        try{
            return ApartmentRoomTypes.valueOf(g) != null;
        }
        catch (Exception ex){
            return false;
        }
    }

}
