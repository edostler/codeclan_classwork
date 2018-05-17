public enum RoomType {

    SINGLE(1, "Single"),
    DOUBLE(2, "Double"),
    TRIPLE(3, "Triple"),
    FAMILY(4, "Family"),
    CONF_SM(10, "Small Conference"),
    CONF_MD(30, "Medium Conference"),
    CONF_LG(100, "Large Conference"),
    DINING(200, "Dining");

    private int capacity;
    private String roomType;

    RoomType(int capacity, String roomType) {
        this.capacity = capacity;
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomType() {
        return roomType;
    }
}
