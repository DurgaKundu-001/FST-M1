package Activities;

public class Activity7 {
}

interface BicycleParts{
    public int gears=0;
    public int currentSpeed=0;
}

interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
 class Bicycle implements BicycleParts, BicycleOperations {
     public int gears;
     public int currentSpeed;

     public Bicycle(int gears, int currentSpeed) {
         this.gears = gears;
         this.currentSpeed = currentSpeed;
     }


     public void applyBrake(int decrement) {
         currentSpeed -= decrement;
         System.out.println("Current speed: " + currentSpeed);
     }


     public void speedUp(int increment) {
         currentSpeed += increment;
         System.out.println("Current speed: " + currentSpeed);
     }
     public String bicycleDesc() {
         return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
     }
 }
