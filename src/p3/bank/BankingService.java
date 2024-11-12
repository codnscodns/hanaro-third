package p3.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingService {
    Scanner scan = new Scanner(System.in);
    private final List<Account> accounts;

    public BankingService() {
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccountList(){
        return this.accounts;
    }

    public Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void menu(int accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        account.information();

        while (true) {
            if (accountNumber == 2 && account.balance != 0) {
                System.out.print(">정기예금이 만기되었습니다. (+:만기처리, -:출금, T:이체, I:정보) ");
            } else if (accountNumber != 2) {
                System.out.print(">원하시는 업무는? (+:입금, -:출금, T:이체, I:정보) ");
            }

            String input = scan.nextLine();

            switch (input) {
                case "+" -> account.deposit(accounts);
                case "-" -> account.withdraw();
                case "T" -> account.transfer(accounts);
                case "I" -> account.information();
                case "0", "" -> {
                    return;
                }
                default -> {
                }
            }
        }
    }
}
