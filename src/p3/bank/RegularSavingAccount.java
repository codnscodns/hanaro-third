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
        throw new UnsupportedOperationException("출금할 수 없는 통장입니다.");
    }

    @Override
    public void transfer(int accountNumber) {
        throw new UnsupportedOperationException("이체할 수 없는 통장입니다.");
    }

    @Override
    public void information(int accountNumber) {
        System.out.printf("%s 통장 (계좌번호: %d, 잔액: %d, 예금주: %s)\n", this.accountName, this.accountNumber, this.balance, this.ownerName);
    }
}
