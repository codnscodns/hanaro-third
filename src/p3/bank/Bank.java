package p3.bank;

public interface Bank {
    public void deposit(int accountNumber);
    public void withdraw(int accountNumber);
    public void transfer(int accountNumber);
    public void information(int accountNumber);
//    public void menu(int accountNumber);
}
