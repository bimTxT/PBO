import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank(); 

        boolean run = true; 
        Account account = null; 

        System.out.println("Welcome to Bank");

        do {
            if (account == null) {
                System.out.println("\n=== MAIN MENU ===");
                System.out.println("Total Registered Accounts: " + Bank.getTotal());
                System.out.println("1. Login");
                System.out.println("2. Create Account");
                System.out.println("3. Exit");
                System.out.print("Select menu (1-3): ");
                
                int menu = input.nextInt();
                input.nextLine(); 

                switch (menu) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        String accNum = input.nextLine();
                        
                        System.out.print("Enter PIN: ");
                        String pin = input.nextLine();

                        account = bank.authenticate(accNum, pin);

                        if (account == null) {
                            System.out.println("Login Failed! Invalid Account Number or PIN.");
                        } else {
                            System.out.println("Login Successful! Welcome, " + account.getOwnerName());
                        }
                        break;
                        
                    case 2:
                        System.out.print("Enter New Account Number: ");
                        String newAccNum = input.nextLine();
                        
                        System.out.print("Enter Owner Name: ");
                        String ownerName = input.nextLine();
                        
                        System.out.print("Enter New PIN: ");
                        String newPin = input.nextLine();
                        
                        System.out.print("Enter Initial Deposit: Rp ");
                        int initialDeposit = input.nextInt();
                        input.nextLine(); 

                        if (bank.addAccount(newAccNum, ownerName, newPin, initialDeposit)) {
                            System.out.println("Account created successfully! You can now login.");
                        } else {
                            System.out.println("Failed! Account Number already taken.");
                        }
                        break;
                        
                    case 3:
                        run = false;
                        break;
                        
                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            } else {
                System.out.println("\n=== MENU ===");
                System.out.println("Owner: " + account.getOwnerName());
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Logout");
                System.out.print("Select menu (1-4): ");
                
                int menu = input.nextInt();
                input.nextLine(); 

                switch (menu) {
                    case 1:
                        System.out.println("Current balance: Rp " + account.getBalance());
                        break;
                        
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        int depositAmount = input.nextInt();
                        input.nextLine();
                        
                        if (account.deposit(depositAmount)) {
                            System.out.println("Deposit: Rp " + depositAmount);
                        } else {
                            System.out.println("Failed! Invalid deposit amount!");
                        }
                        System.out.println("Current balance: Rp " + account.getBalance());
                        break;
                        
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        int withdrawAmount = input.nextInt();
                        input.nextLine();
                        
                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdraw: Rp " + withdrawAmount);
                        } else {
                            System.out.println("Failed! Insufficient balance!");
                        }
                        System.out.println("Current balance: Rp " + account.getBalance());
                        break;
                        
                    case 4:
                        System.out.println("Logging out...");
                        account = null; 
                        break;
                        
                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            }
        } while (run);
        
        System.out.println("Thank you for using our Bank services.");
        input.close();
    }
}