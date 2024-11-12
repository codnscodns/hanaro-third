package p3.bank;

import java.util.List;

public interface Bank {
    public void deposit(List<Account> accoutList);
    public void withdraw();
    public void transfer(List<Account> accoutList);
    public void information();
}
