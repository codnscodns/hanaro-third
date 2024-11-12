package p3.bank;

import java.sql.SQLOutput;
import java.util.Scanner;

//자유입출금통장
public class FreeSavingAccount extends Account {
    Scanner scan = new Scanner(System.in);

    public FreeSavingAccount(int accountNumber, String accountName, String ownerName, int balance) {
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

        if(balance < amount){
            System.out.printf("잔액이 부족합니다! (잔액: %d원)\n", balance);
        }else{
            this.balance -= amount;
            System.out.printf("%s에서 %d원이 출믁되었습니다.\n", accountName, amount);
        }
    }

    @Override
    public void transfer(int accountNumber) {
        System.out.print("어디로 보낼까요? (2: 정기예금, 3: 마이너스) ");
        int transferTo = scan.nextInt();
        scan.nextLine();
    }

    @Override
    public void information(int accountNumber) {
        System.out.printf("%s 통장 (계좌번호: %d, 잔액: %d, 예금주: %s)\n", this.accountName, this.accountNumber, this.balance, this.ownerName);
    }


}
