public class Car {
    private final int fuelCapacity;
    private final float avg;
    private float availableFuel;
    private float distanceCovered;
    private float distanceCarCanTravel;


    public Car(int fuelCapacity,float avg){
        this.fuelCapacity = fuelCapacity;
        this.avg = avg;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }
    public void refillFuel(float fuelInLitres){

        this.availableFuel +=  fuelInLitres;
        if(availableFuel>fuelCapacity) {
         throw new  IllegalArgumentException("Cannot Refill More Than Capacity");
        }
        distanceCarCanTravel = availableFuel*avg;
    }
    public void drive(float distanceInKms){
        distanceCovered=distanceInKms;
        float neededFuel = distanceInKms/avg;
        if(availableFuel>neededFuel){
            availableFuel-=neededFuel;
        }else {
            throw new IllegalArgumentException("Enough Fuel Not Available");
        }
        distanceCarCanTravel= availableFuel*avg;
    }
    public float getAvg() {
        return avg;
    }

    public float getAvailableFuel() {
        return availableFuel;
    }

    public float getDistanceCovered() {
        return distanceCovered;
    }

    public float getDistanceCarCanTravel() {

        return distanceCarCanTravel;
    }
}
