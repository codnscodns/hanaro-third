package p3.bank;

import java.util.List;
import java.util.Scanner;

//자유입출금통장
public class FreeSavingAccount extends Account {
    Scanner scan = new Scanner(System.in);

    public FreeSavingAccount(int accountNumber, String accountName, String ownerName, int balance) {
        super(accountNumber, accountName, ownerName, balance);
    }

    @Override
    public void deposit(int accountNumber, List<Account> accountList) {
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

        if(balance < amount || balance <= 0){
            System.out.printf("잔액이 부족합니다! (잔액: %d원)\n", balance);
        }else{
            this.balance -= amount;
            System.out.printf("%s에서 %d원이 출금되었습니다.\n", accountName, amount);
        }
    }

    @Override
    public void transfer(int accountNumber, List<Account> accountList) {
        System.out.print("어디로 보낼까요? (2: 정기예금, 3: 마이너스) ");
        int transferTo = scan.nextInt();
        scan.nextLine();

        Account targetAccount = null;
        for(Account account: accountList){
            if(account.accountNumber == transferTo){
                targetAccount = account;
            }
        }

        System.out.printf("%s에 보낼 금액은? ", targetAccount.accountName);
        int amount = scan.nextInt();
        scan.nextLine();

        if(this.balance < amount){
            System.out.printf("잔액이 부족합니다! (잔액: %d원)\n", this.balance);
        }else{
            targetAccount.balance += amount;
            this.balance -= amount;
            System.out.printf("%s에 %d원이 입금되었습니다.\n", targetAccount.accountName, amount);
        }
    }

    @Override
    public void information(int accountNumber) {
        System.out.printf("%s 통장 (계좌번호: %d, 잔액: %d, 예금주: %s)\n", this.accountName, this.accountNumber, this.balance, this.ownerName);
    }


}
