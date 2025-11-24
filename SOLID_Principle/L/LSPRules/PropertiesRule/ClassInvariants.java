package SOLID_Principle.L.LSPRules.PropertiesRule;

// Class Invariant of a parent class Object should not be broken by child class Object.
// Hence child class can either maintain or strengthen the invariant but never narrows it down.

// Invariant: Balance cannot be negative
class BankAccount{
    protected double balance ;

    public BankAccount(double amount){
        if(amount < 0) throw new IllegalArgumentException("Balance can't be negative.");
        this.balance = amount ;
    }

    public void withdraw(double amount){
        if(amount > balance) throw new RuntimeException("Insufficient funds");
        balance -= amount ;
        System.out.println("Amount withdrawn. Remaining balance is " + this.balance);
    }
}

// Breaks invariant: Should not be allowed.
class CheatAccount extends BankAccount{
    public CheatAccount(double amount){
        super(amount) ;
    }

    public void withdraw(double amount){
        balance -= amount ;  // LSP break! Negative balance allowed
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

public class ClassInvariants {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(2000) ;
        account1.withdraw(1000);

        BankAccount account2 = new CheatAccount(1000) ;
        account2.withdraw(5000);

    }
}
