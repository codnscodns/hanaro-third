package p3;

import p3.bank.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankingService banking = new BankingService();
        banking.addAccount(new FreeSavingAccount(1, "자유입출금", "홍길동", 0));
        banking.addAccount(new RegularSavingAccount(2, "정기예금", "홍길동", 50000000));
        banking.addAccount(new MinusAccount(3, "마이너스", "홍길동", 0));
        List<Account> accounts = new ArrayList<>();
        boolean exists = true;

        while(true){
            for(Account account: accounts){
                if(account.getAccountNumber() == 2){
                    System.out.println(account.toString() + "ddd");
                    exists = true;
                }
            }

            if (banking.getAccountList().stream().noneMatch(account -> account.getAccountNumber() == 2)) {
                System.out.print(">>통장을 선택하세요(1: 자유입출금, 3: 마이너스) ");
            }else{
                System.out.print(">>통장을 선택하세요(1: 자유입출금, 2: 정기예금, 3: 마이너스) ");
            }
            String input = scan.nextLine();

            switch (input) {
                case "1" -> banking.menu(1);
                case "2" -> banking.menu(2);
                case "3" -> banking.menu(3);
                case "0", "" -> {
                    System.out.println("금일 OneHanaBank는 업무를 종료합니다. 감사합니다.");
                    return;
                }
                default -> System.out.println("올바른 입력을 해주세요.");
            }
        }
    }
}
