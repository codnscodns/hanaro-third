package p3.bank;

//마이너스 통장
public class MinusAccount extends Account{
    public MinusAccount(int accountNumber, String accountName, String ownerName, int balance) {
        super(accountNumber, accountName, ownerName, balance);
    }

    @Override
    public void deposit(int accountNumber) {

    }

    @Override
    public void withdraw(int accountNumber) {

    }

    @Override
    public void transfer(int accountNumber) {

    }

    @Override
    public void information(int accountNumber) {

    }
}
