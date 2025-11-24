package SOLID_Principle.L;
import java.util.ArrayList;
import java.util.List;

interface Account1{
    void deposit(double amount);
    void withdraw(double amount);
}

class SavingAccount1 implements Account1{
    private double balance;

    public SavingAccount1(){
        this.balance = 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited Rs " + amount + " in the Savings Account1.New balance = " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
            System.out.println("Withdrawn Rs " + amount + " from the Savings Account1.New balance = " + this.balance);
        }
        else{
            System.out.println("Insufficient funds in Savings Account1!");
        }
    }
}

class CurrentAccount1 implements Account1{
    private double balance;

    public CurrentAccount1(){
        this.balance = 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited Rs " + amount + " in the Current Account1.New balance = " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
            System.out.println("Withdrawn Rs " + amount + " from the Current Account1.New balance = " + this.balance);
        }
        else{
            System.out.println("Insufficient funds in Current Account1!");
        }
    }
}

class FixedTermAccount1 implements Account1{
    private double balance;

    public FixedTermAccount1(){
        this.balance = 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited Rs " + amount + " in the Fixed Term Account1.New balance = " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account1!");
    }
}

class BankClient1{
    private List<Account1> accounts1;

    public BankClient1(List<Account1> accounts1){
        this.accounts1 = accounts1 ;
    }

    public void processTransaction(){
        for(Account1 a: accounts1){
            a.deposit(2000);

            try{
                a.withdraw(1000);
            } catch (UnsupportedOperationException e){
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}

public class LSPviolated {
    public static void main(String[] args) {

        List<Account1> accounts1 = new ArrayList<>() ;
        accounts1.add(new SavingAccount1()) ;
        accounts1.add(new CurrentAccount1()) ;
        accounts1.add(new FixedTermAccount1()) ;

        BankClient1 client = new BankClient1(accounts1) ;
        client.processTransaction();
    }
}
