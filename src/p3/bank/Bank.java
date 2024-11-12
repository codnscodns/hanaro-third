package p3.bank;

import java.util.List;

public interface Bank {
    public void deposit(int accountNumber, List<Account> accoutList);
    public void withdraw(int accountNumber);
    public void transfer(int accountNumber, List<Account> accoutList);
    public void information(int accountNumber);
}
