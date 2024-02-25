import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    Car car = new Car(50,12);
    @Test
    public void thisTestShouldReturnAllTheDefaultValues() {

    assertEquals(50,car.getFuelCapacity());
    assertEquals(12,car.getAvg());
    assertEquals(0,car.getAvailableFuel());
    assertEquals(0,car.getDistanceCovered());

    assertEquals(0,car.getDistanceCarCanTravel());

    }
    @Test
    public void thisTestShouldTestRefillFuel(){
        car.refillFuel(30);
        assertEquals(30,car.getAvailableFuel());
        assertEquals(360,car.getDistanceCarCanTravel());
    }

    @Test
    public void thisTestShouldTestBeyondCapacityFuel(){

        assertThrows(IllegalArgumentException.class,()->{
            car.refillFuel(51);
        });
    }
    @Test
    public void testForDistanceCoveredAndRemainingFuel(){
        car.refillFuel(40);

        car.drive(100);
        assertEquals(100,car.getDistanceCovered());

        assertEquals((40f-100f/12f),(car.getAvailableFuel()));
        assertEquals((40f-100f/12f)*12,car.getDistanceCarCanTravel());
    }
    @Test
    public void testForDistanceMoreAvailableFuel()
    {
        car.refillFuel(1);

        assertThrows(IllegalArgumentException.class,()->{
            car.drive(100);
        });
    }
}
