package p3.bank;

public abstract class Account implements Bank{
    int accountNumber;
    String accountName;
    String ownerName;
    int balance;

    public Account(int accountNumber, String accountName, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
