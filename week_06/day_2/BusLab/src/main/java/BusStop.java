import java.util.ArrayList;

public class BusStop {

    private String name;
    private ArrayList<Person> queue;

    public BusStop () {
        this.queue = new ArrayList<>();
    }

    public int getQueueSize() {
        return this.queue.size();
    }

    public void addPersonToQueue(Person person) {
        this.queue.add(person);
    }

    public Person removePersonFromQueue() {
        if (this.queue.size() > 0) {
            return this.queue.remove(0);
        }
        return null;
    }
}
