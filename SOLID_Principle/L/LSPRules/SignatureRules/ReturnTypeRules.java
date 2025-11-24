package SOLID_Principle.L.LSPRules.SignatureRules;

// Return Type Rule : 
// Subtype overridden method return type should be either identical 
// or narrower than the parent3 method's return type.
// This is also called return type covariance.
// Java supports this out of the box.

class Animal3 {
    public void legs(){
        System.out.println("Animal3 usually have 4 legs");
    }
}

class Dog extends Animal3{
    @Override
    public void legs(){
        System.out.println("Dogs have 4 legs");
    }
}

class Parent3 {
    public Animal3 getAnimal3(){
        System.out.println("Parent3: Animal3 instance has been returned.");
        return new Animal3() ;
    }
}

class Child3 extends Parent3{
    @Override
    public Animal3 getAnimal3(){
        System.out.println("Child3: Dog (is-a Animal3) which is a narrower instance of Animal3 has been returned.");
        return new Dog() ;
    }
}

class Client3{
    private Parent3 p ;

    public Client3(Parent3 p){
        this.p = p ;
    }

    public void getAnimal3Class(){
        p.getAnimal3() ;
    }
}

public class ReturnTypeRules {
    public static void main(String[] args) {
        Parent3 p1 = new Parent3() ;
        Child3 c1 = new Child3() ;

        Client3 client31 = new Client3(p1) ;
        client31.getAnimal3Class();

        Client3 client32 = new Client3(c1) ;
        client32.getAnimal3Class();

    }
}
