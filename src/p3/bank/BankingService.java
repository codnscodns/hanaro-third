package p3.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingService {
    private List<Account> accounts;
    Scanner scan = new Scanner(System.in);

    public BankingService() {
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void menu(int accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        account.information(accountNumber);

        while(true) {
            if (accountNumber == 2) {
                System.out.print(">정기예금이 만기되었습니다. (+:만기처리, -:출금, T:이체, I:정보) ");
                String input = scan.nextLine();

                switch (input) {
                    case "+": {
                        account.deposit(accountNumber, accounts);
                        break;
                    }
                    case "-": {
                        account.withdraw(accountNumber);
                        break;
                    }
                    case "T": {
                        account.transfer(accountNumber, accounts);
                        break;
                    }
                    case "I": {
                        account.information(accountNumber);
                        break;
                    }
                    case "0", "": {
                        return;
                    }
                    default: {
                        break;
                    }
                }
            } else {
                System.out.print(">원하시는 업무는? (+:입금, -:출금, T:이체, I:정보) ");
                String input = scan.nextLine();

                switch (input) {
                    case "+": {
                        account.deposit(accountNumber, accounts);
                        break;
                    }
                    case "-": {
                        account.withdraw(accountNumber);
                        break;
                    }
                    case "T": {
                        account.transfer(accountNumber, accounts);
                        break;
                    }
                    case "I": {
                        account.information(accountNumber);
                        break;
                    }
                    case "0", "": {
                        return;
                    }
                    default: {
                        break;
                    }
                }
            }
        }
    }

    public Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

//    public void transfer(int accountNumber){
//        System.out.print("어디로 보낼까요? (1: 자유입출금, 2: 정기예금, 3: 마이너스) ");
//        int transferTo = scan.nextInt();
//        scan.nextLine();
//
//        Account account = findAccountByNumber(accountNumber);
//        Account targetAccount = findAccountByNumber(transferTo);
//        if(targetAccount == null){
//            System.out.println("계좌를 찾을 수 없습니다.");
//            return;
//        }
//
//        System.out.printf("%s에 보낼 금액은? \n", targetAccount.accountName);
//        int amount = scan.nextInt();
//        scan.nextLine();
//
//        if(account.balance < amount){
//            System.out.printf("잔액이 부족합니다! (잔액: %d원)\n", account.balance);
//        }else{
//            targetAccount.balance += amount;
//            account.balance -= amount;
//            System.out.printf("%s 통장에 %d원이 입금되었습니다.\n", targetAccount.accountName, amount);
//        }
//    }
}
