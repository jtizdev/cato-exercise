package CatoExcerise.Core;
import java.util.HashMap;
import java.util.Map;

public class CarManager {
    private boolean isTaken;
    private Map<Integer, Integer> parkingSpots;
    private int counter;
    public CarManager(int numberOfSpots)
     {
        this.isTaken = false;
        this.parkingSpots = new HashMap<>();
        for (int i = 0; i < numberOfSpots; i++) {
            this.parkingSpots.put(i, 1); 
        }
    }

    public int park() {
    if (this.isTaken) {
        return -1; 
    }

    for (Map.Entry<Integer, Integer> entry : parkingSpots.entrySet()) {
        int spot = entry.getKey();
        int capacity = entry.getValue();
        
        if (capacity > 0) {
            occupySpot(spot);
            this.counter++;
            return spot;
        }
    }
    
    return -1; // no spots available, i return -1 to indicate that there are no spots available
}


private void occupySpot(int spot) {
    this.isTaken = true;
    int newCapacity = parkingSpots.get(spot) - 1;
    parkingSpots.put(spot, newCapacity);
}

public int getCounter() {
    return this.counter;
}


}
