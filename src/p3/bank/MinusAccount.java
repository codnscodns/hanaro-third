package p3.bank;

import java.util.List;
import java.util.Scanner;

//마이너스 통장
public class MinusAccount extends Account{
    Scanner scan = new Scanner(System.in);

    public MinusAccount(int accountNumber, String accountName, String ownerName, int balance) {
        super(accountNumber, accountName, ownerName, balance);
    }

    @Override
    public void deposit(List<Account> accountList) {
        System.out.print("입금 하실 금액은?");
        String input = scan.nextLine();
        Integer amount = parseValidInteger(input);

        if(amount == null){
            return;
        }
        this.balance += amount;
        System.out.printf("%s 통장에 %d원이 입금되었습니다!\n", accountName, amount);
    }

    @Override
    public void withdraw() {
        System.out.print("출금 하실 금액은?");
        String input = scan.nextLine();
        Integer amount = parseValidInteger(input);

        if(amount == null){
            return;
        }

        this.balance -= amount;
        System.out.printf("%s에서 %d원이 출금되었습니다.\n", accountName, amount);
        System.out.printf("%s통장의 잔액은 %d원입니다.\n", accountName, this.balance);
    }

    @Override
    public void transfer(List<Account> accountList) {
        System.out.print("어디로 보낼까요? (1: 자유입출금, 2: 정기예금) ");
        Integer transferTo;
        String input = scan.nextLine();
        transferTo = parseValidInteger(input);

        if(transferTo == null){
            return;
        }

        Account targetAccount = null;
        for(Account account: accountList){
            if(account.accountNumber == transferTo){
                targetAccount = account;
            }
        }

        if(transferTo == 2 || transferTo == 3){
            System.out.println("이체할 수 없는 통장입니다.");
            return;
        }else if(targetAccount == null){
            System.out.println("존재하지 않는 계좌번호입니다.");
            return;
        }

        System.out.printf("%s에 보낼 금액은? ", targetAccount.accountName);
        input = scan.nextLine();
        Integer amount = parseValidInteger(input);

        if(amount == null){
            return;
        }

        if(this.balance < amount){
            System.out.printf("잔액이 부족합니다! (잔액: %d원)\n", this.balance);
        }else{
            targetAccount.balance += amount;
            this.balance -= amount;
            System.out.printf("%s에 %d원이 입금되었습니다.\n", targetAccount.accountName, amount);
        }
    }

    @Override
    public void information() {
        System.out.printf("%s 통장 (계좌번호: %d, 잔액: %d, 예금주: %s)\n", this.accountName, this.accountNumber, this.balance, this.ownerName);
    }

    private Integer parseValidInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                System.out.println("0보다 큰 숫자를 입력해주세요.");
                return null;
            }
            return value;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
