package p3.bank;

//정기예금
public class RegularSavingAccount extends Account{
    public RegularSavingAccount(int accountNumber, String accountName, String ownerName, int balance) {
        super(accountNumber, accountName, ownerName, balance);
    }

    @Override
    public void deposit(int accountNumber) {

    }

    @Override
    public void withdraw(int accountNumber) {
        throw new UnsupportedOperationException("정기예금 계좌에서는 출금이 불가능합니다.");
    }

    @Override
    public void transfer(int accountNumber) {
        throw new UnsupportedOperationException("정기예금 계좌에서는 이체가 불가능합니다.");
    }

    @Override
    public void information(int accountNumber) {

    }
}
