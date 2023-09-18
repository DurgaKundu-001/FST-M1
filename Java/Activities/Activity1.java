package Activities;

public class Activity1 {
    public static void main(String[] args){
        Car Audi=new Car();
        Audi.make=2014;
        Audi.color="Black";
        Audi.transmission="Manual";

        Audi.displayCharacteristics();
        Audi.accelarate();
        Audi.brake();
    }
}
