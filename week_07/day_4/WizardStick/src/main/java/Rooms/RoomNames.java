package Rooms;

public enum RoomNames {
    TONTINECLASSROOM(1, "Tontine Classroom"),
    ROOMOFBLOOD(2, "Room of Blood"),
    ROOMOFPAIN(3, "Room of Pain"),
    ROOMOFDOOM(4, "Room of Doom"),
    ROOMOFTERROR(5, "Room of Terror"),
    ROOMOFFAILEDCODINGDREAMS(6, "Room of Failed Coding Dreams"),
    ROOMOFBRIDGES(7, "Room of Bridges"),
    ROOMOFFAIRIES(8, "Room of Fairies");


    private int roomNumber;
    private String roomName;


    RoomNames(int roomNumber, String roomName) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
