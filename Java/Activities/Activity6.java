package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane= new Plane(10);
        plane.onboard("Durga");
        plane.onboard("Ria");
        plane.onboard("Disha");
        plane.onboard("Risan");
        System.out.println("The take-off time is : "+ plane.takeOff());
        System.out.println("List of people on the plane : "+ plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("The landing time is : "+ plane.getLastTimeLanded());

    }
}

class Plane{

    private int maxPassengers;
    private List<String> passengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;



    public  Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }
    public void onboard(String passenger){
        this.passengers.add(passenger);
    }
    public Date takeOff(){
        this.lastTimeTookOf= new Date();
        return lastTimeTookOf;

    }
    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }
    public List<String> getPassengers() {
        return passengers;
    }
}