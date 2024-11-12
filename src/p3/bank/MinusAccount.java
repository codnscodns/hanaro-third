package p3.bank;

import java.util.Scanner;

//마이너스 통장
public class MinusAccount extends Account{
    Scanner scan = new Scanner(System.in);

    public MinusAccount(int accountNumber, String accountName, String ownerName, int balance) {
        super(accountNumber, accountName, ownerName, balance);
    }

    @Override
    public void deposit(int accountNumber) {
        System.out.print("입금 하실 금액은?");
        int amount = scan.nextInt();
        scan.nextLine();
        this.balance += amount;
        System.out.printf("%s 통장에 %d원이 입금되었습니다!\n", accountName, amount);
    }

    @Override
    public void withdraw(int accountNumber) {
        System.out.print("출금 하실 금액은?");
        int amount = scan.nextInt();
        scan.nextLine();

        this.balance -= amount;
        System.out.printf("%s에서 %d원이 출믁되었습니다.\n", accountName, amount);
        System.out.printf("%s통장의 잔액은 %d원입니다.\n", accountName, this.balance);
    }

    @Override
    public void transfer(int accountNumber) {

    }

    @Override
    public void information(int accountNumber) {
        System.out.printf("%s 통장 (계좌번호: %d, 잔액: %d, 예금주: %s)\n", this.accountName, this.accountNumber, this.balance, this.ownerName);
    }
}
