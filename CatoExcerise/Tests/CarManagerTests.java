package CatoExcerise.Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import CatoExcerise.Core.CarManager;

import org.junit.jupiter.api.BeforeEach;

public class CarManagerTests {

    private CarManager carManager;
    
    @BeforeEach
    public void setUp() {
        carManager = new CarManager(5);
    }

    @Test
    public void testPark_sanity() {
        int spot = carManager.park();
        assertEquals(0, spot, "Expected spot to be 0");
    }

    @Test
    public void testPark_noSpotsAvailable() {
        for (int i = 0; i < 5; i++) {
            carManager.park();
        }
        int spot = carManager.park();
        assertEquals(-1, spot, "Expected spot to be -1");
    }

    @Test
    public void testGetCounter() {
        int counter = carManager.getCounter();
        assertEquals(0, counter, "Expected counter to be 0");
    }

    @Test
    public void testOccupySpot() {
        carManager.park();
        int counter = carManager.getCounter();
        assertEquals(1, counter, "Expected counter to be 1");
    }

}