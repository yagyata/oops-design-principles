import java.util.ArrayList;

class Bank{
    private String bankName;
    private ArrayList<Customer>customers;

    Bank(String bankName){
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public String getBankName(){
        return bankName;
    }

    public void addAccount(Customer customer){
        customers.add(customer);
    }

    public Account openAccount(Customer customer, int accountNumber, double initialDeposit) {
        Account newAccount = new Account(accountNumber, initialDeposit, this);
        customer.addAccount(newAccount);
        return newAccount;
    }

    public void displayCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Accounts of " + name + ":");
        for (Account acc : accounts) {
            System.out.println("- Account Number: " + acc.getAccountNumber() + ", Balance: $" + acc.getBalance() + " (Bank: " + acc.getBank().getBankName() + ")");
        }
    }
}

class Account {
    private int accountNumber;
    private double balance;
    private Bank bank;  // Association with Bank

    // Constructor
    public Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank1 = new Bank("SBI Bank");

        Customer peter = new Customer("Peter Parker");
        Customer zendaya = new Customer("Zendaya");

        bank1.addAccount(peter);
        bank1.addAccount(zendaya);

        Account account1 = bank1.openAccount(peter, 253800, 12000);
        Account account2 = bank1.openAccount(peter, 793420, 4000);
        Account account3 = bank1.openAccount(zendaya, 571620, 18000);

        bank1.displayCustomers();

        peter.viewBalance();
        zendaya.viewBalance();
    }
}