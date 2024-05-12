package CatoExcerise.Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import CatoExcerise.Core.ParkingManager;

public class ParkingManagerTests {

    private ParkingManager parkingManager;
    
    @BeforeEach
    public void setUp() {
        parkingManager = new ParkingManager(5, 5);
    }

    @Test
    public void testParkCar_sanity() {
        int spot = parkingManager.parkCar(0);
        assertEquals(0, spot, "Expected spot to be 0");
    }

    @Test
    public void testParkCar_noSpotsAvailable() {
        for (int i = 0; i < 5; i++) {
            parkingManager.parkCar(0);
        }
        int spot = parkingManager.parkCar(0);
        assertEquals(-1, spot, "Expected spot to be -1");
    }

    @Test
    public void testGetCarsOnFloor() {
        int counter = parkingManager.getCarsOnFloor(0);
        assertEquals(0, counter, "Expected counter to be 0");
    }

    @Test
    public void testGetCarsOnFloor_InValidFloor() {
        int counter = parkingManager.getCarsOnFloor(6);
        assertEquals(-1, counter, "Expected counter to be -1");
    }

    @Test
    public void testParkCar_InValidFloor() {
        int spot = parkingManager.parkCar(6);
        assertEquals(-1, spot, "Expected spot to be -1");
    }

    
}

