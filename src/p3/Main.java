package p3;

import p3.bank.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankingService banking = new BankingService();
        banking.addAccount(new FreeSavingAccount(1, "자유입출금", "홍길동", 0));
        banking.addAccount(new RegularSavingAccount(2, "정기예금", "홍길동", 50000000));
        banking.addAccount(new MinusAccount(3, "마이너스", "홍길동", 0));

        while(true){
            System.out.print(">>통장을 선택하세요(1: 자유입출금, 2: 정기예금, 3: 마이너스) ");
            String input = scan.nextLine();

            switch(input){ //화살표로 바꾸기!!!
                case "1":{
                    banking.menu(1);
                    break;
                } case "2":{
                    break;
                } case "3":{
                    break;
                } case "0", "":{
                    return;
                } default:{
                    System.out.println("올바른 입력을 해주세요.");
                }
            }
        }
    }
}
