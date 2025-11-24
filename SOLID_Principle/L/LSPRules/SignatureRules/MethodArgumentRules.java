package SOLID_Principle.L.LSPRules.SignatureRules;

// Method Argument Rule : 
// Subtype method arguments can be identical or wider than the supertype
// Java enforces this by requiring the same method signature for overrides

class Parent{
    public void print(String msg){
        System.out.println("Parent: " + msg);
    }
}

class Child extends Parent{
    @Override
    public void print(String msg){
        System.out.println("Child: " + msg);
    }
}

class Client{
    private Parent p ;

    public Client(Parent p){
        this.p = p ;
    }

    public void printMsg(String msg){
        p.print(msg) ;
    }
}

public class MethodArgumentRules {
    public static void main(String[] args) {
        Parent p1 = new Parent() ;
        Client c1 = new Client(p1) ;
        c1.printMsg("Helllo world");

        Parent p2 = new Child() ;
        Client c2 = new Client(p2) ;
        c2.printMsg("Hello World");
    }
}
