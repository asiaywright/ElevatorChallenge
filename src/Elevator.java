import java.util.*;

public class Elevator {
    private int currentFloor;
    private final int MAX_FLOORS = 20;
    private final Queue<Integer> requests = new LinkedList<>();

  
    public Elevator(int startFloor) {
        this.currentFloor = startFloor;
    }

    // Adds a floor request to the queue if valid
    public void addRequest(int floor) {
        if (floor < 1 || floor > MAX_FLOORS) {
            System.out.println("Invalid floor.");
            return;
        }
        if (floor == currentFloor) {
            System.out.println("Already on floor " + floor);
            return;
        }
        if (!requests.contains(floor)) {
            requests.add(floor);
            System.out.println("Request added: Floor " + floor);
        }
    }

    // Processes the next request in the queue
    public void processNextRequest() {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        int nextFloor = requests.poll();
        moveToFloor(nextFloor);
    }

    // Moves elevator to the target floor one step at a time
    private void moveToFloor(int targetFloor) {
        System.out.println("Moving from floor " + currentFloor + " to " + targetFloor);
        while (currentFloor != targetFloor) {
            currentFloor += (targetFloor > currentFloor) ? 1 : -1;
            System.out.println("Passing floor: " + currentFloor);
        }
        System.out.println("Arrived at floor " + currentFloor + ". Doors opening.");
    }

    // Returns the current floor
    public int getCurrentFloor() {
        return currentFloor;
    }

    // Returns true if there are pending requests
    public boolean hasRequests() {
        return !requests.isEmpty();
    }
}

