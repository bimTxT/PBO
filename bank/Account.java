public class Account {
    private String accountNumber;
    private String ownerName;
    private String pin;
    private int balance;

    public Account(String accountNumber, String ownerName, String pin, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public boolean checkPin(String pin) {
        return this.pin.equals(pin);
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false; 
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }
}