import java.util.ArrayList;

public class Bus {

    //declarations
    private String destination;
    private Integer capacity;
    private ArrayList<Person> passengers;

    //constructor
    public Bus(String destination, Integer capacity) {
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    //methods
    public int getBusSize() {
        return this.passengers.size();
    }

    public void addPersonToBus(Person person) {
        if (this.passengers.size() < this.capacity) {
            this.passengers.add(person);
        }
    }

    public void removePersonFromBus(Person person) {
        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i) == person) {
                this.passengers.remove(i);
                break;
            }
        }
    }

    public void makePickUp(BusStop busStop) {
        Person person = busStop.removePersonFromQueue();
        if (this.passengers.size() < this.capacity) {
            this.passengers.add(person);
        }
    }

}
