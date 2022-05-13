import java.util.*;

public class BankMain {

    static ArrayList<BankAccount> listOfAccounts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        listOfAccounts.add(new BankAccount("Thomas", 202201, 10000));
        listOfAccounts.add(new BankAccount("Howard", 202202, 15000));
        listOfAccounts.add(new BankAccount("Susan", 202203, 2000));
        listOfAccounts.add(new BankAccount ("Oprah", 202204, 100_000_000));
        listOfAccounts.add(new BankAccount ("Martha", 202205, 500));

        System.out.println("Hello! Welcome to TF&B Bank.");
        System.out.println("Are you an existing customer? (-1 to exit)");
        System.out.println("1. Yes \n2. No");

        int hasAccount = Integer.valueOf(userInput.nextLine());

        while (hasAccount != -1){

            if (hasAccount == 1){
                System.out.println("What is your account number?");
                int acctNum = Integer.valueOf(userInput.nextLine());

                boolean isAccountHolder = false;
                int index = -1;

                for (int i = 0; i < listOfAccounts.size(); i++){
                    BankAccount acct = listOfAccounts.get(i);
                    if (acctNum == acct.getAccountNumber()){
                        isAccountHolder = true;
                        index = i;
                    }
                }

                if (isAccountHolder){
                    mainMenu(listOfAccounts.get(index));
                } else {
                    System.out.println("Account not found! Please try again!");
                } return;

            } else if (hasAccount == 2){
                BankAccount newAccount = new BankAccount();
                System.out.println("Let's make a new account!");
                System.out.println("What is the name for the account?");
                String accountHolder = userInput.nextLine();
                newAccount.setAccountHolder(accountHolder);
                System.out.println("What is the beginning balance for the account?");
                double initialAcctBalance = Double.valueOf(userInput.nextLine());
                newAccount.setAccountBalance(initialAcctBalance);

                listOfAccounts.add(newAccount);

                mainMenu(listOfAccounts.get(listOfAccounts.size() -1));

                break;

            } else if (hasAccount == -1){
                System.out.println("Have a nice day!");
                break;
            }   

    }
    userInput.close();
}

    public static void mainMenu(BankAccount acct){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello " + acct.getAccountHolder());
        System.out.println("Welcome to the Main Menu, what would you like to do today?");
        System.out.println("1. To check account balance");
        System.out.println("2. To make a withdrawal");
        System.out.println("3. To make a deposit");
        System.out.println("4. To make a transfer to another account");
        System.out.println("0. To exit");

        int menuDo = Integer.valueOf(input.nextLine());

        while (true){
            if (menuDo == 1){
                System.out.println("Account Balance: $" + acct.getAccountBalance());
                return;
            } else if (menuDo == 2) {
                System.out.println("What amount would you like to withdraw?");
                double amtToWithdraw = Double.valueOf(input.nextLine());
                acct.withdrawal(amtToWithdraw);
                System.out.println("$"+ amtToWithdraw + " has been withdrawn.");
                return;
            } else if (menuDo == 3) {
                System.out.println("What amount would you like to deposit?");
                double amtToDeposit = Double.valueOf(input.nextLine());
                acct.deposit(amtToDeposit);
                System.out.println("$" + amtToDeposit + " has been deposited.");
                return;
            } else if (menuDo == 4) {
                System.out.println("Please enter the account number to transfer to.");
                int transferAccount = Integer.valueOf(input.nextLine());

                BankAccount toTransferTo = new BankAccount();

                boolean isAccountHolder = false;
                int index = -1;

                for (int i = 0; i < listOfAccounts.size(); i++){
                    BankAccount accounts = listOfAccounts.get(i);
                    if (transferAccount == accounts.getAccountNumber()){
                        toTransferTo = accounts;
                        isAccountHolder = true;
                        index = 1;
                    }
                }

                if (isAccountHolder){
                    System.out.println("How much would you like to transfer?");
                    double transferAmt = Double.valueOf(input.nextLine());

                    acct.transfer(toTransferTo, transferAmt);

                    System.out.println(acct.getAccountHolder() + " transferred $" + transferAmt + ". The updated account balance is: $" + acct.getAccountBalance());
                    System.out.println(toTransferTo.getAccountHolder() + " was given $" + transferAmt + ". The updated account balance is: $" + toTransferTo.getAccountBalance());
                    break;
                } else {
                    System.out.println("Sorry, account not found!");
                } break;
            } else if (menuDo == 0) {
                System.out.println("Good-bye!");
                break;
            }
        }

        input.close();
    }


        /*BankAccount user1 = new BankAccount(500, "Arthur");
        user1.deposit(100);
        user1.withdrawal(50);
        user1.statement();

    
        BankAccount userId001 = new BankAccount(5000, "Tahirah");
        BankAccount userId002 = new BankAccount(300, "Thomas");
        
        userId001.withdrawal(100);
        userId001.statement();

        userId002.deposit(100);
        userId002.statement();
        */

    }
