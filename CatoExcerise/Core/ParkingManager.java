package CatoExcerise.Core;
import java.util.HashMap;
import java.util.Map;

public class ParkingManager {
    private Map<Integer, CarManager> floors;

    public ParkingManager(int numOfFloors, int spotsPerFloor) {
        floors = new HashMap<>();
        for (int i = 0; i < numOfFloors; i++) {
            floors.put(i, new CarManager(spotsPerFloor));
        }
    }

    public int parkCar(int floor) {
        if (floors.containsKey(floor)) {
            return floors.get(floor).park();
        }
        return -1; // Invalid floor input, i return -1 to indicate that the floor is invalid
    }

    public int getCarsOnFloor(int floor) {
        if (floors.containsKey(floor)) {
            return floors.get(floor).getCounter();
        }
        return -1; // Invalid floor input, i return -1 to indicate that the floor is invalid 
    }
}

