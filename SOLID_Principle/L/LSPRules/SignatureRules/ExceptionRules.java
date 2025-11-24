package SOLID_Principle.L.LSPRules.SignatureRules;

// Exception Rule:
// A subclass should throw fewer or narrower exceptions 
// (but not additional or broader exceptions) than the parent2.
// Java enforces this only for checked Exceptions.

/* 
└── java.lang.Exception                        // Conditions your application might want to catch
    ├── java.io.IOException                    // Checked I/O failures
    │   ├── java.io.FileNotFoundException
    │   ├── java.io.EOFException
    │   └── java.net.MalformedURLException
    ├── java.lang.ClassNotFoundException       // Checked reflect/… failures
    ├── java.lang.InterruptedException         // Checked thread interruption
    ├── java.sql.SQLException                  // Checked SQL/database errors
    ├── java.text.ParseException               // Checked parsing errors
    └── java.lang.RuntimeException             // Unchecked; subclasses may be thrown anywhere
        ├── java.lang.ArithmeticException      // e.g. divide by zero
        ├── java.lang.NullPointerException
        ├── java.lang.ArrayIndexOutOfBoundsException
        ├── java.lang.StringIndexOutOfBoundsException
        ├── java.lang.IllegalArgumentException
        │    └── java.lang.NumberFormatException
        ├── java.lang.IllegalStateException
        ├── java.lang.UnsupportedOperationException
        └── java.lang.IndexOutOfBoundsException // parent2 of the two “…OutOfBounds” above
*/

class Parent2{
    public void getValue() throws RuntimeException{
        throw new RuntimeException("Parent2 Error") ;
    }
}

class Child2 extends Parent2{
    @Override
    public void getValue() throws ArithmeticException{
        throw new ArithmeticException("Child2 Error") ;
    }
}

class Client2{
    private Parent2 p ;

    public Client2(Parent2 p){
        this.p = p ;
    }

    public void takeValue(){
        try {
            p.getValue();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occured: " + e.getMessage());
        }
    }
}

public class ExceptionRules {
    public static void main(String[] args) {
        Parent2 p1 = new Parent2() ;
        Parent2 p2 = new Child2() ;

        Client2 client1 = new Client2(p1) ;
        client1.takeValue(); 

        Client2 client2 = new Client2(p2) ;
        client2.takeValue() ;
    }
}
