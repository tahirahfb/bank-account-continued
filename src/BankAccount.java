public class BankAccount {

    private String accountHolder;
    private int accountNumber;
    private double accountBalance;
    

    public BankAccount(String accountHolder, int accountNumber, double accountBalance){
        this.accountHolder = accountHolder; 
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public BankAccount(){}

    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    public void withdrawal(double amount) {
        this.accountBalance -= amount; 
    }

    public String getAccountHolder(){
        return this.accountHolder;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public void setAccountBalance(double accountBalance){
        this.accountBalance = accountBalance;
    }

    public void transfer(BankAccount acct, double amount){
        withdrawal(amount);
        acct.deposit(amount);
    }

    

    public void statement() {
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Account Balance: " + this.accountBalance);

    }

    public String toString(){
        return "The name on the account is: " + this.accountHolder + "and they have a balance of: $" + this.accountBalance;
    }

}