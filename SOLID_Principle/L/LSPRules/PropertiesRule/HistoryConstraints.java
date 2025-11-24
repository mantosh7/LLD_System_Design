package SOLID_Principle.L.LSPRules.PropertiesRule;

// Subclass methods should not be allowed state changes that
// the base class never allowed.

class BankAccount2 {
    protected double balance;

    public BankAccount2(double b) {
        if (b < 0) throw new IllegalArgumentException("Balance can't be negative");
        this.balance = b;
    }

    // History Constraint: withdraw should be allowed
    public void withdraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

class FixedDepositAccount extends BankAccount2{
    public FixedDepositAccount(double amount){
        super(amount) ;
    }

    // LSP break! History constraint broken!
    // Parent class behavior changed: Now withdraw is not allowed.
    // This class will break client code that relies on withdraw.
    @Override
    public void withdraw(double amount){
        throw new RuntimeException("Withdraw not allowed in Fixed Deposit");
    }
}

public class HistoryConstraints {
    public static void main(String[] args) {
        BankAccount2 a = new BankAccount2(2000) ;
        BankAccount2 b = new FixedDepositAccount(2000);
        
        a.withdraw(1000);
        b.withdraw(1000);  // throw error
    }
}
