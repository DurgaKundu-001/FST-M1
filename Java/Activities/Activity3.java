package Activities;

public class Activity3 {
    public static void main(String[] args){

        double seconds=1000000000;
        double EarthSec=31557600 ,
                MercurySec=0.2408467,
                VenusSec=0.61519726,
                MarsSec=1.8808158,
                JupiterSec=11.862615,
                SaturnSec=29.447498,
                UranusSec=84.016846,
                NeptuneSec=164.79132;
        System.out.println("The age of Mercury is " + seconds/EarthSec/MercurySec);
        System.out.println("The age of Venus is " + seconds/EarthSec/VenusSec);
        System.out.println("The age of Mars is " + seconds/EarthSec/MarsSec);
        System.out.println("The age of Jupiter is " + seconds/EarthSec/JupiterSec);
        System.out.println("The age of Saturn is " + seconds/EarthSec/SaturnSec);
        System.out.println("The age of Uranus is " + seconds/EarthSec/UranusSec);
        System.out.println("The age of Neptune is " + seconds/EarthSec/NeptuneSec);

    }
}
