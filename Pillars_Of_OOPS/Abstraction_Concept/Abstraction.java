package Pillars_Of_OOPS.Abstraction_Concept;
interface Car1 {
    void startEngine() ;
    void stopEngine() ;
    void accelerateEngine() ;
    void breakEngine() ;
}

class SportsCar1 implements Car1{
    boolean isEngineOn ;
    int currSpeed;
    
    public void startEngine()
    {
        this.isEngineOn = true ;
        this.currSpeed = 20 ;
        System.out.println("Engine has been started.");
    }

    public void stopEngine(){
        this.isEngineOn = false ;
        this.currSpeed = 0 ;
        System.out.println("Engine has been stopeed.");
    }

    public void accelerateEngine(){
        if(!isEngineOn) System.out.println("Engine is off, cannot accelerate.");
        else{
            this.currSpeed += 20 ;
            System.out.println("Engine has been accelerated and the current speed is " + currSpeed +"km/h");
        }
    }

    public void breakEngine(){
        if(!isEngineOn) System.out.println("Engine is off, cannot break.");
        else{
            this.currSpeed -= 20 ;
            if(this.currSpeed < 0) this.currSpeed = 0;
            System.out.println("Engine has been breaked and the current speed is " + currSpeed + "km/h");
        }
    }
}

public class Abstraction{
    public static void main(String[] args) {
        SportsCar1 mycar1Car1 = new SportsCar1() ;
        mycar1Car1.startEngine();
        mycar1Car1.accelerateEngine();
        mycar1Car1.accelerateEngine();
        mycar1Car1.breakEngine();
        mycar1Car1.accelerateEngine();
        mycar1Car1.stopEngine();
    }
}