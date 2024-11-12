package p3.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//정기예금
public class RegularSavingAccount extends Account{
    Scanner scan = new Scanner(System.in);

    public RegularSavingAccount(int accountNumber, String accountName, String ownerName, int balance) {
        super(accountNumber, accountName, ownerName, balance);
    }

    @Override
    public void deposit(int accountNumber, List<Account> accountList) {
        double rate = 0;

        if(this.balance >= 50000000){ //만기되었다면 만기처리
            System.out.print("예치 개월수를 입력하세요? (1~60개월) ");
            int month = scan.nextInt();
            scan.nextLine();

            if(month >= 1 && month <= 2){
                rate = 3.0;
            }else if(month >= 3 && month <= 5){
                rate = 3.35;
            }else if(month >= 6 && month <= 8){
                rate = 3.4;
            }else if(month >= 9 && month <= 23){
                rate = 3.35;
            }else if(month >= 24 && month <= 60){
                rate = 2.9;
            }else{
                return;
            }
            System.out.printf("%d개월(적용금리 %.2f%%)로 만기 처리 하시겠어요? (y/n) ", month, rate);
            String input = scan.nextLine();

            if(input.equalsIgnoreCase("Y")){
                transferOnMaturity(rate, month, accountList);
                accountList.remove(this);
                System.out.println("정기예금 통장은 해지되었습니다. 감사합니다.");
            }else{
                return;
            }
        }
    }

    @Override
    public void withdraw(int accountNumber) {
        System.out.println("출금할 수 없는 통장입니다.");
    }

    @Override
    public void transfer(int accountNumber, List<Account> accountList) {
        System.out.println("이체할 수 없는 통장입니다.");
    }

    @Override
    public void information(int accountNumber) {
        System.out.printf("%s 통장 (계좌번호: %d, 잔액: %d, 예금주: %s)\n", this.accountName, this.accountNumber, this.balance, this.ownerName);
        System.out.println("* 예치 개월에 따른 적용 금리");
        System.out.println("    1개월 이상     3.0%");
        System.out.println("    3개월 이상     3.35%");
        System.out.println("    6개월 이상     3.4%");
        System.out.println("    9개월 이상     3.35%");
        System.out.println("    12개월 이상    3.35%");
        System.out.println("    24개월 이상    2.9%");
        System.out.println("    36개월 이상    2.9%");
        System.out.println("    48개월 이상    2.9%");
    }

    public void transferOnMaturity(double rate, int month, List<Account> accountList){
        System.out.print("어디로 보낼까요? (1: 자유입출금, 3: 마이너스) ");
        int transferTo = scan.nextInt();
        scan.nextLine();

        Account targetAccount = null;
        for(Account account: accountList){
            if(account.accountNumber == transferTo){
                targetAccount = account;
            }
        }

        int amount = 0;
        amount = this.balance + (int)(this.balance * (rate) * 0.01);

        targetAccount.balance += amount;
        this.balance = 0;
        System.out.printf("%s에 %d원이 입금되었습니다.\n", targetAccount.accountName, amount);
    }
}
