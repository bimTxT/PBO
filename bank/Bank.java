import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private static int totalAccount = 0; 

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public static int getTotal() {
        return totalAccount;
    }

    public boolean sameAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean addAccount(String accountNumber, String ownerName, String pin, int balance) {
        if (sameAccount(accountNumber)) {
            return false; 
        }
        accounts.add(new Account(accountNumber, ownerName, pin, balance));
        totalAccount++; 
        return true;
    }

    public Account authenticate(String accountNumber, String pin) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.checkPin(pin)) {
                return account;
            }
        }
        return null; 
    }
}