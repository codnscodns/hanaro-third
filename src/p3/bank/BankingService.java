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
        Account temp = null;

        for(Account account: accounts){
            if(account.accountNumber == accountNumber){
                temp = account;
            }
        }

        while(true){
            System.out.print(">원하시는 업무는? (+:입금, -:출금, T:이체, I:정보) ");
            String input = scan.nextLine();

            switch(input){
                case "+": {
                    temp.deposit(accountNumber);
                    break;
                } case "-":{
                    temp.withdraw(accountNumber);
                    break;
                } case "T":{
                    temp.transfer(accountNumber);
                    break;
                } case "I":{
                    temp.information(accountNumber);
                    break;
                } case "0", "":{
                    return;
                } default:{
                    break;
                }
            }
        }
    }
}
