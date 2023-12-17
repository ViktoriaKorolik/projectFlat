package FlatProject.enums;

public enum CommunalRoomTypes {
    KITCHEN,
    CORRIDOR,
    TOILET,
    BEDROOM,
    BALCONY;

    public static boolean isValid(String g){
        try{
            return CommunalRoomTypes.valueOf(g) != null;
        }
        catch (Exception ex){
            return false;
        }
    }

}
