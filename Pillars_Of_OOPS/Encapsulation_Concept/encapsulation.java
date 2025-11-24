package Pillars_Of_OOPS.Encapsulation_Concept;

interface Car2 {
    void startEngine();

    void stopEngine();

    void accelerateEngine();

    void breakEngine();
}

class SportsCar2 implements Car2 {
    private boolean isEngineOn;
    private int currSpeed;

    public void getCurrSpeed(){
        System.out.println("Current Speed: " + this.currSpeed + "km/h");
    }

    public void setCurrSpeed(int speed){
        this.currSpeed = speed ;
        System.out.println("Current Speed: " + this.currSpeed + "km/h");
    }

    public void startEngine() {
        this.isEngineOn = true;
        this.currSpeed = 20;
        System.out.println("Engine has been started.");
    }

    public void stopEngine() {
        this.isEngineOn = false;
        this.currSpeed = 0;
        System.out.println("Engine has been stopped.");
    }

    public void accelerateEngine() {
        if (!isEngineOn)
            System.out.println("Engine is off, cannot accelerate.");
        else {
            this.currSpeed += 20;
            System.out.println("Engine has been accelerated and the current speed is " + currSpeed + "km/h");
        }
    }

    public void breakEngine() {
        if (!isEngineOn)
            System.out.println("Engine is off, cannot break.");
        else {
            this.currSpeed -= 20;
            if (this.currSpeed < 0)
                this.currSpeed = 0;
            System.out.println("Engine has been breaked and the current speed is " + currSpeed + "km/h");
        }
    }
}

public class encapsulation {
    public static void main(String[] args) {
        SportsCar2 mycar2 = new SportsCar2();
        mycar2.startEngine();
        mycar2.accelerateEngine();
        mycar2.accelerateEngine();
        mycar2.breakEngine();
        mycar2.getCurrSpeed();
        mycar2.accelerateEngine();
        mycar2.stopEngine();

    }
}
