public class Printer implements IPeripheral, IPrint {

    @Override
    public String connect() {
        return "connected";
    }

    @Override
    public String print(String data) {
        return "printing: " + data;
    }
}
