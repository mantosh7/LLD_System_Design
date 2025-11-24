package SOLID_Principle.L;

import java.util.ArrayList; 
import java.util.List;

interface DepositOnlyAccount{
    void deposit(double amount) ;
}

interface WithdrawableAccount extends DepositOnlyAccount{
    void withdraw(double amount) ;
}

class SavingsAccount implements WithdrawableAccount{
    private double balance ;

    public SavingsAccount(){
        this.balance= 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited: Rs " + amount + " from Saving Account. Current Balace: " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount ;
            System.out.println("Withdrawn: Rs " + amount + " from Saving Account.Current Balance: " + this.balance);
        }
        else{
            System.out.println("Insufficient balance in Saving Account!");
        }
    }
}

class CurrentAccount implements WithdrawableAccount{
    private double balance ;

    public CurrentAccount(){
        this.balance= 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited: Rs " + amount + " from Current Account. Current Balace: " + this.balance);
    }

    @Override
    public void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount ;
            System.out.println("Withdrawn: Rs " + amount + " from Current Account.Current Balance: " + this.balance);
        }
        else{
            System.out.println("Insufficient balance in Current Account!");
        }
    }
}

class FixedTermAccount implements DepositOnlyAccount{
    private double balance ;

    public FixedTermAccount(){
        this.balance= 0 ;
    }

    @Override
    public void deposit(double amount){
        this.balance += amount ;
        System.out.println("Deposited: Rs " + amount + " from Fixed Term Account. Current Balace: " + this.balance);
    }
}

class BankClient{
    private List<DepositOnlyAccount> depositOnlyAccounts ;
    private List<WithdrawableAccount> withdrawableAccounts;

    public BankClient(List<DepositOnlyAccount> depositOnlyAccounts, List<WithdrawableAccount> withdrawableAccounts){
        this.withdrawableAccounts = withdrawableAccounts ;
        this.depositOnlyAccounts = depositOnlyAccounts ;
    }

    public void processTransactions(){
        for(WithdrawableAccount acc: withdrawableAccounts){
            acc.deposit(2000);
            acc.withdraw(1000);
        }

        for(DepositOnlyAccount acc: depositOnlyAccounts){
            acc.deposit(5000);
        }
    }
}


public class LSPfollowed {
    public static void main(String[] args) {
        List<WithdrawableAccount> wAccount = new ArrayList<>() ;
        wAccount.add(new SavingsAccount()) ;
        wAccount.add(new CurrentAccount()) ;

        List<DepositOnlyAccount> dAccount = new ArrayList<>() ;
        dAccount.add(new FixedTermAccount()) ;

        BankClient client = new BankClient(dAccount, wAccount) ;
        client.processTransactions();

    }
}
