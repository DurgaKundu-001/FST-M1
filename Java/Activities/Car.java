package Activities;

public class Car {
    String color, transmission;
    int make,tyres,doors;
    Car(){
        tyres=4;
        doors=4;
    }
   public void displayCharacteristics(){
       System.out.println("The color of the Car is " + color);
       System.out.println("Make of the car is " +make);
       System.out.println("No of the doors in the car is " +doors);
       System.out.println("No of the tyres in the car is " +tyres);
   }
    public void accelarate(){
   System.out.println("Car is moving forward.");
    }
    public void brake(){
System.out.println("Car has stopped.");
    }
  }
