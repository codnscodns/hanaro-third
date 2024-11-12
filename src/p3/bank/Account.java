package p3.bank;

public abstract class Account implements Bank{
    int accountNumber;
    String accountName;
    String ownerName;
    int balance;

    public Account(int accountNumber, String accountName, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    protected Integer parseValidInteger(String input) {
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
