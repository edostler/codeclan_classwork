public class BedRoom extends Room {

    private RoomType type;
    private int roomNumber;
    private double rate;


    public BedRoom(RoomType type, double rate, int roomNumber) {
        super(type.getCapacity());
        this.type = type;
        this.rate = rate;
        this.roomNumber = roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public double getRate() {
        return rate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
