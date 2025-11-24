package SOLID_Principle.L.LSPRules.MethodRules;

// A Postcondition must be satisfied after a method is executed.
// Subclasses can strengthen the Postcondition but cannot weaken it.

class Car {
    protected int speed ;

    public Car(){
        this.speed = 0 ;
    }

    public void accelerate(){
        System.out.println("Car: Accelerating");
        this.speed += 20 ;
    }

    // PostCondition: Speed must reduce after brake
    public void brake(){
        System.out.println("Car: Applying break");
        this.speed -= 20 ;
        if(this.speed < 0) this.speed = 0 ;
    }
}

// Subclass can strengthen postcondition - Does not violate LSP
class HybridCar extends Car{
    private int charge ;

    public HybridCar(){
        super() ;
        this.charge = 0 ;
    }

    // PostCondition: Speed must reduce after brake
    // PostCondition: Charge must increase.
    @Override
    public void brake(){
        System.out.println("HybridCar: Applying brakes");
        speed -= 20 ;
        if(speed < 0) speed = 0 ;
        this.charge += 20 ;
    }
}

public class PostConditions {
    public static void main(String[] args) {
        Car car = new Car() ;
        car.accelerate();
        car.brake();

        Car hybridCar = new HybridCar();
        hybridCar.brake();
    }
}
