package p1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Print print = new Print();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("당신의 이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.printf("연락처를 입력하세요: ");
        String phoneNumber = scanner.nextLine();
        User user = new User(name, phoneNumber);

        while(true){
            print.menu();
            System.out.print("메뉴 번호를 선택해주세요.");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("현재 고객 정보: ");
                    System.out.printf("이름 %s, 연락처 %s\n", user.getName(), user.getPhoneNumber());
                    break;
                case 2:
                    cart.printCart();
                    break;
                case 3:
                    cart.addCart();
                    break;
                case 4:
                    System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요: ");
                    String input = scanner.nextLine();
                    cart.deleteFromCart(input);
                    break;
                case 5:
                    cart.clearCart();
                    break;
                case 6:
                    cart.recipt(user);
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("유효하지 않은 번호입니다. 다시 선택해주세요.");
                    break;
            }
        }

    }
}