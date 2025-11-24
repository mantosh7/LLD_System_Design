package SOLID_Principle.L;

import java.util.ArrayList;
import java.util.List;


interface Account2{
    void deposit(double amount);
    void withdraw(double amount);
}

class SavingAccount2 implements Account2{
    private double balance;

    public SavingAccount2(){
        this.balance = 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited Rs " + amount + " in the Savings Account2.New balance = " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
            System.out.println("Withdrawn Rs " + amount + " from the Savings Account2.New balance = " + this.balance);
        }
        else{
            System.out.println("Insufficient funds in Savings Account2!");
        }
    }
}

class CurrentAccount2 implements Account2{
    private double balance;

    public CurrentAccount2(){
        this.balance = 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited Rs " + amount + " in the Current Account2.New balance = " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
            System.out.println("Withdrawn Rs " + amount + " from the Current Account2.New balance = " + this.balance);
        }
        else{
            System.out.println("Insufficient funds in Current Account2!");
        }
    }
}

class FixedTermAccount2 implements Account2{
    private double balance;

    public FixedTermAccount2(){
        this.balance = 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited Rs " + amount + " in the Fixed Term Account2.New balance = " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account2!");
    }
}

class BankClient2{
    private List<Account2> accounts1;

    public BankClient2(List<Account2> accounts1){
        this.accounts1 = accounts1 ;
    }

    public void processTransaction(){
        for(Account2 a: accounts1){
            a.deposit(2000);

            // Checking account type explicitly
            if(a instanceof FixedTermAccount2){
                System.out.println("Skipping withdrawal for Fixed Term Account.");
            }
            else{
                try {
                    a.withdraw(1000);
                } catch (UnsupportedOperationException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        }
    }
}

public class LSPWronglyFollowed {
    public static void main(String[] args) {
        List<Account2> accounts1 = new ArrayList<>() ;
        accounts1.add(new SavingAccount2()) ;
        accounts1.add(new CurrentAccount2()) ;
        accounts1.add(new FixedTermAccount2()) ;

        BankClient2 client = new BankClient2(accounts1) ;
        client.processTransaction();
    }
}
