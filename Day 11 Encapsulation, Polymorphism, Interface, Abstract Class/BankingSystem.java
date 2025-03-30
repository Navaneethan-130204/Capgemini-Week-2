interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount implements Loanable{
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        setBalance(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance > 0) {
            this.balance = balance;
        }
        else {
            System.out.println("Balance must be positive!");
        }
    }

    public void deposit(double deposit) {
        if(deposit >= 0) {
            balance += deposit;
            System.out.println("Deposited: $" + deposit + " | New Balance: $" + balance);
        }
        else {
            System.out.println("Deposit must be positive!");
        }
    }

    public void withdraw(double withdraw) {
        if (withdraw > 0 && balance >= withdraw) {
            balance -= withdraw;
            System.out.println("Withdrawal: $" + withdraw + " | New Balance: " + balance);
        }
        else {
            System.out.println("Invalid withdrawal amount!");
        }
    }


    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
    abstract void calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable{

    public SavingsAccount (int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void calculateInterest () {
        double interest =  getBalance() * 0.1;
        System.out.println("Savings Account Interest: $" + interest);
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings Account loan request amount: $" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable{

    public CurrentAccount (int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void calculateInterest () {
        System.out.println("No Interest applicable for Current Account!");
    }

    public void applyForLoan(double amount) {
        System.out.println("Current Account loan request amount: $" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        SavingsAccount s1 = new SavingsAccount(100, "Rick", 50000);
        CurrentAccount c1 = new CurrentAccount(200, "Chum", 25000);

        BankAccount[] accounts = {s1, c1};

        for(BankAccount acc : accounts) {
            acc.display();
            acc.deposit(25000);
            acc.withdraw(10000);
            acc.setBalance(100000);
            acc.calculateInterest();
            acc.applyForLoan(10000);
            if(acc.calculateLoanEligibility()){
                System.out.println("Loan Eligible!");
            }
            else {
                System.out.println("Not Eligible for Loan!");
            }
            System.out.println();
        }
    }
}
